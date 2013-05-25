package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the YYN_FORMAT database table.
 * 
 */
@Entity
@Table(name="YYN_FORMAT")
@NamedQuery(name = "getYynFormat", query = "SELECT y FROM YynFormat y")
public class YynFormat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FMT_1D", unique=true, nullable=false)
	private short fmt1d;

	@Column(name="FMT_AC1KLAMA", length=100)
	private String fmtAc1klama;

	@Column(name="FMT_DEGER", length=100)
	private String fmtDeger;

    public YynFormat() {
    }

	public short getFmt1d() {
		return this.fmt1d;
	}

	public void setFmt1d(short fmt1d) {
		this.fmt1d = fmt1d;
	}

	public String getFmtAc1klama() {
		return this.fmtAc1klama;
	}

	public void setFmtAc1klama(String fmtAc1klama) {
		this.fmtAc1klama = fmtAc1klama;
	}

	public String getFmtDeger() {
		return this.fmtDeger;
	}

	public void setFmtDeger(String fmtDeger) {
		this.fmtDeger = fmtDeger;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fmt1d;
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
		if (!(obj instanceof YynFormat)) {
			return false;
		}
		YynFormat other = (YynFormat) obj;
		if (fmt1d != other.fmt1d) {
			return false;
		}
		return true;
	}

}