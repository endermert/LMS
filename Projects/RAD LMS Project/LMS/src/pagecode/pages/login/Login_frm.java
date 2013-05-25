/**
 * 
 */
package pagecode.pages.login;

import pagecode.PageCodeBase;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entities.kullanicilar.controller.Kullan1c1larManager;
import entities.kullanicilar.Kullan1c1lar;

/**
 * @author EnDeR
 *
 */
public class Login_frm extends PageCodeBase {

	private Kullan1c1lar kullan1c1lar;
	private String kulEposta;
	private String kulParola;
	
	private boolean user;
	private boolean admin;
	
	private boolean tab1;
	private boolean tab2;
	private boolean tab3;
	
			
	public Kullan1c1lar getKullan1c1lar() {
		return kullan1c1lar;
	}
	
	public String loginx(){
		
		Kullan1c1larManager kullan1c1larManager = (Kullan1c1larManager) getManagedBean("Kullan1c1larManager");
		List<Kullan1c1lar> list = kullan1c1larManager
				.getKullan1c1larByKulEpostaAndSifre(kulEposta,kulParola);
		
		if (!list.isEmpty()) {
			System.out.println("Kullanýcý Var");
			
			kullan1c1lar = list.get(0);
			
			int kulYetki= kullan1c1lar.getKulYet1d();
			
			String yonlendir = null;
			if (kulYetki==1){
				System.out.println("1 Kullanýcý ");
				setUser(true);
				yonlendir="";
			}
			
			if (kulYetki==2){
				System.out.println("1 Yönetici ");
				setAdmin(true);
				yonlendir="";
			}
			return yonlendir;

		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hatalý E-Posta veya Þifre..",".."));
			return "Basarisiz";
		}
		
	}
	
	public String logoutx() throws IOException{

		ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
	    HttpSession session = (HttpSession) ectx.getSession(false);
	    session.invalidate();
		return "index";
	}

	public void setKulEposta(String kulEposta) {
		this.kulEposta = kulEposta;
	}

	public String getKulParola() {
		return kulParola;
	}

	public void setKulParola(String kulParola) {
		this.kulParola = kulParola;
	}

	public String getKulEposta() {
		return kulEposta;
	}

	public boolean isUser() {
		return user;
	}

	public void setUser(boolean user) {
		this.user = user;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
		this.user=admin;
	}

	public boolean isTab1() {
		if (admin)
			tab1=true;
		else
			tab1=false;
		return tab1;
	}

	public void setTab1(boolean tab1) {
		this.tab1 = tab1;
	}

	public boolean isTab2() {
		if (user && !admin)
			tab2=true;
		else
			tab2=false;
		return tab2;
	}

	public void setTab2(boolean tab2) {
		this.tab2 = tab2;
	}

	public boolean isTab3() {
		if(!user)
			tab3=true;
		else
			tab3=false;
		return tab3;
	}

	public void setTab3(boolean tab3) {
		this.tab3 = tab3;
	}

	public void setKullan1c1lar(Kullan1c1lar kullan1c1lar) {
		this.kullan1c1lar = kullan1c1lar;
	}




}