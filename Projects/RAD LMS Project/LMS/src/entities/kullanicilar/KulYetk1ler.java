package entities.kullanicilar;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the KUL_YETK1LER database table.
 * 
 */
@Entity
@Table(name="KUL_YETK1LER")
@NamedQuery(name = "getKulYetk1ler", query = "SELECT k FROM KulYetk1ler k")
public class KulYetk1ler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="YET_1D", unique=true, nullable=false)
	private short yet1d;

	@Column(name="YET_AC1KLAMA", length=1)
	private String yetAc1klama;

	@Column(name="YET_DEGER", nullable=false, length=20)
	private String yetDeger;

    public KulYetk1ler() {
    }

	public short getYet1d() {
		return this.yet1d;
	}

	public void setYet1d(short yet1d) {
		this.yet1d = yet1d;
	}

	public String getYetAc1klama() {
		return this.yetAc1klama;
	}

	public void setYetAc1klama(String yetAc1klama) {
		this.yetAc1klama = yetAc1klama;
	}

	public String getYetDeger() {
		return this.yetDeger;
	}

	public void setYetDeger(String yetDeger) {
		this.yetDeger = yetDeger;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + yet1d;
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
		if (!(obj instanceof KulYetk1ler)) {
			return false;
		}
		KulYetk1ler other = (KulYetk1ler) obj;
		if (yet1d != other.yet1d) {
			return false;
		}
		return true;
	}

}