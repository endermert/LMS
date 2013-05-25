
package pagecode.pages.user.include;

import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entities.yayin.Kul1steklerReg;
import entities.yayin.Yay1nlar;
import entities.yayin.controller.Kul1steklerRegManager;
import entities.yayin.controller.Yay1nlarManager;
import pagecode.PageCodeBase;
import pagecode.pages.login.Login_frm;

/**
 * @author EnDeR
 *
 */
public class Kul_istek extends PageCodeBase {
	
	private Login_frm  sessionBean;
	private Kul1steklerReg kulistekReg;
	private List<Kul1steklerReg> kulistekList;
	private int kul1d;
	private int yyn1d;
	private int wnt1d;
	
	
	
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
	
	public String Sureistek(){
		if (sessionBean==null)
			getSessionBean();
		
		Kul1steklerRegManager kir=(Kul1steklerRegManager) getManagedBean("Kul1steklerRegManager");
		List<Kul1steklerReg> list=kir.getKul1steklerRegByKulAndYynAndDrm(sessionBean.getKullan1c1lar().getKul1d(), yyn1d);
		if (list.size()==0){
			kulistekReg=kir.getNewKul1steklerReg();
			kulistekReg.setWntDurum("Beklemede");
			kulistekReg.setWntKul1d(sessionBean.getKullan1c1lar().getKul1d());
			kulistekReg.setWntYyn1d(yyn1d);
			Calendar cal=Calendar.getInstance();
			kulistekReg.setWntTar(cal.getTime());
			kulistekReg.setYynAc1klama("Süre Uzatma");
			
			Yay1nlarManager ym=(Yay1nlarManager) getManagedBean("Yay1nlarManager");
			Yay1nlar yyn=ym.findYay1nlarByYyn1d(yyn1d);
			if (yyn.getKtp1d()!=null){
				kulistekReg.setYynAd(yyn.getKtp1d().getKtpAd());
				kulistekReg.setYynYazar(yyn.getKtp1d().getKtpYazar());
				kulistekReg.setYyn1sbn1ssn(yyn.getKtp1d().getKtp1sbn());
			}
			if (yyn.getDrg1d()!=null){
				kulistekReg.setYynAd(yyn.getDrg1d().getDrgAd());
				kulistekReg.setYyn1sbn1ssn(yyn.getDrg1d().getDrg1ssn());
			}
			
			
			try {
				kir.createKul1steklerReg(kulistekReg);
				mesaj(FacesMessage.SEVERITY_INFO,"Baþarýlý", " isteðiniz gönderildi..");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else
			mesaj(FacesMessage.SEVERITY_WARN,"Dikkat", " Zaten böyle bir istek mevcut..");
		
		return "";
	}
	
	public String isteksil(){
		Kul1steklerRegManager kir=(Kul1steklerRegManager) getManagedBean("Kul1steklerRegManager");
		kulistekReg=kir.findKul1steklerRegByWnt1d(wnt1d);
		if (kulistekReg!=null)
			try {
				kir.deleteKul1steklerReg(kulistekReg);
				mesaj(FacesMessage.SEVERITY_INFO,"Baþarýlý", " isteðiniz silindi..");
			} catch (Exception e) {
				mesaj(FacesMessage.SEVERITY_WARN,"Hata", "isteðiniz silinemiyor..");
				e.printStackTrace();
			}
		
		return "";
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

	public List<Kul1steklerReg> getKulistekList() {
		if (sessionBean==null)
			getSessionBean();
		
		Kul1steklerRegManager kir=(Kul1steklerRegManager) getManagedBean("Kul1steklerRegManager");
		kulistekList=kir.getKul1steklerRegByKul1dOrder(sessionBean.getKullan1c1lar().getKul1d());
		return kulistekList;
	}

	public int getWnt1d() {
		return wnt1d;
	}

	public void setWnt1d(int wnt1d) {
		this.wnt1d = wnt1d;
	}

}