package tools;

import java.io.Serializable;
import java.util.Date;

import entities.yayin.Yay1nRezerve;

public class Yay1nOzel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Yay1nRezerve rzrv1nfo;
	private boolean k1tap=false;
	private boolean derg1=false;
	private boolean odunc=false;
	private boolean foto=false;
	private boolean referans=false;
	private boolean rafta=true;
	private int sira=0;
	private Date l1bAlTar;
	private Date l1bSonAlTar;
	private Date l1bVerTar;
	
	
	public boolean isK1tap() {
		return k1tap;
	}
	public void setK1tap(boolean k1tap) {
		this.k1tap = k1tap;
	}
	public boolean isDerg1() {
		return derg1;
	}
	public void setDerg1(boolean derg1) {
		this.derg1 = derg1;
	}
	public boolean isOdunc() {
		return odunc;
	}
	public void setOdunc(boolean odunc) {
		this.odunc = odunc;
	}
	public boolean isFoto() {
		return foto;
	}
	public void setFoto(boolean foto) {
		this.foto = foto;
	}
	public boolean isReferans() {
		return referans;
	}
	public void setReferans(boolean referans) {
		this.referans = referans;
	}
	public boolean isRafta() {
		return rafta;
	}
	public void setRafta(boolean rafta) {
		this.rafta = rafta;
	}
	public Date getL1bAlTar() {
		return l1bAlTar;
	}
	public void setL1bAlTar(Date l1bAlTar) {
		this.l1bAlTar = l1bAlTar;
	}
	public Date getL1bSonAlTar() {
		return l1bSonAlTar;
	}
	public void setL1bSonAlTar(Date l1bSonAlTar) {
		this.l1bSonAlTar = l1bSonAlTar;
	}
	public Date getL1bVerTar() {
		return l1bVerTar;
	}
	public void setL1bVerTar(Date l1bVerTar) {
		this.l1bVerTar = l1bVerTar;
	}
	public int getSira() {
		return sira;
	}
	public void setSira(int sira) {
		this.sira = sira;
	}
	public Yay1nRezerve getRzrv1nfo() {
		return rzrv1nfo;
	}
	public void setRzrv1nfo(Yay1nRezerve rzrv1nfo) {
		this.rzrv1nfo = rzrv1nfo;
	}
}

