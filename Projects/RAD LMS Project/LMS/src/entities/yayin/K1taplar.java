package entities.yayin;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the K1TAPLAR database table.
 * 
 */
@Entity
@Table(name="K1TAPLAR")
@NamedQueries({@NamedQuery(name = "getK1taplar", query = "SELECT k FROM K1taplar k"),@NamedQuery(name = "getK1taplarByKtp1d", query = "SELECT k FROM K1taplar k WHERE k.ktp1d = :ktp1d")})
public class K1taplar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="KTP_1D", unique=true, nullable=false)
	private int ktp1d;

	@Column(name="KTP_1SBN", length=100)
	private String ktp1sbn;

	@Column(name="KTP_AD", length=100)
	private String ktpAd;

	@Column(name="KTP_D1L")
	private short ktpD1l;

	@Column(name="KTP_KODU", length=20)
	private String ktpKodu;

	@Column(name="KTP_KONU")
	private short ktpKonu;

    @Temporal( TemporalType.DATE)
	@Column(name="KTP_YAY1N_TAR")
	private Date ktpYay1nTar;

	@Column(name="KTP_YAY1NC1")
	private int ktpYay1nc1;

	@Column(name="KTP_YAY1NYER1", length=100)
	private String ktpYay1nyer1;

	@Column(name="KTP_YAZAR", length=100)
	private String ktpYazar;

    public K1taplar() {
    }

	public int getKtp1d() {
		return this.ktp1d;
	}

	public void setKtp1d(int ktp1d) {
		this.ktp1d = ktp1d;
	}

	public String getKtp1sbn() {
		return this.ktp1sbn;
	}

	public void setKtp1sbn(String ktp1sbn) {
		this.ktp1sbn = ktp1sbn;
	}

	public String getKtpAd() {
		return this.ktpAd;
	}

	public void setKtpAd(String ktpAd) {
		this.ktpAd = ktpAd;
	}

	public short getKtpD1l() {
		return this.ktpD1l;
	}

	public void setKtpD1l(short ktpD1l) {
		this.ktpD1l = ktpD1l;
	}

	public String getKtpKodu() {
		return this.ktpKodu;
	}

	public void setKtpKodu(String ktpKodu) {
		this.ktpKodu = ktpKodu;
	}

	public short getKtpKonu() {
		return this.ktpKonu;
	}

	public void setKtpKonu(short ktpKonu) {
		this.ktpKonu = ktpKonu;
	}

	public Date getKtpYay1nTar() {
		return this.ktpYay1nTar;
	}

	public void setKtpYay1nTar(Date ktpYay1nTar) {
		this.ktpYay1nTar = ktpYay1nTar;
	}

	public int getKtpYay1nc1() {
		return this.ktpYay1nc1;
	}

	public void setKtpYay1nc1(int ktpYay1nc1) {
		this.ktpYay1nc1 = ktpYay1nc1;
	}

	public String getKtpYay1nyer1() {
		return this.ktpYay1nyer1;
	}

	public void setKtpYay1nyer1(String ktpYay1nyer1) {
		this.ktpYay1nyer1 = ktpYay1nyer1;
	}

	public String getKtpYazar() {
		return this.ktpYazar;
	}

	public void setKtpYazar(String ktpYazar) {
		this.ktpYazar = ktpYazar;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ktp1d;
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
		if (!(obj instanceof K1taplar)) {
			return false;
		}
		K1taplar other = (K1taplar) obj;
		if (ktp1d != other.ktp1d) {
			return false;
		}
		return true;
	}

}