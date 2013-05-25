package entities.yayin;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the KUL_1STEKLER database table.
 * 
 */
@Entity
@Table(name="KUL_1STEKLER")
@NamedQueries({@NamedQuery(name = "getKul1steklerReg", query = "SELECT k FROM Kul1steklerReg k ORDER BY k.wntTar DESC"),@NamedQuery(name = "getKul1steklerRegByBek", query = "SELECT k FROM Kul1steklerReg k WHERE k.wntDurum = 'Beklemede' ORDER BY k.wntTar DESC"),
@NamedQuery(name = "getKul1steklerRegByKul1dOrder", query = "SELECT k FROM Kul1steklerReg k WHERE k.wntKul1d = :wntKul1d ORDER BY k.wntTar DESC"),
@NamedQuery(name = "getKul1steklerRegByKulAndYynAndDrm", query = "SELECT k FROM Kul1steklerReg k WHERE k.wntKul1d = :wntKul1d AND  k.wntYyn1d = :wntYyn1d AND  k.wntDurum = 'Beklemede'")})
public class Kul1steklerReg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="WNT_1D")
	private int wnt1d;

	@Column(name="ALT_1D")
	private short alt1d;

	@Column(name="D1L_1D")
	private short d1l1d;

	@Column(name="FMT_1D")
	private short fmt1d;

	@Column(name="SKL_1D")
	private short skl1d;

	@Column(name="T1P_1D")
	private short t1p1d;

	@Column(name="WNT_DURUM")
	private String wntDurum;

	@Column(name="WNT_KUL_1D")
	private int wntKul1d;

    @Temporal( TemporalType.DATE)
	@Column(name="WNT_TAR")
	private Date wntTar;

	@Column(name="WNT_YYN_1D")
	private int wntYyn1d;

	@Column(name="YYN_1SBN_1SSN")
	private String yyn1sbn1ssn;

	@Column(name="YYN_AC1KLAMA")
	private String yynAc1klama;

	@Column(name="YYN_AD")
	private String yynAd;

	@Column(name="YYN_BAS1M_B1LG")
	private String yynBas1mB1lg;

	@Column(name="YYN_SORUMLU")
	private String yynSorumlu;

	@Column(name="YYN_YAY1NC1")
	private String yynYay1nc1;

	@Column(name="YYN_YAZAR")
	private String yynYazar;

	@Column(name="YYN_YER1")
	private String yynYer1;

    @Temporal( TemporalType.DATE)
	@Column(name="YYN_YYN_TAR")
	private Date yynYynTar;

    public Kul1steklerReg() {
    }

	public int getWnt1d() {
		return this.wnt1d;
	}

	public void setWnt1d(int wnt1d) {
		this.wnt1d = wnt1d;
	}

	public short getAlt1d() {
		return this.alt1d;
	}

	public void setAlt1d(short alt1d) {
		this.alt1d = alt1d;
	}

	public short getD1l1d() {
		return this.d1l1d;
	}

	public void setD1l1d(short d1l1d) {
		this.d1l1d = d1l1d;
	}

	public short getFmt1d() {
		return this.fmt1d;
	}

	public void setFmt1d(short fmt1d) {
		this.fmt1d = fmt1d;
	}

	public short getSkl1d() {
		return this.skl1d;
	}

	public void setSkl1d(short skl1d) {
		this.skl1d = skl1d;
	}

	public short getT1p1d() {
		return this.t1p1d;
	}

	public void setT1p1d(short t1p1d) {
		this.t1p1d = t1p1d;
	}

	public String getWntDurum() {
		return this.wntDurum;
	}

	public void setWntDurum(String wntDurum) {
		this.wntDurum = wntDurum;
	}

	public int getWntKul1d() {
		return this.wntKul1d;
	}

	public void setWntKul1d(int wntKul1d) {
		this.wntKul1d = wntKul1d;
	}

	public Date getWntTar() {
		return this.wntTar;
	}

	public void setWntTar(Date wntTar) {
		this.wntTar = wntTar;
	}

	public int getWntYyn1d() {
		return this.wntYyn1d;
	}

	public void setWntYyn1d(int wntYyn1d) {
		this.wntYyn1d = wntYyn1d;
	}

	public String getYyn1sbn1ssn() {
		return this.yyn1sbn1ssn;
	}

	public void setYyn1sbn1ssn(String yyn1sbn1ssn) {
		this.yyn1sbn1ssn = yyn1sbn1ssn;
	}

	public String getYynAc1klama() {
		return this.yynAc1klama;
	}

	public void setYynAc1klama(String yynAc1klama) {
		this.yynAc1klama = yynAc1klama;
	}

	public String getYynAd() {
		return this.yynAd;
	}

	public void setYynAd(String yynAd) {
		this.yynAd = yynAd;
	}

	public String getYynBas1mB1lg() {
		return this.yynBas1mB1lg;
	}

	public void setYynBas1mB1lg(String yynBas1mB1lg) {
		this.yynBas1mB1lg = yynBas1mB1lg;
	}

	public String getYynSorumlu() {
		return this.yynSorumlu;
	}

	public void setYynSorumlu(String yynSorumlu) {
		this.yynSorumlu = yynSorumlu;
	}

	public String getYynYay1nc1() {
		return this.yynYay1nc1;
	}

	public void setYynYay1nc1(String yynYay1nc1) {
		this.yynYay1nc1 = yynYay1nc1;
	}

	public String getYynYazar() {
		return this.yynYazar;
	}

	public void setYynYazar(String yynYazar) {
		this.yynYazar = yynYazar;
	}

	public String getYynYer1() {
		return this.yynYer1;
	}

	public void setYynYer1(String yynYer1) {
		this.yynYer1 = yynYer1;
	}

	public Date getYynYynTar() {
		return this.yynYynTar;
	}

	public void setYynYynTar(Date yynYynTar) {
		this.yynYynTar = yynYynTar;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + wnt1d;
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
		if (!(obj instanceof Kul1steklerReg)) {
			return false;
		}
		Kul1steklerReg other = (Kul1steklerReg) obj;
		if (wnt1d != other.wnt1d) {
			return false;
		}
		return true;
	}

}