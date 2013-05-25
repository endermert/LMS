package entities.yayin;

import java.io.Serializable;
import javax.persistence.*;
import entities.yayin.K1taplar;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import entities.yayin.Derg1ler;
import entities.yayin.F1lmler;
import entities.yayin.Tezler;
import entities.yayin.YynHareket;
import entities.yayin.YynAyr1nt1;


/**
 * The persistent class for the YAY1NLAR database table.
 * 
 */
@Entity
@Table(name="YAY1NLAR")
@NamedQueries({
@NamedQuery(name = "getYay1nlarGenelKriter1", query = "SELECT y FROM Yay1nlar y WHERE LOWER(y.yynKodu) LIKE :yynKod1 OR  LOWER(y.yynKodu) LIKE :yynKod2 OR LOWER(y.ktp1d.ktpAd) LIKE :ktpAd OR  LOWER(y.drg1d.drgAd) LIKE :drgAd OR LOWER(y.ktp1d.ktpYazar) LIKE :ktpYazar OR LOWER(y.ayr1d.yaySorumlular) LIKE :ySorumlu OR LOWER(y.ayr1d.yayKonuBasl1k) LIKE :yKonuBasl1k OR LOWER(y.ayr1d.yayAnahtarKel1meler) LIKE :yAnhKelm OR LOWER(y.ayr1d.yayNotlar) LIKE :yNotlar OR LOWER(y.ayr1d.yayBasB1lg) LIKE :yBasB1lg OR LOWER(y.ayr1d.yayOzOzet1cndklr) LIKE :yOzOzet OR LOWER(y.ayr1d.yayS1n1flama) LIKE :yS1n1flama OR LOWER(y.ayr1d.yayDem1rbas) LIKE :yDemirB"),
@NamedQuery(name = "getYay1nlar", query = "SELECT y FROM Yay1nlar y"),
@NamedQuery(name = "getYay1nlarByTez1d", query = "SELECT y FROM Yay1nlar y WHERE y.tez1d.tez1d = :tez1d"),
@NamedQuery(name = "getYay1nlarByKtp1d", query = "SELECT y FROM Yay1nlar y WHERE y.ktp1d.ktp1d = :ktp1d"),
@NamedQuery(name = "getYay1nlarByHrk1d", query = "SELECT y FROM Yay1nlar y WHERE y.hrk1d.hrk1d = :hrk1d"),
@NamedQuery(name = "getYay1nlarByFlm1d", query = "SELECT y FROM Yay1nlar y WHERE y.flm1d.flm1d = :flm1d"),
@NamedQuery(name = "getYay1nlarByDrg1d", query = "SELECT y FROM Yay1nlar y WHERE y.drg1d.drg1d = :drg1d"),
@NamedQuery(name = "getYay1nlarByAyr1d", query = "SELECT y FROM Yay1nlar y WHERE y.ayr1d.ayr1d = :ayr1d"),
@NamedQuery(name = "getYay1nlarByYynKodu", query = "SELECT y FROM Yay1nlar y WHERE y.yynKodu = :yynKodu"),
@NamedQuery(name = "getYay1nlarByT1p1d", query = "SELECT y FROM Yay1nlar y WHERE y.t1p1d = :t1p1d")})
public class Yay1nlar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="YYN_1D", unique=true, nullable=false)
	private int yyn1d;

	@Column(name="T1P_1D")
	private short t1p1d;

	@Column(name="YYN_KODU", length=20)
	private String yynKodu;

	@OneToOne
	@JoinColumn(name="KTP_1D")
	private K1taplar ktp1d;

	@OneToOne
	@JoinColumn(name="DRG_1D")
	private Derg1ler drg1d;

	@OneToOne
	@JoinColumn(name="FLM_1D")
	private F1lmler flm1d;

	@OneToOne
	@JoinColumn(name="TEZ_1D")
	private Tezler tez1d;

	@OneToOne
	@JoinColumn(name="HRK_1D")
	private YynHareket hrk1d;

	@OneToOne
	@JoinColumn(name="AYR_1D")
	private YynAyr1nt1 ayr1d;

    public Yay1nlar() {
    }

	public int getYyn1d() {
		return this.yyn1d;
	}

	public void setYyn1d(int yyn1d) {
		this.yyn1d = yyn1d;
	}

	public short getT1p1d() {
		return this.t1p1d;
	}

	public void setT1p1d(short t1p1d) {
		this.t1p1d = t1p1d;
	}

	public String getYynKodu() {
		return this.yynKodu;
	}

	public void setYynKodu(String yynKodu) {
		this.yynKodu = yynKodu;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + yyn1d;
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
		if (!(obj instanceof Yay1nlar)) {
			return false;
		}
		Yay1nlar other = (Yay1nlar) obj;
		if (yyn1d != other.yyn1d) {
			return false;
		}
		return true;
	}

	public K1taplar getKtp1d() {
		return this.ktp1d;
	}

	public void setKtp1d(K1taplar ktp1d) {
		this.ktp1d = ktp1d;
	}

	public Derg1ler getDrg1d() {
		return this.drg1d;
	}

	public void setDrg1d(Derg1ler drg1d) {
		this.drg1d = drg1d;
	}

	public F1lmler getFlm1d() {
		return this.flm1d;
	}

	public void setFlm1d(F1lmler flm1d) {
		this.flm1d = flm1d;
	}

	public Tezler getTez1d() {
		return this.tez1d;
	}

	public void setTez1d(Tezler tez1d) {
		this.tez1d = tez1d;
	}

	public YynHareket getHrk1d() {
		return this.hrk1d;
	}

	public void setHrk1d(YynHareket hrk1d) {
		this.hrk1d = hrk1d;
	}

	public YynAyr1nt1 getAyr1d() {
		return this.ayr1d;
	}

	public void setAyr1d(YynAyr1nt1 ayr1d) {
		this.ayr1d = ayr1d;
	}

}