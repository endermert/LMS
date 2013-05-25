package entities.yayinTools.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayinTools.D1ller;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayinTools.D1ller.class)
public class D1llerManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public D1llerManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createD1ller(D1ller D1ller) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(D1ller);
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
	public String deleteD1ller(D1ller D1ller) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			D1ller = em.merge(D1ller);
			em.remove(D1ller);
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
	public String updateD1ller(D1ller D1ller) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			D1ller = em.merge(D1ller);
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
	public D1ller findD1llerByD1l1d(short d1l1d) {
		D1ller D1ller = null;
		EntityManager em = getEntityManager();
		try {
			D1ller = (D1ller) em.find(D1ller.class, d1l1d);
		} finally {
			em.close();
		}
		return D1ller;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public D1ller getNewD1ller() {
	
		D1ller D1ller = new D1ller();
	
		return D1ller;
	}

	@NamedQueryTarget("getD1ller")
	public List<D1ller> getD1ller() {
		EntityManager em = getEntityManager();
		List<D1ller> results = null;
		try {
			Query query = em.createNamedQuery("getD1ller");
			results = (List<D1ller>) query.getResultList();
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
	public List<SelectItem> getD1llerSelectList() {
		List<D1ller> D1llerList = getD1ller();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (D1ller D1ller : D1llerList) {
			selectList.add(new SelectItem(D1ller, mf.format(
					new Object[] { D1ller.getD1l1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}