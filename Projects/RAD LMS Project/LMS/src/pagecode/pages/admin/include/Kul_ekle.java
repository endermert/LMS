/**
 * 
 */
package pagecode.pages.admin.include;


import pagecode.PageCodeBase;
import entities.kullanicilar.Kullan1c1lar;
import entities.kullanicilar.controller.Kullan1c1larManager;
import com.ibm.jpa.web.JPA;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import java.util.Calendar;
import org.primefaces.component.inputtext.InputText;
import javax.faces.component.html.HtmlInputHidden;
import org.primefaces.component.messages.Messages;
import org.primefaces.component.inputmask.InputMask;
import javax.faces.component.html.HtmlForm;
import org.primefaces.component.panel.Panel;
import org.primefaces.component.growl.Growl;
/**
 * @author EnDeR
 *
 */
public class Kul_ekle extends PageCodeBase {

	private Kullan1c1lar kullan1c1lar;
	protected InputText kulKod1;
	protected InputText kulSoyad1;
	protected InputText email;
	protected HtmlInputHidden kulDurum;
	protected InputText kulS1fre1;
	protected HtmlInputHidden kulYetk1;
	protected HtmlInputHidden kulC1ns1yet;
	protected HtmlInputHidden kulT1p;
	protected Messages kullan1c1lar2messages;
	protected InputMask kulDgmTar1;
	protected InputMask kulTel1;
	protected InputText kulAd1;
	protected HtmlForm kayit;
	protected Panel panel;
	protected Growl growl;
	@JPA(targetEntityManager = entities.kullanicilar.controller.Kullan1c1larManager.class, targetAction = JPA.ACTION_TYPE.CREATE)
	public Kullan1c1lar getKullan1c1lar() {
		if (kullan1c1lar == null) {
			Kullan1c1larManager kullan1c1larManager = (Kullan1c1larManager) getManagedBean("Kullan1c1larManager");
			kullan1c1lar = kullan1c1larManager.getNewKullan1c1lar();
		}
		return kullan1c1lar;
	}

	/**
	 *  @action id=kullan1c1lar
	 */
	public String createKullan1c1larAction() {
		Kullan1c1larManager kullan1c1larManager = (Kullan1c1larManager) getManagedBean("Kullan1c1larManager");
		try {
			Calendar cal = Calendar.getInstance();
			kullan1c1lar.setKulKytTar(cal.getTime());
			kullan1c1larManager.createKullan1c1lar(kullan1c1lar);
			kullan1c1lar = kullan1c1larManager.getNewKullan1c1lar();
			
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Baþarýlý", "1 Yeni kullanýcý kaydý.."));  
	        
		} catch (Exception e) {
			logException(e);
		}
		
		return "";
	}

	protected InputText getKulKod1() {
		if (kulKod1 == null) {
			kulKod1 = (InputText) findComponentInRoot("kulKod1");
		}
		return kulKod1;
	}

	protected InputText getKulSoyad1() {
		if (kulSoyad1 == null) {
			kulSoyad1 = (InputText) findComponentInRoot("kulSoyad1");
		}
		return kulSoyad1;
	}

	protected InputText getEmail() {
		if (email == null) {
			email = (InputText) findComponentInRoot("email");
		}
		return email;
	}

	protected HtmlInputHidden getKulDurum() {
		if (kulDurum == null) {
			kulDurum = (HtmlInputHidden) findComponentInRoot("kulDurum");
		}
		return kulDurum;
	}

	protected InputText getKulS1fre1() {
		if (kulS1fre1 == null) {
			kulS1fre1 = (InputText) findComponentInRoot("kulS1fre1");
		}
		return kulS1fre1;
	}

	protected HtmlInputHidden getKulYetk1() {
		if (kulYetk1 == null) {
			kulYetk1 = (HtmlInputHidden) findComponentInRoot("kulYetk1");
		}
		return kulYetk1;
	}

	protected HtmlInputHidden getKulC1ns1yet() {
		if (kulC1ns1yet == null) {
			kulC1ns1yet = (HtmlInputHidden) findComponentInRoot("kulC1ns1yet");
		}
		return kulC1ns1yet;
	}

	protected HtmlInputHidden getKulT1p() {
		if (kulT1p == null) {
			kulT1p = (HtmlInputHidden) findComponentInRoot("kulT1p");
		}
		return kulT1p;
	}

	protected Messages getKullan1c1lar2messages() {
		if (kullan1c1lar2messages == null) {
			kullan1c1lar2messages = (Messages) findComponentInRoot("kullan1c1lar2messages");
		}
		return kullan1c1lar2messages;
	}

	protected InputMask getKulDgmTar1() {
		if (kulDgmTar1 == null) {
			kulDgmTar1 = (InputMask) findComponentInRoot("kulDgmTar1");
		}
		return kulDgmTar1;
	}

	protected InputMask getKulTel1() {
		if (kulTel1 == null) {
			kulTel1 = (InputMask) findComponentInRoot("kulTel1");
		}
		return kulTel1;
	}

	protected InputText getKulAd1() {
		if (kulAd1 == null) {
			kulAd1 = (InputText) findComponentInRoot("kulAd1");
		}
		return kulAd1;
	}

	protected HtmlForm getKayit() {
		if (kayit == null) {
			kayit = (HtmlForm) findComponentInRoot("kayit");
		}
		return kayit;
	}

	protected Panel getPanel() {
		if (panel == null) {
			panel = (Panel) findComponentInRoot("panel");
		}
		return panel;
	}

	protected Growl getGrowl() {
		if (growl == null) {
			growl = (Growl) findComponentInRoot("growl");
		}
		return growl;
	}

}