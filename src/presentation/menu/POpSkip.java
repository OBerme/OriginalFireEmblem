package presentation.menu;

import presentation.main.IPEnteController;
import presentation.main.controller.IPController;

public class POpSkip extends POption{

	private IPController contro; 
	public POpSkip(IPController contro) {
		super("Skip");
		this.contro = contro;
	}

	@Override
	public void doAction() {
		contro.skip();
		
	}
	
	

}
