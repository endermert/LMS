package entities.kullanicilar;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.persistence.Column;


/**
 * The persistent class for the KULLAN1C1LAR database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name = "getKullan1c1larByKul1d", query = "SELECT k FROM Kullan1c1lar k WHERE k.kul1d = :kul1d"),@NamedQuery(name = "getKullan1c1larByKulKodu", query = "SELECT k FROM Kullan1c1lar k WHERE k.kulKodu = :kulKodu"),
@NamedQuery(name = "getKullan1c1larByKulEpostaAndSifre", query = "SELECT k FROM Kullan1c1lar k WHERE k.kulEposta = :kulEposta AND  k.kulS1fre = :kulS1fre"),
@NamedQuery(name = "getKullan1c1lar", query = "SELECT k FROM Kullan1c1lar k")})
public class Kullan1c1lar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="KUL_1D")
	private int kul1d;

	@Column(name="KUL_1LG1_ALAN")
	private String kul1lg1Alan;

	@Column(name="KUL_AD")
	private String kulAd;

	@Column(name="KUL_ADM1N_TEMA")
	private String kulAdm1nTema;

	@Column(name="KUL_C1NS1YET")
	private String kulC1ns1yet;

    @Temporal( TemporalType.DATE)
	@Column(name="KUL_DGM_TAR")
	private Date kulDgmTar;

	@Column(name="KUL_EPOSTA")
	private String kulEposta;

	@Column(name="KUL_KODU")
	private String kulKodu;

    @Temporal( TemporalType.DATE)
	@Column(name="KUL_KYT_TAR")
	private Date kulKytTar;

	@Column(name="KUL_RESM1")
	private String kulResm1;

	@Column(name="KUL_S1FRE")
	private String kulS1fre;

	@Column(name="KUL_SOYAD")
	private String kulSoyad;

	@Column(name="KUL_TEL")
	private String kulTel;

	@Column(name="KUL_USER_TEMA")
	private String kulUserTema;

	@Column(name="KUL_YET_1D")
	private short kulYet1d;

	@Column(name="KUL_T1P_1D")
	private short kulT1p1d;

	@Column(name="KUL_DRM_1D")
	private short kulDrm1d;

	public Kullan1c1lar() {
    }

	public int getKul1d() {
		return this.kul1d;
	}

	public void setKul1d(int kul1d) {
		this.kul1d = kul1d;
	}

	public String getKul1lg1Alan() {
		return this.kul1lg1Alan;
	}

	public void setKul1lg1Alan(String kul1lg1Alan) {
		this.kul1lg1Alan = kul1lg1Alan;
	}

	public String getKulAd() {
		return this.kulAd;
	}

	public void setKulAd(String kulAd) {
		this.kulAd = kulAd;
	}

	public String getKulAdm1nTema() {
		return this.kulAdm1nTema;
	}

	public void setKulAdm1nTema(String kulAdm1nTema) {
		this.kulAdm1nTema = kulAdm1nTema;
	}

	public String getKulC1ns1yet() {
		return this.kulC1ns1yet;
	}

	public void setKulC1ns1yet(String kulC1ns1yet) {
		this.kulC1ns1yet = kulC1ns1yet;
	}

	public Date getKulDgmTar() {
		return this.kulDgmTar;
	}

	public void setKulDgmTar(Date kulDgmTar) {
		this.kulDgmTar = kulDgmTar;
	}

	public String getKulEposta() {
		return this.kulEposta;
	}

	public void setKulEposta(String kulEposta) {
		this.kulEposta = kulEposta;
	}

	public String getKulKodu() {
		return this.kulKodu;
	}

	public void setKulKodu(String kulKodu) {
		this.kulKodu = kulKodu;
	}

	public Date getKulKytTar() {
		return this.kulKytTar;
	}

	public void setKulKytTar(Date kulKytTar) {
		this.kulKytTar = kulKytTar;
	}

	public String getKulResm1() {
		return this.kulResm1;
	}

	public void setKulResm1(String kulResm1) {
		this.kulResm1 = kulResm1;
	}

	public String getKulS1fre() {
		return this.kulS1fre;
	}

	public void setKulS1fre(String kulS1fre) {
		this.kulS1fre = kulS1fre;
	}

	public String getKulSoyad() {
		return this.kulSoyad;
	}

	public void setKulSoyad(String kulSoyad) {
		this.kulSoyad = kulSoyad;
	}

	public String getKulTel() {
		return this.kulTel;
	}

	public void setKulTel(String kulTel) {
		this.kulTel = kulTel;
	}

	public String getKulUserTema() {
		return this.kulUserTema;
	}

	public void setKulUserTema(String kulUserTema) {
		this.kulUserTema = kulUserTema;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + kul1d;
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
		if (!(obj instanceof Kullan1c1lar)) {
			return false;
		}
		Kullan1c1lar other = (Kullan1c1lar) obj;
		if (kul1d != other.kul1d) {
			return false;
		}
		return true;
	}

	public short getKulYet1d() {
		return this.kulYet1d;
	}

	public void setKulYet1d(short kulYet1d) {
		this.kulYet1d = kulYet1d;
	}

	public short getKulT1p1d() {
		return this.kulT1p1d;
	}

	public void setKulT1p1d(short kulT1p1d) {
		this.kulT1p1d = kulT1p1d;
	}

	public short getKulDrm1d() {
		return this.kulDrm1d;
	}

	public void setKulDrm1d(short kulDrm1d) {
		this.kulDrm1d = kulDrm1d;
	}

}