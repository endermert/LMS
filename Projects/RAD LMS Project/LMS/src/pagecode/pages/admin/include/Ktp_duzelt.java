/**
 * 
 */
package pagecode.pages.admin.include;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import pagecode.PageCodeBase;
import entities.yayin.K1taplar;
import entities.yayin.Yay1nlarReg;
import entities.yayin.YynAyr1nt1Reg;
import entities.yayin.controller.Yay1nlarRegManager;
import entities.yayin.controller.K1taplarManager;
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
import org.primefaces.component.growl.Growl;
import javax.faces.component.html.HtmlForm;


/**
 * @author EnDeR
 *
 */
public class Ktp_duzelt extends PageCodeBase {

	private K1taplar K1taplar;
	private Yay1nlarReg yay1nlarReg;
	private YynAyr1nt1Reg yynAyr1nt1Reg;
	private Yyn1z1nler yyn1z1nler;
	protected Growl messages;
	protected HtmlForm upform;
	
	
	
	@JPA(targetEntityManager = entities.yayin.controller.K1taplarManager.class, targetAction = JPA.ACTION_TYPE.UPDATE)
	@JPAFilter(name = "ktp1d", value = "#{pc_global_kul_tools.ktp1d}")
	public K1taplar getK1taplar() {
		if (K1taplar == null) {
			K1taplarManager K1taplarManager = (K1taplarManager) getManagedBean("K1taplarManager");
			int ktp1d = (Integer) resolveParam("K1taplar_ktp1d",
					"#{pc_global_kul_tools.ktp1d}", "int");
			K1taplar = K1taplarManager.findK1taplarByKtp1d(ktp1d);
		}
		return K1taplar;
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
			if (K1taplar==null)
				K1taplar=getK1taplar();
			
			Yay1nlarRegManager yay1nlarRegManager = (Yay1nlarRegManager) getManagedBean("Yay1nlarRegManager");
			List<Yay1nlarReg> list = yay1nlarRegManager.getYay1nlarRegByKtp1d(K1taplar.getKtp1d());
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
	
	/**
	 *  @action id=K1taplar
	 */
	public String updateK1taplarAction() {
		K1taplarManager K1taplarManager = (K1taplarManager) getManagedBean("K1taplarManager");
		Yay1nlarRegManager yay1nlarRegManager = (Yay1nlarRegManager) getManagedBean("Yay1nlarRegManager");
		YynAyr1nt1RegManager yynAyr1nt1RegManager = (YynAyr1nt1RegManager) getManagedBean("YynAyr1nt1RegManager");
		Yyn1z1nlerManager yyn1z1nlerManager = (Yyn1z1nlerManager) getManagedBean("Yyn1z1nlerManager");
		try {
			K1taplarManager.updateK1taplar(K1taplar);
			if (yay1nlarReg==null)
				yay1nlarReg=getYay1nlarReg();
			
			yay1nlarReg.setYynKodu(K1taplar.getKtpKodu());
			yay1nlarRegManager.updateYay1nlarReg(yay1nlarReg);
			yyn1z1nlerManager.updateYyn1z1nler(yyn1z1nler);
			yynAyr1nt1RegManager.updateYynAyr1nt1Reg(yynAyr1nt1Reg);
			
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Baþarýlý", "1 Kitap güncellendi.."));
		} catch (Exception e) {
			logException(e);
		}
		return "";
	}

	/**
	 *  @action id=K1taplar
	 */
	public String deleteK1taplarAction() {
		K1taplarManager K1taplarManager = (K1taplarManager) getManagedBean("K1taplarManager");
		Yay1nlarRegManager yay1nlarRegManager = (Yay1nlarRegManager) getManagedBean("Yay1nlarRegManager");
		YynAyr1nt1RegManager yynAyr1nt1RegManager = (YynAyr1nt1RegManager) getManagedBean("YynAyr1nt1RegManager");
		Yyn1z1nlerManager yyn1z1nlerManager = (Yyn1z1nlerManager) getManagedBean("Yyn1z1nlerManager");
		
		try {
			K1taplar=getK1taplar();
			yay1nlarReg=getYay1nlarReg();
			yynAyr1nt1Reg=getYynAyr1nt1Reg();
			yyn1z1nler=getYyn1z1nler();
			
			yyn1z1nlerManager.deleteYyn1z1nler(yyn1z1nler);
			yynAyr1nt1RegManager.deleteYynAyr1nt1Reg(yynAyr1nt1Reg);
			yay1nlarRegManager.deleteYay1nlarReg(yay1nlarReg);
			K1taplarManager.deleteK1taplar(K1taplar);				
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Baþarýlý", "1 kitap silindi.."));
		} catch (Exception e) {
			logException(e);
		}
		return "";
	}

	public void handleFileUpload(FileUploadEvent event) {
    	ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    	String fn="ktp"+ K1taplar.getKtp1d() + "." + event.getFile().getContentType().substring(6,event.getFile().getContentType().length());
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

	protected Growl getMessages() {
		if (messages == null) {
			messages = (Growl) findComponentInRoot("messages");
		}
		return messages;
	}

	protected HtmlForm getUpform() {
		if (upform == null) {
			upform = (HtmlForm) findComponentInRoot("upform");
		}
		return upform;
	}

}