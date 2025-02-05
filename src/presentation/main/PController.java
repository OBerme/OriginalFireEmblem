package presentation.main;



import com.modeliosoft.modelio.javadesigner.annotations.objid;

import presentation.graphicOptions.IShowMenus;
import presentation.map.GraphicPositionInteger;
import presentation.map.IGraphicMap;
import presentation.menu.PMenu;

@objid ("65c28fdb-6a52-451e-9c89-e87930998704")
public class PController implements IPController, IShowMenus {
	private IGraphicMap gMap;
	private GraphicPositionInteger sGPosi;
	
   
    @objid ("40aa2939-d55e-42b6-867d-03835d5581f0")
    public void moveEnte() {
    	
    }

	@Override
	public void showMenu(PMenu menu) {
		// TODO Auto-generated method stub
		System.out.println(menu);
		
	}

	@Override
	public void skip() {
		
		
	}

}
