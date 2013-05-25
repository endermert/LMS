package entities.yayin.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayin.YynAyr1nt1Reg;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayin.YynAyr1nt1Reg.class)
public class YynAyr1nt1RegManager {

	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public YynAyr1nt1RegManager() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createYynAyr1nt1Reg(YynAyr1nt1Reg yynAyr1nt1Reg)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(yynAyr1nt1Reg);
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
	public String deleteYynAyr1nt1Reg(YynAyr1nt1Reg yynAyr1nt1Reg)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yynAyr1nt1Reg = em.merge(yynAyr1nt1Reg);
			em.remove(yynAyr1nt1Reg);
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
	public String updateYynAyr1nt1Reg(YynAyr1nt1Reg yynAyr1nt1Reg)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yynAyr1nt1Reg = em.merge(yynAyr1nt1Reg);
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
	public YynAyr1nt1Reg findYynAyr1nt1RegByAyr1d(int ayr1d) {
		YynAyr1nt1Reg yynAyr1nt1Reg = null;
		EntityManager em = getEntityManager();
		try {
			yynAyr1nt1Reg = (YynAyr1nt1Reg) em.find(YynAyr1nt1Reg.class, ayr1d);
		} finally {
			em.close();
		}
		return yynAyr1nt1Reg;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public YynAyr1nt1Reg getNewYynAyr1nt1Reg() {
	
		YynAyr1nt1Reg yynAyr1nt1Reg = new YynAyr1nt1Reg();
	
		return yynAyr1nt1Reg;
	}

	@NamedQueryTarget("getYynAyr1nt1Reg")
	public List<YynAyr1nt1Reg> getYynAyr1nt1Reg() {
		EntityManager em = getEntityManager();
		List<YynAyr1nt1Reg> results = null;
		try {
			Query query = em.createNamedQuery("getYynAyr1nt1Reg");
			results = (List<YynAyr1nt1Reg>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYynAyr1nt1RegByAyr1d")
	public List<YynAyr1nt1Reg> getYynAyr1nt1RegByAyr1d(int ayr1d) {
		EntityManager em = getEntityManager();
		List<YynAyr1nt1Reg> results = null;
		try {
			Query query = em.createNamedQuery("getYynAyr1nt1RegByAyr1d");
			query.setParameter("ayr1d", ayr1d);
			results = (List<YynAyr1nt1Reg>) query.getResultList();
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
	public List<SelectItem> getYynAyr1nt1RegSelectList() {
		List<YynAyr1nt1Reg> yynAyr1nt1RegList = getYynAyr1nt1Reg();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (YynAyr1nt1Reg yynAyr1nt1Reg : yynAyr1nt1RegList) {
			selectList.add(new SelectItem(yynAyr1nt1Reg, mf.format(
					new Object[] { yynAyr1nt1Reg.getAyr1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}