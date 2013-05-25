package entities.yayinTools.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayinTools.KtphnBolum;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayinTools.KtphnBolum.class)
public class KtphnBolumManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public KtphnBolumManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createKtphnBolum(KtphnBolum ktphnBolum) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(ktphnBolum);
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
	public String deleteKtphnBolum(KtphnBolum ktphnBolum) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			ktphnBolum = em.merge(ktphnBolum);
			em.remove(ktphnBolum);
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
	public String updateKtphnBolum(KtphnBolum ktphnBolum) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			ktphnBolum = em.merge(ktphnBolum);
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
	public KtphnBolum findKtphnBolumByBlm1d(short blm1d) {
		KtphnBolum ktphnBolum = null;
		EntityManager em = getEntityManager();
		try {
			ktphnBolum = (KtphnBolum) em.find(KtphnBolum.class, blm1d);
		} finally {
			em.close();
		}
		return ktphnBolum;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public KtphnBolum getNewKtphnBolum() {
	
		KtphnBolum ktphnBolum = new KtphnBolum();
	
		return ktphnBolum;
	}

	@NamedQueryTarget("getKtphnBolumByKtphn1d")
	public List<KtphnBolum> getKtphnBolumByKtphn1d(int ktphn1d) {
		EntityManager em = getEntityManager();
		List<KtphnBolum> results = null;
		try {
			Query query = em.createNamedQuery("getKtphnBolumByKtphn1d");
			query.setParameter("ktphn1d", ktphn1d);
			results = (List<KtphnBolum>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getKtphnBolumByBlm1d")
	public List<KtphnBolum> getKtphnBolumByBlm1d(short blm1d) {
		EntityManager em = getEntityManager();
		List<KtphnBolum> results = null;
		try {
			Query query = em.createNamedQuery("getKtphnBolumByBlm1d");
			query.setParameter("blm1d", blm1d);
			results = (List<KtphnBolum>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getKtphnBolum")
	public List<KtphnBolum> getKtphnBolum() {
		EntityManager em = getEntityManager();
		List<KtphnBolum> results = null;
		try {
			Query query = em.createNamedQuery("getKtphnBolum");
			results = (List<KtphnBolum>) query.getResultList();
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
	public List<SelectItem> getKtphnBolumSelectList() {
		List<KtphnBolum> ktphnBolumList = getKtphnBolum();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (KtphnBolum ktphnBolum : ktphnBolumList) {
			selectList.add(new SelectItem(ktphnBolum, mf.format(
					new Object[] { ktphnBolum.getBlm1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}