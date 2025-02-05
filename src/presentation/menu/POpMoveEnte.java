package presentation.menu;

import presentation.main.IPController;
import presentation.main.PController;

public class POpMoveEnte extends POption{

	public POpMoveEnte(IPController pcontro) {
		super("Move", pcontro);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction() {
		pcontro.moveEnte();
	}
	
}
