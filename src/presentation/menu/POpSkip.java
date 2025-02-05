package presentation.menu;

import presentation.main.IPController;
import presentation.main.PController;

public class POpSkip extends POption{

	public POpSkip(IPController pcontro) {
		super("Skip", pcontro);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction() {
		pcontro.skip();
		
	}
	
	

}
