package presentation.map.jbutton;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import mapa.md.IPosition;
import presentation.MouseHoverAtackObserver.IHoverPositionAtackerSubject;
import presentation.MouseHoverObserver.IMouseHoverObserver;
import presentation.MouseHoverObserver.IMouseHoverSubject;
import presentation.MouseHoverObserver.PCalculatorRange;
import presentation.main.PDefaultValues;
import presentation.map.IPPPositionSubjectData;
import presentation.map.position.IGraphicPosition;

public class PGraphicOPositionIntegerAtackDistance 
	extends PGraphicPositionIntegerAtack 
		implements IPGraphicPositionIntegerAtackDistance, IMouseHoverObserver{
	
	protected int rangeFromAttacker;
	protected boolean actiDistance;
	protected boolean hidden;

	public PGraphicOPositionIntegerAtackDistance(IGraphicPosition<Integer, Integer> gPosition,
			IPPPositionSubjectData pSubject, IJButtonAction action, IMouseHoverSubject subjectMouse,
			IHoverPositionAtackerSubject subjectPositionAtacker) {
		super(gPosition, pSubject, action, subjectMouse, subjectPositionAtacker);
		this.rangeFromAttacker = 0;
		this.actiDistance = false;
		this.hidden = true;
	}

	@Override
	public void activateDistance(IPosition<Integer, Integer> posiAtacker) {
		this.rangeFromAttacker = PCalculatorRange.getRange(gPosition, posiAtacker);
		actiDistance = true;
		showCell();
	}
	
	
	protected void hiddeCell() {
		hidden = true;
		setBackground(PDefaultValues.D_CELL_COLOR_DIST_DEAC);
	}

	@Override
	public void deactivateDistance() {
		actiDistance = false;
		hiddeCell();
	}

	@Override
	public void setRange(int range) {
		// TODO Auto-generated method stub
		this.rangeFromAttacker = range;
	}
	
	private void showCell() {
		hidden = false;
		setBackground(PDefaultValues.D_CELL_COLOR_DIST_ACTI);
	}

	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
		if(actiDistance) {
			deactivateDistance();
		}
	}
	
	@Override
	public void updateMouseRange() {
		if(actiDistance) {
			if(subjectMouse.getRange() > rangeFromAttacker ) {
				if(hidden)
					showCell();
			}
			else {
				hiddeCell();
			}
		}
	}

	@Override
	public boolean isActive() {
		return actiDistance;
	}


	@Override
	public boolean isActiveDistance() {
		// TODO Auto-generated method stub
		return isActive();
	}
	
	
	

}
