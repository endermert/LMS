package entities.yayin;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the DERG1LER database table.
 * 
 */
@Entity
@Table(name="DERG1LER")
@NamedQueries({@NamedQuery(name = "getDerg1ler", query = "SELECT d FROM Derg1ler d"),@NamedQuery(name = "getDerg1lerByDrg1d", query = "SELECT d FROM Derg1ler d WHERE d.drg1d = :drg1d")})
public class Derg1ler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DRG_1D", unique=true, nullable=false)
	private int drg1d;

	@Column(name="DRG_1SSN", length=100)
	private String drg1ssn;

	@Column(name="DRG_AD", length=100)
	private String drgAd;

	@Column(name="DRG_D1L")
	private short drgD1l;

	@Column(name="DRG_KODU", length=20)
	private String drgKodu;

	@Column(name="DRG_KONU")
	private short drgKonu;

	@Column(name="DRG_SAY1", length=10)
	private String drgSay1;

    @Temporal( TemporalType.DATE)
	@Column(name="DRG_YAY1N_TAR")
	private Date drgYay1nTar;

	@Column(name="DRG_YAY1NC1")
	private int drgYay1nc1;

	@Column(name="DRG_YAY1NYER1", length=100)
	private String drgYay1nyer1;

    public Derg1ler() {
    }

	public int getDrg1d() {
		return this.drg1d;
	}

	public void setDrg1d(int drg1d) {
		this.drg1d = drg1d;
	}

	public String getDrg1ssn() {
		return this.drg1ssn;
	}

	public void setDrg1ssn(String drg1ssn) {
		this.drg1ssn = drg1ssn;
	}

	public String getDrgAd() {
		return this.drgAd;
	}

	public void setDrgAd(String drgAd) {
		this.drgAd = drgAd;
	}

	public short getDrgD1l() {
		return this.drgD1l;
	}

	public void setDrgD1l(short drgD1l) {
		this.drgD1l = drgD1l;
	}

	public String getDrgKodu() {
		return this.drgKodu;
	}

	public void setDrgKodu(String drgKodu) {
		this.drgKodu = drgKodu;
	}

	public short getDrgKonu() {
		return this.drgKonu;
	}

	public void setDrgKonu(short drgKonu) {
		this.drgKonu = drgKonu;
	}

	public String getDrgSay1() {
		return this.drgSay1;
	}

	public void setDrgSay1(String drgSay1) {
		this.drgSay1 = drgSay1;
	}

	public Date getDrgYay1nTar() {
		return this.drgYay1nTar;
	}

	public void setDrgYay1nTar(Date drgYay1nTar) {
		this.drgYay1nTar = drgYay1nTar;
	}

	public int getDrgYay1nc1() {
		return this.drgYay1nc1;
	}

	public void setDrgYay1nc1(int drgYay1nc1) {
		this.drgYay1nc1 = drgYay1nc1;
	}

	public String getDrgYay1nyer1() {
		return this.drgYay1nyer1;
	}

	public void setDrgYay1nyer1(String drgYay1nyer1) {
		this.drgYay1nyer1 = drgYay1nyer1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + drg1d;
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
		if (!(obj instanceof Derg1ler)) {
			return false;
		}
		Derg1ler other = (Derg1ler) obj;
		if (drg1d != other.drg1d) {
			return false;
		}
		return true;
	}

}