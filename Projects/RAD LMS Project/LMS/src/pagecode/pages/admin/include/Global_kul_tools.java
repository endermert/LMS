/**
 * 
 */
package pagecode.pages.admin.include;

import pagecode.PageCodeBase;
import entities.kullanicilar.KulT1pler;
import entities.kullanicilar.KulDurumlar;
import entities.kullanicilar.KulYetk1ler;
import entities.yayinTools.*;
import entities.yayinTools.controller.*;
import tools.SelectPro;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import entities.kullanicilar.controller.KulT1plerManager;
import entities.kullanicilar.controller.KulDurumlarManager;
import entities.kullanicilar.controller.KulYetk1lerManager;
import com.ibm.jpa.web.JPA;

/**
 * @author EnDeR
 *
 */
public class Global_kul_tools extends PageCodeBase {

	private List<KulT1pler> kulT1plerList;
	private List<KulDurumlar> kulDurumlarList;
	private List<KulYetk1ler> kulYetk1lerList;

	private List<D1ller> d1llerList;
	private List<Konular> konularList;
	private List<Yay1nc1lar> yay1nc1larList;
	private List<AltT1pler> altT1pler;
	private List<Kutuphane> kutuphaneler;
	private List<YynFormat> yynFormat;
	private List<YynSek1l> yynSekil;
	private List<KtphnBolum> ktphnBolum;
	private List<AltT1pler> ktpAltT1pler;
	private List<AltT1pler> drgAltT1pler;
	private List<AltT1pler> flmAltT1pler;

	private List<SelectItem> yasGrubu;
	private List<SelectItem> sglmaSkl1;
	private List<SelectItem> drgSure;
	private List<SelectItem> aramaKriter1;
	private List<SelectItem> istekDrm;
	private List<SelectPro> kriter1;
	private List<SelectPro> drgSr;
	private List<SelectPro> temalar;
	
	private String yyn1d;
	private String Kul1d;
	private String Ktp1d;
	private String Drg1d;
	private String sayfa;
	

	@JPA(targetEntityManager = entities.kullanicilar.controller.KulT1plerManager.class, targetNamedQuery = "getKulT1pler")
	public List<KulT1pler> getKulT1plerList() {
		if (kulT1plerList == null) {
			KulT1plerManager kulT1plerManager = (KulT1plerManager) getManagedBean("KulT1plerManager");
			kulT1plerList = kulT1plerManager.getKulT1pler();
		}
		return kulT1plerList;
	}

	@JPA(targetEntityManager = entities.kullanicilar.controller.KulDurumlarManager.class, targetNamedQuery = "getKulDurumlar")
	public List<KulDurumlar> getKulDurumlarList() {
		if (kulDurumlarList == null) {
			KulDurumlarManager kulDurumlarManager =(KulDurumlarManager) getManagedBean("KulDurumlarManager");
			kulDurumlarList= kulDurumlarManager.getKulDurumlar();
		}
		return kulDurumlarList;
	}

	@JPA(targetEntityManager = entities.kullanicilar.controller.KulYetk1lerManager.class, targetNamedQuery = "getKulYetk1ler")
	public List<KulYetk1ler> getKulYetk1lerList() {
		if (kulYetk1lerList==null){
			KulYetk1lerManager kulYetk1lerManager=(KulYetk1lerManager) getManagedBean("KulYetk1lerManager");
			kulYetk1lerList=kulYetk1lerManager.getKulYetk1ler();
		}
		return kulYetk1lerList;
	}
	
	@JPA(targetEntityManager = entities.yayinTools.controller.D1llerManager.class, targetNamedQuery="getD1ller")
	public List<D1ller> getD1llerList() {
		if (d1llerList==null){
			D1llerManager d1llerManager =(D1llerManager) getManagedBean("D1llerManager");
			d1llerList=d1llerManager.getD1ller();
		}
		return d1llerList;
	}
	
	@JPA(targetEntityManager=entities.yayinTools.controller.KonularManager.class,targetNamedQuery="getKonular")
	public List<Konular> getKonularList() {
		if (konularList==null){
			KonularManager konularManager=(KonularManager) getManagedBean("KonularManager");
			konularList=konularManager.getKonular();
		}
		return konularList;
	}
	
	@JPA(targetEntityManager=entities.yayinTools.controller.Yay1nc1larManager.class,targetNamedQuery="getYay1nc1lar")
	public List<Yay1nc1lar> getYay1nc1larList() {
		if (yay1nc1larList==null){
			Yay1nc1larManager yay1nc1larManager=(Yay1nc1larManager) getManagedBean("Yay1nc1larManager");
			yay1nc1larList=yay1nc1larManager.getYay1nc1lar();
		}
		return yay1nc1larList;
	}

	public String getKul1d() {
		return Kul1d;
	}

	public void setKul1d(String kul1d) {
		Kul1d = kul1d;
	}

	public String getKtp1d() {
		return Ktp1d;
	}

	public void setKtp1d(String ktp1d) {
		Ktp1d = ktp1d;
	}

	public String getDrg1d() {
		return Drg1d;
	}

	public void setDrg1d(String drg1d) {
		Drg1d = drg1d;
	}

	public List<SelectItem> getYasGrubu() {
		if (yasGrubu==null){
			yasGrubu=new ArrayList<SelectItem>();
			yasGrubu.add(new SelectItem("1","Tüm Yaþlar"));
			yasGrubu.add(new SelectItem("2","0-3 Yaþ"));
			yasGrubu.add(new SelectItem("3","4-8 Yaþ"));
			yasGrubu.add(new SelectItem("4","9-12 Yaþ"));
			yasGrubu.add(new SelectItem("5","Genç"));
		}
		return yasGrubu;
	}

	public List<SelectItem> getSglmaSkl1() {
		if (sglmaSkl1==null){
			sglmaSkl1=new ArrayList<SelectItem>();
			sglmaSkl1.add(new SelectItem("1","Satýn"));
			sglmaSkl1.add(new SelectItem("2","Baðýþ"));
			sglmaSkl1.add(new SelectItem("3","Daðýtým"));
		}
		return sglmaSkl1;
	}

	
	public List<AltT1pler> getAltT1pler() {
		if (altT1pler==null){
			AltT1plerManager altT1plerManager=(AltT1plerManager) getManagedBean("AltT1plerManager");
			altT1pler=altT1plerManager.getAltT1pler();
		}
		return altT1pler;
	}

	public List<AltT1pler> getKtpAltT1pler() {
		if (ktpAltT1pler==null){
			AltT1plerManager altT1plerManager=(AltT1plerManager) getManagedBean("AltT1plerManager");
			ktpAltT1pler=altT1plerManager.getAltT1plerByT1p1d((short)1);
		}
		return ktpAltT1pler;
	}

	public List<AltT1pler> getDrgAltT1pler() {
		if (drgAltT1pler==null){
			AltT1plerManager altT1plerManager=(AltT1plerManager) getManagedBean("AltT1plerManager");
			drgAltT1pler=altT1plerManager.getAltT1plerByT1p1d((short)2);
		}
		return drgAltT1pler;
	}

	public List<AltT1pler> getFlmAltT1pler() {
		if (flmAltT1pler==null){
			AltT1plerManager altT1plerManager=(AltT1plerManager) getManagedBean("AltT1plerManager");
			flmAltT1pler=altT1plerManager.getAltT1plerByT1p1d((short)4);
		}
		return flmAltT1pler;
	}

	public List<Kutuphane> getKutuphaneler() {
		if (kutuphaneler==null){
			KutuphaneManager kutuphaneManager=(KutuphaneManager) getManagedBean("KutuphaneManager");
			kutuphaneler=kutuphaneManager.getKutuphane();
		}
		return kutuphaneler;
	}

	public List<YynFormat> getYynFormat() {
		if (yynFormat==null){
			YynFormatManager yynFormatManager=(YynFormatManager) getManagedBean("YynFormatManager");
			yynFormat=yynFormatManager.getYynFormat();
		}
		return yynFormat;
	}

	public List<YynSek1l> getYynSekil() {
		if (yynSekil==null){
			YynSek1lManager yynSek1lManager=(YynSek1lManager) getManagedBean("YynSek1lManager");
			yynSekil=yynSek1lManager.getYynSek1l();
		}
		return yynSekil;
	}

	public List<KtphnBolum> getKtphnBolum() {
		if (ktphnBolum==null){
			KtphnBolumManager ktphnBolumManager=(KtphnBolumManager) getManagedBean("KtphnBolumManager");
			ktphnBolum=ktphnBolumManager.getKtphnBolum();
		}
		return ktphnBolum;
	}

	public List<SelectItem> getDrgSure() {
		if (drgSure==null){
			drgSure=new ArrayList<SelectItem>();
			drgSure.add(new SelectItem("1","Tümü"));
			drgSure.add(new SelectItem("2","Günlük"));
			drgSure.add(new SelectItem("3","Haftalýk"));
			drgSure.add(new SelectItem("4","15 Günlük"));
			drgSure.add(new SelectItem("5","Aylýk"));
			drgSure.add(new SelectItem("6","2 Aylýk"));
			drgSure.add(new SelectItem("7","3 Aylýk"));
			drgSure.add(new SelectItem("8","4 Aylýk"));
			drgSure.add(new SelectItem("9","6 Aylýk"));
			drgSure.add(new SelectItem("10","Yýllýk"));
			drgSure.add(new SelectItem("11","Düzensiz"));
			drgSure.add(new SelectItem("12","Belirsiz"));
		}
		return drgSure;
	}

	public String getSayfa() {
		return sayfa;
	}

	public void setSayfa(String sayfa) {
		this.sayfa = sayfa;
	}

	public List<SelectItem> getAramaKriter1() {
		if (aramaKriter1==null){
			aramaKriter1=new ArrayList<SelectItem>();
			aramaKriter1.add(new SelectItem("0","Tümü"));
			aramaKriter1.add(new SelectItem("1","Yayýn Kodu"));
			aramaKriter1.add(new SelectItem("2","Yayýn Adý"));
			aramaKriter1.add(new SelectItem("3","Yazar"));
			aramaKriter1.add(new SelectItem("12","ISBN/ISSN"));
			aramaKriter1.add(new SelectItem("4","Sorumlular"));
			aramaKriter1.add(new SelectItem("5","Konu Baþlýklarý"));
			aramaKriter1.add(new SelectItem("6","Anahtar Kelimeler"));
			aramaKriter1.add(new SelectItem("7","Notlar"));
			aramaKriter1.add(new SelectItem("8","Basým Bilgileri"));
			aramaKriter1.add(new SelectItem("9","Öz/Özet/Ýçindekiler"));
			aramaKriter1.add(new SelectItem("10","Sýnýflama"));
			aramaKriter1.add(new SelectItem("11","Demirbaþ"));
		}
		return aramaKriter1;
	}

	public void setAramaKriter1(List<SelectItem> aramaKriter1) {
		this.aramaKriter1 = aramaKriter1;
	}

	public List<SelectPro> getKriter1() {
		if (kriter1==null){
			kriter1=new ArrayList<SelectPro>();
			kriter1.add(new SelectPro("0", "Tümü"));
			kriter1.add(new SelectPro("1", "Yayýn Kodu"));
			kriter1.add(new SelectPro("2", "Yayýn Adý"));
			kriter1.add(new SelectPro("3","Yazar"));
			kriter1.add(new SelectPro("12","ISBN/ISSN"));
			kriter1.add(new SelectPro("4","Sorumlular"));
			kriter1.add(new SelectPro("5","Konu Baþlýklarý"));
			kriter1.add(new SelectPro("6","Anahtar Kelimeler"));
			kriter1.add(new SelectPro("7","Notlar"));
			kriter1.add(new SelectPro("8","Basým Bilgileri"));
			kriter1.add(new SelectPro("9","Öz/Özet/Ýçindekiler"));
			kriter1.add(new SelectPro("10","Sýnýflama"));
			kriter1.add(new SelectPro("11","Demirbaþ"));
			
		}
		return kriter1;
	}

	public List<SelectPro> getDrgSr() {
		if (drgSr==null){
			drgSr=new ArrayList<SelectPro>();
			drgSr.add(new SelectPro("0","Tümü"));
			drgSr.add(new SelectPro("1","Günlük"));
			drgSr.add(new SelectPro("2","Haftalýk"));
			drgSr.add(new SelectPro("3","15 Günlük"));
			drgSr.add(new SelectPro("4","Aylýk"));
			drgSr.add(new SelectPro("5","2 Aylýk"));
			drgSr.add(new SelectPro("6","3 Aylýk"));
			drgSr.add(new SelectPro("7","4 Aylýk"));
			drgSr.add(new SelectPro("8","6 Aylýk"));
			drgSr.add(new SelectPro("9","Yýllýk"));
			drgSr.add(new SelectPro("10","Düzensiz"));
			drgSr.add(new SelectPro("11","Belirsiz"));
		}
		return drgSr;
	}

	public String getYyn1d() {
		return yyn1d;
	}

	public void setYyn1d(String yyn1d) {
		this.yyn1d = yyn1d;
	}

	public List<SelectPro> getTemalar() {
		if (temalar==null){
			temalar=new ArrayList<SelectPro>();
			temalar.add(new SelectPro("default", "Varsayýlan"));
			temalar.add(new SelectPro("redmond", "Redmond"));
			temalar.add(new SelectPro("start", "Start"));
			temalar.add(new SelectPro("lightness", "Lightness"));
			temalar.add(new SelectPro("cupertino", "Cupertino"));
			temalar.add(new SelectPro("excite-bike", "Excite Bike"));
			temalar.add(new SelectPro("south-street", "South Street"));
		}
		return temalar;
	}
	
	public String yasGetirTek(String sira){
			getYasGrubu();
		
		if (yasGrubu.size()!=0 && !sira.equalsIgnoreCase(""))
			sira=yasGrubu.get(Integer.parseInt(sira)-1).getLabel();
		
		return sira;
	}
	
	public String saglamaSklTek(String sira){
		
		getSglmaSkl1();
		
		if (sglmaSkl1.size()!=0 && !sira.equalsIgnoreCase(""))
			sira=sglmaSkl1.get(Integer.parseInt(sira)-1).getLabel();
		
		return sira;
	}
	
	public String drgSureTek(String sira){
		
		getDrgSure();
		
		if (drgSure.size()!=0 && !sira.equalsIgnoreCase(""))
			sira=drgSure.get(Integer.parseInt(sira)-1).getLabel();
		
		return sira;
	}

	public List<SelectItem> getIstekDrm() {
		if (istekDrm==null){
			istekDrm=new ArrayList<SelectItem>();
			istekDrm.add(new SelectItem("Beklemede", "Beklemede"));
			istekDrm.add(new SelectItem("Kabul Edildi", "Kabul Edildi"));
			istekDrm.add(new SelectItem("Red Edildi", "Red Edildi"));
		}
		return istekDrm;
	}
	
}
