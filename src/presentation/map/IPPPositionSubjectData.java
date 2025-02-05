package presentation.map;

import mapa.md.IPosition;

public interface IPPPositionSubjectData extends IPPositionSubject {
	IPosition<Integer, Integer> getPosi();

	void setsPosi(IPosition<Integer, Integer> sPosi);
	
}
