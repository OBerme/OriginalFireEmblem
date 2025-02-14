package presentation.main;



import com.modeliosoft.modelio.javadesigner.annotations.objid;

import mapa.md.IPosition;
import presentation.graphicOptions.IShowMenus;
import presentation.map.GraphicPositionInteger;
import presentation.map.IGraphicMap;
import presentation.map.IObserver;
import presentation.map.IPPPositionSubjectData;
import presentation.map.IPositionObserver;
import presentation.menu.PMenu;

@objid ("65c28fdb-6a52-451e-9c89-e87930998704")
public class PController implements IPEnteController, IShowMenus, IPositionObserver, IPController{
	private IGraphicMap gMap;
	private IPPPositionSubjectData posiProductor; // observer pattern to catch the position selected
	private IPosition<Integer, Integer> lastPosition;
	
    public PController(IGraphicMap gMap, IPPPositionSubjectData posiProductor) {
		super();
		this.gMap = gMap;
		this.posiProductor = posiProductor;
	}

    //Pre: ---
    //Post: it will do some exceptions if you dont use the setGMap and setIPositionObserver
	public PController() {
		this(null, null);
	}

	@objid ("40aa2939-d55e-42b6-867d-03835d5581f0")
    public void moveEnte() {
    	
    }

	@Override
	public void showMenu(PMenu menu, IPosition<Integer, Integer> position) {
		// TODO Auto-generated method stub
		lastPosition = position;
		menu.showMenu(position);
		
	}

	@Override
	public void skip() {
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Position update! " + posiProductor.getPosi());
		
	}

	@Override
	public void setgMap(IGraphicMap gMap) {
		this.gMap = gMap;
	}

	@Override
	public void setPosiProductor(IPPPositionSubjectData posiProductor) {
		this.posiProductor = posiProductor;
	}

	@Override
	public void showMenu(PMenu nextMenu) {
		// TODO Auto-generated method stub
		nextMenu.showMenu(lastPosition);
	}

	
	


}
