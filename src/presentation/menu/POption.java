package presentation.menu;

import presentation.graphicOptions.IShowMenus;
import presentation.main.IPEnteController;
import presentation.main.controller.IPController;
// This class use a strategy pattern to do his action
public abstract class POption implements IPOption {
	protected String option;
	
	
	@Override
	public  abstract void doAction();
	
	public POption(String option) {
		super();
		this.option = option;
	}


	@Override
	public String getOption() {
		return option;
	}
	
	
	
	
}
