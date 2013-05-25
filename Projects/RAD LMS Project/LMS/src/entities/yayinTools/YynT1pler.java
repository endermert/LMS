package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the YYN_T1PLER database table.
 * 
 */
@Entity
@Table(name="YYN_T1PLER")
@NamedQuery(name = "getYynT1pler", query = "SELECT y FROM YynT1pler y")
public class YynT1pler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="T1P_1D", unique=true, nullable=false)
	private short t1p1d;

	@Column(name="T1P_AC1KLAMA", length=1)
	private String t1pAc1klama;

	@Column(name="T1P_DEGER", length=50)
	private String t1pDeger;

    public YynT1pler() {
    }

	public short getT1p1d() {
		return this.t1p1d;
	}

	public void setT1p1d(short t1p1d) {
		this.t1p1d = t1p1d;
	}

	public String getT1pAc1klama() {
		return this.t1pAc1klama;
	}

	public void setT1pAc1klama(String t1pAc1klama) {
		this.t1pAc1klama = t1pAc1klama;
	}

	public String getT1pDeger() {
		return this.t1pDeger;
	}

	public void setT1pDeger(String t1pDeger) {
		this.t1pDeger = t1pDeger;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + t1p1d;
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
		if (!(obj instanceof YynT1pler)) {
			return false;
		}
		YynT1pler other = (YynT1pler) obj;
		if (t1p1d != other.t1p1d) {
			return false;
		}
		return true;
	}

}