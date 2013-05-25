package entities.kullanicilar.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.kullanicilar.KulT1pler;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.kullanicilar.KulT1pler.class)
public class KulT1plerManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public KulT1plerManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createKulT1pler(KulT1pler kulT1pler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(kulT1pler);
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
	public String deleteKulT1pler(KulT1pler kulT1pler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			kulT1pler = em.merge(kulT1pler);
			em.remove(kulT1pler);
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
	public String updateKulT1pler(KulT1pler kulT1pler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			kulT1pler = em.merge(kulT1pler);
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
	public KulT1pler findKulT1plerByT1p1d(short t1p1d) {
		KulT1pler kulT1pler = null;
		EntityManager em = getEntityManager();
		try {
			kulT1pler = (KulT1pler) em.find(KulT1pler.class, t1p1d);
		} finally {
			em.close();
		}
		return kulT1pler;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public KulT1pler getNewKulT1pler() {
	
		KulT1pler kulT1pler = new KulT1pler();
	
		return kulT1pler;
	}

	@NamedQueryTarget("getKulT1pler")
	public List<KulT1pler> getKulT1pler() {
		EntityManager em = getEntityManager();
		List<KulT1pler> results = null;
		try {
			Query query = em.createNamedQuery("getKulT1pler");
			results = (List<KulT1pler>) query.getResultList();
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
	public List<SelectItem> getKulT1plerSelectList() {
		List<KulT1pler> kulT1plerList = getKulT1pler();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (KulT1pler kulT1pler : kulT1plerList) {
			selectList.add(new SelectItem(kulT1pler, mf.format(
					new Object[] { kulT1pler.getT1p1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}