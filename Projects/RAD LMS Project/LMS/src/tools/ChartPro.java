package tools;

import java.io.Serializable;


public class ChartPro implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ay;
	private int ay1;
	private int alinan;
	private int verilen;
	
	public ChartPro(int ay1, int verilen,int alinan) {
		super();
		this.ay1 = ay1;
		this.alinan = alinan;
		this.verilen = verilen;
	}
	
	public ChartPro(String ay, int verilen,int alinan) {
		super();
		this.ay = ay;
		this.alinan = alinan;
		this.verilen = verilen;
	}
	
	public String getAy() {
		return ay;
	}
	public void setAy(String ay) {
		this.ay = ay;
	}
	public int getAlinan() {
		return alinan;
	}
	public void setAlinan(int alinan) {
		this.alinan = alinan;
	}
	public int getVerilen() {
		return verilen;
	}
	public void setVerilen(int verilen) {
		this.verilen = verilen;
	}

	public int getAy1() {
		return ay1;
	}

	public void setAy1(int ay1) {
		this.ay1 = ay1;
	}
	
}