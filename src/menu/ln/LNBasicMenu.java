package menu.ln;

import menu.md.BasicMenu;
import menu.md.EnteMenu;

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

