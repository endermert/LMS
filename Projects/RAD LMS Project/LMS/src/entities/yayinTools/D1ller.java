package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the D1LLER database table.
 * 
 */
@Entity
@Table(name="D1LLER")
@NamedQuery(name = "getD1ller", query = "SELECT d FROM D1ller d")
public class D1ller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="D1L_1D", unique=true, nullable=false)
	private short d1l1d;

	@Column(name="D1L_AC1KLAMA", length=1)
	private String d1lAc1klama;

	@Column(name="D1L_AD", length=20)
	private String d1lAd;

    public D1ller() {
    }

	public short getD1l1d() {
		return this.d1l1d;
	}

	public void setD1l1d(short d1l1d) {
		this.d1l1d = d1l1d;
	}

	public String getD1lAc1klama() {
		return this.d1lAc1klama;
	}

	public void setD1lAc1klama(String d1lAc1klama) {
		this.d1lAc1klama = d1lAc1klama;
	}

	public String getD1lAd() {
		return this.d1lAd;
	}

	public void setD1lAd(String d1lAd) {
		this.d1lAd = d1lAd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + d1l1d;
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
		if (!(obj instanceof D1ller)) {
			return false;
		}
		D1ller other = (D1ller) obj;
		if (d1l1d != other.d1l1d) {
			return false;
		}
		return true;
	}

}