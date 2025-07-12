package presentation.main.controller;

import java.util.List;

import mapa.md.IPosition;
import presentation.GAtack.IPGraphicAtack;
import presentation.GAtack.IPGraphicDistanceAtack;
import presentation.GAtack.IShowAtack;
import presentation.GAtack.IShowAtackCached;
import presentation.GAtack.IShowAtackDistance;
import presentation.MouseHoverAtackObserver.IHoverPositionAtackerObserver;
import presentation.MouseHoverAtackObserver.IHoverPositionAtackerSubject;
import presentation.MouseHoverObserver.IAtackerSubject;
import presentation.MouseHoverObserver.IMouseHoverObserver;
import presentation.MouseHoverObserver.IMouseHoverSubject;
import presentation.main.PDefaultValues;
import presentation.map.ILNGraphicMapIntegerAtackDistance;
import presentation.map.IPPPositionSubjectData;
import presentation.map.position.GraphicPositionInteger;
import presentation.map.position.IObserver;
import presentation.map.position.IPositionObserver;

public class PController 
		implements IPController, IShowAtackDistance, 
		IMouseHoverObserver, IPositionObserver, IShowAtackCached, IEnteController, IHoverPositionAtackerObserver{
	
	 //TODO SOLVE PROBLEM WIHT OBSERVER
	protected IPPPositionSubjectData subject;
	private IAtackerSubject atackSubject;
	private IMouseHoverSubject mHSubject;
	private IHoverPositionAtackerSubject hPASubject;
	
	private IShowAtackDistance showAtacks;
	
	protected GraphicPositionInteger sPosition;
	
	
	//Atack variables
	private boolean isCacheAtack;
	private IPGraphicDistanceAtack cacheAtack; //The last atack used
	
	private ILNGraphicMapIntegerAtackDistance lnGMIAD;
	
	public PController(IPPPositionSubjectData subject,
			IAtackerSubject atackSubject, IMouseHoverSubject mHSubject,IHoverPositionAtackerSubject hPASubject) {
		super();
		this.subject = subject;
		this.atackSubject = atackSubject;
		this.mHSubject = mHSubject;
		this.hPASubject = hPASubject;
	}
	
	
	@Override
	public void setShowAtacks(IShowAtackDistance showAtacks) {
		this.showAtacks = showAtacks;
	}



	@Override
	public void setLnGMIAD(ILNGraphicMapIntegerAtackDistance lnGMIAD) {
		this.lnGMIAD = lnGMIAD;
	}

	@Override
	public void skip() {
		// TODO Auto-generated method stub
		if(PDefaultValues.DEBUG_MODE_CONTROLLER) System.out.println("PCONTROLLER se ha pasado el turno");
	}

	
	@Override
	public void activateAtackPositions(List<IPosition<Integer, Integer>> activatePositions) {
		this.atackSubject.setAtackerPosition(sPosition);
		this.lnGMIAD.activateAtackPositions(activatePositions);
	}

	@Override
	public void activateDistancePositions(List<IPosition<Integer, Integer>> activateDistancePositions) {
		this.lnGMIAD.activateDistancePositions(activateDistancePositions, sPosition);
		
	}

	@Override
	public void clearActivateAtacks() {
		this.showAtacks.clearActivateAtacks();
		
	}


	@Override
	public void setCacheAtack(IPGraphicDistanceAtack cacheAtack) {
		isCacheAtack = true;
		this.cacheAtack = (IPGraphicDistanceAtack)cacheAtack;
	}


	@Override
	public void update() {
		sPosition = (GraphicPositionInteger)subject.getPosi();
		if(isCacheAtack) isCacheAtack = false;
	}
	
	
	@Override
	public void updateMouseRange() {
		if(isCacheAtack) {
			IPosition<Integer, Integer> sPosi =  mHSubject.getRangerPosition();
			if(lnGMIAD.activeDistancePosition(sPosi)) {
				showAtacks.clearActivateAtacks();
				IPosition<Integer, Integer> atackerPosi =  mHSubject.getAtackerPosition();
				cacheAtack.onChangeActivatePosition(atackerPosi, mHSubject.getRange());
				
			}
			
//			showAtacks.activateDistancePositions(cacheAtack.getActivateDistancePositions(sPosi));
		}
		
	}


	@Override
	public void updateHoverAtacker() {
		if(isCacheAtack) {
			IPosition<Integer, Integer> sPosi =  mHSubject.getRangerPosition();
			
			showAtacks.clearActivateAtacks();
			IPosition<Integer, Integer> atackerPosi =  mHSubject.getAtackerPosition();
			cacheAtack.onChangeActivatePosition(atackerPosi);
			
			
//			showAtacks.activateDistancePositions(cacheAtack.getActivateDistancePositions(sPosi));
		}
		
	}


	@Override
	public void setCenterPosition(IPosition<Integer, Integer> centerPosition) {
		showAtacks.setCenterPosition(centerPosition);
	}

}
