package presentation.menu;

import presentation.main.IPEnteController;
import presentation.main.PController;
// This class use a strategy pattern to do his action
public abstract class POption implements IPOption {
	protected String option;
	protected IPEnteController pcontro;
	
	@Override
	public  abstract void doAction();
	
	public POption(String option, IPEnteController pcontro2) {
		super();
		this.option = option;
		this.pcontro = pcontro2;
	}


	@Override
	public String getOption() {
		return option;
	}
	
	
	
	
}
