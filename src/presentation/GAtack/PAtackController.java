package presentation.GAtack;

import java.util.List;

import acciones.ln.LNAccionesAtaque;
import acciones.md.ataque.IAtack;
import entes.md.IEnte;
import mapa.md.IPosition;
import presentation.ente.IGEnte;
import presentation.main.PDefaultValues;
import presentation.main.controller.IPController;
import presentation.map.AbstractMapSizeFactory;
import presentation.map.ILNGraphicMapIntegerAtackDistance;
import presentation.map.IRelativePosition;
import presentation.map.position.ILastPositionObserver;
import presentation.map.position.ILastPositionSubject;
import presentation.map.position.IPositionObserver;
import turner.md.Actionable;

public class PAtackController 
	implements IPAtackController,IPositionObserver, ILastPositionObserver{


	//ENTE attack variables 
	private boolean wantAtack;
	private IAtack atackUsed;
	private LNAccionesAtaque lnAccionesAtaque;
	
	private ILNGraphicMapIntegerAtackDistance lnGMap;
	private IShowAtackDistance showAtacks;
	
	private ILastPositionSubject lastPosiSubject;
	
	
	
	
	public PAtackController(LNAccionesAtaque lnAccionesAtaque,
			ILNGraphicMapIntegerAtackDistance lnGMap,
			ILastPositionSubject lastPosiSubject,
			IShowAtackDistance showAtacks) {
		super();
		this.wantAtack = false;
		this.lnAccionesAtaque = lnAccionesAtaque;
		this.lnGMap = lnGMap;
		this.lastPosiSubject = lastPosiSubject;
		this.showAtacks = showAtacks;
	}


	@Override
	public void showAtack(IAtack atack) {
		if(atack instanceof IPGraphicAtack) {	
			this.atackUsed = atack;
			
			this.wantAtack = true;
			
			IPosition<Integer, Integer> lastPosition = lastPosiSubject.getLastPosition();
			IPosition<Integer, Integer> posicion = lastPosition instanceof IRelativePosition 
					?  AbstractMapSizeFactory.getInverseRelativeIntegerPosition((IRelativePosition)lastPosition, -1, 0)
					: lastPosition;
			
			
			((IPGraphicAtack) atack).activatePositions(posicion);
		}
		
	}


	@Override
	public void update() {
		if(wantAtack) {
			wantAtack = false;
			
			IPosition<Integer, Integer> lastPosition = lastPosiSubject.getLastPosition();
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
		
	}
}
