package entities.yayinTools.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayinTools.YynFormat;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayinTools.YynFormat.class)
public class YynFormatManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public YynFormatManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createYynFormat(YynFormat yynFormat) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(yynFormat);
			utx.commit();
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
		return "";
	}

	@Action(Action.ACTION_TYPE.DELETE)
	public String deleteYynFormat(YynFormat yynFormat) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yynFormat = em.merge(yynFormat);
			em.remove(yynFormat);
			utx.commit();
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
		return "";
	}

	@Action(Action.ACTION_TYPE.UPDATE)
	public String updateYynFormat(YynFormat yynFormat) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yynFormat = em.merge(yynFormat);
			utx.commit();
		} catch (Exception ex) {
			try {
				utx.rollback();
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
		return "";
	}

	@Action(Action.ACTION_TYPE.FIND)
	public YynFormat findYynFormatByFmt1d(short fmt1d) {
		YynFormat yynFormat = null;
		EntityManager em = getEntityManager();
		try {
			yynFormat = (YynFormat) em.find(YynFormat.class, fmt1d);
		} finally {
			em.close();
		}
		return yynFormat;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public YynFormat getNewYynFormat() {
	
		YynFormat yynFormat = new YynFormat();
	
		return yynFormat;
	}

	@NamedQueryTarget("getYynFormat")
	public List<YynFormat> getYynFormat() {
		EntityManager em = getEntityManager();
		List<YynFormat> results = null;
		try {
			Query query = em.createNamedQuery("getYynFormat");
			results = (List<YynFormat>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	/**
	 * Retrieve a list of entities that can be used to populate a combo box. The
	 * MessageFormat can be used to format how your list items will be
	 * displayed.
	 */
	public List<SelectItem> getYynFormatSelectList() {
		List<YynFormat> yynFormatList = getYynFormat();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (YynFormat yynFormat : yynFormatList) {
			selectList.add(new SelectItem(yynFormat, mf.format(
					new Object[] { yynFormat.getFmt1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}