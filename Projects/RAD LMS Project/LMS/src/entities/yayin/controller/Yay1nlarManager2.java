package entities.yayin.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import entities.yayin.Yay1nlar;
import java.util.List;
import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.faces.model.SelectItem;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = entities.yayin.Yay1nlar.class)
public class Yay1nlarManager2 {

	protected static final class NamedQueries {

		protected static final String getKriter1 = "SELECT y FROM Yay1nlar y WHERE y.yynKodu LIKE :q3 OR y.ktp1d.ktpAd LIKE :q4 OR y.drg1d.drgAd LIKE :q5 OR y.ktp1d.ktpYazar LIKE :q6 OR y.ayr1d.yaySorumlular LIKE :q7 OR y.ayr1d.yayKonuBasl1k LIKE :q8 OR y.ayr1d.yayAnahtarKel1meler LIKE :q9 OR y.ayr1d.yayNotlar LIKE :q10 OR y.ayr1d.yayBasB1lg LIKE :q11 OR y.ayr1d.yayOzOzet1cndklr LIKE :q12 OR y.ayr1d.yayS1n1flama LIKE :q13 OR y.ayr1d.yayDem1rbas LIKE :q14";
		protected static final String getBasit="SELECT y FROM Yay1nlar y WHERE LOWER(y.yynKodu) LIKE :d0 OR LOWER(y.ktp1d.ktpAd) LIKE :d1 OR LOWER(y.drg1d.drgAd) LIKE :d2 OR LOWER(y.ktp1d.ktp1sbn) LIKE :d3 OR LOWER(y.drg1d.drg1ssn) LIKE :d4 OR LOWER(y.ktp1d.ktpYazar) LIKE :d5 OR LOWER(y.ayr1d.yaySorumlular) LIKE :d6 OR LOWER(y.ayr1d.yayKonuBasl1k) LIKE :d7 OR LOWER(y.ayr1d.yayAnahtarKel1meler) LIKE :d8 OR LOWER(y.ayr1d.yayNotlar) LIKE :d9 OR LOWER(y.ayr1d.yayBasB1lg) LIKE :d10 OR LOWER(y.ayr1d.yayOzOzet1cndklr) LIKE :d11 OR LOWER(y.ayr1d.yayS1n1flama) LIKE :d12 OR LOWER(y.ayr1d.yayDem1rbas) LIKE :d13";
		}
		
	@PersistenceUnit
	private EntityManagerFactory emf;
	@Resource
	private UserTransaction utx;

	public Yay1nlarManager2() {
	
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public String createYay1nlar(Yay1nlar yay1nlar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			em.persist(yay1nlar);
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
	public String deleteYay1nlar(Yay1nlar yay1nlar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yay1nlar = em.merge(yay1nlar);
			em.remove(yay1nlar);
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
	public String updateYay1nlar(Yay1nlar yay1nlar) throws Exception {
		EntityManager em = getEntityManager();
		try {
			utx.begin();
			em.joinTransaction();
			yay1nlar = em.merge(yay1nlar);
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
	public Yay1nlar findYay1nlarByYyn1d(int yyn1d) {
		Yay1nlar yay1nlar = null;
		EntityManager em = getEntityManager();
		try {
			yay1nlar = (Yay1nlar) em.find(Yay1nlar.class, yyn1d);
		} finally {
			em.close();
		}
		return yay1nlar;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public Yay1nlar getNewYay1nlar() {
	
		Yay1nlar yay1nlar = new Yay1nlar();
	
		return yay1nlar;
	}
	
	public List<Yay1nlar> getYay1nlarByK1tapAra(String[][] alanlar) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			String sorgu=null;
			String srg="SELECT y FROM Yay1nlar y ";
			String sart1="",sart2="";
			
			short syc1=0;
			int i=0;
			for (i=0;i<17;i++){
				if (alanlar[i][2].length()>1){
					if (syc1>0)
						sart1=sart1 + " AND";
					if (i<10)
						sart1= sart1 + " LOWER(" + alanlar[i][0] + ") LIKE '" + alanlar[i][2]+"'";
					else
						sart1= sart1 + " " + alanlar[i][0] + " LIKE '" + alanlar[i][2]+"'";
					syc1++;
				}
			}
			
			short syc2=0;
			for (i=17;i<26;i++){
				if (Integer.parseInt((String) alanlar[i][2])!=0){
					if (syc2>0 || syc1>0)
						sart1=sart1 + " AND";
					
					sart1= sart1 + " " + alanlar[i][0] + " = " + alanlar[i][2];
					syc2++;
					
				}
			}
			
			if (alanlar[29][2].length()>1){
				if (syc1>0 || syc2>0)
					sart2=" AND " + alanlar[29][0] + " " + alanlar[29][3] + " '" + alanlar[29][2]+"'"; 
				else
					sart2=" " + alanlar[29][0] + " " + alanlar[29][3] + " '" + alanlar[29][2]+"'";
			}
			
			if (syc1>0 || syc2>0 || sart2.length()>1){
				sorgu=srg+" WHERE y.t1p1d = 1 AND "+sart1 + sart2;
				
			System.out.println(sorgu);
			Query query = em.createQuery(sorgu);
			results = (List<Yay1nlar>) query.getResultList();
			}
		} finally {
			em.close();
		}
		return results;
	}
	
	public List<Yay1nlar> getYay1nlarByDerg1Ara(String[][] alanlar) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			String sorgu=null;
			String srg="SELECT y FROM Yay1nlar y ";
			String sart1="",sart2="";
			
			short syc1=0;
			int i=0;
			for (i=0;i<17;i++){
				if (alanlar[i][2].length()>1){
					if (syc1>0)
						sart1=sart1 + " AND";
					if (i<10)
						sart1= sart1 + " LOWER(" + alanlar[i][0] + ") LIKE '" + alanlar[i][2]+"'";
					else
						sart1= sart1 + " " + alanlar[i][0] + " LIKE '" + alanlar[i][2]+"'";
					syc1++;
				}
			}
			
			short syc2=0;
			for (i=17;i<27;i++){
				if (Integer.parseInt((String) alanlar[i][2])!=0){
					if (syc2>0 || syc1>0)
						sart1=sart1 + " AND";
					
					sart1= sart1 + " " + alanlar[i][0] + " = " + alanlar[i][2];
					syc2++;
					
				}
			}
			
			if (alanlar[30][2].length()>1){
				if (syc1>0 || syc2>0)
					sart2=" AND " + alanlar[30][0] + " " + alanlar[30][3] + " '" + alanlar[30][2]+"'"; 
				else
					sart2=" " + alanlar[30][0] + " " + alanlar[30][3] + " '" + alanlar[30][2]+"'";
			}
			i=37;
			
			if (Integer.parseInt((String) alanlar[i][2])!=0){
				if (syc2>0 || syc1>0 || alanlar[30][2].length()>1)
					sart2=sart2 + " AND";
				
				sart2= sart2 +" " + alanlar[i][0] + " = '" + alanlar[i][2]+"'";
				syc2++;
				
			}
			
			if (syc1>0 || syc2>0 || sart2.length()>1){
				sorgu=srg+" WHERE y.t1p1d = 2 AND "+sart1 + sart2;
				
			System.out.println(sorgu);
			Query query = em.createQuery(sorgu);
			results = (List<Yay1nlar>) query.getResultList();
			}
		} finally {
			em.close();
		}
		return results;
	}
	
	public List<Yay1nlar> getYay1nlarByOzelArama1(String[][] alanlar,byte Secim) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		Query query=null;
		try {
			String sorgu=null;
			String srg="SELECT y FROM Yay1nlar y ";
			String sart="",sart1="",sart2="";
			int i;
			
			if (Secim==(byte)0 || Secim==(byte)1 ){
				short syc1=0;
				for (i=0;i<17;i++){
					if (!alanlar[i][2].equalsIgnoreCase("0")){
						if (syc1>0)
							sart1=sart1 + " OR";
						if (i<9)
							sart1= sart1 + " LOWER(" + alanlar[i][0] + ") LIKE :" + alanlar[i][1];
						else
							sart1= sart1 + " " + alanlar[i][0] + " LIKE :" + alanlar[i][1];
						syc1++;
					}
				}
				
				short syc2=0;
				if (Secim==(byte)1){
					for (i=17;i<45;i++){
						if (Integer.parseInt((String) alanlar[i][2])!=0){
							if (syc2>0)
								sart2=sart2 + alanlar[i][3];
							
							sart2= sart2 + " " + alanlar[i][0] + " = :" + alanlar[i][1];
							syc2++;
							
						}
					}
				}
				short say=0;
				if (syc2>0){
					for (i=0;i<sart2.length();i++)
						if (sart2.substring(i,i+1).equalsIgnoreCase("(") || sart2.substring(i,i+1).equalsIgnoreCase(")"))
							say++;
					
					System.out.println("say--"+(say%2));
					if ((short)(say%2)!=0)
						sart2=sart2+")";
				}
						
				
				if (syc1>0 )
					sart=" ("+sart1+")";
				
				if (syc2>0 )
					sart=" ("+sart2+")";
				
				if (syc1>0 && syc2>0 )
					sart=" ("+sart1+") AND ("+sart2+")";
				
				if (syc1>0 || syc2>0){
					sorgu=srg+" WHERE "+sart;
				
				
				System.out.println(sorgu);
				
				query = em.createQuery(sorgu);
				for (i=0;i<17;i++){
					if (!alanlar[i][2].equalsIgnoreCase("0"))
						query.setParameter(alanlar[i][1],alanlar[i][2]);
				}
				
				if (Integer.parseInt((String) alanlar[17][2])!=0)
					query.setParameter(alanlar[17][1],Integer.parseInt(alanlar[17][2]));
					
				for (i=18;i<29;i++){
					if (Integer.parseInt((String) alanlar[i][2])!=0)
						query.setParameter(alanlar[i][1],Short.parseShort(alanlar[i][2]));
				}
				
				results = (List<Yay1nlar>) query.getResultList();
				
				}
			}
		} finally {
			em.close();
		}
		return results;
	}
	
	public List<Yay1nlar> getYay1nlarByBasitArama(Object[][] alanlar,byte Secim) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery(NamedQueries.getKriter1);
			
			query.setParameter("q14",alanlar[2][2]);
			query.setParameter("q3",alanlar[3][2]);
			query.setParameter("q4",alanlar[4][2]);
			query.setParameter("q5",alanlar[5][2]);
			query.setParameter("q6",alanlar[6][2]);
			query.setParameter("q7",alanlar[7][2]);
			query.setParameter("q8",alanlar[8][2]);
			query.setParameter("q9",alanlar[9][2]);
			query.setParameter("q10",alanlar[10][2]);
			query.setParameter("q11",alanlar[11][2]);
			query.setParameter("q12",alanlar[12][2]);
			query.setParameter("q13",alanlar[13][2]);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlar")
	public List<Yay1nlar> getYay1nlar() {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlar");
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByTez1d")
	public List<Yay1nlar> getYay1nlarByTez1d(Object tez1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByTez1d");
			query.setParameter("tez1d", tez1d);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByKtp1d")
	public List<Yay1nlar> getYay1nlarByKtp1d(Object ktp1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByKtp1d");
			query.setParameter("ktp1d", ktp1d);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByHrk1d")
	public List<Yay1nlar> getYay1nlarByHrk1d(Object hrk1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByHrk1d");
			query.setParameter("hrk1d", hrk1d);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByFlm1d")
	public List<Yay1nlar> getYay1nlarByFlm1d(Object flm1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByFlm1d");
			query.setParameter("flm1d", flm1d);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByDrg1d")
	public List<Yay1nlar> getYay1nlarByDrg1d(Object drg1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByDrg1d");
			query.setParameter("drg1d", drg1d);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByAyr1d")
	public List<Yay1nlar> getYay1nlarByAyr1d(Object ayr1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByAyr1d");
			query.setParameter("ayr1d", ayr1d);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByYynKodu")
	public List<Yay1nlar> getYay1nlarByYynKodu(String yynKodu) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByYynKodu");
			query.setParameter("yynKodu", yynKodu);
			results = (List<Yay1nlar>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("getYay1nlarByT1p1d")
	public List<Yay1nlar> getYay1nlarByT1p1d(short t1p1d) {
		EntityManager em = getEntityManager();
		List<Yay1nlar> results = null;
		try {
			Query query = em.createNamedQuery("getYay1nlarByT1p1d");
			query.setParameter("t1p1d", t1p1d);
			results = (List<Yay1nlar>) query.getResultList();
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
	public List<SelectItem> getYay1nlarSelectList() {
		List<Yay1nlar> yay1nlarList = getYay1nlar();
		List<SelectItem> selectList = new ArrayList<SelectItem>();
		MessageFormat mf = new MessageFormat("{0}");
		for (Yay1nlar yay1nlar : yay1nlarList) {
			selectList.add(new SelectItem(yay1nlar, mf.format(
					new Object[] { yay1nlar.getYyn1d() }, 
					new StringBuffer(), null).toString()));
		}
		return selectList;
	}

}