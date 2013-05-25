
package pagecode.pages.user.include;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

import pagecode.PageCodeBase;
import pagecode.pages.login.Login_frm;
import tools.ChartPro;
import entities.yayin.YynHareket4istat;
import entities.yayin.controller.YynHareket4istatManager;
/**
 * @author EnDeR
 *
 */
public class Kul_index extends PageCodeBase {
	
	private Login_frm  sessionBean;
	private DashboardModel model;
	private DashboardModel modelq;
	private List<ChartPro> istat1;
	private List<ChartPro> istat2;
	private List<ChartPro> istat3;
	private String[] aylar=new String[12];
	
	public Kul_index() {
		model = new DefaultDashboardModel();
		DashboardColumn column1 = new DefaultDashboardColumn();
		DashboardColumn column2 = new DefaultDashboardColumn();
		
		column1.addWidget("ktphnHrkt");
		column2.addWidget("kulHrkt");

		model.addColumn(column1);
		model.addColumn(column2);
		
		modelq = new DefaultDashboardModel();
		DashboardColumn b1 = new DefaultDashboardColumn();
		DashboardColumn b2 = new DefaultDashboardColumn();
		DashboardColumn b3 = new DefaultDashboardColumn();
		DashboardColumn b4 = new DefaultDashboardColumn();
		
		b1.addWidget("b1");
		b2.addWidget("b2");
		b3.addWidget("b3");
		b4.addWidget("b4");

		modelq.addColumn(b1);
		modelq.addColumn(b2);
		modelq.addColumn(b3);
		modelq.addColumn(b4);
		
		aylar[0]="Ocak";
		aylar[1]="Þubat";
		aylar[2]="Mart";
		aylar[3]="Nisan";
		aylar[4]="Mayýs";
		aylar[5]="Haziran";
		aylar[6]="Temmuz";
		aylar[7]="Aðustos";
		aylar[8]="Eylül";
		aylar[9]="Ekim";
		aylar[10]="Kasým";
		aylar[11]="Aralýk";
	}

	


	public void mesaj(Severity severity,String summary,String detail){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(severity,summary,detail));
	}
	
	public Login_frm getSessionBean() {
		if (sessionBean==null) {
			FacesContext context = FacesContext.getCurrentInstance();
		    HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		    sessionBean = (Login_frm) session.getAttribute("pc_sessionBean");
		}
		return sessionBean;
	}




	public DashboardModel getModel() {
		return model;
	}




	public void setModel(DashboardModel model) {
		this.model = model;
	}




	@SuppressWarnings("deprecation")
	public List<ChartPro> getIstat1() {

		istat1=new ArrayList<ChartPro>();
		YynHareket4istatManager hi=(YynHareket4istatManager) getManagedBean("YynHareket4istatManager");
		Calendar cal = Calendar.getInstance();
		
		int buay=cal.getTime().getMonth();
		int[][] dizi=new int[12][3];
		for (int i=0;i<6;i++){
			if (buay==-1) buay=11;
			dizi[buay][2]=1;
			buay--;
			
		}
		cal.add(Calendar.MONTH, -6);
		List<YynHareket4istat> list=hi.getYynHareket4istatVer(cal.getTime());
		
		int ayver,ayal;
		for (int i=0;i<list.size();i++){
			ayver=list.get(i).getL1bVerTar().getMonth();
			dizi[ayver][0]++;
			dizi[ayver][2]=1;
			
		}
		list=hi.getYynHareket4istatAl(cal.getTime());
		for (int i=0;i<list.size();i++){
			
			ayal=list.get(i).getL1bAlTar().getMonth();
			dizi[ayal][1]++;
			dizi[ayal][2]=1;
			
		}
		
		buay++;
		for (int i=0;i<12;i++){
			if (buay==12) 
				buay=0;
			
			if (dizi[buay][2]==1){
				istat1.add(new ChartPro(aylar[buay],dizi[buay][0],dizi[buay][1]));
			}
			buay++;
		}
		return istat1;
	}




	public void setIstat1(List<ChartPro> istat1) {
		this.istat1 = istat1;
	}




	@SuppressWarnings("deprecation")
	public List<ChartPro> getIstat2() {
		istat2=new ArrayList<ChartPro>();
		YynHareket4istatManager hi=(YynHareket4istatManager) getManagedBean("YynHareket4istatManager");
		Calendar cal = Calendar.getInstance();
		int buay=cal.getTime().getMonth();
		int[][] dizi=new int[12][3];
		for (int i=0;i<6;i++){
			if (buay==-1) buay=11;
			dizi[buay][2]=1;
			buay--;
			
		}
		cal.add(Calendar.MONTH, -6);
		getSessionBean();
		List<YynHareket4istat> list=hi.getYynHareket4istatKulVer(sessionBean.getKullan1c1lar().getKul1d(),cal.getTime());		
		int ayver,ayal;
		for (int i=0;i<list.size();i++){
			ayver=list.get(i).getL1bVerTar().getMonth();
			dizi[ayver][0]++;
			dizi[ayver][2]=1;
			
		}
		list=hi.getYynHareket4istatKulAl(sessionBean.getKullan1c1lar().getKul1d(),cal.getTime());
		for (int i=0;i<list.size();i++){
			
			ayal=list.get(i).getL1bAlTar().getMonth();
			dizi[ayal][1]++;
			dizi[ayal][2]=1;
			
		}
		
		buay++;
		for (int i=0;i<12;i++){
			if (buay==12) 
				buay=0;
			
			if (dizi[buay][2]==1){
				istat2.add(new ChartPro(aylar[buay],dizi[buay][0],dizi[buay][1]));
			}
			buay++;
		}
		return istat2;
	}




	public void setIstat2(List<ChartPro> istat2) {
		this.istat2 = istat2;
	}




	public DashboardModel getModelq() {
		return modelq;
	}




	public void setModelq(DashboardModel modelq) {
		this.modelq = modelq;
	}




	@SuppressWarnings("deprecation")
	public List<ChartPro> getIstat3() {
		istat3=new ArrayList<ChartPro>();
		YynHareket4istatManager hi=(YynHareket4istatManager) getManagedBean("YynHareket4istatManager");
		Calendar cal = Calendar.getInstance();
		int buay=cal.getTime().getMonth();
		int[][] dizi=new int[12][3];
		for (int i=0;i<6;i++){
			if (buay==-1) buay=11;
			dizi[buay][2]=1;
			buay--;
			
		}
		cal.add(Calendar.MONTH, -6);
		getSessionBean();
		List<YynHareket4istat> list=hi.getYynHareket4istatUser(sessionBean.getKullan1c1lar().getKul1d(),cal.getTime());
		
		
		int ayver;
		for (int i=0;i<list.size();i++){
			ayver=list.get(i).getL1bVerTar().getMonth();
			dizi[ayver][0]++;
			dizi[ayver][2]=1;
			
		}
		buay++;
		for (int i=0;i<12;i++){
			if (buay==12) 
				buay=0;
			
			if (dizi[buay][2]==1){
				istat3.add(new ChartPro(aylar[buay],dizi[buay][0],dizi[buay][1]));
			}
			buay++;
		}
		return istat3;
	}




	public void setIstat3(List<ChartPro> istat3) {
		this.istat3 = istat3;
	}
	


}