
package pagecode.pages.include;

import pagecode.PageCodeBase;

/**
 * @author EnDeR
 *
 */
public class AramaBar extends PageCodeBase {

	private boolean basitSec=true;
	private boolean detaySec=false;
	private boolean k1tapSec=false;
	private boolean derg1Sec=false;
	
	public String secBasit(){
		basitSec=true;
		detaySec=false;
		k1tapSec=false;
		derg1Sec=false;
		return "";
	}
	
	public String secDetay(){
		basitSec=true;
		detaySec=true;
		k1tapSec=false;
		derg1Sec=false;
		return "";
	}
	
	public String secK1tap(){
		basitSec=false;
		detaySec=true;
		k1tapSec=true;
		derg1Sec=false;
		return "";
	}
	
	public String secDerg1(){
		basitSec=false;
		detaySec=true;
		k1tapSec=false;
		derg1Sec=true;
		return "";
	}
	

	public boolean isBasitSec() {
		return basitSec;
	}

	public void setBasitSec(boolean basitSec) {
		this.basitSec = basitSec;
	}

	public boolean isDetaySec() {
		return detaySec;
	}

	public void setDetaySec(boolean detaySec) {
		this.detaySec = detaySec;
	}

	public boolean isK1tapSec() {
		return k1tapSec;
	}

	public void setK1tapSec(boolean k1tapSec) {
		this.k1tapSec = k1tapSec;
	}

	public boolean isDerg1Sec() {
		return derg1Sec;
	}

	public void setDerg1Sec(boolean derg1Sec) {
		this.derg1Sec = derg1Sec;
	}

	
	
}