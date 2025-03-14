package presentation.map;

import entes.md.GraphicEnte;
import mapa.md.IPosition;
import presentation.ente.IGEnte;
import presentation.map.jbutton.IJButtonAction;

public interface IGraphicMapIntegerEnte extends IGraphicMap {

	//Pre: The graphicEnte and bAction should be not null
	//Post: It will change the ente to that position 
	public void moveEnte(IGEnte gEnte, int lx, int ly, int nx, int ny);

	IGEnte getEntePosition(IPosition<Integer, Integer> posicion);

	public void putEnteOnPosi(IGEnte gEnte, int x, int y);


}
