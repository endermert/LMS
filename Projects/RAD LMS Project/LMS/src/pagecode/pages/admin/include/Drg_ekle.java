package pagecode.pages.admin.include;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import pagecode.PageCodeBase;
import entities.yayin.Derg1ler;
import entities.yayin.Yay1nlarReg;
import entities.yayin.YynAyr1nt1Reg;
import entities.yayin.controller.Yay1nlarRegManager;
import entities.yayin.controller.Derg1lerManager;
import entities.yayin.controller.YynAyr1nt1RegManager;
import entities.yayinTools.Yyn1z1nler;
import entities.yayinTools.controller.Yyn1z1nlerManager;

import com.ibm.jpa.web.JPA;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;



/**
 * @author EnDeR
 *
 */
public class Drg_ekle extends PageCodeBase {

	private Derg1ler derg1ler;
	private Yay1nlarReg yay1nlarReg;
	private YynAyr1nt1Reg yynAyr1nt1Reg;
	private Yyn1z1nler yyn1z1nler;
	private String fileName;
	
	@JPA(targetEntityManager = entities.yayin.controller.Derg1lerManager.class, targetAction = JPA.ACTION_TYPE.CREATE)
	public Derg1ler getDerg1ler() {
		if (derg1ler == null) {
			Derg1lerManager derg1lerManager = (Derg1lerManager) getManagedBean("Derg1lerManager");
			derg1ler = derg1lerManager.getNewDerg1ler();
			fileName="default.gif";
		}
		return derg1ler;
	}
	
	public YynAyr1nt1Reg getYynAyr1nt1Reg() {
		if (yynAyr1nt1Reg == null) {
			YynAyr1nt1RegManager yynAyr1nt1RegManager = (YynAyr1nt1RegManager) getManagedBean("YynAyr1nt1RegManager");
			yynAyr1nt1Reg = yynAyr1nt1RegManager.getNewYynAyr1nt1Reg();
			yynAyr1nt1Reg.setYayC1ltSay((short)1);
			yynAyr1nt1Reg.setYayKopyaSay((short)1);
		}
		return yynAyr1nt1Reg;
	}
	
	/**
	 *  @action id=derg1ler
	 */
	public String createDerg1lerAction() {
		Derg1lerManager derg1lerManager = (Derg1lerManager) getManagedBean("Derg1lerManager");
		Yay1nlarRegManager yay1nlarRegManager = (Yay1nlarRegManager) getManagedBean("Yay1nlarRegManager");
		YynAyr1nt1RegManager yynAyr1nt1RegManager = (YynAyr1nt1RegManager) getManagedBean("YynAyr1nt1RegManager");
		Yyn1z1nlerManager yyn1z1nlerManager = (Yyn1z1nlerManager) getManagedBean("Yyn1z1nlerManager");
		
		try {
			
			derg1lerManager.createDerg1ler(derg1ler);
			yyn1z1nlerManager.createYyn1z1nler(yyn1z1nler);
			
			if (yynAyr1nt1Reg==null)
				yynAyr1nt1Reg=getYynAyr1nt1Reg();
			
			yynAyr1nt1Reg.setYayRes1m1(fileName);
			yynAyr1nt1Reg.setZ1n1d(yyn1z1nler.getZ1n1d());
			yynAyr1nt1RegManager.createYynAyr1nt1Reg(yynAyr1nt1Reg);
			fileName="default.gif";
			yay1nlarReg=yay1nlarRegManager.getNewYay1nlarReg();
			yay1nlarReg.setT1p1d((short)2);
			yay1nlarReg.setDrg1d(derg1ler.getDrg1d());
			yay1nlarReg.setYynKodu(derg1ler.getDrgKodu());
			yay1nlarReg.setAyr1d(yynAyr1nt1Reg.getAyr1d());
			yay1nlarRegManager.createYay1nlarReg(yay1nlarReg);
			yyn1z1nler=yyn1z1nlerManager.getNewYyn1z1nler();
			derg1ler = derg1lerManager.getNewDerg1ler();
			yynAyr1nt1Reg=yynAyr1nt1RegManager.getNewYynAyr1nt1Reg();
			
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Baþarýlý", "1 Yeni Dergi kaydý.."));
		} catch (Exception e) {
			logException(e);
		}
		return "";
	}
	
	public void handleFileUpload(FileUploadEvent event) {
    	ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    	fileName="drg"+ ((int)(Math.random()*100000)) + "." + event.getFile().getContentType().substring(6,event.getFile().getContentType().length());
		String newFileName = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "uploads" + File.separator + fileName;
		
		FileImageOutputStream imageOutput;
		try {
			imageOutput = new FileImageOutputStream(new File(newFileName));
			imageOutput.write(event.getFile().getContents(), 0, event.getFile().getContents().length);
			imageOutput.close();
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
	
	public Yyn1z1nler getYyn1z1nler() {
		if (yyn1z1nler == null) {
			Yyn1z1nlerManager yyn1z1nlerManager = (Yyn1z1nlerManager) getManagedBean("Yyn1z1nlerManager");
			yyn1z1nler = yyn1z1nlerManager.getNewYyn1z1nler();
		}
		return yyn1z1nler;
	}
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
}