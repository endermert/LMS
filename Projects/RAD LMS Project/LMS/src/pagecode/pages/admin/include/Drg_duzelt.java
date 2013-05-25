package pagecode.pages.admin.include;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import pagecode.PageCodeBase;
import entities.yayin.Derg1ler;
import entities.yayin.Yay1nlarReg;
import entities.yayin.YynAyr1nt1Reg;
import entities.yayin.controller.Derg1lerManager;
import entities.yayin.controller.Yay1nlarRegManager;
import entities.yayin.controller.YynAyr1nt1RegManager;
import entities.yayinTools.Yyn1z1nler;
import entities.yayinTools.controller.Yyn1z1nlerManager;

import com.ibm.jpa.web.JPA;
import com.ibm.jpa.web.JPAFilter;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;



/**
 * @author EnDeR
 *
 */
public class Drg_duzelt extends PageCodeBase {

	private Derg1ler derg1ler;
	private Yay1nlarReg yay1nlarReg;
	private YynAyr1nt1Reg yynAyr1nt1Reg;
	private Yyn1z1nler yyn1z1nler;

	
	
	@JPA(targetEntityManager = entities.yayin.controller.Derg1lerManager.class, targetAction = JPA.ACTION_TYPE.UPDATE)
	@JPAFilter(name = "drg1d", value = "#{pc_global_kul_tools.drg1d}")
	public Derg1ler getDerg1ler() {
		if (derg1ler == null) {
			Derg1lerManager derg1lerManager = (Derg1lerManager) getManagedBean("Derg1lerManager");
			int drg1d = (Integer) resolveParam("derg1ler_drg1d",
					"#{pc_global_kul_tools.drg1d}", "int");
			derg1ler = derg1lerManager.findDerg1lerByDrg1d(drg1d);
		}
		return derg1ler;
	}
	
	public YynAyr1nt1Reg getYynAyr1nt1Reg() {
		if (yynAyr1nt1Reg == null) {
			if (yay1nlarReg==null)
				yay1nlarReg=getYay1nlarReg();
			YynAyr1nt1RegManager yynAyr1nt1RegManager = (YynAyr1nt1RegManager) getManagedBean("YynAyr1nt1RegManager");
			yynAyr1nt1Reg = yynAyr1nt1RegManager.findYynAyr1nt1RegByAyr1d(yay1nlarReg.getAyr1d());
		}
		return yynAyr1nt1Reg;
	}
	
	
	public Yay1nlarReg getYay1nlarReg() {
		if (yay1nlarReg == null) {
			if (derg1ler==null)
				derg1ler=getDerg1ler();
			Yay1nlarRegManager yay1nlarRegManager = (Yay1nlarRegManager) getManagedBean("Yay1nlarRegManager");
			List<Yay1nlarReg> list = yay1nlarRegManager.getYay1nlarRegByDrg1d(derg1ler.getDrg1d());
			if (!list.isEmpty()) {
				yay1nlarReg = list.get(0);
			}
		}
		return yay1nlarReg;
	}
	
	public Yyn1z1nler getYyn1z1nler() {
		if (yyn1z1nler==null){
			if (yynAyr1nt1Reg==null)
				yynAyr1nt1Reg=getYynAyr1nt1Reg();
			
			Yyn1z1nlerManager yyn1z1nlerManager = (Yyn1z1nlerManager) getManagedBean("Yyn1z1nlerManager");
			yyn1z1nler=yyn1z1nlerManager.findYyn1z1nlerByZ1n1d(yynAyr1nt1Reg.getZ1n1d());
		}
		return yyn1z1nler;
	}

	public String updateDerg1lerAction() {
		Derg1lerManager derg1lerManager = (Derg1lerManager) getManagedBean("Derg1lerManager");
		Yay1nlarRegManager yay1nlarRegManager = (Yay1nlarRegManager) getManagedBean("Yay1nlarRegManager");
		YynAyr1nt1RegManager yynAyr1nt1RegManager = (YynAyr1nt1RegManager) getManagedBean("YynAyr1nt1RegManager");
		Yyn1z1nlerManager yyn1z1nlerManager = (Yyn1z1nlerManager) getManagedBean("Yyn1z1nlerManager");
		try {
			derg1lerManager.updateDerg1ler(derg1ler);
			
			if (yay1nlarReg==null)
				yay1nlarReg=getYay1nlarReg();
			
			yay1nlarReg.setYynKodu(derg1ler.getDrgKodu());
			yay1nlarRegManager.updateYay1nlarReg(yay1nlarReg);
			yyn1z1nlerManager.updateYyn1z1nler(yyn1z1nler);
			yynAyr1nt1RegManager.updateYynAyr1nt1Reg(yynAyr1nt1Reg);
			
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Baþarýlý", "1 Dergi güncellendi.."));
		} catch (Exception e) {
			logException(e);
		}
		return "";
	}


	public String deleteDerg1lerAction() {
		Derg1lerManager derg1lerManager = (Derg1lerManager) getManagedBean("Derg1lerManager");
		Yay1nlarRegManager yay1nlarRegManager = (Yay1nlarRegManager) getManagedBean("Yay1nlarRegManager");
		YynAyr1nt1RegManager yynAyr1nt1RegManager = (YynAyr1nt1RegManager) getManagedBean("YynAyr1nt1RegManager");
		Yyn1z1nlerManager yyn1z1nlerManager = (Yyn1z1nlerManager) getManagedBean("Yyn1z1nlerManager");
		try {
			derg1ler=getDerg1ler();
			yyn1z1nler=getYyn1z1nler();
			yay1nlarReg=getYay1nlarReg();
			yynAyr1nt1Reg=getYynAyr1nt1Reg();
			
			yay1nlarRegManager.deleteYay1nlarReg(yay1nlarReg);
			yynAyr1nt1RegManager.deleteYynAyr1nt1Reg(yynAyr1nt1Reg);
			yyn1z1nlerManager.deleteYyn1z1nler(yyn1z1nler);
			derg1lerManager.deleteDerg1ler(derg1ler);
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Baþarýlý", "1 Dergi silindi.."));
		} catch (Exception e) {
			logException(e);
		}
		return "";
	}
	
	public String createYynAyr1nt1RegAction() {
		YynAyr1nt1RegManager yynAyr1nt1RegManager = (YynAyr1nt1RegManager) getManagedBean("YynAyr1nt1RegManager");
		try {
			yynAyr1nt1RegManager.createYynAyr1nt1Reg(yynAyr1nt1Reg);
		} catch (Exception e) {
			logException(e);
		}
		return "";
	}
	

	public void handleFileUpload(FileUploadEvent event) {
    	ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    	String fn="drg"+ derg1ler.getDrg1d() + "." + event.getFile().getContentType().substring(6,event.getFile().getContentType().length());
		String newFileName = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "uploads" + File.separator + fn;
		
		FileImageOutputStream imageOutput;
		try {
			imageOutput = new FileImageOutputStream(new File(newFileName));
			imageOutput.write(event.getFile().getContents(), 0, event.getFile().getContents().length);
			imageOutput.close();
			YynAyr1nt1RegManager yynAyr1nt1RegManager = (YynAyr1nt1RegManager) getManagedBean("YynAyr1nt1RegManager");
			yynAyr1nt1Reg.setYayRes1m1(fn);
			yynAyr1nt1RegManager.updateYynAyr1nt1Reg(yynAyr1nt1Reg);
	        FacesMessage msg = new FacesMessage("Baþarýlý", event.getFile().getFileName() + " upload edildi.");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}