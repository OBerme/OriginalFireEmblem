package presentation.menu;

import presentation.main.IPEnteController;
import presentation.main.PController;

public class POpMoveEnte extends POption{

	public POpMoveEnte(IPEnteController pcontro) {
		super("Move", pcontro);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction() {
		((IPEnteController)pcontro).moveEnte();
	}
	
}
