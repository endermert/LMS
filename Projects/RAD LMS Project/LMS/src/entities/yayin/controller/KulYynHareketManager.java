package entities.yayin.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayin.KulYynHareket;
import java.util.List;
import javax.persistence.Query;
import entities.yayin.Yay1nlar;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayin.KulYynHareket.class)
public class KulYynHareketManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public KulYynHareketManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createKulYynHareket(KulYynHareket kulYynHareket)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(kulYynHareket);
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
	public String deleteKulYynHareket(KulYynHareket kulYynHareket)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			kulYynHareket = em.merge(kulYynHareket);
			em.remove(kulYynHareket);
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
	public String updateKulYynHareket(KulYynHareket kulYynHareket)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			kulYynHareket = em.merge(kulYynHareket);
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
	public KulYynHareket findKulYynHareketByHrk1d(long hrk1d) {
		KulYynHareket kulYynHareket = null;
		EntityManager em = getEntityManager();
		try {
			kulYynHareket = (KulYynHareket) em.find(KulYynHareket.class, hrk1d);
		} finally {
			em.close();
		}
		return kulYynHareket;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public KulYynHareket getNewKulYynHareket() {
	
		KulYynHareket kulYynHareket = new KulYynHareket();
	
		return kulYynHareket;
	}

	@NamedQueryTarget("getKulYynHareketByYyn1d")
	public List<KulYynHareket> getKulYynHareketByYyn1d(Yay1nlar yyn1d) {
		EntityManager em = getEntityManager();
		List<KulYynHareket> results = null;
		try {
			Query query = em.createNamedQuery("getKulYynHareketByYyn1d");
			query.setParameter("yyn1d", yyn1d);
			results = (List<KulYynHareket>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getKulYynHareketByVerenGrvl11d")
	public List<KulYynHareket> getKulYynHareketByVerenGrvl11d(int verenGrvl11d) {
		EntityManager em = getEntityManager();
		List<KulYynHareket> results = null;
		try {
			Query query = em.createNamedQuery("getKulYynHareketByVerenGrvl11d");
			query.setParameter("verenGrvl11d", verenGrvl11d);
			results = (List<KulYynHareket>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getKulYynHareketByAlanGrvl11d")
	public List<KulYynHareket> getKulYynHareketByAlanGrvl11d(int alanGrvl11d) {
		EntityManager em = getEntityManager();
		List<KulYynHareket> results = null;
		try {
			Query query = em.createNamedQuery("getKulYynHareketByAlanGrvl11d");
			query.setParameter("alanGrvl11d", alanGrvl11d);
			results = (List<KulYynHareket>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getKulYynHareketByAktKul1d")
	public List<KulYynHareket> getKulYynHareketByAktKul1d(int aktKul1d) {
		EntityManager em = getEntityManager();
		List<KulYynHareket> results = null;
		try {
			Query query = em.createNamedQuery("getKulYynHareketByAktKul1d");
			query.setParameter("aktKul1d", aktKul1d);
			results = (List<KulYynHareket>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}