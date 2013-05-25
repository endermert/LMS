package entities.yayin;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the F1LMLER database table.
 * 
 */
@Entity
@Table(name="F1LMLER")
public class F1lmler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FLM_1D", unique=true, nullable=false)
	private int flm1d;

	@Column(name="FLM_AD", length=100)
	private String flmAd;

	@Column(name="FLM_ALT_YAZ_D1L", length=200)
	private String flmAltYazD1l;

	@Column(name="FLM_D1L_1D")
	private short flmD1l1d;

	@Column(name="FLM_KODU", length=20)
	private String flmKodu;

	@Column(name="FLM_OYUNCULAR", length=1)
	private String flmOyuncular;

	@Column(name="FLM_RSM_FORMAT", length=100)
	private String flmRsmFormat;

	@Column(name="FLM_SENARYO", length=100)
	private String flmSenaryo;

	@Column(name="FLM_SES_FORMAT", length=100)
	private String flmSesFormat;

	@Column(name="FLM_SURE", length=50)
	private String flmSure;

    @Temporal( TemporalType.DATE)
	@Column(name="FLM_YAP_TAR")
	private Date flmYapTar;

	@Column(name="FLM_YAP1M_YER", length=100)
	private String flmYap1mYer;

	@Column(name="FLM_YAP1MC1", length=100)
	private String flmYap1mc1;

	@Column(name="FLM_YONETMEN", length=100)
	private String flmYonetmen;

    public F1lmler() {
    }

	public int getFlm1d() {
		return this.flm1d;
	}

	public void setFlm1d(int flm1d) {
		this.flm1d = flm1d;
	}

	public String getFlmAd() {
		return this.flmAd;
	}

	public void setFlmAd(String flmAd) {
		this.flmAd = flmAd;
	}

	public String getFlmAltYazD1l() {
		return this.flmAltYazD1l;
	}

	public void setFlmAltYazD1l(String flmAltYazD1l) {
		this.flmAltYazD1l = flmAltYazD1l;
	}

	public short getFlmD1l1d() {
		return this.flmD1l1d;
	}

	public void setFlmD1l1d(short flmD1l1d) {
		this.flmD1l1d = flmD1l1d;
	}

	public String getFlmKodu() {
		return this.flmKodu;
	}

	public void setFlmKodu(String flmKodu) {
		this.flmKodu = flmKodu;
	}

	public String getFlmOyuncular() {
		return this.flmOyuncular;
	}

	public void setFlmOyuncular(String flmOyuncular) {
		this.flmOyuncular = flmOyuncular;
	}

	public String getFlmRsmFormat() {
		return this.flmRsmFormat;
	}

	public void setFlmRsmFormat(String flmRsmFormat) {
		this.flmRsmFormat = flmRsmFormat;
	}

	public String getFlmSenaryo() {
		return this.flmSenaryo;
	}

	public void setFlmSenaryo(String flmSenaryo) {
		this.flmSenaryo = flmSenaryo;
	}

	public String getFlmSesFormat() {
		return this.flmSesFormat;
	}

	public void setFlmSesFormat(String flmSesFormat) {
		this.flmSesFormat = flmSesFormat;
	}

	public String getFlmSure() {
		return this.flmSure;
	}

	public void setFlmSure(String flmSure) {
		this.flmSure = flmSure;
	}

	public Date getFlmYapTar() {
		return this.flmYapTar;
	}

	public void setFlmYapTar(Date flmYapTar) {
		this.flmYapTar = flmYapTar;
	}

	public String getFlmYap1mYer() {
		return this.flmYap1mYer;
	}

	public void setFlmYap1mYer(String flmYap1mYer) {
		this.flmYap1mYer = flmYap1mYer;
	}

	public String getFlmYap1mc1() {
		return this.flmYap1mc1;
	}

	public void setFlmYap1mc1(String flmYap1mc1) {
		this.flmYap1mc1 = flmYap1mc1;
	}

	public String getFlmYonetmen() {
		return this.flmYonetmen;
	}

	public void setFlmYonetmen(String flmYonetmen) {
		this.flmYonetmen = flmYonetmen;
	}

}