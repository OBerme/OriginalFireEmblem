package presentation.main;

import mapa.ln.ILNMapaMatrixEntesGroup;
import presentation.map.IGraphicMap;
import presentation.map.IPPPositionSubjectData;
import presentation.menu.IPMenu;
import presentation.menu.PMenu;

public interface IPController {

	void setPosiProductor(IPPPositionSubjectData posiProductor);

	void setgMap(IGraphicMap gMap);


	void skip();

	void showMenu(IPMenu<Integer, Integer> nextMenu);


}
