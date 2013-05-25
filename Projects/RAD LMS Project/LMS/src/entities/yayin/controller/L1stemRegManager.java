package entities.yayin.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayin.L1stemReg;
import java.util.List;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayin.L1stemReg.class)
public class L1stemRegManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public L1stemRegManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createL1stemReg(L1stemReg L1stemReg) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(L1stemReg);
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
	public String deleteL1stemReg(L1stemReg L1stemReg) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			L1stemReg = em.merge(L1stemReg);
			em.remove(L1stemReg);
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
	public String updateL1stemReg(L1stemReg L1stemReg) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			L1stemReg = em.merge(L1stemReg);
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
	public L1stemReg findL1stemRegByLst1d(int lst1d) {
		L1stemReg L1stemReg = null;
		EntityManager em = getEntityManager();
		try {
			L1stemReg = (L1stemReg) em.find(L1stemReg.class, lst1d);
		} finally {
			em.close();
		}
		return L1stemReg;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public L1stemReg getNewL1stemReg() {
	
		L1stemReg L1stemReg = new L1stemReg();
	
		return L1stemReg;
	}

	@NamedQueryTarget("getL1stemRegByKul1dAndYyn1d")
	public List<L1stemReg> getL1stemRegByKul1dAndYyn1d(int lstKul1d,
			int lstYyn1d) {
		EntityManager em = getEntityManager();
		List<L1stemReg> results = null;
		try {
			Query query = em.createNamedQuery("getL1stemRegByKul1dAndYyn1d");
			query.setParameter("lstKul1d", lstKul1d);
			query.setParameter("lstYyn1d", lstYyn1d);
			results = (List<L1stemReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}