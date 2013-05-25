package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the YAY1NC1LAR database table.
 * 
 */
@Entity
@Table(name="YAY1NC1LAR")
@NamedQuery(name = "getYay1nc1lar", query = "SELECT y FROM Yay1nc1lar y")
public class Yay1nc1lar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="YNC_1D", unique=true, nullable=false)
	private int ync1d;

	@Column(name="YNC_AC1KLAMA", length=1)
	private String yncAc1klama;

	@Column(name="YNC_AD", length=100)
	private String yncAd;

    public Yay1nc1lar() {
    }

	public int getYnc1d() {
		return this.ync1d;
	}

	public void setYnc1d(int ync1d) {
		this.ync1d = ync1d;
	}

	public String getYncAc1klama() {
		return this.yncAc1klama;
	}

	public void setYncAc1klama(String yncAc1klama) {
		this.yncAc1klama = yncAc1klama;
	}

	public String getYncAd() {
		return this.yncAd;
	}

	public void setYncAd(String yncAd) {
		this.yncAd = yncAd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ync1d;
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
		if (!(obj instanceof Yay1nc1lar)) {
			return false;
		}
		Yay1nc1lar other = (Yay1nc1lar) obj;
		if (ync1d != other.ync1d) {
			return false;
		}
		return true;
	}

}