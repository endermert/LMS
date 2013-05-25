package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the KUTUPHANE database table.
 * 
 */
@Entity
@Table(name="KUTUPHANE")
@NamedQuery(name = "getKutuphane", query = "SELECT k FROM Kutuphane k")
public class Kutuphane implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="KTPHN_1D", unique=true, nullable=false)
	private int ktphn1d;

	@Column(name="KTPHN_AC1KLAMA", length=200)
	private String ktphnAc1klama;

	@Column(name="KTPHN_AD", length=200)
	private String ktphnAd;

	@Column(name="KTPHN_ADRES", length=200)
	private String ktphnAdres;

    public Kutuphane() {
    }

	public int getKtphn1d() {
		return this.ktphn1d;
	}

	public void setKtphn1d(int ktphn1d) {
		this.ktphn1d = ktphn1d;
	}

	public String getKtphnAc1klama() {
		return this.ktphnAc1klama;
	}

	public void setKtphnAc1klama(String ktphnAc1klama) {
		this.ktphnAc1klama = ktphnAc1klama;
	}

	public String getKtphnAd() {
		return this.ktphnAd;
	}

	public void setKtphnAd(String ktphnAd) {
		this.ktphnAd = ktphnAd;
	}

	public String getKtphnAdres() {
		return this.ktphnAdres;
	}

	public void setKtphnAdres(String ktphnAdres) {
		this.ktphnAdres = ktphnAdres;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ktphn1d;
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
		if (!(obj instanceof Kutuphane)) {
			return false;
		}
		Kutuphane other = (Kutuphane) obj;
		if (ktphn1d != other.ktphn1d) {
			return false;
		}
		return true;
	}

}