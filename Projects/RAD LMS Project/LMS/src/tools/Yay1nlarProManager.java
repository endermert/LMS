package tools;
import java.util.ArrayList;
import java.util.List;

import entities.yayin.KulYynHareket;
import entities.yayin.Yay1nRezerve;
import entities.yayin.Yay1nlar;
import tools.Yay1nlarPro;
import tools.Yay1nOzel;

public class Yay1nlarProManager {
	
	private List<Yay1nlarPro> yay1nlarProList;
	private Yay1nlarPro yay1nlarSingle;
	private int sira=0;
	public List<Yay1nlarPro> Yay1nlarProAdder(List<Yay1nlar> yay1nlarList) {
		yay1nlarProList=new ArrayList<Yay1nlarPro>();
		sira=0;
		for (int i=0;i<yay1nlarList.size();i++)	{
			sira++;
			yay1nlarProList.add(Yay1nlarProAdder(yay1nlarList.get(i)));
		}
		
		return yay1nlarProList;
	}
	
	public List<Yay1nlarPro> Yay1nlarProAdder(List<KulYynHareket> kulYynHarekets,boolean onay) {
		if (onay){
		yay1nlarProList=new ArrayList<Yay1nlarPro>();
		sira=0;
		for (int i=0;i<kulYynHarekets.size();i++)	{
			if (kulYynHarekets.get(i).getL1bAlTar()!=null){
				sira++;
				yay1nlarSingle=Yay1nlarProAdder(kulYynHarekets.get(i));
				yay1nlarProList.add(yay1nlarSingle);
			}
		}
		}
		return yay1nlarProList;
	}
	
	private Yay1nOzel ProYay1nOzel(Yay1nlar yay1nlar){
		Yay1nOzel yay1nOzel=new Yay1nOzel();
		yay1nOzel.setSira(sira);
		if (yay1nlar.getT1p1d()==(short)1)
			yay1nOzel.setK1tap(true);
		else
			yay1nOzel.setK1tap(false);
		
		if (yay1nlar.getT1p1d()==(short)2)
			yay1nOzel.setDerg1(true);
		else
			yay1nOzel.setDerg1(false);
		
		if (yay1nlar.getAyr1d().getZ1n1d().getZ1nFotokop1().equalsIgnoreCase("true"))
			yay1nOzel.setFoto(true);
		else
			yay1nOzel.setFoto(false);
		
		if (yay1nlar.getAyr1d().getZ1n1d().getZ1nOdunc().equalsIgnoreCase("true"))
			yay1nOzel.setOdunc(true);
		else
			yay1nOzel.setOdunc(false);
		
		if (yay1nlar.getAyr1d().getZ1n1d().getZ1nReferans().equalsIgnoreCase("true"))
			yay1nOzel.setReferans(true);
		else
			yay1nOzel.setReferans(false);
		
		if (yay1nlar.getHrk1d()==null)
			yay1nOzel.setRafta(true);
		else
			yay1nOzel.setRafta(false);
		
		return yay1nOzel;
	}
	
	private Yay1nOzel ProYay1nOzel(KulYynHareket kulYynHareket){
		Yay1nOzel yay1nOzel=ProYay1nOzel(kulYynHareket.getYyn1d());
		yay1nOzel.setL1bAlTar(kulYynHareket.getL1bAlTar());
		yay1nOzel.setL1bSonAlTar(kulYynHareket.getL1bSonAlTar());
		yay1nOzel.setL1bVerTar(kulYynHareket.getL1bVerTar());
		yay1nOzel.setSira(sira);
		return yay1nOzel;
	}
	
	private Yay1nOzel ProYay1nOzel(Yay1nlar yay1nlar,Yay1nRezerve rzrv1nfo){
		Yay1nOzel yay1nOzel=new Yay1nOzel();
		yay1nOzel.setRzrv1nfo(rzrv1nfo);
		sira++;
		yay1nOzel.setSira(sira);
		if (yay1nlar.getT1p1d()==(short)1)
			yay1nOzel.setK1tap(true);
		else
			yay1nOzel.setK1tap(false);
		
		if (yay1nlar.getT1p1d()==(short)2)
			yay1nOzel.setDerg1(true);
		else
			yay1nOzel.setDerg1(false);
		
		if (yay1nlar.getAyr1d().getZ1n1d().getZ1nFotokop1().equalsIgnoreCase("true"))
			yay1nOzel.setFoto(true);
		else
			yay1nOzel.setFoto(false);
		
		if (yay1nlar.getAyr1d().getZ1n1d().getZ1nOdunc().equalsIgnoreCase("true"))
			yay1nOzel.setOdunc(true);
		else
			yay1nOzel.setOdunc(false);
		
		if (yay1nlar.getAyr1d().getZ1n1d().getZ1nReferans().equalsIgnoreCase("true"))
			yay1nOzel.setReferans(true);
		else
			yay1nOzel.setReferans(false);
		
		if (yay1nlar.getHrk1d()==null)
			yay1nOzel.setRafta(true);
		else
			yay1nOzel.setRafta(false);
		
		return yay1nOzel;
	}
	public Yay1nlarPro Yay1nlarProAdder(Yay1nlar yay1nlar) {
		yay1nlarSingle=new Yay1nlarPro();
		Yay1nOzel yay1nOzel=ProYay1nOzel(yay1nlar);
		
			yay1nlarSingle.setYyn1d(yay1nlar.getYyn1d());
			yay1nlarSingle.setAyr1d(yay1nlar.getAyr1d());
			yay1nlarSingle.setDrg1d(yay1nlar.getDrg1d());
			yay1nlarSingle.setFlm1d(yay1nlar.getFlm1d());
			yay1nlarSingle.setHrk1d(yay1nlar.getHrk1d());
			yay1nlarSingle.setKtp1d(yay1nlar.getKtp1d());
			yay1nlarSingle.setT1p1d(yay1nlar.getT1p1d());
			yay1nlarSingle.setTez1d(yay1nlar.getTez1d());
			yay1nlarSingle.setYynKodu(yay1nlar.getYynKodu());
			yay1nlarSingle.setYay1nOzel(yay1nOzel);
			
		return yay1nlarSingle;
	}
	
	
	public Yay1nlarPro Yay1nlarProAdder(KulYynHareket kulYynHareket) {
		yay1nlarSingle=new Yay1nlarPro();
		Yay1nlar yay1nlar=kulYynHareket.getYyn1d();
		Yay1nOzel yay1nOzel=ProYay1nOzel(kulYynHareket);
		
			yay1nlarSingle.setYyn1d(yay1nlar.getYyn1d());
			yay1nlarSingle.setAyr1d(yay1nlar.getAyr1d());
			yay1nlarSingle.setDrg1d(yay1nlar.getDrg1d());
			yay1nlarSingle.setFlm1d(yay1nlar.getFlm1d());
			yay1nlarSingle.setHrk1d(yay1nlar.getHrk1d());
			yay1nlarSingle.setKtp1d(yay1nlar.getKtp1d());
			yay1nlarSingle.setT1p1d(yay1nlar.getT1p1d());
			yay1nlarSingle.setTez1d(yay1nlar.getTez1d());
			yay1nlarSingle.setYynKodu(yay1nlar.getYynKodu());
			yay1nlarSingle.setYay1nOzel(yay1nOzel);
			
		return yay1nlarSingle;
	}
	
	public Yay1nlarPro Yay1nlarProAdder(Yay1nlar yay1nlar,Yay1nRezerve rzrv1nfo) {
		yay1nlarSingle=new Yay1nlarPro();
		Yay1nOzel yay1nOzel=ProYay1nOzel(yay1nlar,rzrv1nfo);
		
			yay1nlarSingle.setYyn1d(yay1nlar.getYyn1d());
			yay1nlarSingle.setAyr1d(yay1nlar.getAyr1d());
			yay1nlarSingle.setDrg1d(yay1nlar.getDrg1d());
			yay1nlarSingle.setFlm1d(yay1nlar.getFlm1d());
			yay1nlarSingle.setHrk1d(yay1nlar.getHrk1d());
			yay1nlarSingle.setKtp1d(yay1nlar.getKtp1d());
			yay1nlarSingle.setT1p1d(yay1nlar.getT1p1d());
			yay1nlarSingle.setTez1d(yay1nlar.getTez1d());
			yay1nlarSingle.setYynKodu(yay1nlar.getYynKodu());
			yay1nlarSingle.setYay1nOzel(yay1nOzel);
			
		return yay1nlarSingle;
	}

	public int getSira() {
		return sira;
	}

	public void setSira(int sira) {
		this.sira = sira;
	}
	
}
