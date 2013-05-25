package entities.yayin.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayin.Yay1nlar;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayin.Yay1nlar.class)
public class Yay1nlarManager1 {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public Yay1nlarManager1() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createYay1nlar(Yay1nlar yay1nlar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(yay1nlar);
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
	public String deleteYay1nlar(Yay1nlar yay1nlar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yay1nlar = em.merge(yay1nlar);
			em.remove(yay1nlar);
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
	public String updateYay1nlar(Yay1nlar yay1nlar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yay1nlar = em.merge(yay1nlar);
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
	public Yay1nlar findYay1nlarByYyn1d(int yyn1d) {
		Yay1nlar yay1nlar = null;
		EntityManager em = getEntityManager();
		try {
			yay1nlar = (Yay1nlar) em.find(Yay1nlar.class, yyn1d);
		} finally {
			em.close();
		}
		return yay1nlar;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public Yay1nlar getNewYay1nlar() {
	
		Yay1nlar yay1nlar = new Yay1nlar();
	
		return yay1nlar;
	}

	@NamedQueryTarget("getYay1nlarGenelKriter1")
	public List<Yay1nlar> getYay1nlarGenelKriter1() {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarGenelKriter1");
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlar")
	public List<Yay1nlar> getYay1nlar() {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlar");
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByTez1d")
	public List<Yay1nlar> getYay1nlarByTez1d(Object tez1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByTez1d");
			query.setParameter("tez1d", tez1d);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByKtp1d")
	public List<Yay1nlar> getYay1nlarByKtp1d(Object ktp1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByKtp1d");
			query.setParameter("ktp1d", ktp1d);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByHrk1d")
	public List<Yay1nlar> getYay1nlarByHrk1d(Object hrk1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByHrk1d");
			query.setParameter("hrk1d", hrk1d);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByFlm1d")
	public List<Yay1nlar> getYay1nlarByFlm1d(Object flm1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByFlm1d");
			query.setParameter("flm1d", flm1d);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByDrg1d")
	public List<Yay1nlar> getYay1nlarByDrg1d(Object drg1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByDrg1d");
			query.setParameter("drg1d", drg1d);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByAyr1d")
	public List<Yay1nlar> getYay1nlarByAyr1d(Object ayr1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByAyr1d");
			query.setParameter("ayr1d", ayr1d);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByYynKodu")
	public List<Yay1nlar> getYay1nlarByYynKodu(String yynKodu) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByYynKodu");
			query.setParameter("yynKodu", yynKodu);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByT1p1d")
	public List<Yay1nlar> getYay1nlarByT1p1d(short t1p1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByT1p1d");
			query.setParameter("t1p1d", t1p1d);
			results = (List<Yay1nlar>) query.getResultList();
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
	public List<SelectItem> getYay1nlarSelectList() {
		List<Yay1nlar> yay1nlarList = getYay1nlar();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (Yay1nlar yay1nlar : yay1nlarList) {
			selectList.add(new SelectItem(yay1nlar, mf.format(
					new Object[] { yay1nlar.getYyn1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}