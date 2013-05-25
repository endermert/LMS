package pagecode.pages.admin.include;

import pagecode.PageCodeBase;
import pagecode.pages.login.Login_frm;
import tools.Yay1nlarPro;
import tools.Yay1nlarProManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entities.yayin.controller.Yay1nlarManager;
import entities.yayin.controller.Yay1nlarRegManager;

import entities.yayin.Yay1nlar;
import entities.yayin.Yay1nRezerveReg;
import entities.yayin.controller.Yay1nRezerveRegManager;
import entities.kullanicilar.Kullan1c1lar;
import entities.kullanicilar.controller.Kullan1c1larManager;
import entities.yayin.YynHareket;
import entities.yayin.Yay1nlarReg;
import entities.yayin.controller.YynHareketManager;
import entities.yayin.YynAyr1nt1Reg;
import entities.yayin.controller.YynAyr1nt1RegManager;


/**
 * @author EnDeR
 *
 */
public class Yyn_hareket extends PageCodeBase {

	private String yynKodu;
	private String kulKodu;
	private int rzrv1d;
	
	private boolean yynVar=false;
	private boolean kulVar=false;
	private boolean butonlar=false;
	private boolean yynVer=false;
	private boolean yynAl=false;
	private boolean btnVer=false;
	private boolean btnAl=false;
	private boolean btnRez=false;
	private boolean btnSrUz=false;
	
	private Login_frm  sessionBean;
	private Yay1nlar yay1nlar;
	private Yay1nlarReg yay1nlarReg;
	private Kullan1c1lar kullan1c1lar;
	private YynHareket yynHareket;
	private Yay1nlarPro yay1nlarPro;
	private YynAyr1nt1Reg yynAyr1nt1Reg;
	private Yay1nRezerveReg yay1nRezerveReg;

	public Yay1nlar getYay1nlar() {
		if (yay1nlar == null) {
			Yay1nlarManager yay1nlarManager = (Yay1nlarManager) getManagedBean("Yay1nlarManager");
			List<Yay1nlar> list = yay1nlarManager.getYay1nlarByYynKodu(yynKodu);
			
			if (!list.isEmpty()) {
				setYynVar(true);
				Yay1nlarProManager ypm=new Yay1nlarProManager();
				yay1nlar = list.get(0);
				yay1nlarPro=ypm.Yay1nlarProAdder(yay1nlar);
			}
		}
		return yay1nlar;
	}

	public Kullan1c1lar getKullan1c1lar() {
		if (kullan1c1lar == null) {
			Kullan1c1larManager kullan1c1larManager = (Kullan1c1larManager) getManagedBean("Kullan1c1larManager");
			List<Kullan1c1lar> list = kullan1c1larManager.getKullan1c1larByKulKodu(kulKodu);
			
			if (!list.isEmpty()) {
				setKulVar(true);
				kullan1c1lar = list.get(0);
			}
		}
		return kullan1c1lar;
	}
	
	public YynHareket getYynHareket() {
		if (yynHareket == null) {
			YynHareketManager yynHareketManager = (YynHareketManager) getManagedBean("YynHareketManager");
			yynHareket = yynHareketManager.getNewYynHareket();
		}
		return yynHareket;
	}
	
	
	public Yay1nlarReg getYay1nlarReg() {
		if (yay1nlarReg == null) {
			Yay1nlarRegManager yay1nlarRegManager = (Yay1nlarRegManager) getManagedBean("Yay1nlarRegManager");
			if (yay1nlar==null)
				getYay1nlar();
			List<Yay1nlarReg> list = yay1nlarRegManager.getYay1nlarRegByYyn1d(yay1nlar.getYyn1d());
			if (!list.isEmpty()) {
				yay1nlarReg = list.get(0);
			}
		}
		return yay1nlarReg;
	}
	
		
	public String createYynVermeAction() {
		FacesContext context = FacesContext.getCurrentInstance(); 
		hareketeBasla();
		if (btnVer){
		YynHareketManager yynHareketManager = (YynHareketManager) getManagedBean("YynHareketManager");
		Yay1nlarRegManager yay1nlarRegManager = (Yay1nlarRegManager) getManagedBean("Yay1nlarRegManager");
		YynAyr1nt1RegManager yynAyr1nt1RegManager=(YynAyr1nt1RegManager) getManagedBean("YynAyr1nt1RegManager");
		try {
			
			yynHareket = yynHareketManager.getNewYynHareket();
			yynHareket.setAktKul1d(getKullan1c1lar().getKul1d());
			getSessionBean();
			yynHareket.setVerenGrvl11d(sessionBean.getKullan1c1lar().getKul1d());
			yynHareket.setYyn1d(getYay1nlar().getYyn1d());
			Calendar cal = Calendar.getInstance();
			yynHareket.setL1bVerTar(cal.getTime());
			cal.add(Calendar.DATE, 15);
			yynHareket.setL1bSonAlTar(cal.getTime());
			yynHareketManager.createYynHareket(yynHareket);
			
			yay1nlarReg=getYay1nlarReg();
			yay1nlarReg.setHrk1d(yynHareket.getHrk1d());
			yay1nlarRegManager.updateYay1nlarReg(yay1nlarReg);
			
			yynAyr1nt1Reg=yynAyr1nt1RegManager.findYynAyr1nt1RegByAyr1d(yay1nlarReg.getAyr1d());
			int odsay=yynAyr1nt1Reg.getYayOduncSay();
			odsay++;
			yynAyr1nt1Reg.setYayOduncSay(odsay);
			yynAyr1nt1RegManager.updateYynAyr1nt1Reg(yynAyr1nt1Reg);
			
	        context.addMessage(null, new FacesMessage("Baþarýlý", "1 Yayýn Verdiniz.."));
	        
		} catch (Exception e) {
			logException(e);
		}
		}
		islemTemizle();
		return "";	
	}
	
	public String createYynAlmaAction() {
		FacesContext context = FacesContext.getCurrentInstance(); 
		hareketeBasla();
		if (btnAl){

			YynHareketManager yynHareketManager = (YynHareketManager) getManagedBean("YynHareketManager");
			Yay1nlarRegManager yay1nlarRegManager = (Yay1nlarRegManager) getManagedBean("Yay1nlarRegManager");
			try {
				
				yay1nlarReg=getYay1nlarReg();
				yynHareket=yynHareketManager.findYynHareketByHrk1d(yay1nlarReg.getHrk1d());
				
				Calendar cal = Calendar.getInstance();
				yynHareket.setL1bAlTar(cal.getTime());
				getSessionBean();
				yynHareket.setAlanGrvl11d(sessionBean.getKullan1c1lar().getKul1d());
				yynHareketManager.updateYynHareket(yynHareket);
				
				yay1nlarReg.setHrk1d((long)0);
				yay1nlarRegManager.updateYay1nlarReg(yay1nlarReg);
				
				context.addMessage(null, new FacesMessage("Baþarýlý Ýþlem : ", "Yayýn iade iþlemi baþarýlý."));
		        
			} catch (Exception e) {
				logException(e);
			}
		}else{
			if (btnVer)
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Yayýn Bilgisi : ","Bu yayýn zaten rafta bulunmaktadýr. "));
		}
		islemTemizle();
		return "";
	}
	
	public String createYynRezervationAction() {
		FacesContext context = FacesContext.getCurrentInstance(); 
		hareketeBasla();
		if (btnRez){
			
			if (Integer.parseInt(kulKodu)!=yay1nlarPro.getHrk1d().getAktKul1d()){
				
				Yay1nRezerveRegManager rrm=(Yay1nRezerveRegManager) getManagedBean("Yay1nRezerveRegManager");
				yay1nRezerveReg=new Yay1nRezerveReg();
				try{
					Calendar cal = Calendar.getInstance();
					List<Yay1nRezerveReg> list=new ArrayList<Yay1nRezerveReg>();
					list =rrm.getYay1nRezerveRegByYyn1dAndKul1d(kullan1c1lar.getKul1d(),yay1nlarPro.getYyn1d(),cal.getTime());
					if (list.size()==0){
						list = rrm.getYay1nRezerveRegByYyn1d(yay1nlarPro.getYyn1d(),cal.getTime());
						if (list.size()==0){
							yay1nRezerveReg.setKul1d(kullan1c1lar.getKul1d());
							yay1nRezerveReg.setYyn1d(yay1nlarPro.getYyn1d());
							yay1nRezerveReg.setRzv1slemTar(cal.getTime());
							yay1nRezerveReg.setYynGel1sTar(yay1nlarPro.getHrk1d().getL1bSonAlTar());
							cal.setTime(yay1nlarPro.getHrk1d().getL1bSonAlTar());
							cal.add(Calendar.DATE,1);
							yay1nRezerveReg.setYynAlnacag1Tar(cal.getTime());
							rrm.createYay1nRezerveReg(yay1nRezerveReg);
						}else{
							yay1nRezerveReg.setYyn1d(yay1nlarPro.getYyn1d());
							yay1nRezerveReg.setKul1d(kullan1c1lar.getKul1d());
							yay1nRezerveReg.setRzv1slemTar(cal.getTime());
							yay1nRezerveReg.setYynGel1sTar(yay1nlarPro.getHrk1d().getL1bSonAlTar());
							cal.setTime(list.get(0).getYynAlnacag1Tar());
							cal.add(Calendar.DATE, 1);
							yay1nRezerveReg.setYynAlnacag1Tar(cal.getTime());
							rrm.createYay1nRezerveReg(yay1nRezerveReg);
						}
						mesaj(FacesMessage.SEVERITY_INFO,"Baþarýlý Ýþlem  :","Bu kullanýcý adýna 1 rezervasyon yapýldý..");
					}else{
						mesaj(FacesMessage.SEVERITY_WARN,"Yanlýþ Ýþlem  :", "Zaten aktif bir rezervasyon bulunmaktadýr..");
					}
						
				}catch (Exception e) {
					logException(e);
				}
			}else{
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Yanlýþ Ýþlem  :", "Bu yayýn zaten bu kullanýcýdadýr.."));
			}
				
		}else
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Yanlýþ Ýþlem  :", "Bu bilgiler doðrultusunda rezervasyon yapýlamýyor.."));
		islemTemizle();
		return "";
	}
	
	public String createYynSureUzAction() { 
		hareketeBasla();
		if (btnSrUz){
			YynHareketManager yynHareketManager = (YynHareketManager) getManagedBean("YynHareketManager");
			try {
				
				yynHareket=yynHareketManager.findYynHareketByHrk1d(yay1nlarPro.getHrk1d().getHrk1d());
				Calendar cal = Calendar.getInstance();
				cal.setTime(yynHareket.getL1bSonAlTar());
				cal.add(Calendar.DATE,7);
				yynHareket.setL1bSonAlTar(cal.getTime());
				short syc= yynHareket.getSureUzSay();
				syc++;
				yynHareket.setSureUzSay(syc);
				yynHareketManager.updateYynHareket(yynHareket);

		        mesaj(FacesMessage.SEVERITY_INFO,"Baþarýlý Ýþlem :", "Yayýnýn son iade süresi 1 hafta uzaltýldý..");
			} catch (Exception e) {
				logException(e);
			}
			
							
				
		}else
			mesaj( FacesMessage.SEVERITY_ERROR,"Yanlýþ Ýþlem  :", "Bu bilgiler doðrultusunda süre uzaltma iþlemi yapýlamýyor..");
		
		islemTemizle();
		return "";
	}
	
	public String istekYynSureUz(int yyn1d) { 
		
		YynHareketManager yynHareketManager = (YynHareketManager) getManagedBean("YynHareketManager");
		Yay1nlarManager yay1nlarManager = (Yay1nlarManager) getManagedBean("Yay1nlarManager");
		yay1nlar = yay1nlarManager.findYay1nlarByYyn1d(yyn1d);
		
		if (yay1nlar!=null) {
			setYynVar(true);
			Yay1nlarProManager ypm=new Yay1nlarProManager();
			yay1nlarPro=ypm.Yay1nlarProAdder(yay1nlar);
		
			try {
				
				yynHareket=yynHareketManager.findYynHareketByHrk1d(yay1nlarPro.getHrk1d().getHrk1d());
				Calendar cal = Calendar.getInstance();
				cal.setTime(yynHareket.getL1bSonAlTar());
				cal.add(Calendar.DATE,7);
				yynHareket.setL1bSonAlTar(cal.getTime());
				short syc= yynHareket.getSureUzSay();
				syc++;
				yynHareket.setSureUzSay(syc);
				yynHareketManager.updateYynHareket(yynHareket);
	
		        mesaj(FacesMessage.SEVERITY_INFO,"Baþarýlý Ýþlem :", "Yayýnýn son iade süresi 1 hafta uzaltýldý..");
			} catch (Exception e) {
				logException(e);
			}
		}
		return "";
	}
	public String deleteYynRzrvAction() {
		try {
			Yay1nRezerveRegManager rrm=(Yay1nRezerveRegManager) getManagedBean("Yay1nRezerveRegManager");
			yay1nRezerveReg =rrm.findYay1nRezerveRegByRzv1d(rzrv1d);
			if (yay1nRezerveReg!=null)
				rrm.deleteYay1nRezerveReg(yay1nRezerveReg);
			
			
		} catch (Exception e) {
			logException(e);
		}
		return "";
	}
	private void mesaj(Severity severity,String summary,String detail){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(severity,summary,detail));
	}
	public void hareketeBasla() {
		getYay1nlarPro();
		getKullan1c1lar();
		
		if (isKulVar()&& isYynVar())
			btnVer=true;
		else
			btnVer=false;
		
		FacesContext context = FacesContext.getCurrentInstance();
		if (isKulVar()){
			if (kullan1c1lar.getKulDrm1d()==(short)2)
			{
				btnVer=false;
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Bloke edilmiþ kullanýcý :", "Bu kullanýcý bu hizmetten yararlanamaz.."));
			}
		}else{
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Kullanýcý Bilgisi : ", "Lütfen kullanýcý kodunu doðru girdiðinizden emin olun.."));
		}
		
		if(isYynVar())
		{	
			if (!yay1nlarPro.getYay1nOzel().isRafta()){
				btnVer=false;
				btnAl=true;
				if (isKulVar())
					btnRez=true;
				btnSrUz=true;
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Yayýn Bilgisi : ","Bu yayýn henüz iade edilmemiþtir.. "));
			}else{
				btnAl=false;
				btnRez=false;
				btnSrUz=false;
			}
			if (!yay1nlarPro.getYay1nOzel().isOdunc()){
				btnVer=false;
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Yayýn Bilgisi : ", "Bu yayýn ödünç verilmez.."));
			}
			if (yay1nlarPro.getYay1nOzel().isReferans()){
				btnVer=false;
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Yayýn Bilgisi : ", "Bu yayýn referans statüsündedir.."));
			}
		}else{
			btnVer=false;
			btnRez=false;
			btnSrUz=false;
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Yayýn Bilgisi : ", "Lütfen yayýn kodunu doðru girdiðinizden emin olun.."));
		}
		
	}
	
	public Login_frm getSessionBean() {
		if (sessionBean==null) {
			FacesContext context = FacesContext.getCurrentInstance();
		    HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		    sessionBean = (Login_frm) session.getAttribute("pc_sessionBean");
		}
		return sessionBean;
	}
	private void islemTemizle(){
		btnSrUz=false;
		btnRez=false;
		btnAl=false;
		yynVer=false;
		yynVar=false;
		kulVar=false;
	}
	public String getYynKodu() {
		return yynKodu;
	}

	public void setYynKodu(String yynKodu) {
		this.yynKodu = yynKodu;
	}

	public String getKulKodu() {
		return kulKodu;
	}

	public void setKulKodu(String kulKodu) {
		this.kulKodu = kulKodu;
	}

	public boolean isYynVar() {
		return yynVar;
	}

	public void setYynVar(boolean yynVar) {
		this.yynVar = yynVar;
	}

	public boolean isKulVar() {
		return kulVar;
	}

	public void setKulVar(boolean kulVar) {
		this.kulVar = kulVar;
	}

	
	public boolean isYynVer() {
		return yynVer;
	}

	public void setYynVer(boolean yynVer) {
		this.yynVer = yynVer;
	}

	public boolean isYynAl() {
		return yynAl;
	}

	public void setYynAl(boolean yynAl) {
		this.yynAl = yynAl;
	}
	public boolean isButonlar() {
		return butonlar;
	}
	public void setButonlar(boolean butonlar) {
		this.butonlar = butonlar;
	}
	public Yay1nlarPro getYay1nlarPro() {
		if (yay1nlarPro==null)
		{
			getYay1nlar();
		}
		return yay1nlarPro;
	}

	public boolean isBtnVer() {
		return btnVer;
	}

	public void setBtnVer(boolean btnVer) {
		this.btnVer = btnVer;
	}

	public boolean isBtnAl() {
		return btnAl;
	}

	public void setBtnAl(boolean btnAl) {
		this.btnAl = btnAl;
	}

	public boolean isBtnRez() {
		return btnRez;
	}

	public void setBtnRez(boolean btnRez) {
		this.btnRez = btnRez;
	}

	public boolean isBtnSrUz() {
		return btnSrUz;
	}

	public void setBtnSrUz(boolean btnSrUz) {
		this.btnSrUz = btnSrUz;
	}

	public int getRzrv1d() {
		return rzrv1d;
	}

	public void setRzrv1d(int rzrv1d) {
		this.rzrv1d = rzrv1d;
	}


}