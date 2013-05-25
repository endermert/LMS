package entities.yayinTools.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayinTools.Kutuphane;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayinTools.Kutuphane.class)
public class KutuphaneManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public KutuphaneManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createKutuphane(Kutuphane kutuphane) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(kutuphane);
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
	public String deleteKutuphane(Kutuphane kutuphane) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			kutuphane = em.merge(kutuphane);
			em.remove(kutuphane);
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
	public String updateKutuphane(Kutuphane kutuphane) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			kutuphane = em.merge(kutuphane);
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
	public Kutuphane findKutuphaneByKtphn1d(int ktphn1d) {
		Kutuphane kutuphane = null;
		EntityManager em = getEntityManager();
		try {
			kutuphane = (Kutuphane) em.find(Kutuphane.class, ktphn1d);
		} finally {
			em.close();
		}
		return kutuphane;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public Kutuphane getNewKutuphane() {
	
		Kutuphane kutuphane = new Kutuphane();
	
		return kutuphane;
	}

	@NamedQueryTarget("getKutuphane")
	public List<Kutuphane> getKutuphane() {
		EntityManager em = getEntityManager();
		List<Kutuphane> results = null;
		try {
			Query query = em.createNamedQuery("getKutuphane");
			results = (List<Kutuphane>) query.getResultList();
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
	public List<SelectItem> getKutuphaneSelectList() {
		List<Kutuphane> kutuphaneList = getKutuphane();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (Kutuphane kutuphane : kutuphaneList) {
			selectList.add(new SelectItem(kutuphane, mf.format(
					new Object[] { kutuphane.getKtphn1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}