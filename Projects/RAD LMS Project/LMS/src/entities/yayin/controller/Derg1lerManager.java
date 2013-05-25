package entities.yayin.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayin.Derg1ler;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayin.Derg1ler.class)
public class Derg1lerManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public Derg1lerManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createDerg1ler(Derg1ler derg1ler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(derg1ler);
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
	public String deleteDerg1ler(Derg1ler derg1ler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			derg1ler = em.merge(derg1ler);
			em.remove(derg1ler);
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
	public String updateDerg1ler(Derg1ler derg1ler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			derg1ler = em.merge(derg1ler);
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
	public Derg1ler findDerg1lerByDrg1d(int drg1d) {
		Derg1ler derg1ler = null;
		EntityManager em = getEntityManager();
		try {
			derg1ler = (Derg1ler) em.find(Derg1ler.class, drg1d);
		} finally {
			em.close();
		}
		return derg1ler;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public Derg1ler getNewDerg1ler() {
	
		Derg1ler derg1ler = new Derg1ler();
	
		return derg1ler;
	}

	@NamedQueryTarget("getDerg1ler")
	public List<Derg1ler> getDerg1ler() {
		EntityManager em = getEntityManager();
		List<Derg1ler> results = null;
		try {
			Query query = em.createNamedQuery("getDerg1ler");
			results = (List<Derg1ler>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getDerg1lerByDrg1d")
	public List<Derg1ler> getDerg1lerByDrg1d(int drg1d) {
		EntityManager em = getEntityManager();
		List<Derg1ler> results = null;
		try {
			Query query = em.createNamedQuery("getDerg1lerByDrg1d");
			query.setParameter("drg1d", drg1d);
			results = (List<Derg1ler>) query.getResultList();
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
	public List<SelectItem> getDerg1lerSelectList() {
		List<Derg1ler> derg1lerList = getDerg1ler();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (Derg1ler derg1ler : derg1lerList) {
			selectList.add(new SelectItem(derg1ler, mf.format(
					new Object[] { derg1ler.getDrg1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}