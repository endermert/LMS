/**
 * 
 */
package pagecode.pages.admin.include;

import pagecode.PageCodeBase;

import java.util.List;
import com.ibm.jpa.web.JPA;
import entities.kullanicilar.Kullan1c1lar;
import entities.kullanicilar.controller.Kullan1c1larManager;
import javax.faces.event.ActionEvent;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlPanelGrid;
import org.primefaces.component.growl.Growl;
import org.primefaces.component.datatable.DataTable;

/**
 * @author EnDeR
 *
 */
public class Kul_list extends PageCodeBase {

	private List<Kullan1c1lar> kullan1c1larList;
	protected HtmlForm list;
	protected HtmlPanelGrid panel;
	protected Growl messages;
	protected DataTable table;


	@JPA(targetEntityManager = entities.kullanicilar.controller.Kullan1c1larManager.class, targetNamedQuery = "getKullan1c1lar")
	public List<Kullan1c1lar> getKullan1c1larList() {
		
			Kullan1c1larManager kullan1c1larManager = (Kullan1c1larManager) getManagedBean("Kullan1c1larManager");
			kullan1c1larList = kullan1c1larManager.getKullan1c1lar();
		
		return kullan1c1larList;
	}
	
	public void listYenile(ActionEvent actionEvent){
		kullan1c1larList=getKullan1c1larList();
	}

	protected HtmlForm getList() {
		if (list == null) {
			list = (HtmlForm) findComponentInRoot("list");
		}
		return list;
	}

	protected HtmlPanelGrid getPanel() {
		if (panel == null) {
			panel = (HtmlPanelGrid) findComponentInRoot("panel");
		}
		return panel;
	}

	protected Growl getMessages() {
		if (messages == null) {
			messages = (Growl) findComponentInRoot("messages");
		}
		return messages;
	}

	protected DataTable getTable() {
		if (table == null) {
			table = (DataTable) findComponentInRoot("table");
		}
		return table;
	}
	
	

}