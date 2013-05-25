package entities.yayin.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayin.K1taplar;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayin.K1taplar.class)
public class K1taplarManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public K1taplarManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createK1taplar(K1taplar K1taplar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(K1taplar);
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
	public String deleteK1taplar(K1taplar K1taplar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			K1taplar = em.merge(K1taplar);
			em.remove(K1taplar);
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
	public String updateK1taplar(K1taplar K1taplar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			K1taplar = em.merge(K1taplar);
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
	public K1taplar findK1taplarByKtp1d(int ktp1d) {
		K1taplar K1taplar = null;
		EntityManager em = getEntityManager();
		try {
			K1taplar = (K1taplar) em.find(K1taplar.class, ktp1d);
		} finally {
			em.close();
		}
		return K1taplar;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public K1taplar getNewK1taplar() {
	
		K1taplar K1taplar = new K1taplar();
	
		return K1taplar;
	}

	@NamedQueryTarget("getK1taplar")
	public List<K1taplar> getK1taplar() {
		EntityManager em = getEntityManager();
		List<K1taplar> results = null;
		try {
			Query query = em.createNamedQuery("getK1taplar");
			results = (List<K1taplar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getK1taplarByKtp1d")
	public List<K1taplar> getK1taplarByKtp1d(int ktp1d) {
		EntityManager em = getEntityManager();
		List<K1taplar> results = null;
		try {
			Query query = em.createNamedQuery("getK1taplarByKtp1d");
			query.setParameter("ktp1d", ktp1d);
			results = (List<K1taplar>) query.getResultList();
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
	public List<SelectItem> getK1taplarSelectList() {
		List<K1taplar> K1taplarList = getK1taplar();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (K1taplar K1taplar : K1taplarList) {
			selectList.add(new SelectItem(K1taplar, mf.format(
					new Object[] { K1taplar.getKtp1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}