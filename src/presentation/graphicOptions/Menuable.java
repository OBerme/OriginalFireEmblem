package presentation.graphicOptions;

import menu.md.Menu;

public interface Menuable {
	//Pre: the menu should be valid and not null
	//Post: it will show the menu as a graphic in the 
	public void showMenu(Menu menu);
}
