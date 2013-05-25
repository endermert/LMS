package entities.yayin;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the YAY1NLAR database table.
 * 
 */
@Entity
@Table(name="YAY1NLAR")
@NamedQueries({@NamedQuery(name = "getYay1nlarRegByTez1d", query = "SELECT y FROM Yay1nlarReg y WHERE y.tez1d = :tez1d"),@NamedQuery(name = "getYay1nlarRegByFlm1d", query = "SELECT y FROM Yay1nlarReg y WHERE y.flm1d = :flm1d"),
@NamedQuery(name = "getYay1nlarRegByAyr1d", query = "SELECT y FROM Yay1nlarReg y WHERE y.ayr1d = :ayr1d"),
@NamedQuery(name = "getYay1nlarRegByYynKodu", query = "SELECT y FROM Yay1nlarReg y WHERE y.yynKodu = :yynKodu"),
@NamedQuery(name = "getYay1nlarRegByT1p1d", query = "SELECT y FROM Yay1nlarReg y WHERE y.t1p1d = :t1p1d"),
@NamedQuery(name = "getYay1nlarRegByKtp1d", query = "SELECT y FROM Yay1nlarReg y WHERE y.ktp1d = :ktp1d"),
@NamedQuery(name = "getYay1nlarRegByHrk1d", query = "SELECT y FROM Yay1nlarReg y WHERE y.hrk1d = :hrk1d"),
@NamedQuery(name = "getYay1nlarRegByDrg1d", query = "SELECT y FROM Yay1nlarReg y WHERE y.drg1d = :drg1d"),
@NamedQuery(name = "getYay1nlarRegByYyn1d", query = "SELECT y FROM Yay1nlarReg y WHERE y.yyn1d = :yyn1d"),
@NamedQuery(name = "getYay1nlarReg", query = "SELECT y FROM Yay1nlarReg y")})
public class Yay1nlarReg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="YYN_1D", unique=true, nullable=false)
	private int yyn1d;

	@Column(name="AYR_1D")
	private int ayr1d;

	@Column(name="DRG_1D")
	private int drg1d;

	@Column(name="FLM_1D")
	private int flm1d;

	@Column(name="HRK_1D")
	private long hrk1d;

	@Column(name="KTP_1D")
	private int ktp1d;

	@Column(name="T1P_1D")
	private short t1p1d;

	@Column(name="TEZ_1D")
	private int tez1d;

	@Column(name="YYN_KODU", length=20)
	private String yynKodu;

    public Yay1nlarReg() {
    }

	public int getYyn1d() {
		return this.yyn1d;
	}

	public void setYyn1d(int yyn1d) {
		this.yyn1d = yyn1d;
	}

	public int getAyr1d() {
		return this.ayr1d;
	}

	public void setAyr1d(int ayr1d) {
		this.ayr1d = ayr1d;
	}

	public int getDrg1d() {
		return this.drg1d;
	}

	public void setDrg1d(int drg1d) {
		this.drg1d = drg1d;
	}

	public int getFlm1d() {
		return this.flm1d;
	}

	public void setFlm1d(int flm1d) {
		this.flm1d = flm1d;
	}

	public long getHrk1d() {
		return this.hrk1d;
	}

	public void setHrk1d(long hrk1d) {
		this.hrk1d = hrk1d;
	}

	public int getKtp1d() {
		return this.ktp1d;
	}

	public void setKtp1d(int ktp1d) {
		this.ktp1d = ktp1d;
	}

	public short getT1p1d() {
		return this.t1p1d;
	}

	public void setT1p1d(short t1p1d) {
		this.t1p1d = t1p1d;
	}

	public int getTez1d() {
		return this.tez1d;
	}

	public void setTez1d(int tez1d) {
		this.tez1d = tez1d;
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
		if (!(obj instanceof Yay1nlarReg)) {
			return false;
		}
		Yay1nlarReg other = (Yay1nlarReg) obj;
		if (yyn1d != other.yyn1d) {
			return false;
		}
		return true;
	}

}