package main.ln.controller.menu;

import main.md.controller.menu.EnteMenu;
import main.md.controller.menu.PositionMenu;

public class LNPositionMenu extends LNMenu implements ILNPositionMenu{
	private PositionMenu positionMenu;

	public LNPositionMenu(PositionMenu positionMenu) {
		super(positionMenu);
		this.positionMenu = positionMenu;
	}

	@Override
	public Integer[] getMenuOptions() {
		// TODO Auto-generated method stub
		return positionMenu.getOptions();
	}

}
