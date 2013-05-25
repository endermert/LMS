
package pagecode.pages.user.include;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entities.yayin.L1stem;
import entities.yayin.L1stemReg;
import entities.yayin.Yay1nlar;
import entities.yayin.controller.L1stemManager;
import entities.yayin.controller.L1stemRegManager;
import pagecode.PageCodeBase;
import pagecode.pages.login.Login_frm;
import tools.Yay1nlarPro;
import tools.Yay1nlarProManager;

/**
 * @author EnDeR
 *
 */
public class Yyn_Listem extends PageCodeBase {
	
	private Login_frm  sessionBean;
	private L1stemReg listem;
	private List<L1stem> yynL1stem;
	private List<Yay1nlar> yay1nlar;
	private List<Yay1nlarPro> yynGoster;
	
	private int kul1d;
	private int yyn1d;
	
	
	public String L1steyeEkle(){
		L1stemRegManager lr=(L1stemRegManager) getManagedBean("L1stemRegManager");
		try {
			List<L1stemReg> list=lr.getL1stemRegByKul1dAndYyn1d(kul1d, yyn1d);
			if (list.size()==0){
				listem=lr.getNewL1stemReg();
				listem.setLstKul1d(kul1d);
				listem.setLstYyn1d(yyn1d);
				Calendar cal=Calendar.getInstance();
				listem.setLstEklmTar(cal.getTime());
				lr.createL1stemReg(listem);
				mesaj(FacesMessage.SEVERITY_INFO, "Baþarýlý", " Kayýt Edildi..");
			}else
				mesaj(FacesMessage.SEVERITY_WARN, "Dikkat", " Zaten Listenizde..");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "";
	}
	
	public String L1stedenSil(){
		if (sessionBean==null)
			getSessionBean();
		
		L1stemRegManager lr=(L1stemRegManager) getManagedBean("L1stemRegManager");
		List<L1stemReg> list=lr.getL1stemRegByKul1dAndYyn1d(sessionBean.getKullan1c1lar().getKul1d(), yyn1d);
		if (list.size()!=0){
			try {
				lr.deleteL1stemReg(list.get(0));
				mesaj(FacesMessage.SEVERITY_INFO, "Baþarýlý", " Yayýn Listeden Silindi..");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else
			mesaj(FacesMessage.SEVERITY_WARN, "Silinemedi", " Yayýn Bulunamadý..");
		return "";
	}
	public void mesaj(Severity severity,String summary,String detail){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(severity,summary,detail));
	}
	
	public Login_frm getSessionBean() {
		if (sessionBean==null) {
			FacesContext context = FacesContext.getCurrentInstance();
		    HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		    sessionBean = (Login_frm) session.getAttribute("pc_sessionBean");
		}
		return sessionBean;
	}
	
	public L1stemReg getListem() {
		
		return listem;
	}
	
	public int getKul1d() {
		return kul1d;
	}

	public void setKul1d(int kul1d) {
		this.kul1d = kul1d;
	}

	public int getYyn1d() {
		return yyn1d;
	}

	public void setYyn1d(int yyn1d) {
		this.yyn1d = yyn1d;
	}

	public List<L1stem> getYynL1stem() {
		if (sessionBean==null)
			getSessionBean();
		
		L1stemManager l=(L1stemManager) getManagedBean("L1stemManager");
		yynL1stem=l.getL1stemByKul1dOrder(sessionBean.getKullan1c1lar().getKul1d());
		
		return yynL1stem;
	}

	public List<Yay1nlarPro> getYynGoster() {
		Yay1nlarProManager ypm=new Yay1nlarProManager();
		yynGoster=new ArrayList<Yay1nlarPro>();
		yay1nlar= new ArrayList<Yay1nlar>();
		getYynL1stem();
		
		for (int i=0;i<yynL1stem.size();i++)
			yay1nlar.add(yynL1stem.get(i).getLstYyn1d());
		
		yynGoster=ypm.Yay1nlarProAdder(yay1nlar);
		
		return yynGoster;
	}
}