package entities.kullanicilar.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.kullanicilar.KulDurumlar;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.kullanicilar.KulDurumlar.class)
public class KulDurumlarManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public KulDurumlarManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createKulDurumlar(KulDurumlar kulDurumlar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(kulDurumlar);
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
	public String deleteKulDurumlar(KulDurumlar kulDurumlar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			kulDurumlar = em.merge(kulDurumlar);
			em.remove(kulDurumlar);
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
	public String updateKulDurumlar(KulDurumlar kulDurumlar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			kulDurumlar = em.merge(kulDurumlar);
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
	public KulDurumlar findKulDurumlarByDrm1d(short drm1d) {
		KulDurumlar kulDurumlar = null;
		EntityManager em = getEntityManager();
		try {
			kulDurumlar = (KulDurumlar) em.find(KulDurumlar.class, drm1d);
		} finally {
			em.close();
		}
		return kulDurumlar;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public KulDurumlar getNewKulDurumlar() {
	
		KulDurumlar kulDurumlar = new KulDurumlar();
	
		return kulDurumlar;
	}

	@NamedQueryTarget("getKulDurumlar")
	public List<KulDurumlar> getKulDurumlar() {
		EntityManager em = getEntityManager();
		List<KulDurumlar> results = null;
		try {
			Query query = em.createNamedQuery("getKulDurumlar");
			results = (List<KulDurumlar>) query.getResultList();
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
	public List<SelectItem> getKulDurumlarSelectList() {
		List<KulDurumlar> kulDurumlarList = getKulDurumlar();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (KulDurumlar kulDurumlar : kulDurumlarList) {
			selectList.add(new SelectItem(kulDurumlar, mf.format(
					new Object[] { kulDurumlar.getDrm1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}