package menu.ln;

import menu.md.ActionableMenu;
import menu.md.BasicMenu;
import menu.md.EnteMenu;

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

