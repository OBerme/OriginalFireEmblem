package presentation.map.jbutton;

import mapa.md.IPosition;
import mapa.md.IPositionable;

public interface IPGraphicPositionInteger extends IPGraphicPosition<Integer, Integer> {
	IJButtonAction getGraAction();

	void setAction(IJButtonAction action);
	
	

}
