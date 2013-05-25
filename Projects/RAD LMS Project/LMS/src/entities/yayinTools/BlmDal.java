package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BLM_DAL database table.
 * 
 */
@Entity
@Table(name="BLM_DAL")
@NamedQuery(name = "getBlmDal", query = "SELECT b FROM BlmDal b")
public class BlmDal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BLM_1D", unique=true, nullable=false)
	private short blm1d;

	@Column(name="BLM_AC1KLAMA", length=1)
	private String blmAc1klama;

	@Column(name="BLM_AD", length=100)
	private String blmAd;

    public BlmDal() {
    }

	public short getBlm1d() {
		return this.blm1d;
	}

	public void setBlm1d(short blm1d) {
		this.blm1d = blm1d;
	}

	public String getBlmAc1klama() {
		return this.blmAc1klama;
	}

	public void setBlmAc1klama(String blmAc1klama) {
		this.blmAc1klama = blmAc1klama;
	}

	public String getBlmAd() {
		return this.blmAd;
	}

	public void setBlmAd(String blmAd) {
		this.blmAd = blmAd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + blm1d;
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
		if (!(obj instanceof BlmDal)) {
			return false;
		}
		BlmDal other = (BlmDal) obj;
		if (blm1d != other.blm1d) {
			return false;
		}
		return true;
	}

}