package presentation.menu;

import presentation.main.IPController;
import presentation.main.IPEnteController;
import presentation.main.PController;

public class POpShowMenu extends POption{
	
	public POpShowMenu(String option, IPController pcontro, IPMenu<Integer, Integer> nextMenu) {
		super(option, pcontro);
		this.nextMenu = nextMenu;
	}


	private IPMenu<Integer, Integer> nextMenu;
	
	
	@Override
	public void doAction() {
		pcontro.showMenu(nextMenu);
	}

}
