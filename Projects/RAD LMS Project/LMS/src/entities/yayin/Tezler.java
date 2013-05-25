package entities.yayin;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TEZLER database table.
 * 
 */
@Entity
@Table(name="TEZLER")
public class Tezler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TEZ_1D", unique=true, nullable=false)
	private int tez1d;

	@Column(name="ABD_1D")
	private short abd1d;

	@Column(name="BLM_1D")
	private short blm1d;

	@Column(name="D1L_1D")
	private short d1l1d;

	@Column(name="ENS_1D")
	private short ens1d;

	@Column(name="FAK_1D")
	private short fak1d;

	@Column(name="KON_1D")
	private short kon1d;

	@Column(name="TEZ_AD", length=100)
	private String tezAd;

	@Column(name="TEZ_KODU", length=20)
	private String tezKodu;

	@Column(name="TEZ_SAYFA", length=5)
	private String tezSayfa;

	@Column(name="TEZ_YAZAR", length=100)
	private String tezYazar;

    @Temporal( TemporalType.DATE)
	@Column(name="TEZ_YYN_TAR")
	private Date tezYynTar;

	@Column(name="TEZ_YYN_YER", length=100)
	private String tezYynYer;

	@Column(name="UN1_1D")
	private short un11d;

	@Column(name="YNC_1D")
	private int ync1d;

    public Tezler() {
    }

	public int getTez1d() {
		return this.tez1d;
	}

	public void setTez1d(int tez1d) {
		this.tez1d = tez1d;
	}

	public short getAbd1d() {
		return this.abd1d;
	}

	public void setAbd1d(short abd1d) {
		this.abd1d = abd1d;
	}

	public short getBlm1d() {
		return this.blm1d;
	}

	public void setBlm1d(short blm1d) {
		this.blm1d = blm1d;
	}

	public short getD1l1d() {
		return this.d1l1d;
	}

	public void setD1l1d(short d1l1d) {
		this.d1l1d = d1l1d;
	}

	public short getEns1d() {
		return this.ens1d;
	}

	public void setEns1d(short ens1d) {
		this.ens1d = ens1d;
	}

	public short getFak1d() {
		return this.fak1d;
	}

	public void setFak1d(short fak1d) {
		this.fak1d = fak1d;
	}

	public short getKon1d() {
		return this.kon1d;
	}

	public void setKon1d(short kon1d) {
		this.kon1d = kon1d;
	}

	public String getTezAd() {
		return this.tezAd;
	}

	public void setTezAd(String tezAd) {
		this.tezAd = tezAd;
	}

	public String getTezKodu() {
		return this.tezKodu;
	}

	public void setTezKodu(String tezKodu) {
		this.tezKodu = tezKodu;
	}

	public String getTezSayfa() {
		return this.tezSayfa;
	}

	public void setTezSayfa(String tezSayfa) {
		this.tezSayfa = tezSayfa;
	}

	public String getTezYazar() {
		return this.tezYazar;
	}

	public void setTezYazar(String tezYazar) {
		this.tezYazar = tezYazar;
	}

	public Date getTezYynTar() {
		return this.tezYynTar;
	}

	public void setTezYynTar(Date tezYynTar) {
		this.tezYynTar = tezYynTar;
	}

	public String getTezYynYer() {
		return this.tezYynYer;
	}

	public void setTezYynYer(String tezYynYer) {
		this.tezYynYer = tezYynYer;
	}

	public short getUn11d() {
		return this.un11d;
	}

	public void setUn11d(short un11d) {
		this.un11d = un11d;
	}

	public int getYnc1d() {
		return this.ync1d;
	}

	public void setYnc1d(int ync1d) {
		this.ync1d = ync1d;
	}

}