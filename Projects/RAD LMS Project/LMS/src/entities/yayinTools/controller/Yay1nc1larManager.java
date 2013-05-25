package entities.yayinTools.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayinTools.Yay1nc1lar;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayinTools.Yay1nc1lar.class)
public class Yay1nc1larManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public Yay1nc1larManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createYay1nc1lar(Yay1nc1lar yay1nc1lar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(yay1nc1lar);
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
	public String deleteYay1nc1lar(Yay1nc1lar yay1nc1lar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yay1nc1lar = em.merge(yay1nc1lar);
			em.remove(yay1nc1lar);
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
	public String updateYay1nc1lar(Yay1nc1lar yay1nc1lar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yay1nc1lar = em.merge(yay1nc1lar);
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
	public Yay1nc1lar findYay1nc1larByYnc1d(int ync1d) {
		Yay1nc1lar yay1nc1lar = null;
		EntityManager em = getEntityManager();
		try {
			yay1nc1lar = (Yay1nc1lar) em.find(Yay1nc1lar.class, ync1d);
		} finally {
			em.close();
		}
		return yay1nc1lar;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public Yay1nc1lar getNewYay1nc1lar() {
	
		Yay1nc1lar yay1nc1lar = new Yay1nc1lar();
	
		return yay1nc1lar;
	}

	@NamedQueryTarget("getYay1nc1lar")
	public List<Yay1nc1lar> getYay1nc1lar() {
		EntityManager em = getEntityManager();
		List<Yay1nc1lar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nc1lar");
			results = (List<Yay1nc1lar>) query.getResultList();
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
	public List<SelectItem> getYay1nc1larSelectList() {
		List<Yay1nc1lar> yay1nc1larList = getYay1nc1lar();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (Yay1nc1lar yay1nc1lar : yay1nc1larList) {
			selectList.add(new SelectItem(yay1nc1lar, mf.format(
					new Object[] { yay1nc1lar.getYnc1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}