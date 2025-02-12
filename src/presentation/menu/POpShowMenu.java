package presentation.menu;

import presentation.main.IPEnteController;
import presentation.main.PController;

public class POpShowMenu extends POption{
	
	public POpShowMenu(String option, IPEnteController pcontro, PMenu nextMenu) {
		super(option, pcontro);
		this.nextMenu = nextMenu;
	}


	private PMenu nextMenu;
	
	
	@Override
	public void doAction() {
		pcontro.showMenu(nextMenu);
	}

}
