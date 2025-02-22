package presentation.main;





import java.util.List;

import javax.swing.JFrame;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import acciones.ln.LNAccionesAtaque;
import acciones.md.ataque.Ataque;
import acciones.md.ataque.IAtack;
import acciones.md.ataque.Tipo;
import entes.Atacable;
import entes.Movable;
import entes.md.Ente;
import entes.md.IEnte;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.md.IPosition;
import md.range.Rombo;
import presentation.GAtack.IPGraphicAtack;
import presentation.GAtack.IPGraphicDistanceAtack;
import presentation.GAtack.IShowAtack;
import presentation.GAtack.PGraphicMeleAtack;
import presentation.ente.IGEnte;
import presentation.graphicOptions.IShowMenus;
import presentation.map.AbstractMapSizeFactory;
import presentation.map.IGraphicMap;
import presentation.map.IGraphicMapAtack;
import presentation.map.IGraphicMapAtackDistance;
import presentation.map.ILNGraphicMapIntegerAtackDistance;
import presentation.map.IPPPositionSubjectData;
import presentation.map.IRelativePosition;
import presentation.map.jbutton.IJButtonAction;
import presentation.map.jbutton.IJButtonActionAtack;
import presentation.map.jbutton.IPGraphicPosition;
import presentation.map.jbutton.PGraphicPositionInteger;
import presentation.map.jbutton.PGraphicPositionIntegerAtack;
import presentation.map.position.GraphicPositionInteger;
import presentation.map.position.IObserver;
import presentation.map.position.IPositionObserver;
import presentation.menu.IPMenu;
import presentation.menu.PMenu;
import turner.md.Actionable;

@objid ("65c28fdb-6a52-451e-9c89-e87930998704")
public class PController implements IPEnteController, IShowMenus, IPositionObserver{
	private static final String PControllerLog = "PController";
	private ILNGraphicMapIntegerAtackDistance lnGMap;
	private IPPPositionSubjectData posiProductor; // observer pattern to catch the position selected
	private IPosition<Integer, Integer> lastPosition;
	private ILNMapaMatrixEntesGroup lnMMEG;
	private JFrame frame;
	
	//Ente cache variables
	private List<IPosition<Integer, Integer>>  pMPP;//Possible Moving Positions
	private IPosition<Integer, Integer> lastEP; //Last Ente position
	private boolean wantMove;
	
	//ENTE attack variables 
	private boolean wantAtack;
	private IAtack atackUsed;
	private LNAccionesAtaque lnAccionesAtaque;
	
	
    public PController(ILNGraphicMapIntegerAtackDistance lnGMap,
    		IPPPositionSubjectData posiProductor,
    		ILNMapaMatrixEntesGroup lnMMEG, JFrame frame,
    		LNAccionesAtaque lnAccionesAtaque) {
		super();
		this.lnGMap = lnGMap;
		this.posiProductor = posiProductor;
		this.lnMMEG = lnMMEG;
		this.frame = frame;
		
		
		this.wantMove = false;
		this.wantAtack = false;
		this.lnAccionesAtaque = lnAccionesAtaque;
		
	}

    //Pre: ---
    //Post: it will do some exceptions if you dont use the setGMap and setIPositionObserver
	public PController( JFrame frame) {
		this(null, null, null,frame,null);
	}

	@Override
    public void moveEnte(Ente ente) {		
		
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

	//TODO change IPosition to RelativePosition
	@Override
	public void showMenu(IPMenu<Integer, Integer> menu, IRelativePosition position) {
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
				IPGraphicPosition<Integer, Integer>  fPGP = lnGMap.getGraphicPosition(lastEP);
				IPGraphicPosition<Integer, Integer>  sPGP = lnGMap.getGraphicPosition(sPosi);
				lnGMap.changePositions(fPGP, sPGP);  //Change the data of the positions
				wantMove = false;
			}
			else
				if(PDefaultValues.DEBUG_MODE) System.out.println("The selected position is not valid" + sPosi);
		}
		else if (wantAtack) {
			doAtack();
			
			
//			sEnteActi.subtractNumActions(cAtack.getCost());
			
//			
//			
//			if(sEnteActi.hasActions()) {
//				if(sEnte instanceof Atacable) {
//    				System.out.println(this.lnMapa.getEnteDesingNumber());
//    				Ente eneEnte = this.scn.getEnemyEnte(lnPlayerGroup.getGroup());
//    				Ataque cAtack = this.scn.getAtack((Atacable)sEnte);
//    				lnAccionesAtaque.appendAtaque(eneEnte, cAtack);
//    				sEnteActi.subtractNumActions(cAtack.getCost());
//    			}
//    			else
//    				System.out.println("The player is a fucking big chungus and can't do more atacks");
//    		}
			
			
		}
	}
	
	private void doAtack() {	wantAtack = false;
		IPosition<Integer, Integer> posicion = lastPosition instanceof IRelativePosition 
				?  AbstractMapSizeFactory.getInverseRelativeIntegerPosition((IRelativePosition)lastPosition, -1, 0)
				: lastPosition;
		IGEnte entePosi = lnGMap.getGEntePosition(posicion);//for the future to get the force of the ente
		
		if(entePosi instanceof Actionable) {
			if(PDefaultValues.DEBUG_MODE) System.out.println("Getting the attacked entes");
			List<IEnte> entesAtacked = lnGMap.getEntesAtacked(); 			
			
			for(IEnte nIEnte : entesAtacked) {
				lnAccionesAtaque.appendAtaque(nIEnte, atackUsed);	
			}
			
			lnAccionesAtaque.doAtacks(); //TODO REFACTOR
			((Actionable)entePosi).subtractNumActions(atackUsed.getCost());
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
	public void setgMap(ILNGraphicMapIntegerAtackDistance gMap) {
		this.lnGMap = gMap;
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
	
	@Override
	public void setLnAccionesAtaque(LNAccionesAtaque lnAccionesAtaque) {
		this.lnAccionesAtaque = lnAccionesAtaque;
	}

	public void setLastPosition(IPosition<Integer, Integer> lastPosition) {
		this.lastPosition = lastPosition;
	}

	@Override
	public void showAtack(IAtack atack) {
		if(atack instanceof IPGraphicAtack) {	
			this.atackUsed = atack;
			
			this.wantAtack = true;
			IPosition<Integer, Integer> posicion = lastPosition instanceof IRelativePosition 
					?  AbstractMapSizeFactory.getInverseRelativeIntegerPosition((IRelativePosition)lastPosition, -1, 0)
					: lastPosition;
			
			((IPGraphicAtack) atack).activatePositions((IShowAtack)lnGMap,posicion);
		}
		
	}


	
	


}

