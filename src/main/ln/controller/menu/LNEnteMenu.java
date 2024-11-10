package main.ln.controller.menu;

import main.md.controller.menu.EnteMenu;

public class LNEnteMenu extends LNMenu implements ILNEnteMenu{
	private EnteMenu enteMenu;

	public LNEnteMenu(EnteMenu enteMenu) {
		super(enteMenu);
		this.enteMenu = enteMenu;
	}
	

	@Override
	public Integer[] getMenuOptions() {
		// TODO Auto-generated method stub
		return enteMenu.getOptions();
	}
	
}
