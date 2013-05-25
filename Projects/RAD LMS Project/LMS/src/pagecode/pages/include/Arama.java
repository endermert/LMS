
package pagecode.pages.include;

import pagecode.PageCodeBase;
import entities.yayin.Yay1nlar;
import pagecode.pages.admin.include.Global_kul_tools;
import pagecode.pages.include.AramaAyar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.yayin.controller.Yay1nlarManager;
import entities.yayin.controller.Yay1nlarManager2;
import tools.Yay1nlarPro;
import tools.Yay1nlarProManager;
/**
 * @author EnDeR
 *
 */
public class Arama extends PageCodeBase {
	
	
	
	private List<Yay1nlar> yay1nlarList;
	private List<Yay1nlarPro> yay1nlarProList;
	private Yay1nlarPro secilenYay1n;
	
	private AramaAyar aramaAyar=new AramaAyar();
	private int secYyn1d;
	private String kriterNo="0";
	private String kelime;
	private String aranan;
	private String drgkod,drgad,drgSure="0",drgsorml,drg1ssn,drgs1nf,drgknB,drgozet,drgahk;
	private String ktpkod,ktpad,ktpYazar,ktpsorml,ktp1sbn,ktps1nf,ktpknB,ktpozet,ktpahk;
	private double oran=7;
	private short blm1d,konu1d,altT1d,frmt1d,skl1d,d1l1d;
	private int ktphn1d;
	private String yasGrub,saglmSkl,drgSre;
	private String tarSec="0";
	private Date YynTar1;
	private String tarSec2="0";
	private Date YynTar2;
	
	private boolean tblShow;
	private String[][] alanlar=new String[24][4];
	
	
	public List<Yay1nlar> getYay1nlarList() {
		if (yay1nlarList==null){
			Yay1nlarManager yay1nlarManager = (Yay1nlarManager) getManagedBean("Yay1nlarManager");
			yay1nlarList = yay1nlarManager.getYay1nlar();	
		}
		return yay1nlarList;
	}

	public List<Yay1nlarPro> getYay1nlarProList() {
		if (yay1nlarList!=null){
			Yay1nlarProManager ypm=new Yay1nlarProManager();
			yay1nlarProList=new ArrayList<Yay1nlarPro>();
			yay1nlarProList=ypm.Yay1nlarProAdder(yay1nlarList);
		}
		return yay1nlarProList;
	}
	
	public String DetayArama(){
		aranan = aramaAyar.KelimeIslem(kelime);
		alanlar= aramaAyar.aramaAyari(1, kriterNo, aranan);
		DetayGir();
		Yay1nlarManager2 yay1nlarManager = (Yay1nlarManager2) getManagedBean("Yay1nlarManager2");
		yay1nlarList=yay1nlarManager.getYay1nlarByOzelArama1(alanlar,(byte) 1);
		return "";
	}
	public String BasitArama(){
		System.out.println("Basit");
		aranan = aramaAyar.KelimeIslem(kelime);
		alanlar= aramaAyar.aramaAyari(0, kriterNo, aranan);
		Yay1nlarManager2 yay1nlarManager = (Yay1nlarManager2) getManagedBean("Yay1nlarManager2");
		yay1nlarList=yay1nlarManager.getYay1nlarByOzelArama1(alanlar,(byte) 0);
		
		return "";
	}
	public String K1tapArama(){
		System.out.println("K1tap");
		alanlar=aramaAyar.AlanGir();
		alanlar[0][2]=aramaAyar.KelimeIslem(ktpkod);
		alanlar[1][2]=aramaAyar.KelimeIslem(ktpad);
		alanlar[5][2]=aramaAyar.KelimeIslem(ktp1sbn);
		alanlar[7][2]=aramaAyar.KelimeIslem(ktpYazar);
		alanlar[9][2]=aramaAyar.KelimeIslem(ktps1nf);
		alanlar[12][2]=aramaAyar.KelimeIslem(ktpsorml);
		alanlar[13][2]=aramaAyar.KelimeIslem(ktpknB);
		alanlar[14][2]=aramaAyar.KelimeIslem(ktpahk);
		alanlar[16][2]=aramaAyar.KelimeIslem(ktpozet);
		
		if (YynTar1!=null){
			SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
			alanlar[29][2]=format.format(YynTar1);
			System.out.println(format.format(YynTar1));
		}
		
		
		String sec="0";
		
		if (tarSec.equalsIgnoreCase("0"))
			sec="=";
		if (tarSec.equalsIgnoreCase("1"))
			sec="<";
		if (tarSec.equalsIgnoreCase("2"))
			sec=">";
		
		alanlar[29][3]=sec;
		
		alanlar[17][2]="0"+ktphn1d;
		alanlar[18][2]="0"+blm1d;
		alanlar[19][2]="0"+konu1d;
		alanlar[22][2]="0"+altT1d;
		alanlar[23][2]="0"+frmt1d;
		alanlar[24][2]="0"+skl1d;
		alanlar[25][2]="0"+d1l1d;
		
		Yay1nlarManager2 yay1nlarManager = (Yay1nlarManager2) getManagedBean("Yay1nlarManager2");
		yay1nlarList=yay1nlarManager.getYay1nlarByK1tapAra(alanlar);
		return "";
	}
	
	public String Derg1Arama(){
		System.out.println("Derg1");
		alanlar=aramaAyar.AlanGir();
		
		alanlar[0][2]=aramaAyar.KelimeIslem(drgkod);
		alanlar[2][2]=aramaAyar.KelimeIslem(drgad);
		alanlar[6][2]=aramaAyar.KelimeIslem(drg1ssn);
		alanlar[9][2]=aramaAyar.KelimeIslem(drgs1nf);
		alanlar[12][2]=aramaAyar.KelimeIslem(drgsorml);
		alanlar[13][2]=aramaAyar.KelimeIslem(drgknB);
		alanlar[14][2]=aramaAyar.KelimeIslem(drgahk);
		alanlar[16][2]=aramaAyar.KelimeIslem(drgozet);

		
		if (YynTar2!=null){
			SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
			alanlar[30][2]=format.format(YynTar2);
		}
		
		
		String sec="0";
		
		if (tarSec2.equalsIgnoreCase("0"))
			sec="=";
		if (tarSec2.equalsIgnoreCase("1"))
			sec="<";
		if (tarSec2.equalsIgnoreCase("2"))
			sec=">";
		
		alanlar[30][3]=sec;
		
		alanlar[17][2]="0"+ktphn1d;
		alanlar[18][2]="0"+blm1d;
		alanlar[20][2]="0"+konu1d;
		alanlar[22][2]="0"+altT1d;
		alanlar[23][2]="0"+frmt1d;
		alanlar[24][2]="0"+skl1d;
		alanlar[26][2]="0"+d1l1d;
		alanlar[37][2]=drgSure;
		
		Yay1nlarManager2 yay1nlarManager = (Yay1nlarManager2) getManagedBean("Yay1nlarManager2");
		yay1nlarList=yay1nlarManager.getYay1nlarByDerg1Ara(alanlar);
		return "";
	}
	
	private void DetayGir(){
		
		alanlar[17][2]="0"+ktphn1d;
		alanlar[18][2]="0"+blm1d;
		alanlar[19][2]="0"+konu1d;
		alanlar[20][2]="0"+konu1d;
		alanlar[21][2]="0"+konu1d;
		alanlar[22][2]="0"+altT1d;
		alanlar[23][2]="0"+frmt1d;
		alanlar[24][2]="0"+skl1d;
		alanlar[25][2]="0"+d1l1d;
		alanlar[26][2]="0"+d1l1d;
		alanlar[27][2]="0"+d1l1d;
		alanlar[28][2]="0"+d1l1d;
		
		alanlar[17][3]="";
		alanlar[18][3]=") AND (";
		alanlar[19][3]=") AND (";
		alanlar[20][3]=" OR";
		alanlar[21][3]=" OR";
		alanlar[22][3]=") AND (";
		alanlar[23][3]=") AND (";
		alanlar[24][3]=") AND (";
		alanlar[25][3]=") AND (";
		alanlar[26][3]=" OR";
		alanlar[27][3]=" OR";
		alanlar[28][3]=" OR";
	}
	public void Tem1zle(){
		System.out.println("Temizlendi");
		ktphn1d=0;
		blm1d=0;
		konu1d=0;
		altT1d=0;
		frmt1d=0;
		skl1d=0;
		d1l1d=0;
		
		ktpad="";
		ktp1sbn="";
		ktpahk="";
		ktpknB="";
		ktpkod="";
		ktpkod="";
		ktpozet="";
		ktps1nf="";
		ktpsorml="";
		ktpYazar="";
		YynTar1=null;
		kriterNo="0";
		
	}
	public String getKriterNo() {
		return kriterNo;
	}

	public void setKriterNo(String kriterNo) {
		this.kriterNo = kriterNo;
	}

	public String getKelime() {
		
		return kelime;
	}

	public void setKelime(String kelime) {
		this.kelime = kelime;
	}

	public String[][] getAlanlar() {
		return alanlar;
	}

	public String getAranan() {
		return aranan;
	}

	public void setAranan(String aranan) {
		this.aranan = aranan;
	}


	public short getBlm1d() {
		return blm1d;
	}

	public void setBlm1d(short blm1d) {
		this.blm1d = blm1d;
	}

	public short getKonu1d() {
		return konu1d;
	}

	public void setKonu1d(short konu1d) {
		this.konu1d = konu1d;
	}

	public short getAltT1d() {
		return altT1d;
	}

	public void setAltT1d(short altT1d) {
		this.altT1d = altT1d;
	}

	public short getFrmt1d() {
		return frmt1d;
	}

	public void setFrmt1d(short frmt1d) {
		this.frmt1d = frmt1d;
	}

	public short getSkl1d() {
		return skl1d;
	}

	public void setSkl1d(short skl1d) {
		this.skl1d = skl1d;
	}

	public short getD1l1d() {
		return d1l1d;
	}

	public void setD1l1d(short d1l1d) {
		this.d1l1d = d1l1d;
	}

	public int getKtphn1d() {
		return ktphn1d;
	}

	public void setKtphn1d(int ktphn1d) {
		this.ktphn1d = ktphn1d;
	}


	public String getKtpYazar() {
		return ktpYazar;
	}

	public void setKtpYazar(String ktpYazar) {
		this.ktpYazar = ktpYazar;
	}


	public String getKtp1sbn() {
		return ktp1sbn;
	}

	public void setKtp1sbn(String ktp1sbn) {
		this.ktp1sbn = ktp1sbn;
	}


	public boolean isTblShow() {
		if (yay1nlarProList.size()==0)
			tblShow=false;
		else
			tblShow=true;
		return tblShow;
	}

	public void setTblShow(boolean tblShow) {
		
		this.tblShow = tblShow;
	}

	public String getTarSec() {
		return tarSec;
	}

	public void setTarSec(String tarSec) {
		this.tarSec = tarSec;
	}

	public Date getYynTar1() {
		return YynTar1;
	}

	public void setYynTar1(Date yynTar1) {
		YynTar1 = yynTar1;
	}


	public String getTarSec2() {
		return tarSec2;
	}

	public void setTarSec2(String tarSec2) {
		this.tarSec2 = tarSec2;
	}

	public Date getYynTar2() {
		return YynTar2;
	}

	public void setYynTar2(Date yynTar2) {
		YynTar2 = yynTar2;
	}

	public String getDrg1ssn() {
		return drg1ssn;
	}

	public void setDrg1ssn(String drg1ssn) {
		this.drg1ssn = drg1ssn;
	}

	public String getDrgSure() {
		return drgSure;
	}

	public void setDrgSure(String drgSure) {
		this.drgSure = drgSure;
	}

	public String getDrgkod() {
		return drgkod;
	}

	public void setDrgkod(String drgkod) {
		this.drgkod = drgkod;
	}

	public String getDrgad() {
		return drgad;
	}

	public void setDrgad(String drgad) {
		this.drgad = drgad;
	}

	public String getDrgsorml() {
		return drgsorml;
	}

	public void setDrgsorml(String drgsorml) {
		this.drgsorml = drgsorml;
	}

	public String getDrgs1nf() {
		return drgs1nf;
	}

	public void setDrgs1nf(String drgs1nf) {
		this.drgs1nf = drgs1nf;
	}

	public String getDrgknB() {
		return drgknB;
	}

	public void setDrgknB(String drgknB) {
		this.drgknB = drgknB;
	}

	public String getDrgozet() {
		return drgozet;
	}

	public void setDrgozet(String drgozet) {
		this.drgozet = drgozet;
	}

	public String getDrgahk() {
		return drgahk;
	}

	public void setDrgahk(String drgahk) {
		this.drgahk = drgahk;
	}

	public String getKtpkod() {
		return ktpkod;
	}

	public void setKtpkod(String ktpkod) {
		this.ktpkod = ktpkod;
	}

	public String getKtpad() {
		return ktpad;
	}

	public void setKtpad(String ktpad) {
		this.ktpad = ktpad;
	}

	public String getKtpsorml() {
		return ktpsorml;
	}

	public void setKtpsorml(String ktpsorml) {
		this.ktpsorml = ktpsorml;
	}

	public String getKtps1nf() {
		return ktps1nf;
	}

	public void setKtps1nf(String ktps1nf) {
		this.ktps1nf = ktps1nf;
	}

	public String getKtpknB() {
		return ktpknB;
	}

	public void setKtpknB(String ktpknB) {
		this.ktpknB = ktpknB;
	}

	public String getKtpozet() {
		return ktpozet;
	}

	public void setKtpozet(String ktpozet) {
		this.ktpozet = ktpozet;
	}

	public String getKtpahk() {
		return ktpahk;
	}

	public void setKtpahk(String ktpahk) {
		this.ktpahk = ktpahk;
	}

	public Yay1nlarPro getSecilenYay1n() {
		if (secilenYay1n == null) 
			secilenYay1n=new Yay1nlarPro();
		
		if ( (Integer) resolveParam("secilenYay1n1d","#{pc_global_kul_tools.yyn1d}", "int")!=null)
				secYyn1d = (Integer) resolveParam("secilenYay1n1d",
				"#{pc_global_kul_tools.yyn1d}", "int");
		
		if (yay1nlarProList!=null ){
			for (int i=0;i<yay1nlarProList.size();i++){
				if (yay1nlarProList.get(i).getYyn1d()==secYyn1d){
					secilenYay1n=new Yay1nlarPro();
					secilenYay1n=yay1nlarProList.get(i);
					
					oran=secilenYay1n.getAyr1d().getYayOran();
					
					Global_kul_tools gtl=new Global_kul_tools();
					if(secilenYay1n.getAyr1d().getYayYasGrup()!=null)
						yasGrub= gtl.yasGetirTek(secilenYay1n.getAyr1d().getYayYasGrup());
					if(secilenYay1n.getAyr1d().getYaySaglamaSkl()!=null)
						saglmSkl=gtl.saglamaSklTek(secilenYay1n.getAyr1d().getYaySaglamaSkl());
					if(secilenYay1n.getAyr1d().getYaySure()!=null)
						drgSre=gtl.drgSureTek(secilenYay1n.getAyr1d().getYaySure());
				}
			}
		}
		return secilenYay1n;
	}

	public void setSecilenYay1n(Yay1nlarPro secilenYay1n) {
		
		this.secilenYay1n = secilenYay1n;
	}

	public int getSecYyn1d() {
		return secYyn1d;
	}

	public void setSecYyn1d(int secYyn1d) {
		this.secYyn1d = secYyn1d;
	}

	public double getOran() {
		return oran;
	}

	public void setOran(double oran) {
		this.oran = oran;
	}

	public String getYasGrub() {
		return yasGrub;
	}

	public void setYasGrub(String yasGrub) {
		this.yasGrub = yasGrub;
	}

	public String getSaglmSkl() {
		return saglmSkl;
	}

	public void setSaglmSkl(String saglmSkl) {
		this.saglmSkl = saglmSkl;
	}

	public String getDrgSre() {
		return drgSre;
	}

	public void setDrgSre(String drgSre) {
		this.drgSre = drgSre;
	}


}