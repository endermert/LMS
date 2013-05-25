package entities.yayin;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import entities.yayin.Yay1nlar;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 * The persistent class for the L1STEM database table.
 * 
 */
@Entity
@NamedQuery(name = "getL1stemByKul1dOrder", query = "SELECT l FROM L1stem l WHERE l.lstKul1d = :lstKul1d  ORDER BY l.lstEklmTar DESC")
public class L1stem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LST_1D")
	private int lst1d;

    @Temporal( TemporalType.DATE)
	@Column(name="LST_EKLM_TAR")
	private Date lstEklmTar;

	@Column(name="LST_KUL_1D")
	private int lstKul1d;

	@OneToOne
	@JoinColumn(name="LST_YYN_1D")
	private Yay1nlar lstYyn1d;

	public L1stem() {
    }

	public int getLst1d() {
		return this.lst1d;
	}

	public void setLst1d(int lst1d) {
		this.lst1d = lst1d;
	}

	public Date getLstEklmTar() {
		return this.lstEklmTar;
	}

	public void setLstEklmTar(Date lstEklmTar) {
		this.lstEklmTar = lstEklmTar;
	}

	public int getLstKul1d() {
		return this.lstKul1d;
	}

	public void setLstKul1d(int lstKul1d) {
		this.lstKul1d = lstKul1d;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lst1d;
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
		if (!(obj instanceof L1stem)) {
			return false;
		}
		L1stem other = (L1stem) obj;
		if (lst1d != other.lst1d) {
			return false;
		}
		return true;
	}

	public Yay1nlar getLstYyn1d() {
		return this.lstYyn1d;
	}

	public void setLstYyn1d(Yay1nlar lstYyn1d) {
		this.lstYyn1d = lstYyn1d;
	}

}