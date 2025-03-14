package presentation.map.jbutton;


import presentation.main.PDefaultValues;
import presentation.map.IPPPositionSubjectData;
import presentation.map.position.IGraphicPosition;


//Pre: ----
//Post: when the ente of this position dies should convert,
//		or cast, this PGraphicPositionEnte in a normal PGraphicPosition 
public class PGraphicPositionIntegerAtack 
	extends PGraphicPositionInteger implements IPGraphicPositionIntegerAtack{
	
	protected boolean actiAtack; //Shows if the cell is activate for an atack
	
	
	
	public PGraphicPositionIntegerAtack(IGraphicPosition<Integer, Integer> gPosition,
			IPPPositionSubjectData pSubject,
			IJButtonAction action) {
		super(gPosition, pSubject, action);
		this.actiAtack = false;

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

	
}
