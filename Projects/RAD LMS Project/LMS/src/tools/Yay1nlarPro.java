package tools;

import java.io.Serializable;
import entities.yayin.*;


public class Yay1nlarPro implements Serializable {
	private static final long serialVersionUID = 1L;

	private int yyn1d;
	private short t1p1d;
	private String yynKodu;
	private K1taplar ktp1d;
	private Derg1ler drg1d;
	private F1lmler flm1d;
	private Tezler tez1d;
	private YynHareket hrk1d;
	private YynAyr1nt1 ayr1d;
	private Yay1nOzel yay1nOzel;
	
	public Yay1nlarPro(){
		
	}
			
	public Yay1nlarPro(int yyn1d, short t1p1d, String yynKodu, K1taplar ktp1d,
			Derg1ler drg1d, F1lmler flm1d, Tezler tez1d, YynHareket hrk1d,
			YynAyr1nt1 ayr1d,Yay1nOzel yay1nOzel) {
		super();
		this.yyn1d = yyn1d;
		this.t1p1d = t1p1d;
		this.yynKodu = yynKodu;
		this.ktp1d = ktp1d;
		this.drg1d = drg1d;
		this.flm1d = flm1d;
		this.tez1d = tez1d;
		this.hrk1d = hrk1d;
		this.ayr1d = ayr1d;
		this.yay1nOzel=yay1nOzel;
	}
	
	public int getYyn1d() {
		return yyn1d;
	}
	public void setYyn1d(int yyn1d) {
		this.yyn1d = yyn1d;
	}
	public short getT1p1d() {
		return t1p1d;
	}
	public void setT1p1d(short t1p1d) {
		this.t1p1d = t1p1d;
	}
	public String getYynKodu() {
		return yynKodu;
	}
	public void setYynKodu(String yynKodu) {
		this.yynKodu = yynKodu;
	}
	public K1taplar getKtp1d() {
		return ktp1d;
	}
	public void setKtp1d(K1taplar ktp1d) {
		this.ktp1d = ktp1d;
	}
	public Derg1ler getDrg1d() {
		return drg1d;
	}
	public void setDrg1d(Derg1ler drg1d) {
		this.drg1d = drg1d;
	}
	public F1lmler getFlm1d() {
		return flm1d;
	}
	public void setFlm1d(F1lmler flm1d) {
		this.flm1d = flm1d;
	}
	public Tezler getTez1d() {
		return tez1d;
	}
	public void setTez1d(Tezler tez1d) {
		this.tez1d = tez1d;
	}
	public YynHareket getHrk1d() {
		return hrk1d;
	}
	public void setHrk1d(YynHareket hrk1d) {
		this.hrk1d = hrk1d;
	}
	public YynAyr1nt1 getAyr1d() {
		return ayr1d;
	}
	public void setAyr1d(YynAyr1nt1 ayr1d) {
		this.ayr1d = ayr1d;
	}

	public Yay1nOzel getYay1nOzel() {
		return yay1nOzel;
	}

	public void setYay1nOzel(Yay1nOzel yay1nOzel) {
		this.yay1nOzel = yay1nOzel;
	}
	
}