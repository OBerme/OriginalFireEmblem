package presentation.map.jbutton;


import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import presentation.MouseHoverAtackObserver.IHoverPositionAtackerObserver;
import presentation.MouseHoverAtackObserver.IHoverPositionAtackerSubject;
import presentation.MouseHoverObserver.IMouseHoverSubject;
import presentation.main.PDefaultValues;
import presentation.map.IPPPositionSubjectData;
import presentation.map.position.IGraphicPosition;


//Pre: ----
//Post: when the ente of this position dies should convert,
//		or cast, this PGraphicPositionEnte in a normal PGraphicPosition 
public class PGraphicPositionIntegerAtack 
	extends PGraphicPositionInteger implements IPGraphicPositionIntegerAtack{
	
	protected boolean actiAtack; //Shows if the cell is activate for an atack

	protected boolean isLastPositionAtack;
	
	protected IMouseHoverSubject subjectMouse;
	protected IHoverPositionAtackerSubject subjectPositionAtacker;
	
	
	public PGraphicPositionIntegerAtack(IGraphicPosition<Integer, Integer> gPosition,
			IPPPositionSubjectData pSubject,
			IJButtonAction action,IMouseHoverSubject subjectMouse, IHoverPositionAtackerSubject subjectPositionAtacker) {
		super(gPosition, pSubject, action);
		this.actiAtack = false;
		this.subjectMouse = subjectMouse;
		this.subjectPositionAtacker = subjectPositionAtacker;
		
		addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
             	onMouseMotion(e);
            }
        });
	}
	
	private void onMouseMotion(MouseEvent e) {
		if(PDefaultValues.DEBUG_MODE_PGPIAD) System.out.println("Positions reached atack" + gPosition);
    	if(actiAtack) {
    		subjectMouse.setPosition(gPosition);
    	}
    	
    	if(isLastPositionAtack) {
    		subjectPositionAtacker.setAtackerPositionHover(gPosition);
    	}
	}
	
	

	@Override
	public void activateAtack() {
		// TODO Auto-generated method stub
		
		actiAtack = true;
		setBackground(PDefaultValues.D_CELL_COLOR_ACTI_ATACK);
	}
	

	@Override
	public void update() {
		super.update();
		if(actiAtack) {
			if(!pSubject.getPosi().equals(gPosition)) {
				isLastPositionAtack = false;
				deactivateAtack();
			}
		}
		
	}
	

	
	protected void onClickedPosition() {
		if(actiAtack) {
			deactivateAtack();
		}
		super.onClickedPosition();
	}

	@Override
	public void deactivateAtack() {
		active = false;
		setBackground(PDefaultValues.D_CELL_COLOR_DEAC_ATACK);		
	}

	@Override
	public boolean isActive() {
		return actiAtack;
	}

	@Override
	public void setCenterPositionAtack() {
		this.isLastPositionAtack = true;
	}


	
}
