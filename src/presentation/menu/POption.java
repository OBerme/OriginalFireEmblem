package presentation.menu;

import presentation.graphicOptions.IShowMenus;
import presentation.main.IPController;
import presentation.main.IPEnteController;
import presentation.main.PController;
// This class use a strategy pattern to do his action
public abstract class POption implements IPOption {
	protected String option;
	protected IPController pcontro;
	
	@Override
	public  abstract void doAction();
	
	public POption(String option,  IPController pcontro) {
		super();
		this.option = option;
		this.pcontro = pcontro;
	}


	@Override
	public String getOption() {
		return option;
	}
	
	
	
	
}
