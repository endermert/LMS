package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the YYN_SEK1L database table.
 * 
 */
@Entity
@Table(name="YYN_SEK1L")
@NamedQuery(name = "getYynSek1l", query = "SELECT y FROM YynSek1l y")
public class YynSek1l implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SKL_1D", unique=true, nullable=false)
	private short skl1d;

	@Column(name="SKL_AC1KLAMA", length=100)
	private String sklAc1klama;

	@Column(name="SKL_DEGER", length=100)
	private String sklDeger;

    public YynSek1l() {
    }

	public short getSkl1d() {
		return this.skl1d;
	}

	public void setSkl1d(short skl1d) {
		this.skl1d = skl1d;
	}

	public String getSklAc1klama() {
		return this.sklAc1klama;
	}

	public void setSklAc1klama(String sklAc1klama) {
		this.sklAc1klama = sklAc1klama;
	}

	public String getSklDeger() {
		return this.sklDeger;
	}

	public void setSklDeger(String sklDeger) {
		this.sklDeger = sklDeger;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + skl1d;
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
		if (!(obj instanceof YynSek1l)) {
			return false;
		}
		YynSek1l other = (YynSek1l) obj;
		if (skl1d != other.skl1d) {
			return false;
		}
		return true;
	}

}