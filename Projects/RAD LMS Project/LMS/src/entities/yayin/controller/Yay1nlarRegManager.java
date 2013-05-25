package entities.yayin.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayin.Yay1nlarReg;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayin.Yay1nlarReg.class)
public class Yay1nlarRegManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public Yay1nlarRegManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createYay1nlarReg(Yay1nlarReg yay1nlarReg) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(yay1nlarReg);
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
	public String deleteYay1nlarReg(Yay1nlarReg yay1nlarReg) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yay1nlarReg = em.merge(yay1nlarReg);
			em.remove(yay1nlarReg);
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
	public String updateYay1nlarReg(Yay1nlarReg yay1nlarReg) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yay1nlarReg = em.merge(yay1nlarReg);
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
	public Yay1nlarReg findYay1nlarRegByYyn1d(int yyn1d) {
		Yay1nlarReg yay1nlarReg = null;
		EntityManager em = getEntityManager();
		try {
			yay1nlarReg = (Yay1nlarReg) em.find(Yay1nlarReg.class, yyn1d);
		} finally {
			em.close();
		}
		return yay1nlarReg;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public Yay1nlarReg getNewYay1nlarReg() {
	
		Yay1nlarReg yay1nlarReg = new Yay1nlarReg();
	
		return yay1nlarReg;
	}

	@NamedQueryTarget("getYay1nlarRegByTez1d")
	public List<Yay1nlarReg> getYay1nlarRegByTez1d(int tez1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlarReg> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarRegByTez1d");
			query.setParameter("tez1d", tez1d);
			results = (List<Yay1nlarReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarRegByFlm1d")
	public List<Yay1nlarReg> getYay1nlarRegByFlm1d(int flm1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlarReg> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarRegByFlm1d");
			query.setParameter("flm1d", flm1d);
			results = (List<Yay1nlarReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarRegByAyr1d")
	public List<Yay1nlarReg> getYay1nlarRegByAyr1d(int ayr1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlarReg> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarRegByAyr1d");
			query.setParameter("ayr1d", ayr1d);
			results = (List<Yay1nlarReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarRegByYynKodu")
	public List<Yay1nlarReg> getYay1nlarRegByYynKodu(String yynKodu) {
		EntityManager em = getEntityManager();
		List<Yay1nlarReg> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarRegByYynKodu");
			query.setParameter("yynKodu", yynKodu);
			results = (List<Yay1nlarReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarRegByT1p1d")
	public List<Yay1nlarReg> getYay1nlarRegByT1p1d(short t1p1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlarReg> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarRegByT1p1d");
			query.setParameter("t1p1d", t1p1d);
			results = (List<Yay1nlarReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarRegByKtp1d")
	public List<Yay1nlarReg> getYay1nlarRegByKtp1d(int ktp1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlarReg> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarRegByKtp1d");
			query.setParameter("ktp1d", ktp1d);
			results = (List<Yay1nlarReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarRegByHrk1d")
	public List<Yay1nlarReg> getYay1nlarRegByHrk1d(long hrk1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlarReg> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarRegByHrk1d");
			query.setParameter("hrk1d", hrk1d);
			results = (List<Yay1nlarReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarRegByDrg1d")
	public List<Yay1nlarReg> getYay1nlarRegByDrg1d(int drg1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlarReg> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarRegByDrg1d");
			query.setParameter("drg1d", drg1d);
			results = (List<Yay1nlarReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarRegByYyn1d")
	public List<Yay1nlarReg> getYay1nlarRegByYyn1d(int yyn1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlarReg> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarRegByYyn1d");
			query.setParameter("yyn1d", yyn1d);
			results = (List<Yay1nlarReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarReg")
	public List<Yay1nlarReg> getYay1nlarReg() {
		EntityManager em = getEntityManager();
		List<Yay1nlarReg> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarReg");
			results = (List<Yay1nlarReg>) query.getResultList();
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
	public List<SelectItem> getYay1nlarRegSelectList() {
		List<Yay1nlarReg> yay1nlarRegList = getYay1nlarReg();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (Yay1nlarReg yay1nlarReg : yay1nlarRegList) {
			selectList.add(new SelectItem(yay1nlarReg, mf.format(
					new Object[] { yay1nlarReg.getYyn1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}