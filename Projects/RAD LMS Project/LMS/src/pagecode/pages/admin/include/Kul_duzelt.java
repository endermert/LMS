/**
 * 
 */
package pagecode.pages.admin.include;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import pagecode.PageCodeBase;
import entities.kullanicilar.Kullan1c1lar;
import entities.kullanicilar.controller.Kullan1c1larManager;
import com.ibm.jpa.web.JPA;
import com.ibm.jpa.web.JPAFilter;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import org.primefaces.component.messages.Messages;
import org.primefaces.event.FileUploadEvent;



/**
 * @author EnDeR
 *
 */
public class Kul_duzelt extends PageCodeBase {

	private Kullan1c1lar kullan1c1lar;
	protected Messages kullan1c1lar2messages;
	private String pass1;
	
	@JPA(targetEntityManager = entities.kullanicilar.controller.Kullan1c1larManager.class, targetAction = JPA.ACTION_TYPE.UPDATE)
	@JPAFilter(name = "kul1d", value = "#{pc_global_kul_tools.kul1d}")
	public Kullan1c1lar getKullan1c1lar() {
		if (kullan1c1lar == null) {
			Kullan1c1larManager kullan1c1larManager = (Kullan1c1larManager) getManagedBean("Kullan1c1larManager");
			int kul1d = (Integer) resolveParam("kullan1c1lar_kul1d",
					"#{pc_global_kul_tools.kul1d}", "int");
			kullan1c1lar = kullan1c1larManager.findKullan1c1larByKul1d(kul1d);
			
		}
		return kullan1c1lar;
	}
	
	public void kontrol() {
		
		if (pass1!=kullan1c1lar.getKulS1fre()){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hata", "Þifreler uyumsuz"));
		}
	}
	
	public String updateKullan1c1larAction(){
		Kullan1c1larManager kullan1c1larManager = (Kullan1c1larManager) getManagedBean("Kullan1c1larManager");
		try {
			kullan1c1larManager.updateKullan1c1lar(kullan1c1lar);
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Baþarýlý", "1 kullanýcý güncellendi.."));
	        
		} catch (Exception e) {
			logException(e);
		}
		return "";
	}
	public String deleteKullan1c1larAction() {
		Kullan1c1larManager kullan1c1larManager = (Kullan1c1larManager) getManagedBean("Kullan1c1larManager");
		try {
			kullan1c1lar=getKullan1c1lar();
			kullan1c1larManager.deleteKullan1c1lar(kullan1c1lar);
			FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Baþarýlý", "1 kullanýcý silindi.."));
		} catch (Exception e) {
			logException(e);
		}
		return "";
	}

	protected Messages getKullan1c1lar2messages() {
		if (kullan1c1lar2messages == null) {
			kullan1c1lar2messages = (Messages) findComponentInRoot("kullan1c1lar2messages");
		}
		return kullan1c1lar2messages;
	}
	

	public void handleFileUpload(FileUploadEvent event) {
		String fileName;
    	ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    	fileName="user"+ kullan1c1lar.getKul1d() + "." + event.getFile().getContentType().substring(6,event.getFile().getContentType().length());
		String newFileName = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "uploads" + File.separator + fileName;
		
		FileImageOutputStream imageOutput;
		try {
			imageOutput = new FileImageOutputStream(new File(newFileName));
			imageOutput.write(event.getFile().getContents(), 0, event.getFile().getContents().length);
			imageOutput.close();
			kullan1c1lar.setKulResm1(fileName);
			updateKullan1c1larAction();
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
	public String getPass1() {

		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	
}