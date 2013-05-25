package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ENST1TULER database table.
 * 
 */
@Entity
@Table(name="ENST1TULER")
@NamedQuery(name = "getEnst1tuler", query = "SELECT e FROM Enst1tuler e")
public class Enst1tuler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ENS_1D", unique=true, nullable=false)
	private short ens1d;

	@Column(name="ENS_AC1KLAMA", length=1)
	private String ensAc1klama;

	@Column(name="ENS_AD", length=100)
	private String ensAd;

    public Enst1tuler() {
    }

	public short getEns1d() {
		return this.ens1d;
	}

	public void setEns1d(short ens1d) {
		this.ens1d = ens1d;
	}

	public String getEnsAc1klama() {
		return this.ensAc1klama;
	}

	public void setEnsAc1klama(String ensAc1klama) {
		this.ensAc1klama = ensAc1klama;
	}

	public String getEnsAd() {
		return this.ensAd;
	}

	public void setEnsAd(String ensAd) {
		this.ensAd = ensAd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ens1d;
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
		if (!(obj instanceof Enst1tuler)) {
			return false;
		}
		Enst1tuler other = (Enst1tuler) obj;
		if (ens1d != other.ens1d) {
			return false;
		}
		return true;
	}

}