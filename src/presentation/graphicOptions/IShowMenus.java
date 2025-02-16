package presentation.graphicOptions;

import mapa.md.IPosition;
import presentation.menu.IPMenu;
import presentation.menu.PMenu;

public interface IShowMenus {
	

	void showMenu(IPMenu<Integer, Integer> menu, IPosition<Integer, Integer> position);
}
