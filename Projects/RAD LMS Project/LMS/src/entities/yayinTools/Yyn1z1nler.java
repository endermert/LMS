package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the YYN_1Z1NLER database table.
 * 
 */
@Entity
@Table(name="YYN_1Z1NLER")
@NamedQueries({@NamedQuery(name = "getYyn1z1nler1By1z1n1d", query = "SELECT y FROM Yyn1z1nler y WHERE y.z1n1d = :z1n1d"),@NamedQuery(name = "getYyn1z1nler", query = "SELECT y FROM Yyn1z1nler y")})
public class Yyn1z1nler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Z1N_1D")
	private short z1n1d;

	@Column(name="Z1N_AR1ZAL1")
	private String z1nAr1zal1;

	@Column(name="Z1N_BAK1MDA")
	private String z1nBak1mda;

	@Column(name="Z1N_FOTOKOP1")
	private String z1nFotokop1;

	@Column(name="Z1N_ODUNC")
	private String z1nOdunc;

	@Column(name="Z1N_REFERANS")
	private String z1nReferans;

    public Yyn1z1nler() {
    }

	public short getZ1n1d() {
		return this.z1n1d;
	}

	public void setZ1n1d(short z1n1d) {
		this.z1n1d = z1n1d;
	}

	public String getZ1nAr1zal1() {
		return this.z1nAr1zal1;
	}

	public void setZ1nAr1zal1(String z1nAr1zal1) {
		this.z1nAr1zal1 = z1nAr1zal1;
	}

	public String getZ1nBak1mda() {
		return this.z1nBak1mda;
	}

	public void setZ1nBak1mda(String z1nBak1mda) {
		this.z1nBak1mda = z1nBak1mda;
	}

	public String getZ1nFotokop1() {
		return this.z1nFotokop1;
	}

	public void setZ1nFotokop1(String z1nFotokop1) {
		this.z1nFotokop1 = z1nFotokop1;
	}

	public String getZ1nOdunc() {
		return this.z1nOdunc;
	}

	public void setZ1nOdunc(String z1nOdunc) {
		this.z1nOdunc = z1nOdunc;
	}

	public String getZ1nReferans() {
		return this.z1nReferans;
	}

	public void setZ1nReferans(String z1nReferans) {
		this.z1nReferans = z1nReferans;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + z1n1d;
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
		if (!(obj instanceof Yyn1z1nler)) {
			return false;
		}
		Yyn1z1nler other = (Yyn1z1nler) obj;
		if (z1n1d != other.z1n1d) {
			return false;
		}
		return true;
	}

}