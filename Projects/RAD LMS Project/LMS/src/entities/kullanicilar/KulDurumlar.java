package entities.kullanicilar;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the KUL_DURUMLAR database table.
 * 
 */
@Entity
@Table(name="KUL_DURUMLAR")
@NamedQuery(name = "getKulDurumlar", query = "SELECT k FROM KulDurumlar k")
public class KulDurumlar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DRM_1D", unique=true, nullable=false)
	private short drm1d;

	@Column(name="DRM_AC1KLAMA", length=1)
	private String drmAc1klama;

	@Column(name="DRM_DEGER", nullable=false, length=20)
	private String drmDeger;

    public KulDurumlar() {
    }

	public short getDrm1d() {
		return this.drm1d;
	}

	public void setDrm1d(short drm1d) {
		this.drm1d = drm1d;
	}

	public String getDrmAc1klama() {
		return this.drmAc1klama;
	}

	public void setDrmAc1klama(String drmAc1klama) {
		this.drmAc1klama = drmAc1klama;
	}

	public String getDrmDeger() {
		return this.drmDeger;
	}

	public void setDrmDeger(String drmDeger) {
		this.drmDeger = drmDeger;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + drm1d;
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
		if (!(obj instanceof KulDurumlar)) {
			return false;
		}
		KulDurumlar other = (KulDurumlar) obj;
		if (drm1d != other.drm1d) {
			return false;
		}
		return true;
	}

}