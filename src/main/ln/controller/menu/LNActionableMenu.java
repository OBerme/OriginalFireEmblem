package main.ln.controller.menu;

import main.md.controller.menu.ActionableMenu;
import main.md.controller.menu.BasicMenu;
import main.md.controller.menu.EnteMenu;

public class LNActionableMenu extends LNMenu implements ILNActionableMenu{
	private ActionableMenu actionMenu;

	public LNActionableMenu(ActionableMenu basicMenu) {
		super(basicMenu);
		this.actionMenu = basicMenu;
	}

	@Override
	public Integer[] getMenuOptions() {
		// TODO Auto-generated method stub
		return actionMenu.getOptions();
	}
	
	// Método para mostrar las opciones del menú
    public void showMenuOptions() {
    	System.out.println(actionMenu.toString());
    }

}

