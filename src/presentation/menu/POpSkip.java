package presentation.menu;

import presentation.main.IPEnteController;
import presentation.main.PController;

public class POpSkip extends POption{

	public POpSkip(IPEnteController pcontro) {
		super("Skip", pcontro);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction() {
		pcontro.skip();
		
	}
	
	

}
