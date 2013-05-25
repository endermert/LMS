package entities.yayin.controller;

import com.ibm.jpa.web.JPAManager;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;

import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayin.Yay1nRezerveReg;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.Date;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayin.Yay1nRezerveReg.class)
public class Yay1nRezerveRegManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public Yay1nRezerveRegManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createYay1nRezerveReg(Yay1nRezerveReg yay1nRezerveReg)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(yay1nRezerveReg);
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
	public String deleteYay1nRezerveReg(Yay1nRezerveReg yay1nRezerveReg)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yay1nRezerveReg = em.merge(yay1nRezerveReg);
			em.remove(yay1nRezerveReg);
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
	public String updateYay1nRezerveReg(Yay1nRezerveReg yay1nRezerveReg)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yay1nRezerveReg = em.merge(yay1nRezerveReg);
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
	public Yay1nRezerveReg findYay1nRezerveRegByRzv1d(int rzv1d) {
		Yay1nRezerveReg yay1nRezerveReg = null;
		EntityManager em = getEntityManager();
		try {
			yay1nRezerveReg = (Yay1nRezerveReg) em.find(Yay1nRezerveReg.class,
					rzv1d);
		} finally {
			em.close();
		}
		return yay1nRezerveReg;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public Yay1nRezerveReg getNewYay1nRezerveReg() {
	
		Yay1nRezerveReg yay1nRezerveReg = new Yay1nRezerveReg();
	
		return yay1nRezerveReg;
	}

	public List<Yay1nRezerveReg> getYay1nRezerveRegByYyn1dAndKul1d(int kul1d,
			int yyn1d,Date bugunTar) {
		EntityManager em = getEntityManager();
		List<Yay1nRezerveReg> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nRezerveRegByYyn1dAndKul1d");
			query.setParameter("yyn1d", yyn1d);
			query.setParameter("kul1d", kul1d);
			query.setParameter("bugunTar", bugunTar, TemporalType.DATE);
			results = (List<Yay1nRezerveReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nRezerveRegByYyn1d")
	public List<Yay1nRezerveReg> getYay1nRezerveRegByYyn1d(int yyn1d,
			Date bugunTar) {
		EntityManager em = getEntityManager();
		List<Yay1nRezerveReg> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nRezerveRegByYyn1d");
			query.setParameter("yyn1d", yyn1d);
			query.setParameter("bugunTar", bugunTar, TemporalType.DATE);
			results = (List<Yay1nRezerveReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}