
package pagecode.pages.include;

import pagecode.PageCodeBase;
/**
 * @author EnDeR
 *
 */
public class AramaAyar extends PageCodeBase {
	
	private String[][] alanlar=new String[45][4];
	
	public String[][] AlanGir(){
		alanlar[0][0]="y.yynKodu";
		alanlar[1][0]="y.ktp1d.ktpAd";
		alanlar[2][0]="y.drg1d.drgAd";
		alanlar[3][0]="y.tez1d.tezAd";
		alanlar[4][0]="y.flm1d.flmAd";
		alanlar[5][0]="y.ktp1d.ktp1sbn";
		alanlar[6][0]="y.drg1d.drg1ssn";
		alanlar[7][0]="y.ktp1d.ktpYazar";
		alanlar[8][0]="y.tez1d.tezYazar";
		alanlar[9][0]="y.ayr1d.yayS1n1flama";
		alanlar[10][0]="y.ayr1d.yayDem1rbas";
		alanlar[11][0]="y.ayr1d.yayBasB1lg";
		alanlar[12][0]="y.ayr1d.yaySorumlular";
		alanlar[13][0]="y.ayr1d.yayKonuBasl1k";
		alanlar[14][0]="y.ayr1d.yayAnahtarKel1meler";
		alanlar[15][0]="y.ayr1d.yayNotlar";
		alanlar[16][0]="y.ayr1d.yayOzOzet1cndklr";
		alanlar[17][0]="y.ayr1d.ktphn1d.ktphn1d";
		alanlar[18][0]="y.ayr1d.blm1d.blm1d";
		alanlar[19][0]="y.ktp1d.ktpKonu";
		alanlar[20][0]="y.drg1d.drgKonu";
		alanlar[21][0]="y.tez1d.kon1d";
		alanlar[22][0]="y.ayr1d.alt1d.alt1d";
		alanlar[23][0]="y.ayr1d.fmt1d.fmt1d";
		alanlar[24][0]="y.ayr1d.skl1d.skl1d";
		alanlar[25][0]="y.ktp1d.ktpD1l";
		alanlar[26][0]="y.drg1d.drgD1l";
		alanlar[27][0]="y.tez1d.d1l1d";
		alanlar[28][0]="y.flm1d.flmD1l1d";
		alanlar[29][0]="y.ktp1d.ktpYay1nTar";
		alanlar[30][0]="y.drg1d.drgYay1nTar";		
		alanlar[31][0]="y.tez1d.abd1d";
		alanlar[32][0]="y.tez1d.blm1d";
		alanlar[33][0]="y.tez1d.ens1d";
		alanlar[34][0]="y.tez1d.fak1d";
		alanlar[35][0]="y.tez1d.un11d";
		alanlar[36][0]="y.tez1d.tezYynTar";
		alanlar[37][0]="y.ayr1d.yaySure";
		alanlar[38][0]="y.flm1d.flmYapTar";
		alanlar[39][0]="y.flm1d.flmOyuncular";
		alanlar[40][0]="y.flm1d.flmRsmFormat";
		alanlar[41][0]="y.flm1d.flmSenaryo";
		alanlar[42][0]="y.flm1d.flmSesFormat";
		alanlar[43][0]="y.flm1d.flmYap1mc1";
		alanlar[44][0]="y.flm1d.flmYonetmen";
		
		
		for (int i=0;i<45;i++){
			alanlar[i][1]="d"+i;
			alanlar[i][2]="0";
		}
		return alanlar;
	}
	
	public String[][] aramaAyari(int secNo,String kriterNo,String aranan){
		alanlar=AlanGir();
		
		if (secNo==0){
			kelimeKume(kriterNo,aranan);
			
			for (short i=17;i<45;i++)
				alanlar[i][2]="0";
		}
		if (secNo==1){
			for (short i=17;i<45;i++)
				alanlar[i][2]="0";
			kelimeKume(kriterNo,aranan);
		}
		
		return alanlar;
	}
	
	private void kelimeKume(String krNo,String aranan){		
				
		if (Short.parseShort(krNo)==0)
			for (short i=0;i<17;i++)
				alanlar[i][2]=aranan;
		else
			for (short i=0;i<17;i++)
				alanlar[i][2]="0";
		
		if (Short.parseShort(krNo)==1){
			alanlar[0][2]=aranan;
		}
		if (Short.parseShort(krNo)==2){
			alanlar[1][2]=aranan;
			alanlar[2][2]=aranan;
			alanlar[3][2]=aranan;
			alanlar[4][2]=aranan;
		}
		if (Short.parseShort(krNo)==3){
			alanlar[7][2]=aranan;
			alanlar[8][2]=aranan;
		}
		if (Short.parseShort(krNo)==4){
			alanlar[12][2]=aranan;
		}
		if (Short.parseShort(krNo)==5){
			alanlar[13][2]=aranan;
		}
		if (Short.parseShort(krNo)==6){
			alanlar[14][2]=aranan;
		}
		if (Short.parseShort(krNo)==7){
			alanlar[15][2]=aranan;
		}
		if (Short.parseShort(krNo)==8){
			alanlar[11][2]=aranan;
		}
		if (Short.parseShort(krNo)==9){
			alanlar[16][2]=aranan;
		}
		if (Short.parseShort(krNo)==10){
			alanlar[9][2]=aranan;
		}
		if (Short.parseShort(krNo)==11){
			alanlar[10][2]=aranan;
		}
		if (Short.parseShort(krNo)==12){
			alanlar[5][2]=aranan;
			alanlar[6][2]=aranan;
		}

	}
	

	public String KelimeIslem(String kelime) {
		String str="",aranan="";
		if (kelime==null)
			aranan="0";
		else
		if (kelime.trim().length()>2){
			for(int i=0;i<kelime.length();i++){
				if (kelime.substring(i,i+1).equalsIgnoreCase("Ý")||kelime.substring(i,i+1).equalsIgnoreCase("þ")
						|| kelime.substring(i,i+1).equalsIgnoreCase("ð")||kelime.substring(i,i+1).equalsIgnoreCase("ç")
						|| kelime.substring(i,i+1).equalsIgnoreCase("ö")||kelime.substring(i,i+1).equalsIgnoreCase("ü") 
						|| kelime.substring(i,i+1).equalsIgnoreCase("ý"))
					str=str+"%";
				else
					str=str+kelime.substring(i,i+1).toLowerCase();
			}
			aranan="%"+str+"%";
			}else
				aranan="0";
		
		return aranan;
	}

	public String[][] getAlanlar() {
		return alanlar;
	}

	
}