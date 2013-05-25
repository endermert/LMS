/**
 * 
 */
package pagecode.pages.admin.include;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;

import pagecode.PageCodeBase;
import entities.yayin.K1taplar;
import entities.yayin.YynAyr1nt1Reg;

import entities.yayin.controller.K1taplarManager;
import entities.yayin.controller.YynAyr1nt1RegManager;
import entities.yayin.Yay1nlarReg;
import entities.yayin.controller.Yay1nlarRegManager;
import entities.yayinTools.Yyn1z1nler;
import entities.yayinTools.controller.Yyn1z1nlerManager;


import com.ibm.jpa.web.JPA;

/**
 * @author EnDeR
 *
 */
public class Ktp_ekle extends PageCodeBase {

	private K1taplar k1taplar;
	private Yay1nlarReg yay1nlarReg;
	private YynAyr1nt1Reg yynAyr1nt1Reg;
	private Yyn1z1nler yyn1z1nler;
	private String fileName;

	@JPA(targetEntityManager = entities.yayin.controller.K1taplarManager.class, targetAction = JPA.ACTION_TYPE.CREATE)
	public K1taplar getK1taplar() {
		if (k1taplar==null){
			K1taplarManager K1taplarManager = (K1taplarManager) getManagedBean("K1taplarManager");
			k1taplar = K1taplarManager.getNewK1taplar();
			fileName="default.gif";
		}
		return k1taplar;
	}
	
	@JPA(targetEntityManager = entities.yayin.controller.YynAyr1nt1RegManager.class, targetAction = JPA.ACTION_TYPE.CREATE)
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
	 *  @action id=K1taplar
	 */
	@JPA(targetEntityManager = entities.yayin.controller.Yay1nlarRegManager.class, targetAction = JPA.ACTION_TYPE.CREATE)
	
	public String createK1taplarAction() {
		K1taplarManager K1taplarManager = (K1taplarManager) getManagedBean("K1taplarManager");
		Yay1nlarRegManager yay1nlarRegManager = (Yay1nlarRegManager) getManagedBean("Yay1nlarRegManager");
		Yyn1z1nlerManager yyn1z1nlerManager = (Yyn1z1nlerManager) getManagedBean("Yyn1z1nlerManager");
		YynAyr1nt1RegManager yynAyr1nt1RegManager = (YynAyr1nt1RegManager) getManagedBean("YynAyr1nt1RegManager");
		try {
			K1taplarManager.createK1taplar(k1taplar);
			yyn1z1nlerManager.createYyn1z1nler(yyn1z1nler);
			
			if (yynAyr1nt1Reg==null)
				yynAyr1nt1Reg=getYynAyr1nt1Reg();
			
			yynAyr1nt1Reg.setYayRes1m1(fileName);
			yynAyr1nt1Reg.setZ1n1d(yyn1z1nler.getZ1n1d());
			yynAyr1nt1RegManager.createYynAyr1nt1Reg(yynAyr1nt1Reg);
			fileName="default.gif";
			yay1nlarReg=yay1nlarRegManager.getNewYay1nlarReg();
			yay1nlarReg.setT1p1d((short)1);
			yay1nlarReg.setKtp1d(k1taplar.getKtp1d());
			yay1nlarReg.setYynKodu(k1taplar.getKtpKodu());
			yay1nlarReg.setAyr1d(yynAyr1nt1Reg.getAyr1d());
			yay1nlarRegManager.createYay1nlarReg(yay1nlarReg);
			k1taplar=K1taplarManager.getNewK1taplar();
			yynAyr1nt1Reg=yynAyr1nt1RegManager.getNewYynAyr1nt1Reg();
			yyn1z1nler=yyn1z1nlerManager.getNewYyn1z1nler();
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Baþarýlý", "1 Yeni Kitap kaydý.."));
		} catch (Exception e) {
			logException(e);
		}
		return "";
	}
		
	public Yyn1z1nler getYyn1z1nler() {
		if (yyn1z1nler == null) {
			Yyn1z1nlerManager yyn1z1nlerManager = (Yyn1z1nlerManager) getManagedBean("Yyn1z1nlerManager");
			yyn1z1nler = yyn1z1nlerManager.getNewYyn1z1nler();
		}
		return yyn1z1nler;
	}
	
	public void handleFileUpload(FileUploadEvent event) {
    	ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    	fileName="ktp"+ ((int)(Math.random()*100000)) + "." + event.getFile().getContentType().substring(6,event.getFile().getContentType().length());
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
	public void setYyn1z1nler(Yyn1z1nler yyn1z1nler) {
		this.yyn1z1nler = yyn1z1nler;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}