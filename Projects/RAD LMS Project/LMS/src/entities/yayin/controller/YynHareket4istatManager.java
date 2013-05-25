package entities.yayin.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayin.YynHareket4istat;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.Date;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayin.YynHareket4istat.class)
public class YynHareket4istatManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public YynHareket4istatManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createYynHareket4istat(YynHareket4istat yynHareket4istat)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(yynHareket4istat);
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
	public String deleteYynHareket4istat(YynHareket4istat yynHareket4istat)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yynHareket4istat = em.merge(yynHareket4istat);
			em.remove(yynHareket4istat);
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
	public String updateYynHareket4istat(YynHareket4istat yynHareket4istat)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yynHareket4istat = em.merge(yynHareket4istat);
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
	public YynHareket4istat findYynHareket4istatByHrk1d(long hrk1d) {
		YynHareket4istat yynHareket4istat = null;
		EntityManager em = getEntityManager();
		try {
			yynHareket4istat = (YynHareket4istat) em.find(
					YynHareket4istat.class, hrk1d);
		} finally {
			em.close();
		}
		return yynHareket4istat;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public YynHareket4istat getNewYynHareket4istat() {
	
		YynHareket4istat yynHareket4istat = new YynHareket4istat();
	
		return yynHareket4istat;
	}

	@NamedQueryTarget("getYynHareket4istatUser")
	public List<YynHareket4istat> getYynHareket4istatUser(int aktKul1d,
			Date l1bVerTar) {
		EntityManager em = getEntityManager();
		List<YynHareket4istat> results = null;
		try {
			Query query = em.createNamedQuery("getYynHareket4istatUser");
			query.setParameter("aktKul1d", aktKul1d);
			query.setParameter("l1bVerTar", l1bVerTar, TemporalType.DATE);
			results = (List<YynHareket4istat>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYynHareket4istatAl")
	public List<YynHareket4istat> getYynHareket4istatAl(Date l1bAlTar) {
		EntityManager em = getEntityManager();
		List<YynHareket4istat> results = null;
		try {
			Query query = em.createNamedQuery("getYynHareket4istatAl");
			query.setParameter("l1bAlTar", l1bAlTar, TemporalType.DATE);
			results = (List<YynHareket4istat>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYynHareket4istatKulVer")
	public List<YynHareket4istat> getYynHareket4istatKulVer(int verenGrvl11d,
			Date l1bVerTar) {
		EntityManager em = getEntityManager();
		List<YynHareket4istat> results = null;
		try {
			Query query = em.createNamedQuery("getYynHareket4istatKulVer");
			query.setParameter("verenGrvl11d", verenGrvl11d);
			query.setParameter("l1bVerTar", l1bVerTar, TemporalType.DATE);
			results = (List<YynHareket4istat>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYynHareket4istatKulAl")
	public List<YynHareket4istat> getYynHareket4istatKulAl(int alanGrvl11d,
			Date l1bAlTar) {
		EntityManager em = getEntityManager();
		List<YynHareket4istat> results = null;
		try {
			Query query = em.createNamedQuery("getYynHareket4istatKulAl");
			query.setParameter("alanGrvl11d", alanGrvl11d);
			query.setParameter("l1bAlTar", l1bAlTar, TemporalType.DATE);
			results = (List<YynHareket4istat>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYynHareket4istatVer")
	public List<YynHareket4istat> getYynHareket4istatVer(Date l1bVerTar) {
		EntityManager em = getEntityManager();
		List<YynHareket4istat> results = null;
		try {
			Query query = em.createNamedQuery("getYynHareket4istatVer");
			query.setParameter("l1bVerTar", l1bVerTar, TemporalType.DATE);
			results = (List<YynHareket4istat>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}