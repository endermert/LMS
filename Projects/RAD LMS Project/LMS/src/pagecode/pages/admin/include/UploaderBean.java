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



/**
 * @author EnDeR
 *
 */
public class UploaderBean extends PageCodeBase {
	
	
	private String fileName;
	private String randomName;
	
	public void handleFileUpload(FileUploadEvent event) {
    	ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    	fileName="yyn"+ getRandomName() + "." + event.getFile().getContentType().substring(6,event.getFile().getContentType().length());
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
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRandomName() {
		int i = (int) (Math.random()*100000);
		randomName=String.valueOf(i);
		return randomName;
	}


}