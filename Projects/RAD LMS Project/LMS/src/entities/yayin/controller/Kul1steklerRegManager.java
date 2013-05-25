package entities.yayin.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayin.Kul1steklerReg;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayin.Kul1steklerReg.class)
public class Kul1steklerRegManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public Kul1steklerRegManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createKul1steklerReg(Kul1steklerReg kul1steklerReg)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(kul1steklerReg);
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
	public String deleteKul1steklerReg(Kul1steklerReg kul1steklerReg)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			kul1steklerReg = em.merge(kul1steklerReg);
			em.remove(kul1steklerReg);
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
	public String updateKul1steklerReg(Kul1steklerReg kul1steklerReg)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			kul1steklerReg = em.merge(kul1steklerReg);
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
	public Kul1steklerReg findKul1steklerRegByWnt1d(int wnt1d) {
		Kul1steklerReg kul1steklerReg = null;
		EntityManager em = getEntityManager();
		try {
			kul1steklerReg = (Kul1steklerReg) em.find(Kul1steklerReg.class,
					wnt1d);
		} finally {
			em.close();
		}
		return kul1steklerReg;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public Kul1steklerReg getNewKul1steklerReg() {
	
		Kul1steklerReg kul1steklerReg = new Kul1steklerReg();
	
		return kul1steklerReg;
	}

	@NamedQueryTarget("getKul1steklerReg")
	public List<Kul1steklerReg> getKul1steklerReg() {
		EntityManager em = getEntityManager();
		List<Kul1steklerReg> results = null;
		try {
			Query query = em.createNamedQuery("getKul1steklerReg");
			results = (List<Kul1steklerReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getKul1steklerRegByBek")
	public List<Kul1steklerReg> getKul1steklerRegByBek() {
		EntityManager em = getEntityManager();
		List<Kul1steklerReg> results = null;
		try {
			Query query = em.createNamedQuery("getKul1steklerRegByBek");
			results = (List<Kul1steklerReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getKul1steklerRegByKul1dOrder")
	public List<Kul1steklerReg> getKul1steklerRegByKul1dOrder(int wntKul1d) {
		EntityManager em = getEntityManager();
		List<Kul1steklerReg> results = null;
		try {
			Query query = em.createNamedQuery("getKul1steklerRegByKul1dOrder");
			query.setParameter("wntKul1d", wntKul1d);
			results = (List<Kul1steklerReg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getKul1steklerRegByKulAndYynAndDrm")
	public List<Kul1steklerReg> getKul1steklerRegByKulAndYynAndDrm(
			int wntKul1d, int wntYyn1d) {
		EntityManager em = getEntityManager();
		List<Kul1steklerReg> results = null;
		try {
			Query query = em
					.createNamedQuery("getKul1steklerRegByKulAndYynAndDrm");
			query.setParameter("wntKul1d", wntKul1d);
			query.setParameter("wntYyn1d", wntYyn1d);
			results = (List<Kul1steklerReg>) query.getResultList();
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
	public List<SelectItem> getKul1steklerRegSelectList() {
		List<Kul1steklerReg> kul1steklerRegList = getKul1steklerReg();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (Kul1steklerReg kul1steklerReg : kul1steklerRegList) {
			selectList.add(new SelectItem(kul1steklerReg, mf.format(
					new Object[] { kul1steklerReg.getWnt1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}