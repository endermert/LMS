package entities.yayin.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayin.Yay1nRezerve;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.Date;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayin.Yay1nRezerve.class)
public class Yay1nRezerveManager {

	@Resource
	private UserTransaction utx;
	@PersistenceUnit
	private EntityManagerFactory emf;

	public Yay1nRezerveManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createYay1nRezerve(Yay1nRezerve yay1nRezerve)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(yay1nRezerve);
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
	public String deleteYay1nRezerve(Yay1nRezerve yay1nRezerve)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yay1nRezerve = em.merge(yay1nRezerve);
			em.remove(yay1nRezerve);
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
	public String updateYay1nRezerve(Yay1nRezerve yay1nRezerve)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yay1nRezerve = em.merge(yay1nRezerve);
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
	public Yay1nRezerve findYay1nRezerveByRzv1d(int rzv1d) {
		Yay1nRezerve yay1nRezerve = null;
		EntityManager em = getEntityManager();
		try {
			yay1nRezerve = (Yay1nRezerve) em.find(Yay1nRezerve.class, rzv1d);
		} finally {
			em.close();
		}
		return yay1nRezerve;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public Yay1nRezerve getNewYay1nRezerve() {
	
		Yay1nRezerve yay1nRezerve = new Yay1nRezerve();
	
		return yay1nRezerve;
	}

	@NamedQueryTarget("getYay1nRezerveBykul1d")
	public List<Yay1nRezerve> getYay1nRezerveBykul1d(int kul1d, Date bugunTar) {
		EntityManager em = getEntityManager();
		List<Yay1nRezerve> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nRezerveBykul1d");
			query.setParameter("kul1d", kul1d);
			query.setParameter("bugunTar", bugunTar, TemporalType.DATE);
			results = (List<Yay1nRezerve>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}