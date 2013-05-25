package tools;

import java.io.Serializable;


public class SelectPro implements Serializable {
	

	private static final long serialVersionUID = 1L;


	private String slctVl;
	private String slctLbl;
	
	public SelectPro(){
		
	}
	
	public SelectPro(String slctVl, String slctLbl) {
		super();
		this.slctVl = slctVl;
		this.slctLbl = slctLbl;
	}
	
	public String getSlctVl() {
		return slctVl;
	}

	public void setSlctVl(String slctVl) {
		this.slctVl = slctVl;
	}

	public String getSlctLbl() {
		return slctLbl;
	}

	public void setSlctLbl(String slctLbl) {
		this.slctLbl = slctLbl;
	}
			
	
}