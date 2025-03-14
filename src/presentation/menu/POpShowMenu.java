package presentation.menu;

import presentation.graphicOptions.IShowMenus;

public class POpShowMenu extends POption{
	private IShowMenus iShowMenu;
	public POpShowMenu(String option, IShowMenus iShowMenu, IPMenu<Integer, Integer> nextMenu) {
		super(option);
		this.nextMenu = nextMenu;
		this.iShowMenu = iShowMenu;
	}


	private IPMenu<Integer, Integer> nextMenu;
	
	
	@Override
	public void doAction() {
		iShowMenu.showMenu(nextMenu);
	}

}
