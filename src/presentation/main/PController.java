package presentation.main;





import java.util.List;

import javax.swing.JFrame;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import entes.Movable;
import entes.md.Ente;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.md.IPosition;
import presentation.graphicOptions.IShowMenus;
import presentation.map.IGraphicMap;
import presentation.map.IPPPositionSubjectData;
import presentation.map.jbutton.IJButtonAction;
import presentation.map.jbutton.IJButtonActionEnte;
import presentation.map.jbutton.IPGraphicPosition;
import presentation.map.jbutton.PGraphicPositionInteger;
import presentation.map.jbutton.PGraphicPositionIntegerEnte;
import presentation.map.position.GraphicPositionInteger;
import presentation.map.position.IObserver;
import presentation.map.position.IPositionObserver;
import presentation.menu.IPMenu;
import presentation.menu.PMenu;

@objid ("65c28fdb-6a52-451e-9c89-e87930998704")
public class PController implements IPEnteController, IShowMenus, IPositionObserver{
	private static final String PControllerLog = "PController";
	private IGraphicMap gMap;
	private IPPPositionSubjectData posiProductor; // observer pattern to catch the position selected
	private IPosition<Integer, Integer> lastPosition;
	private ILNMapaMatrixEntesGroup lnMMEG;
	private JFrame frame;
	
	//Ente cache variables
	private List<IPosition<Integer, Integer>>  pMPP;//Possible Moving Positions
	private IPosition<Integer, Integer> lastEP; //Last Ente position
	private boolean wantMove;
	
    public PController(IGraphicMap gMap, IPPPositionSubjectData posiProductor,ILNMapaMatrixEntesGroup lnMMEG, JFrame frame) {
		super();
		this.gMap = gMap;
		this.posiProductor = posiProductor;
		this.lnMMEG = lnMMEG;
		this.frame = frame;
		this.wantMove = false;
		
	}

    //Pre: ---
    //Post: it will do some exceptions if you dont use the setGMap and setIPositionObserver
	public PController( JFrame frame) {
		this(null, null, null,frame);
	}

	@Override
    public void moveEnte(Ente ente) {		
		
    	if(ente instanceof Movable) {
    		Movable mEnte = (Movable)ente;
    		mEnte.getRangeMove();
    		
			if(lnMMEG.isEnteInMap(ente)) {
				lastEP =  lnMMEG.getPositionEnte(ente);
	    		gMap.activateCells(
	    				pMPP = lnMMEG.getRangeDiagonal(lastEP.getX(), lastEP.getY(),  mEnte.getRangeMove() ));
	    		
	    		wantMove = true;
			}
			else if(PDefaultValues.DEBUG_MODE) System.out.println(" The ente is not in the map");
    	}
    }

	@Override
	public void showMenu(IPMenu<Integer, Integer> menu, IPosition<Integer, Integer> position) {
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
		if(PDefaultValues.DEBUG_MODE) System.out.println(PControllerLog + "Position update! " + posiProductor.getPosi());
		
		if(wantMove) {
			if(PDefaultValues.DEBUG_MODE) System.out.println("Moving the ente to the position");
			IPosition<Integer, Integer> sPosi =  posiProductor.getPosi();
			
			if(isInPosiblePositions(sPosi)) {
				//Move the ente in map and update
				IPGraphicPosition<Integer, Integer>  fPGP = gMap.getGraphicPosition(lastEP);
				IPGraphicPosition<Integer, Integer>  sPGP = gMap.getGraphicPosition(sPosi);
				gMap.changePositions(fPGP, sPGP);  //Change the data of the positions
				wantMove = false;
			}
			else
				if(PDefaultValues.DEBUG_MODE) System.out.println("The selected position is not valid" + sPosi);
		}
	}
	
	private boolean isInPosiblePositions(IPosition<Integer, Integer> sPosi) {
		for(IPosition<Integer, Integer> nPosi : pMPP) {
			if(nPosi.equals(sPosi))
				return true;
		}
		return false;
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
	public void showMenu(IPMenu<Integer, Integer> nextMenu) {
		// TODO Auto-generated method stub
		nextMenu.showMenu(lastPosition);
	}	

	public void setLnMMEG(ILNMapaMatrixEntesGroup lnMMEG) {
		this.lnMMEG = lnMMEG;
	}


	
	


}
