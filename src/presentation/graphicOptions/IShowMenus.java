package presentation.graphicOptions;

import presentation.map.IRelativePosition;
import presentation.menu.IPMenu;

public interface IShowMenus {
	void showMenu(IPMenu<Integer, Integer> menu, IRelativePosition position);
	
	void showMenu(IPMenu<Integer, Integer> menu);
}
