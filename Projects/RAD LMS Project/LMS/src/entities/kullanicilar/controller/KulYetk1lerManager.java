package entities.kullanicilar.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.kullanicilar.KulYetk1ler;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.kullanicilar.KulYetk1ler.class)
public class KulYetk1lerManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public KulYetk1lerManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createKulYetk1ler(KulYetk1ler kulYetk1ler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(kulYetk1ler);
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
	public String deleteKulYetk1ler(KulYetk1ler kulYetk1ler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			kulYetk1ler = em.merge(kulYetk1ler);
			em.remove(kulYetk1ler);
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
	public String updateKulYetk1ler(KulYetk1ler kulYetk1ler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			kulYetk1ler = em.merge(kulYetk1ler);
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
	public KulYetk1ler findKulYetk1lerByYet1d(short yet1d) {
		KulYetk1ler kulYetk1ler = null;
		EntityManager em = getEntityManager();
		try {
			kulYetk1ler = (KulYetk1ler) em.find(KulYetk1ler.class, yet1d);
		} finally {
			em.close();
		}
		return kulYetk1ler;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public KulYetk1ler getNewKulYetk1ler() {
	
		KulYetk1ler kulYetk1ler = new KulYetk1ler();
	
		return kulYetk1ler;
	}

	@NamedQueryTarget("getKulYetk1ler")
	public List<KulYetk1ler> getKulYetk1ler() {
		EntityManager em = getEntityManager();
		List<KulYetk1ler> results = null;
		try {
			Query query = em.createNamedQuery("getKulYetk1ler");
			results = (List<KulYetk1ler>) query.getResultList();
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
	public List<SelectItem> getKulYetk1lerSelectList() {
		List<KulYetk1ler> kulYetk1lerList = getKulYetk1ler();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (KulYetk1ler kulYetk1ler : kulYetk1lerList) {
			selectList.add(new SelectItem(kulYetk1ler, mf.format(
					new Object[] { kulYetk1ler.getYet1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}