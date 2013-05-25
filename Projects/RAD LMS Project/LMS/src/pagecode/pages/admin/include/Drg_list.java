/**
 * 
 */
package pagecode.pages.admin.include;

import pagecode.PageCodeBase;
import entities.yayin.Derg1ler;
import java.util.List;
import entities.yayin.controller.Derg1lerManager;
import com.ibm.jpa.web.JPA;
import javax.faces.component.html.HtmlForm;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.column.Column;
import javax.faces.component.html.HtmlOutputText;
import org.primefaces.component.growl.Growl;
import javax.faces.component.html.HtmlPanelGrid;


/**
 * @author EnDeR
 *
 */
public class Drg_list extends PageCodeBase {

	private List<Derg1ler> derg1lerList;
	protected HtmlForm drgList;
	protected DataTable derg1lerList1;
	protected Column drgKodu1column;
	protected HtmlOutputText drgKodu1text;
	protected HtmlOutputText drgKodu1;
	protected Column drgAd1column;
	protected HtmlOutputText drgAd1text;
	protected HtmlOutputText drgAd1;
	protected Growl messages;
	protected HtmlPanelGrid panel;
	protected HtmlOutputText drg1ssn1text;
	protected Column drg1ssn1column;
	protected HtmlOutputText drg1ssn1;
	@JPA(targetEntityManager = entities.yayin.controller.Derg1lerManager.class, targetNamedQuery = "getDerg1ler")
	public List<Derg1ler> getDerg1lerList() {
		if (derg1lerList == null) {
			Derg1lerManager derg1lerManager = (Derg1lerManager) getManagedBean("Derg1lerManager");
			derg1lerList = derg1lerManager.getDerg1ler();
		}
		return derg1lerList;
	}

	protected HtmlForm getDrgList() {
		if (drgList == null) {
			drgList = (HtmlForm) findComponentInRoot("drgList");
		}
		return drgList;
	}

	protected DataTable getDerg1lerList1() {
		if (derg1lerList1 == null) {
			derg1lerList1 = (DataTable) findComponentInRoot("derg1lerList1");
		}
		return derg1lerList1;
	}

	protected Column getDrgKodu1column() {
		if (drgKodu1column == null) {
			drgKodu1column = (Column) findComponentInRoot("drgKodu1column");
		}
		return drgKodu1column;
	}

	protected HtmlOutputText getDrgKodu1text() {
		if (drgKodu1text == null) {
			drgKodu1text = (HtmlOutputText) findComponentInRoot("drgKodu1text");
		}
		return drgKodu1text;
	}

	protected HtmlOutputText getDrgKodu1() {
		if (drgKodu1 == null) {
			drgKodu1 = (HtmlOutputText) findComponentInRoot("drgKodu1");
		}
		return drgKodu1;
	}

	protected Column getDrgAd1column() {
		if (drgAd1column == null) {
			drgAd1column = (Column) findComponentInRoot("drgAd1column");
		}
		return drgAd1column;
	}

	protected HtmlOutputText getDrgAd1text() {
		if (drgAd1text == null) {
			drgAd1text = (HtmlOutputText) findComponentInRoot("drgAd1text");
		}
		return drgAd1text;
	}

	protected HtmlOutputText getDrgAd1() {
		if (drgAd1 == null) {
			drgAd1 = (HtmlOutputText) findComponentInRoot("drgAd1");
		}
		return drgAd1;
	}

	protected Growl getMessages() {
		if (messages == null) {
			messages = (Growl) findComponentInRoot("messages");
		}
		return messages;
	}

	protected HtmlPanelGrid getPanel() {
		if (panel == null) {
			panel = (HtmlPanelGrid) findComponentInRoot("panel");
		}
		return panel;
	}

	protected HtmlOutputText getDrg1ssn1text() {
		if (drg1ssn1text == null) {
			drg1ssn1text = (HtmlOutputText) findComponentInRoot("drg1ssn1text");
		}
		return drg1ssn1text;
	}

	protected Column getDrg1ssn1column() {
		if (drg1ssn1column == null) {
			drg1ssn1column = (Column) findComponentInRoot("drg1ssn1column");
		}
		return drg1ssn1column;
	}

	protected HtmlOutputText getDrg1ssn1() {
		if (drg1ssn1 == null) {
			drg1ssn1 = (HtmlOutputText) findComponentInRoot("drg1ssn1");
		}
		return drg1ssn1;
	}


}