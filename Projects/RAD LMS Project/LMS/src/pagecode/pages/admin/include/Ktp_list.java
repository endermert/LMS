/**
 * 
 */
package pagecode.pages.admin.include;

import pagecode.PageCodeBase;
import entities.yayin.K1taplar;
import java.util.List;
import entities.yayin.controller.K1taplarManager;
import com.ibm.jpa.web.JPA;
import javax.faces.component.html.HtmlOutputText;
import org.primefaces.component.growl.Growl;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.column.Column;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlForm;

/**
 * @author EnDeR
 *
 */
public class Ktp_list extends PageCodeBase {

	private List<K1taplar> K1taplarList;
	protected HtmlOutputText ktpKodu1text;
	protected HtmlOutputText ktp1sbn1text;
	protected HtmlOutputText ktpAd1text;
	protected HtmlOutputText ktpYazar1text;
	protected HtmlOutputText ktpKodu1;
	protected HtmlOutputText ktp1sbn1;
	protected HtmlOutputText ktpAd1;
	protected HtmlOutputText ktpYazar1;
	protected Growl messages;
	protected DataTable table;
	protected Column ktpKodu1column;
	protected Column ktp1sbn1column;
	protected Column ktpAd1column;
	protected Column ktpYazar1column;
	protected HtmlPanelGrid panel;
	protected HtmlForm ktpList;

	@JPA(targetEntityManager = entities.yayin.controller.K1taplarManager.class, targetNamedQuery = "getK1taplar")
	public List<K1taplar> getK1taplarList() {
		if (K1taplarList == null) {
			K1taplarManager K1taplarManager = (K1taplarManager) getManagedBean("K1taplarManager");
			K1taplarList = K1taplarManager.getK1taplar();
		}
		return K1taplarList;
	}

	protected HtmlOutputText getKtpKodu1text() {
		if (ktpKodu1text == null) {
			ktpKodu1text = (HtmlOutputText) findComponentInRoot("ktpKodu1text");
		}
		return ktpKodu1text;
	}

	protected HtmlOutputText getKtp1sbn1text() {
		if (ktp1sbn1text == null) {
			ktp1sbn1text = (HtmlOutputText) findComponentInRoot("ktp1sbn1text");
		}
		return ktp1sbn1text;
	}

	protected HtmlOutputText getKtpAd1text() {
		if (ktpAd1text == null) {
			ktpAd1text = (HtmlOutputText) findComponentInRoot("ktpAd1text");
		}
		return ktpAd1text;
	}

	protected HtmlOutputText getKtpYazar1text() {
		if (ktpYazar1text == null) {
			ktpYazar1text = (HtmlOutputText) findComponentInRoot("ktpYazar1text");
		}
		return ktpYazar1text;
	}

	protected HtmlOutputText getKtpKodu1() {
		if (ktpKodu1 == null) {
			ktpKodu1 = (HtmlOutputText) findComponentInRoot("ktpKodu1");
		}
		return ktpKodu1;
	}

	protected HtmlOutputText getKtp1sbn1() {
		if (ktp1sbn1 == null) {
			ktp1sbn1 = (HtmlOutputText) findComponentInRoot("ktp1sbn1");
		}
		return ktp1sbn1;
	}

	protected HtmlOutputText getKtpAd1() {
		if (ktpAd1 == null) {
			ktpAd1 = (HtmlOutputText) findComponentInRoot("ktpAd1");
		}
		return ktpAd1;
	}

	protected HtmlOutputText getKtpYazar1() {
		if (ktpYazar1 == null) {
			ktpYazar1 = (HtmlOutputText) findComponentInRoot("ktpYazar1");
		}
		return ktpYazar1;
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

	protected Column getKtpKodu1column() {
		if (ktpKodu1column == null) {
			ktpKodu1column = (Column) findComponentInRoot("ktpKodu1column");
		}
		return ktpKodu1column;
	}

	protected Column getKtp1sbn1column() {
		if (ktp1sbn1column == null) {
			ktp1sbn1column = (Column) findComponentInRoot("ktp1sbn1column");
		}
		return ktp1sbn1column;
	}

	protected Column getKtpAd1column() {
		if (ktpAd1column == null) {
			ktpAd1column = (Column) findComponentInRoot("ktpAd1column");
		}
		return ktpAd1column;
	}

	protected Column getKtpYazar1column() {
		if (ktpYazar1column == null) {
			ktpYazar1column = (Column) findComponentInRoot("ktpYazar1column");
		}
		return ktpYazar1column;
	}

	protected HtmlPanelGrid getPanel() {
		if (panel == null) {
			panel = (HtmlPanelGrid) findComponentInRoot("panel");
		}
		return panel;
	}

	protected HtmlForm getKtpList() {
		if (ktpList == null) {
			ktpList = (HtmlForm) findComponentInRoot("ktpList");
		}
		return ktpList;
	}

}