package entities.yayinTools.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayinTools.YynSek1l;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayinTools.YynSek1l.class)
public class YynSek1lManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public YynSek1lManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createYynSek1l(YynSek1l yynSek1l) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(yynSek1l);
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
	public String deleteYynSek1l(YynSek1l yynSek1l) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yynSek1l = em.merge(yynSek1l);
			em.remove(yynSek1l);
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
	public String updateYynSek1l(YynSek1l yynSek1l) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yynSek1l = em.merge(yynSek1l);
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
	public YynSek1l findYynSek1lBySkl1d(short skl1d) {
		YynSek1l yynSek1l = null;
		EntityManager em = getEntityManager();
		try {
			yynSek1l = (YynSek1l) em.find(YynSek1l.class, skl1d);
		} finally {
			em.close();
		}
		return yynSek1l;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public YynSek1l getNewYynSek1l() {
	
		YynSek1l yynSek1l = new YynSek1l();
	
		return yynSek1l;
	}

	@NamedQueryTarget("getYynSek1l")
	public List<YynSek1l> getYynSek1l() {
		EntityManager em = getEntityManager();
		List<YynSek1l> results = null;
		try {
			Query query = em.createNamedQuery("getYynSek1l");
			results = (List<YynSek1l>) query.getResultList();
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
	public List<SelectItem> getYynSek1lSelectList() {
		List<YynSek1l> yynSek1lList = getYynSek1l();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (YynSek1l yynSek1l : yynSek1lList) {
			selectList.add(new SelectItem(yynSek1l, mf.format(
					new Object[] { yynSek1l.getSkl1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}