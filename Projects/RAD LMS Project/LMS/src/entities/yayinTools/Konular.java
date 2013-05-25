package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the KONULAR database table.
 * 
 */
@Entity
@Table(name="KONULAR")
@NamedQuery(name = "getKonular", query = "SELECT k FROM Konular k")
public class Konular implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="KON_1D", unique=true, nullable=false)
	private short kon1d;

	@Column(name="KON_AC1KLAMA", length=1)
	private String konAc1klama;

	@Column(name="KON_AD", length=100)
	private String konAd;

    public Konular() {
    }

	public short getKon1d() {
		return this.kon1d;
	}

	public void setKon1d(short kon1d) {
		this.kon1d = kon1d;
	}

	public String getKonAc1klama() {
		return this.konAc1klama;
	}

	public void setKonAc1klama(String konAc1klama) {
		this.konAc1klama = konAc1klama;
	}

	public String getKonAd() {
		return this.konAd;
	}

	public void setKonAd(String konAd) {
		this.konAd = konAd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + kon1d;
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
		if (!(obj instanceof Konular)) {
			return false;
		}
		Konular other = (Konular) obj;
		if (kon1d != other.kon1d) {
			return false;
		}
		return true;
	}

}