package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the KTPHN_BOLUM database table.
 * 
 */
@Entity
@Table(name="KTPHN_BOLUM")
@NamedQueries({@NamedQuery(name = "getKtphnBolumByKtphn1d", query = "SELECT k FROM KtphnBolum k WHERE k.ktphn1d = :ktphn1d"),@NamedQuery(name = "getKtphnBolumByBlm1d", query = "SELECT k FROM KtphnBolum k WHERE k.blm1d = :blm1d"),
@NamedQuery(name = "getKtphnBolum", query = "SELECT k FROM KtphnBolum k")})
public class KtphnBolum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BLM_1D", unique=true, nullable=false)
	private short blm1d;

	@Column(name="BLM_AC1KLAMA", length=5)
	private String blmAc1klama;

	@Column(name="BLM_AD", length=100)
	private String blmAd;

	@Column(name="KTPHN_1D")
	private int ktphn1d;

    public KtphnBolum() {
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

	public int getKtphn1d() {
		return this.ktphn1d;
	}

	public void setKtphn1d(int ktphn1d) {
		this.ktphn1d = ktphn1d;
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
		if (!(obj instanceof KtphnBolum)) {
			return false;
		}
		KtphnBolum other = (KtphnBolum) obj;
		if (blm1d != other.blm1d) {
			return false;
		}
		return true;
	}

}