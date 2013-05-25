package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ANA_BLM_DAL database table.
 * 
 */
@Entity
@Table(name="ANA_BLM_DAL")
@NamedQuery(name = "getAnaBlmDal", query = "SELECT a FROM AnaBlmDal a")
public class AnaBlmDal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ABD_1D", unique=true, nullable=false)
	private short abd1d;

	@Column(name="ABD_AC1KLAMA", length=1)
	private String abdAc1klama;

	@Column(name="ABD_AD", length=100)
	private String abdAd;

    public AnaBlmDal() {
    }

	public short getAbd1d() {
		return this.abd1d;
	}

	public void setAbd1d(short abd1d) {
		this.abd1d = abd1d;
	}

	public String getAbdAc1klama() {
		return this.abdAc1klama;
	}

	public void setAbdAc1klama(String abdAc1klama) {
		this.abdAc1klama = abdAc1klama;
	}

	public String getAbdAd() {
		return this.abdAd;
	}

	public void setAbdAd(String abdAd) {
		this.abdAd = abdAd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + abd1d;
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
		if (!(obj instanceof AnaBlmDal)) {
			return false;
		}
		AnaBlmDal other = (AnaBlmDal) obj;
		if (abd1d != other.abd1d) {
			return false;
		}
		return true;
	}

}