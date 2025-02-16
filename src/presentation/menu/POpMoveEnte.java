package presentation.menu;

import entes.Movable;
import entes.md.Ente;
import presentation.main.IPEnteController;
import presentation.main.PController;
import presentation.main.PDefaultValues;
import turner.md.Actionable;
import turner.md.enums.TurnerEnumConstant;

public class POpMoveEnte extends POption{
	private Ente ente;
	private IPMenuEnte<Integer, Integer> pMenuEnte;
	public POpMoveEnte(IPEnteController pcontro, Ente ente, IPMenuEnte<Integer, Integer> pMenuEnte) {
		super("Move", pcontro);
		this.ente = ente;
		this.pMenuEnte = pMenuEnte;
	}

	@Override
	public void doAction() {
    	if( (ente instanceof Movable && ente instanceof Actionable)) { //To pay the turn 
    		Actionable sEnteActi = (Actionable) ente;
    		if(sEnteActi.hasActions()) {
    			if(sEnteActi.canMove()) {
        			((IPEnteController)pcontro).moveEnte(ente);		
        			sEnteActi.subtractNumActions(TurnerEnumConstant.MOVE_COST.getCost());
        			
        			if(!sEnteActi.canMove()) //Disable the option
        				pMenuEnte.disableOption(this);
        				
    			}
    		}
    		else if(PDefaultValues.DEBUG_MODE_MENU) System.out.println("The ente cant move because is a big chungus");
    	}
    	
		
	}
	
}
