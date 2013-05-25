
package pagecode.pages;

import pagecode.PageCodeBase;
import entities.yayin.Yay1nlar;

import java.util.ArrayList;
import java.util.List;
import entities.yayin.controller.Yay1nlarManager;
import tools.Yay1nlarPro;
import tools.Yay1nlarProManager;
/**
 * @author EnDeR
 *
 */
public class YayinArama extends PageCodeBase {

	private List<Yay1nlar> yay1nlarList;
	private List<Yay1nlarPro> yay1nlarProList;
	
	
	public List<Yay1nlar> getYay1nlarList() {
		if (yay1nlarList==null){
			Yay1nlarManager yay1nlarManager = (Yay1nlarManager) getManagedBean("Yay1nlarManager");
			yay1nlarList = yay1nlarManager.getYay1nlar();	
		}
		return yay1nlarList;
	}

	public List<Yay1nlarPro> getYay1nlarProList() {
		if (yay1nlarProList==null){
			Yay1nlarProManager ypm=new Yay1nlarProManager();
			yay1nlarProList=new ArrayList<Yay1nlarPro>();
			yay1nlarProList=ypm.Yay1nlarProAdder(getYay1nlarList());
		}
		return yay1nlarProList;
	}

}