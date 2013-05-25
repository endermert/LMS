package entities.yayinTools.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayinTools.AltT1pler;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayinTools.AltT1pler.class)
public class AltT1plerManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public AltT1plerManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createAltT1pler(AltT1pler altT1pler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(altT1pler);
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
	public String deleteAltT1pler(AltT1pler altT1pler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			altT1pler = em.merge(altT1pler);
			em.remove(altT1pler);
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
	public String updateAltT1pler(AltT1pler altT1pler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			altT1pler = em.merge(altT1pler);
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
	public AltT1pler findAltT1plerByAlt1d(short alt1d) {
		AltT1pler altT1pler = null;
		EntityManager em = getEntityManager();
		try {
			altT1pler = (AltT1pler) em.find(AltT1pler.class, alt1d);
		} finally {
			em.close();
		}
		return altT1pler;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public AltT1pler getNewAltT1pler() {
	
		AltT1pler altT1pler = new AltT1pler();
	
		return altT1pler;
	}

	@NamedQueryTarget("getAltT1plerByT1p1d")
	public List<AltT1pler> getAltT1plerByT1p1d(short t1p1d) {
		EntityManager em = getEntityManager();
		List<AltT1pler> results = null;
		try {
			Query query = em.createNamedQuery("getAltT1plerByT1p1d");
			query.setParameter("t1p1d", t1p1d);
			results = (List<AltT1pler>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getAltT1plerByAlt1d")
	public List<AltT1pler> getAltT1plerByAlt1d(short alt1d) {
		EntityManager em = getEntityManager();
		List<AltT1pler> results = null;
		try {
			Query query = em.createNamedQuery("getAltT1plerByAlt1d");
			query.setParameter("alt1d", alt1d);
			results = (List<AltT1pler>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getAltT1pler")
	public List<AltT1pler> getAltT1pler() {
		EntityManager em = getEntityManager();
		List<AltT1pler> results = null;
		try {
			Query query = em.createNamedQuery("getAltT1pler");
			results = (List<AltT1pler>) query.getResultList();
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
	public List<SelectItem> getAltT1plerSelectList() {
		List<AltT1pler> altT1plerList = getAltT1pler();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (AltT1pler altT1pler : altT1plerList) {
			selectList.add(new SelectItem(altT1pler, mf.format(
					new Object[] { altT1pler.getAlt1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}