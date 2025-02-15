package presentation.map;

import mapa.md.IPosition;
import presentation.map.position.IPPositionSubject;

public interface IPPPositionSubjectData extends IPPositionSubject {
	IPosition<Integer, Integer> getPosi();

	void setsPosi(IPosition<Integer, Integer> sPosi);
	
}
