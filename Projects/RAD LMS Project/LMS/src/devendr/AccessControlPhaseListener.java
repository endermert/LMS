package devendr;

import static devendr.AccessControlPhaseListener.AccessLevel.ADMIN;
import static devendr.AccessControlPhaseListener.AccessLevel.NONE;
import static devendr.AccessControlPhaseListener.AccessLevel.USER;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pagecode.pages.login.Login_frm;
import devendr.UrlFilter;

/**
 * Phase Listener that checks the viewId (URL) against a set of filters to determine the required access level. If the
 * correct level is not there then redirect.
 * 
 * See {@link UrlFilter} for details on the url matching.
 * 
 * @author Chris Watts 2009
 * 
 */
public class AccessControlPhaseListener implements PhaseListener
{
  /** Logger for this class */
  private static final Logger log = LoggerFactory.getLogger(AccessControlPhaseListener.class);

  /** */
  private static final long serialVersionUID = 1L;
 
  private final HashMap<AccessLevel, List<UrlFilter>> levelFilters = new HashMap<AccessLevel, List<UrlFilter>>();

  public enum AccessLevel
  {
    NONE,USER, ADMIN;
  }

  public AccessControlPhaseListener()
  {
    initLevels();
    
    requires(USER)
      .include("/pages/user/*")
      .exclude("/pages/login/login.xhtml");
    
    requires(ADMIN)
      .include("/pages/admin/*")
      .exclude("/pages/login/login.xhtml");
      
    
  }

  private void initLevels()
  {
    AccessLevel[] levels = AccessLevel.values();
    for (int i = 1; i < levels.length; i++)
    {
      levelFilters.put(levels[i], new ArrayList<UrlFilter>());
    }
  }

  private UrlFilter requires(AccessLevel level)
  {
    //ALL is default
    if (level == NONE)
      return null;

    UrlFilter filter = new UrlFilter();
    List<UrlFilter> list = levelFilters.get(level);
    list.add(filter);
    return filter;
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.faces.event.PhaseListener#afterPhase(javax.faces.event.PhaseEvent)
   */
  public void afterPhase(PhaseEvent event)
  {
    try
    {
      //check have correct access
      FacesContext context = event.getFacesContext();
      HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
      Login_frm  sessionBean = (Login_frm) session.getAttribute("pc_sessionBean");
     
      //can't use this here. only valid at render response phase?
      String viewId = context.getViewRoot().getViewId();
      AccessLevel required = requiredLevel(viewId);
      log.debug("Required level={} for viewId={}", required, viewId);
      
      if(sessionBean==null){
    	  switch (required) {
          case NONE:
            break;
          case USER:
            {
              redirectActive(event.getFacesContext());
            }  
            break;
          case ADMIN:
            {
              redirectAdmin(event.getFacesContext());
            }
            break;
          default:
            //error
            System.out.println("Not a valid access level");
          }
      }else{
    	  
      //check if page require access:
      switch (required) {
      case NONE:
        break;
  
      case USER:
        if (!sessionBean.isUser())
        {
          redirectActive(event.getFacesContext());
        }  
        break;
      case ADMIN:
        if (!sessionBean.isAdmin())
        {
          redirectAdmin(event.getFacesContext());
        }
        break;
      default:
        //error
        System.out.println("Not a valid access level");
      }
     }
    }
    catch (Exception e)
    {
      System.out.println("beforePhase caught exception");
    
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.faces.event.PhaseListener#beforePhase(javax.faces.event.PhaseEvent)
   */
  public void beforePhase(PhaseEvent event)
  {
	  FacesContext facesContext = event.getFacesContext();
		HttpServletResponse response = (HttpServletResponse) facesContext
				.getExternalContext().getResponse();
		response.addHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		// Stronger according to blog comment below that references HTTP spec
		response.addHeader("Cache-Control", "no-store");
		response.addHeader("Cache-Control", "must-revalidate");
		// some date in the past
		
  }


  private void redirectActive(FacesContext context)
  {
    context.getApplication().getNavigationHandler().handleNavigation(context, null, "unauthorizedPage");
  }

  private void redirectAdmin(FacesContext context)
  {
    context.getApplication().getNavigationHandler().handleNavigation(context,null,"unauthorizedPage");
  }




  /**
   * Checks defined filters for view id, checks starting at the highest level down to NONE.
   * 
   * @return the matching level or {@link AccessLevel#NONE} if none matching.
   */
  private AccessLevel requiredLevel(String viewId)
  {
    AccessLevel[] levels = AccessLevel.values();
    for (int i = levels.length - 1; i > 0; i--)
    {
      if (checkLevel(levels[i], viewId))
        return levels[i];
    }

    return AccessLevel.NONE;
  }

  private boolean checkLevel(AccessLevel level, String viewId)
  {
    return matchUri(levelFilters.get(level), viewId);
  }

  private boolean matchUri(List<UrlFilter> list, String uri)
  {
    for (UrlFilter filter : list)
    {
      if (filter.matches(uri))
        return true;
    }
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.faces.event.PhaseListener#getPhaseId()
   */
  public PhaseId getPhaseId()
  {
    //ALL access go through RESTORE_VIEW and RENDER_VIEW (even direct url)
    return PhaseId.RESTORE_VIEW;
  }

}
