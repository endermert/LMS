package entities.yayinTools;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UN1VERS1TELER database table.
 * 
 */
@Entity
@Table(name="UN1VERS1TELER")
@NamedQuery(name = "getUn1vers1teler", query = "SELECT u FROM Un1vers1teler u")
public class Un1vers1teler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UN1_1D", unique=true, nullable=false)
	private short un11d;

	@Column(name="UN1_AC1KLAMA", length=1)
	private String un1Ac1klama;

	@Column(name="UN1_AD", length=100)
	private String un1Ad;

	@Column(name="UN1_URL", length=100)
	private String un1Url;

    public Un1vers1teler() {
    }

	public short getUn11d() {
		return this.un11d;
	}

	public void setUn11d(short un11d) {
		this.un11d = un11d;
	}

	public String getUn1Ac1klama() {
		return this.un1Ac1klama;
	}

	public void setUn1Ac1klama(String un1Ac1klama) {
		this.un1Ac1klama = un1Ac1klama;
	}

	public String getUn1Ad() {
		return this.un1Ad;
	}

	public void setUn1Ad(String un1Ad) {
		this.un1Ad = un1Ad;
	}

	public String getUn1Url() {
		return this.un1Url;
	}

	public void setUn1Url(String un1Url) {
		this.un1Url = un1Url;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + un11d;
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
		if (!(obj instanceof Un1vers1teler)) {
			return false;
		}
		Un1vers1teler other = (Un1vers1teler) obj;
		if (un11d != other.un11d) {
			return false;
		}
		return true;
	}

}