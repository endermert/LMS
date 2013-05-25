package entities.yayin;

import java.io.Serializable;
import javax.persistence.*;
import entities.yayinTools.Yyn1z1nler;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import entities.yayinTools.Kutuphane;
import entities.yayinTools.KtphnBolum;
import entities.yayinTools.AltT1pler;
import entities.yayinTools.YynFormat;
import entities.yayinTools.YynSek1l;


/**
 * The persistent class for the YYN_AYR1NT1 database table.
 * 
 */
@Entity
@Table(name="YYN_AYR1NT1")
public class YynAyr1nt1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AYR_1D", unique=true, nullable=false)
	private int ayr1d;

	@Column(name="YAY_AC1KLAMA", length=1)
	private String yayAc1klama;

	@Column(name="YAY_ANAHTAR_KEL1MELER", length=1)
	private String yayAnahtarKel1meler;

	@Column(name="YAY_BAS_B1LG", length=200)
	private String yayBasB1lg;

	@Column(name="YAY_C1LT_SAY")
	private short yayC1ltSay;

	@Column(name="YAY_DEM1RBAS", length=100)
	private String yayDem1rbas;

	@Column(name="YAY_DURUM", length=50)
	private String yayDurum;

	@Column(name="YAY_F1Z1K1_OZ", length=1)
	private String yayF1z1k1Oz;

	@Column(name="YAY_KONU_BASL1K", length=1)
	private String yayKonuBasl1k;

	@Column(name="YAY_KOPYA_SAY")
	private short yayKopyaSay;

	@Column(name="YAY_NOTLAR", length=1)
	private String yayNotlar;

	@Column(name="YAY_ODA", length=100)
	private String yayOda;

	@Column(name="YAY_ODUNC_SAY")
	private int yayOduncSay;

	@Column(name="YAY_ORAN")
	private double yayOran;

	@Column(name="YAY_OZ_OZET_1CNDKLR", length=1)
	private String yayOzOzet1cndklr;

	@Column(name="YAY_RES1M1")
	private String yayRes1m1;

	@Column(name="YAY_RES1M2")
	private String yayRes1m2;

	@Column(name="YAY_S1N1FLAMA", length=100)
	private String yayS1n1flama;

	@Column(name="YAY_SAGLAMA_SKL", length=50)
	private String yaySaglamaSkl;

	@Column(name="YAY_SAYFA", length=5)
	private String yaySayfa;

	@Column(name="YAY_SORUMLULAR", length=1)
	private String yaySorumlular;

	@Column(name="YAY_SURE", length=100)
	private String yaySure;

	@Column(name="YAY_URL", length=200)
	private String yayUrl;

	@Column(name="YAY_YAS_GRUP", length=100)
	private String yayYasGrup;

	@OneToOne
	@JoinColumn(name="Z1N_1D")
	private Yyn1z1nler z1n1d;

	@OneToOne
	@JoinColumn(name="KTPHN_1D")
	private Kutuphane ktphn1d;

	@OneToOne
	@JoinColumn(name="BLM_1D")
	private KtphnBolum blm1d;

	@OneToOne
	@JoinColumn(name="ALT_1D")
	private AltT1pler alt1d;

	@OneToOne
	@JoinColumn(name="FMT_1D")
	private YynFormat fmt1d;

	@OneToOne
	@JoinColumn(name="SKL_1D")
	private YynSek1l skl1d;

	public YynAyr1nt1() {
    }

	public int getAyr1d() {
		return this.ayr1d;
	}

	public void setAyr1d(int ayr1d) {
		this.ayr1d = ayr1d;
	}

	public String getYayAc1klama() {
		return this.yayAc1klama;
	}

	public void setYayAc1klama(String yayAc1klama) {
		this.yayAc1klama = yayAc1klama;
	}

	public String getYayAnahtarKel1meler() {
		return this.yayAnahtarKel1meler;
	}

	public void setYayAnahtarKel1meler(String yayAnahtarKel1meler) {
		this.yayAnahtarKel1meler = yayAnahtarKel1meler;
	}

	public String getYayBasB1lg() {
		return this.yayBasB1lg;
	}

	public void setYayBasB1lg(String yayBasB1lg) {
		this.yayBasB1lg = yayBasB1lg;
	}

	public short getYayC1ltSay() {
		return this.yayC1ltSay;
	}

	public void setYayC1ltSay(short yayC1ltSay) {
		this.yayC1ltSay = yayC1ltSay;
	}

	public String getYayDem1rbas() {
		return this.yayDem1rbas;
	}

	public void setYayDem1rbas(String yayDem1rbas) {
		this.yayDem1rbas = yayDem1rbas;
	}

	public String getYayDurum() {
		return this.yayDurum;
	}

	public void setYayDurum(String yayDurum) {
		this.yayDurum = yayDurum;
	}

	public String getYayF1z1k1Oz() {
		return this.yayF1z1k1Oz;
	}

	public void setYayF1z1k1Oz(String yayF1z1k1Oz) {
		this.yayF1z1k1Oz = yayF1z1k1Oz;
	}

	public String getYayKonuBasl1k() {
		return this.yayKonuBasl1k;
	}

	public void setYayKonuBasl1k(String yayKonuBasl1k) {
		this.yayKonuBasl1k = yayKonuBasl1k;
	}

	public short getYayKopyaSay() {
		return this.yayKopyaSay;
	}

	public void setYayKopyaSay(short yayKopyaSay) {
		this.yayKopyaSay = yayKopyaSay;
	}

	public String getYayNotlar() {
		return this.yayNotlar;
	}

	public void setYayNotlar(String yayNotlar) {
		this.yayNotlar = yayNotlar;
	}

	public String getYayOda() {
		return this.yayOda;
	}

	public void setYayOda(String yayOda) {
		this.yayOda = yayOda;
	}

	public int getYayOduncSay() {
		return this.yayOduncSay;
	}

	public void setYayOduncSay(int yayOduncSay) {
		this.yayOduncSay = yayOduncSay;
	}

	public double getYayOran() {
		return this.yayOran;
	}

	public void setYayOran(double yayOran) {
		this.yayOran = yayOran;
	}

	public String getYayOzOzet1cndklr() {
		return this.yayOzOzet1cndklr;
	}

	public void setYayOzOzet1cndklr(String yayOzOzet1cndklr) {
		this.yayOzOzet1cndklr = yayOzOzet1cndklr;
	}

	public String getYayRes1m1() {
		return this.yayRes1m1;
	}

	public void setYayRes1m1(String yayRes1m1) {
		this.yayRes1m1 = yayRes1m1;
	}

	public String getYayRes1m2() {
		return this.yayRes1m2;
	}

	public void setYayRes1m2(String yayRes1m2) {
		this.yayRes1m2 = yayRes1m2;
	}

	public String getYayS1n1flama() {
		return this.yayS1n1flama;
	}

	public void setYayS1n1flama(String yayS1n1flama) {
		this.yayS1n1flama = yayS1n1flama;
	}

	public String getYaySaglamaSkl() {
		return this.yaySaglamaSkl;
	}

	public void setYaySaglamaSkl(String yaySaglamaSkl) {
		this.yaySaglamaSkl = yaySaglamaSkl;
	}

	public String getYaySayfa() {
		return this.yaySayfa;
	}

	public void setYaySayfa(String yaySayfa) {
		this.yaySayfa = yaySayfa;
	}

	public String getYaySorumlular() {
		return this.yaySorumlular;
	}

	public void setYaySorumlular(String yaySorumlular) {
		this.yaySorumlular = yaySorumlular;
	}

	public String getYaySure() {
		return this.yaySure;
	}

	public void setYaySure(String yaySure) {
		this.yaySure = yaySure;
	}

	public String getYayUrl() {
		return this.yayUrl;
	}

	public void setYayUrl(String yayUrl) {
		this.yayUrl = yayUrl;
	}

	public String getYayYasGrup() {
		return this.yayYasGrup;
	}

	public void setYayYasGrup(String yayYasGrup) {
		this.yayYasGrup = yayYasGrup;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ayr1d;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof YynAyr1nt1)) {
			return false;
		}
		YynAyr1nt1 other = (YynAyr1nt1) obj;
		if (ayr1d != other.ayr1d) {
			return false;
		}
		return true;
	}

	public Yyn1z1nler getZ1n1d() {
		return this.z1n1d;
	}

	public void setZ1n1d(Yyn1z1nler z1n1d) {
		this.z1n1d = z1n1d;
	}

	public Kutuphane getKtphn1d() {
		return this.ktphn1d;
	}

	public void setKtphn1d(Kutuphane ktphn1d) {
		this.ktphn1d = ktphn1d;
	}

	public KtphnBolum getBlm1d() {
		return this.blm1d;
	}

	public void setBlm1d(KtphnBolum blm1d) {
		this.blm1d = blm1d;
	}

	public AltT1pler getAlt1d() {
		return this.alt1d;
	}

	public void setAlt1d(AltT1pler alt1d) {
		this.alt1d = alt1d;
	}

	public YynFormat getFmt1d() {
		return this.fmt1d;
	}

	public void setFmt1d(YynFormat fmt1d) {
		this.fmt1d = fmt1d;
	}

	public YynSek1l getSkl1d() {
		return this.skl1d;
	}

	public void setSkl1d(YynSek1l skl1d) {
		this.skl1d = skl1d;
	}

}