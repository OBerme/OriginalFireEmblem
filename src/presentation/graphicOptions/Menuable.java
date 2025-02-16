package presentation.graphicOptions;

import menu.md.Menu;
import presentation.menu.IPMenu;
import presentation.menu.PMenu;

public interface Menuable {
	//Pre: the menu should be valid and not null
	//Post: it will show the menu as a graphic in the 
	
	
	public IPMenu<Integer, Integer> getMenu();
}
