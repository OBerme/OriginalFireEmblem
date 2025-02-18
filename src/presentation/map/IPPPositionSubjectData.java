package presentation.map;

import mapa.md.IPosition;
import presentation.map.position.IPPositionSubject;

public interface IPPPositionSubjectData extends IPPositionSubject {
	IPosition<Integer, Integer> getPosi();

	void setsPosi(IPosition<Integer, Integer> sPosi);

	
	//Pre: All the observers should contain the equals and filter a null type
	//Post: it deactivate all the positions 
	void resetPositons();
	
}
