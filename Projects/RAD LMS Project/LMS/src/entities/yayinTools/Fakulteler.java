package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FAKULTELER database table.
 * 
 */
@Entity
@Table(name="FAKULTELER")
@NamedQuery(name = "getFakulteler", query = "SELECT f FROM Fakulteler f")
public class Fakulteler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FAK_1D", unique=true, nullable=false)
	private short fak1d;

	@Column(name="FAK_AC1KLAMA", length=1)
	private String fakAc1klama;

	@Column(name="FAK_AD", length=100)
	private String fakAd;

    public Fakulteler() {
    }

	public short getFak1d() {
		return this.fak1d;
	}

	public void setFak1d(short fak1d) {
		this.fak1d = fak1d;
	}

	public String getFakAc1klama() {
		return this.fakAc1klama;
	}

	public void setFakAc1klama(String fakAc1klama) {
		this.fakAc1klama = fakAc1klama;
	}

	public String getFakAd() {
		return this.fakAd;
	}

	public void setFakAd(String fakAd) {
		this.fakAd = fakAd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fak1d;
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
		if (!(obj instanceof Fakulteler)) {
			return false;
		}
		Fakulteler other = (Fakulteler) obj;
		if (fak1d != other.fak1d) {
			return false;
		}
		return true;
	}

}