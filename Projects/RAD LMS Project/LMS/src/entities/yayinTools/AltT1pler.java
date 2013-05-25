package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ALT_T1PLER database table.
 * 
 */
@Entity
@Table(name="ALT_T1PLER")
@NamedQueries({@NamedQuery(name = "getAltT1plerByT1p1d", query = "SELECT a FROM AltT1pler a WHERE a.t1p1d = :t1p1d"),@NamedQuery(name = "getAltT1plerByAlt1d", query = "SELECT a FROM AltT1pler a WHERE a.alt1d = :alt1d"),
@NamedQuery(name = "getAltT1pler", query = "SELECT a FROM AltT1pler a")})
public class AltT1pler implements Serializable {
	public AltT1pler(short alt1d, String altDeger) {
		super();
		this.alt1d = alt1d;
		this.altDeger = altDeger;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ALT_1D", unique=true, nullable=false)
	private short alt1d;

	@Column(name="ALT_AC1KLAMA", length=1)
	private String altAc1klama;

	@Column(name="ALT_DEGER", length=100)
	private String altDeger;

	@Column(name="T1P_1D")
	private short t1p1d;

    public AltT1pler() {
    }

	public short getAlt1d() {
		return this.alt1d;
	}

	public void setAlt1d(short alt1d) {
		this.alt1d = alt1d;
	}

	public String getAltAc1klama() {
		return this.altAc1klama;
	}

	public void setAltAc1klama(String altAc1klama) {
		this.altAc1klama = altAc1klama;
	}

	public String getAltDeger() {
		return this.altDeger;
	}

	public void setAltDeger(String altDeger) {
		this.altDeger = altDeger;
	}

	public short getT1p1d() {
		return this.t1p1d;
	}

	public void setT1p1d(short t1p1d) {
		this.t1p1d = t1p1d;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alt1d;
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
		if (!(obj instanceof AltT1pler)) {
			return false;
		}
		AltT1pler other = (AltT1pler) obj;
		if (alt1d != other.alt1d) {
			return false;
		}
		return true;
	}

}