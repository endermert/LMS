package entities.kullanicilar.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.kullanicilar.Kullan1c1lar;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.kullanicilar.Kullan1c1lar.class)
public class Kullan1c1larManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public Kullan1c1larManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createKullan1c1lar(Kullan1c1lar kullan1c1lar)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(kullan1c1lar);
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
	public String deleteKullan1c1lar(Kullan1c1lar kullan1c1lar)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			kullan1c1lar = em.merge(kullan1c1lar);
			em.remove(kullan1c1lar);
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
	public String updateKullan1c1lar(Kullan1c1lar kullan1c1lar)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			kullan1c1lar = em.merge(kullan1c1lar);
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
	public Kullan1c1lar findKullan1c1larByKul1d(int kul1d) {
		Kullan1c1lar kullan1c1lar = null;
		EntityManager em = getEntityManager();
		try {
			kullan1c1lar = (Kullan1c1lar) em.find(Kullan1c1lar.class, kul1d);
		} finally {
			em.close();
		}
		return kullan1c1lar;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public Kullan1c1lar getNewKullan1c1lar() {
	
		Kullan1c1lar kullan1c1lar = new Kullan1c1lar();
	
		return kullan1c1lar;
	}

	@NamedQueryTarget("getKullan1c1larByKulKodu")
	public List<Kullan1c1lar> getKullan1c1larByKulKodu(String kulKodu) {
		EntityManager em = getEntityManager();
		List<Kullan1c1lar> results = null;
		try {
			Query query = em.createNamedQuery("getKullan1c1larByKulKodu");
			query.setParameter("kulKodu", kulKodu);
			results = (List<Kullan1c1lar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getKullan1c1lar")
	public List<Kullan1c1lar> getKullan1c1lar() {
		EntityManager em = getEntityManager();
		List<Kullan1c1lar> results = null;
		try {
			Query query = em.createNamedQuery("getKullan1c1lar");
			results = (List<Kullan1c1lar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getKullan1c1larByKulEpostaAndSifre")
	public List<Kullan1c1lar> getKullan1c1larByKulEpostaAndSifre(
			String kulEposta, String kulS1fre) {
		EntityManager em = getEntityManager();
		List<Kullan1c1lar> results = null;
		try {
			Query query = em
					.createNamedQuery("getKullan1c1larByKulEpostaAndSifre");
			query.setParameter("kulEposta", kulEposta);
			query.setParameter("kulS1fre", kulS1fre);
			results = (List<Kullan1c1lar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getKullan1c1larByKul1d")
	public List<Kullan1c1lar> getKullan1c1larByKul1d(int kul1d) {
		EntityManager em = getEntityManager();
		List<Kullan1c1lar> results = null;
		try {
			Query query = em.createNamedQuery("getKullan1c1larByKul1d");
			query.setParameter("kul1d", kul1d);
			results = (List<Kullan1c1lar>) query.getResultList();
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
	public List<SelectItem> getKullan1c1larSelectList() {
		List<Kullan1c1lar> kullan1c1larList = getKullan1c1lar();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (Kullan1c1lar kullan1c1lar : kullan1c1larList) {
			selectList.add(new SelectItem(kullan1c1lar, mf.format(
					new Object[] { kullan1c1lar.getKul1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}