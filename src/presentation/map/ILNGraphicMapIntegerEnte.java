package presentation.map;

import java.util.List;

import entes.md.GraphicEnte;
import entes.md.IEnte;
import mapa.md.IPosition;
import presentation.ente.IGEnte;
import presentation.map.jbutton.IJButtonAction;

public interface ILNGraphicMapIntegerEnte  {

	IGEnte getGEntePosition(IPosition<Integer, Integer> posicion);

	void moveEnte(IGEnte gEnte, int x, int y);
	
}
