package entities.yayin.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayin.L1stem;
import java.util.List;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayin.L1stem.class)
public class L1stemManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public L1stemManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createL1stem(L1stem L1stem) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(L1stem);
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
	public String deleteL1stem(L1stem L1stem) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			L1stem = em.merge(L1stem);
			em.remove(L1stem);
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
	public String updateL1stem(L1stem L1stem) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			L1stem = em.merge(L1stem);
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
	public L1stem findL1stemByLst1d(int lst1d) {
		L1stem L1stem = null;
		EntityManager em = getEntityManager();
		try {
			L1stem = (L1stem) em.find(L1stem.class, lst1d);
		} finally {
			em.close();
		}
		return L1stem;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public L1stem getNewL1stem() {
	
		L1stem L1stem = new L1stem();
	
		return L1stem;
	}

	@NamedQueryTarget("getL1stemByKul1dOrder")
	public List<L1stem> getL1stemByKul1dOrder(int lstKul1d) {
		EntityManager em = getEntityManager();
		List<L1stem> results = null;
		try {
			Query query = em.createNamedQuery("getL1stemByKul1dOrder");
			query.setParameter("lstKul1d", lstKul1d);
			results = (List<L1stem>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}