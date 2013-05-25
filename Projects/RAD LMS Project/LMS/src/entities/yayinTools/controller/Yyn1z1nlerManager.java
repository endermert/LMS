package entities.yayinTools.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayinTools.Yyn1z1nler;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayinTools.Yyn1z1nler.class)
public class Yyn1z1nlerManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public Yyn1z1nlerManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createYyn1z1nler(Yyn1z1nler yyn1z1nler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(yyn1z1nler);
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
	public String deleteYyn1z1nler(Yyn1z1nler yyn1z1nler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yyn1z1nler = em.merge(yyn1z1nler);
			em.remove(yyn1z1nler);
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
	public String updateYyn1z1nler(Yyn1z1nler yyn1z1nler) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yyn1z1nler = em.merge(yyn1z1nler);
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
	public Yyn1z1nler findYyn1z1nlerByZ1n1d(short z1n1d) {
		Yyn1z1nler yyn1z1nler = null;
		EntityManager em = getEntityManager();
		try {
			yyn1z1nler = (Yyn1z1nler) em.find(Yyn1z1nler.class, z1n1d);
		} finally {
			em.close();
		}
		return yyn1z1nler;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public Yyn1z1nler getNewYyn1z1nler() {
	
		Yyn1z1nler yyn1z1nler = new Yyn1z1nler();
	
		return yyn1z1nler;
	}

	@NamedQueryTarget("getYyn1z1nler1By1z1n1d")
	public List<Yyn1z1nler> getYyn1z1nler1By1z1n1d(short z1n1d) {
		EntityManager em = getEntityManager();
		List<Yyn1z1nler> results = null;
		try {
			Query query = em.createNamedQuery("getYyn1z1nler1By1z1n1d");
			query.setParameter("z1n1d", z1n1d);
			results = (List<Yyn1z1nler>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYyn1z1nler")
	public List<Yyn1z1nler> getYyn1z1nler() {
		EntityManager em = getEntityManager();
		List<Yyn1z1nler> results = null;
		try {
			Query query = em.createNamedQuery("getYyn1z1nler");
			results = (List<Yyn1z1nler>) query.getResultList();
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
	public List<SelectItem> getYyn1z1nlerSelectList() {
		List<Yyn1z1nler> yyn1z1nlerList = getYyn1z1nler();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (Yyn1z1nler yyn1z1nler : yyn1z1nlerList) {
			selectList.add(new SelectItem(yyn1z1nler, mf.format(
					new Object[] { yyn1z1nler.getZ1n1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}