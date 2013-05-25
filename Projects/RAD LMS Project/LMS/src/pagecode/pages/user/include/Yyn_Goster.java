
package pagecode.pages.user.include;

import pagecode.PageCodeBase;
import pagecode.pages.login.Login_frm;
import entities.yayin.Yay1nlar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entities.yayin.controller.Yay1nRezerveManager;
import entities.yayin.controller.Yay1nlarManager;
import tools.Yay1nlarPro;
import entities.yayin.Yay1nRezerve;
import entities.yayin.Yay1nRezerveReg;
import entities.yayin.YynHareket;
import entities.yayin.KulYynHareket;
import entities.yayin.controller.KulYynHareketManager;
import tools.Yay1nlarProManager;
/**
 * @author EnDeR
 *
 */
public class Yyn_Goster extends PageCodeBase {

	public enum Goster {
	    HEPSI,UZRMDKLR,IADLRM,REZERV
	}
	private List<Yay1nlar> yay1nlarList;
	private List<Yay1nlar> yynss;
	private List<Yay1nlarPro> yay1nlarProList;
	private List<Yay1nlarPro> yynGoster;
	private List<YynHareket> yynHareketer;
	private Yay1nRezerveReg rzrvInfo;
	private Login_frm  sessionBean;
	private Goster goster;
	
	private List<Yay1nlarPro> yynUzerimde;
	private List<Yay1nlarPro> yynIade;
	private List<KulYynHareket> kulYynHarekets;
	private List<Yay1nlarPro> yynAyrt;
	private boolean tblIade=false;
	private boolean tblUzrm=false;
	private boolean tblAyrt=false;

	
	public List<Yay1nlar> getYay1nlarList() {
		if (yay1nlarList==null){
			Yay1nlarManager yay1nlarManager = (Yay1nlarManager) getManagedBean("Yay1nlarManager");
			yay1nlarList = yay1nlarManager.getYay1nlar();	
		}
		return yay1nlarList;
	}

	public List<Yay1nlarPro> getYay1nlarProList() {
		if (yay1nlarProList==null){
			Yay1nlarProManager ypm=new Yay1nlarProManager();
			yay1nlarProList=new ArrayList<Yay1nlarPro>();
			yay1nlarProList=ypm.Yay1nlarProAdder(getYay1nlarList());
		}
		return yay1nlarProList;
	}

	public List<Yay1nlarPro> getYynGoster() {
		
		if (sessionBean==null)
			getSessionBean();
		
		if (goster!=null){
			
			if (goster==Goster.HEPSI)
				yynGoster=getYay1nlarProList();
			else
				if (goster==Goster.REZERV){
					Calendar cal=Calendar.getInstance();
					Yay1nRezerveManager rrm=(Yay1nRezerveManager) getManagedBean("Yay1nRezerveManager");
					List<Yay1nRezerve> list=rrm.getYay1nRezerveBykul1d(sessionBean.getKullan1c1lar().getKul1d(), cal.getTime());
					Yay1nlarProManager ypm=new Yay1nlarProManager();
					yynGoster=new ArrayList<Yay1nlarPro>();
					for (int i=0;i<list.size();i++){
						yynGoster.add(ypm.Yay1nlarProAdder(list.get(i).getYyn1d(), list.get(i)));
					}
					
				
				}else{
				KulYynHareketManager kulYynHareketManager =(KulYynHareketManager) getManagedBean("KulYynHareketManager");
				kulYynHarekets=kulYynHareketManager.getKulYynHareketByAktKul1d(sessionBean.getKullan1c1lar().getKul1d());
				yynss=new ArrayList<Yay1nlar>();
				for (int i=0;i<kulYynHarekets.size();i++){
					yynss.add(kulYynHarekets.get(i).getYyn1d());
				}
				Yay1nlarProManager ypm=new Yay1nlarProManager();
				yynGoster=ypm.Yay1nlarProAdder(yynss);
				
				yynUzerimde=new ArrayList<Yay1nlarPro>();
				yynIade=new ArrayList<Yay1nlarPro>();
				for (int i=0;i<yynGoster.size();i++){
					if (!yynGoster.get(i).getYay1nOzel().isRafta() && yynGoster.get(i).getHrk1d().getAktKul1d()==sessionBean.getKullan1c1lar().getKul1d())
					{
						int say=0;
						
						for (int j=0;j<yynUzerimde.size();j++)
							if (yynGoster.get(i).getYyn1d()==yynUzerimde.get(j).getYyn1d())
								say=1;
						
						if (say==0)
							yynUzerimde.add(yynGoster.get(i));
						else
							yynIade.add(yynGoster.get(i));
					}else{
						yynIade.add(yynGoster.get(i));
					}
					
				}
				
				if (goster==Goster.UZRMDKLR){
					yynGoster=yynUzerimde;
				}
				
				if (goster==Goster.IADLRM){
					yynGoster=ypm.Yay1nlarProAdder(kulYynHarekets, true);
				}
				}
			
			}
		
		
		return yynGoster;
	}

	public String stUzerimde(){
		tblIade=false;
		tblAyrt=false;
		tblUzrm=true;
		this.goster=Goster.UZRMDKLR;
		
		return "indexUser";
	}
	public void stIadeler(){
		tblIade=true;
		tblAyrt=false;
		tblUzrm=false;
		this.goster=Goster.IADLRM;
	}
	
	public void stRzrv(){
		tblIade=false;
		tblAyrt=true;
		tblUzrm=false;
		this.goster=Goster.REZERV;
	}
	public void stHepsi(){
		this.goster=Goster.HEPSI;
	}

	public Goster getGoster() {
		return goster;
	}

	public void setGoster(Goster goster) {
		this.goster = goster;
	}

	public List<YynHareket> getYynHareketer() {
		return yynHareketer;
	}

	public Login_frm getSessionBean() {
		if (sessionBean==null) {
			FacesContext context = FacesContext.getCurrentInstance();
		    HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		    sessionBean = (Login_frm) session.getAttribute("pc_sessionBean");
		}
		return sessionBean;
	}

	public List<Yay1nlarPro> getYynUzerimde() {
		if (yynUzerimde==null){
			goster=Goster.UZRMDKLR;
			yynUzerimde=getYynGoster();
			
		}
		return yynUzerimde;
	}

	public void setYynUzerimde(List<Yay1nlarPro> yynUzerimde) {
		
		this.yynUzerimde = yynUzerimde;
	}

	public List<Yay1nlarPro> getYynIade() {
		if (yynIade==null){
			goster=Goster.IADLRM;
			yynIade=getYynGoster();
		}
		return yynIade;
	}

	public void setYynIade(List<Yay1nlarPro> yynIade) {
		
		this.yynIade = yynIade;
	}

	public List<KulYynHareket> getKulYynHarekets() {
		KulYynHareketManager kulYynHareketManager =(KulYynHareketManager) getManagedBean("KulYynHareketManager");
		kulYynHarekets=kulYynHareketManager.getKulYynHareketByAktKul1d(sessionBean.getKullan1c1lar().getKul1d());
		return kulYynHarekets;
	}

	public void setKulYynHarekets(List<KulYynHareket> kulYynHarekets) {
		this.kulYynHarekets = kulYynHarekets;
	}

	public List<Yay1nlar> getYynss() {
		return yynss;
	}

	public void setYynss(List<Yay1nlar> yynss) {
		this.yynss = yynss;
	}

	public boolean isTblIade() {
		return tblIade;
	}

	public boolean isTblUzrm() {
		return tblUzrm;
	}

	public boolean isTblAyrt() {
		return tblAyrt;
	}

	public Yay1nRezerveReg getRzrvInfo() {
		return rzrvInfo;
	}

	public void setRzrvInfo(Yay1nRezerveReg rzrvInfo) {
		this.rzrvInfo = rzrvInfo;
	}

	public void setTblAyrt(boolean tblAyrt) {
		this.tblAyrt = tblAyrt;
	}

	public List<Yay1nlarPro> getYynAyrt() {
		if(yynAyrt==null){
			goster=Goster.REZERV;
			yynAyrt=getYynGoster();
		}
		return yynAyrt;
	}

	public void setYynAyrt(List<Yay1nlarPro> yynAyrt) {
		this.yynAyrt = yynAyrt;
	}


}