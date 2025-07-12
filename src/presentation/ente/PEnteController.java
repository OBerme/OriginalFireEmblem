package presentation.ente;

import java.util.List;

import acciones.ln.LNAccionesAtaque;
import acciones.md.ataque.IAtack;
import entes.Movable;
import entes.md.IEnte;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.md.IPosition;
import presentation.main.IPEnteController;
import presentation.main.PDefaultValues;
import presentation.main.controller.IPController;
import presentation.map.ILNGraphicMapIntegerAtackDistance;
import presentation.map.IPPPositionSubjectData;
import presentation.map.jbutton.IPGraphicPosition;
import presentation.map.position.IPositionObserver;
import presentation.menu.IPMenu;

public class PEnteController
		implements IPEnteController, IPositionObserver{
	
	private IPPPositionSubjectData posiProductor; // observer pattern to catch the position selected
	
	private ILNMapaMatrixEntesGroup lnMMEG;
	private IPosition<Integer, Integer> lastEP; //Last Ente position
	
	private ILNGraphicMapIntegerAtackDistance lnGMap;
	private List<IPosition<Integer, Integer>>  pMPP;//Possible Moving Positions
	private boolean wantMove;

	public PEnteController(IPPPositionSubjectData posiProductor, 
			ILNMapaMatrixEntesGroup lnMMEG, ILNGraphicMapIntegerAtackDistance lnGMap) {
		super();
		this.posiProductor = posiProductor;
		this.lnMMEG = lnMMEG;
		this.lnGMap = lnGMap;
		
		this.wantMove = false;
	}

	@Override
	public void skip() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveEnte(IEnte ente) {

    	if(ente instanceof Movable) {
    		Movable mEnte = (Movable)ente;
    		mEnte.getRangeMove();
    		
    		
    		
			if(lnMMEG.isEnteInMap(ente)) {
				lastEP =  lnMMEG.getPositionEnte(ente);
				
	    		lnGMap.activateCells(
	    				pMPP = lnMMEG.getRangeDiagonal(lastEP.getX(), lastEP.getY(),  mEnte.getRangeMove() ));
	    		
	    		wantMove = true;
			}
			else if(PDefaultValues.DEBUG_MODE) System.out.println(" The ente is not in the map");
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
	public void update() {
		if(wantMove) {
			if(PDefaultValues.DEBUG_MODE) System.out.println("Moving the ente to the position");
			
			IPosition<Integer, Integer> sPosi =  posiProductor.getPosi();
			
			if(isInPosiblePositions(sPosi)) {
				//Move the ente in map and update
				IPGraphicPosition<Integer, Integer>  fPGP = lnGMap.getGraphicPosition(lastEP);
				IPGraphicPosition<Integer, Integer>  sPGP = lnGMap.getGraphicPosition(sPosi);
				lnGMap.changePositions(fPGP, sPGP);  //Change the data of the positions
				wantMove = false;
			}
			else
				if(PDefaultValues.DEBUG_MODE) System.out.println("The selected position is not valid" + sPosi);
		}
		
	}


}
