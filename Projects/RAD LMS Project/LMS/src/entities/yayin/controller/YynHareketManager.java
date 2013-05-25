package entities.yayin.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayin.YynHareket;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayin.YynHareket.class)
public class YynHareketManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public YynHareketManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createYynHareket(YynHareket yynHareket) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(yynHareket);
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
	public String deleteYynHareket(YynHareket yynHareket) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yynHareket = em.merge(yynHareket);
			em.remove(yynHareket);
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
	public String updateYynHareket(YynHareket yynHareket) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yynHareket = em.merge(yynHareket);
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
	public YynHareket findYynHareketByHrk1d(long hrk1d) {
		YynHareket yynHareket = null;
		EntityManager em = getEntityManager();
		try {
			yynHareket = (YynHareket) em.find(YynHareket.class, hrk1d);
		} finally {
			em.close();
		}
		return yynHareket;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public YynHareket getNewYynHareket() {
	
		YynHareket yynHareket = new YynHareket();
	
		return yynHareket;
	}

	@NamedQueryTarget("getYynHareketByYyn1d")
	public List<YynHareket> getYynHareketByYyn1d(int yyn1d) {
		EntityManager em = getEntityManager();
		List<YynHareket> results = null;
		try {
			Query query = em.createNamedQuery("getYynHareketByYyn1d");
			query.setParameter("yyn1d", yyn1d);
			results = (List<YynHareket>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYynHareketByVerenGrvl11d")
	public List<YynHareket> getYynHareketByVerenGrvl11d(int verenGrvl11d) {
		EntityManager em = getEntityManager();
		List<YynHareket> results = null;
		try {
			Query query = em.createNamedQuery("getYynHareketByVerenGrvl11d");
			query.setParameter("verenGrvl11d", verenGrvl11d);
			results = (List<YynHareket>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYynHareketByAlanGrvl11d")
	public List<YynHareket> getYynHareketByAlanGrvl11d(int alanGrvl11d) {
		EntityManager em = getEntityManager();
		List<YynHareket> results = null;
		try {
			Query query = em.createNamedQuery("getYynHareketByAlanGrvl11d");
			query.setParameter("alanGrvl11d", alanGrvl11d);
			results = (List<YynHareket>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYynHareketByAktKul1d")
	public List<YynHareket> getYynHareketByAktKul1d(int aktKul1d) {
		EntityManager em = getEntityManager();
		List<YynHareket> results = null;
		try {
			Query query = em.createNamedQuery("getYynHareketByAktKul1d");
			query.setParameter("aktKul1d", aktKul1d);
			results = (List<YynHareket>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYynHareketByHrk1d")
	public List<YynHareket> getYynHareketByHrk1d(long hrk1d) {
		EntityManager em = getEntityManager();
		List<YynHareket> results = null;
		try {
			Query query = em.createNamedQuery("getYynHareketByHrk1d");
			query.setParameter("hrk1d", hrk1d);
			results = (List<YynHareket>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYynHareket")
	public List<YynHareket> getYynHareket() {
		EntityManager em = getEntityManager();
		List<YynHareket> results = null;
		try {
			Query query = em.createNamedQuery("getYynHareket");
			results = (List<YynHareket>) query.getResultList();
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
	public List<SelectItem> getYynHareketSelectList() {
		List<YynHareket> yynHareketList = getYynHareket();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (YynHareket yynHareket : yynHareketList) {
			selectList.add(new SelectItem(yynHareket, mf.format(
					new Object[] { yynHareket.getHrk1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}