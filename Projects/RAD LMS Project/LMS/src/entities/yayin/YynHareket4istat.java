package entities.yayin;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the YYN_HAREKET database table.
 * 
 */
@Entity
@Table(name="YYN_HAREKET")
@NamedQueries({@NamedQuery(name = "getYynHareket4istatUser", query = "SELECT y FROM YynHareket4istat y WHERE y.aktKul1d = :aktKul1d AND  y.l1bVerTar > :l1bVerTar ORDER BY y.l1bVerTar"),@NamedQuery(name = "getYynHareket4istatAl", query = "SELECT y FROM YynHareket4istat y WHERE y.l1bAlTar > :l1bAlTar ORDER BY y.l1bAlTar"),
@NamedQuery(name = "getYynHareket4istatKulVer", query = "SELECT y FROM YynHareket4istat y WHERE ( y.verenGrvl11d = :verenGrvl11d AND y.l1bVerTar > :l1bVerTar ) ORDER BY y.l1bVerTar"),
@NamedQuery(name = "getYynHareket4istatKulAl", query = "SELECT y FROM YynHareket4istat y WHERE y.alanGrvl11d = :alanGrvl11d AND  y.l1bAlTar > :l1bAlTar ORDER BY y.l1bAlTar"),
@NamedQuery(name = "getYynHareket4istatVer", query = "SELECT y FROM YynHareket4istat y WHERE y.l1bVerTar > :l1bVerTar ORDER BY y.l1bVerTar")})
public class YynHareket4istat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HRK_1D")
	private long hrk1d;

	@Column(name="AKT_KUL_1D")
	private int aktKul1d;

	@Column(name="ALAN_GRVL1_1D")
	private int alanGrvl11d;

    @Temporal( TemporalType.DATE)
	@Column(name="L1B_AL_TAR")
	private Date l1bAlTar;

    @Temporal( TemporalType.DATE)
	@Column(name="L1B_SON_AL_TAR")
	private Date l1bSonAlTar;

    @Temporal( TemporalType.DATE)
	@Column(name="L1B_VER_TAR")
	private Date l1bVerTar;

	@Column(name="SURE_UZ_SAY")
	private short sureUzSay;

	@Column(name="VEREN_GRVL1_1D")
	private int verenGrvl11d;

	@Column(name="YYN_1D")
	private int yyn1d;

    public YynHareket4istat() {
    }

	public long getHrk1d() {
		return this.hrk1d;
	}

	public void setHrk1d(long hrk1d) {
		this.hrk1d = hrk1d;
	}

	public int getAktKul1d() {
		return this.aktKul1d;
	}

	public void setAktKul1d(int aktKul1d) {
		this.aktKul1d = aktKul1d;
	}

	public int getAlanGrvl11d() {
		return this.alanGrvl11d;
	}

	public void setAlanGrvl11d(int alanGrvl11d) {
		this.alanGrvl11d = alanGrvl11d;
	}

	public Date getL1bAlTar() {
		return this.l1bAlTar;
	}

	public void setL1bAlTar(Date l1bAlTar) {
		this.l1bAlTar = l1bAlTar;
	}

	public Date getL1bSonAlTar() {
		return this.l1bSonAlTar;
	}

	public void setL1bSonAlTar(Date l1bSonAlTar) {
		this.l1bSonAlTar = l1bSonAlTar;
	}

	public Date getL1bVerTar() {
		return this.l1bVerTar;
	}

	public void setL1bVerTar(Date l1bVerTar) {
		this.l1bVerTar = l1bVerTar;
	}

	public short getSureUzSay() {
		return this.sureUzSay;
	}

	public void setSureUzSay(short sureUzSay) {
		this.sureUzSay = sureUzSay;
	}

	public int getVerenGrvl11d() {
		return this.verenGrvl11d;
	}

	public void setVerenGrvl11d(int verenGrvl11d) {
		this.verenGrvl11d = verenGrvl11d;
	}

	public int getYyn1d() {
		return this.yyn1d;
	}

	public void setYyn1d(int yyn1d) {
		this.yyn1d = yyn1d;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (hrk1d ^ (hrk1d >>> 32));
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
		if (!(obj instanceof YynHareket4istat)) {
			return false;
		}
		YynHareket4istat other = (YynHareket4istat) obj;
		if (hrk1d != other.hrk1d) {
			return false;
		}
		return true;
	}

}