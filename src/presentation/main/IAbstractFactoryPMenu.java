package presentation.main;

import entes.md.Ente;
import entes.md.IEnte;
import presentation.menu.IPMenu;
import presentation.menu.PMenu;

public interface IAbstractFactoryPMenu {
	 IPMenu<Integer, Integer>  createMenuEnte(IEnte ente);
}
