package presentation.main;

import acciones.ln.LNAccionesAtaque;
import acciones.md.ataque.IAtack;
import mapa.ln.ILNMapaMatrixEntesGroup;
import presentation.map.IGraphicMap;
import presentation.map.ILNGraphicMapIntegerAtackDistance;
import presentation.map.IPPPositionSubjectData;
import presentation.menu.IPMenu;
import presentation.menu.PMenu;

public interface IPController {

	void setPosiProductor(IPPPositionSubjectData posiProductor);

	void showAtack(IAtack atack);
	
	void skip();

	void showMenu(IPMenu<Integer, Integer> nextMenu);

	void setLNMap(ILNGraphicMapIntegerAtackDistance gMap);

	void setLnAccionesAtaque(LNAccionesAtaque lnAccionesAtaque);


}
