package main.ln.controller.menu;

import main.md.controller.menu.BasicMenu;
import main.md.controller.menu.EnteMenu;

public class LNBasicMenu extends LNMenu implements ILNBasicMenu{
	private BasicMenu basicMenu;

	public LNBasicMenu(BasicMenu basicMenu) {
		super(basicMenu);
		this.basicMenu = basicMenu;
	}

	@Override
	public Integer[] getMenuOptions() {
		// TODO Auto-generated method stub
		return basicMenu.getOptions();
	}
	
	// Método para mostrar las opciones del menú
    public void showMenuOptions() {
    	System.out.println(basicMenu.toString());
    }

}

