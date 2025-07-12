package presentation.map.jbutton;

import mapa.md.IPosition;

public interface IPGraphicPositionIntegerAtackDistance {
	//Pre: ---
	//Post: it will show the cell as a distance/range cell 
	void activateDistance(IPosition<Integer, Integer> posiAtacker);
	
	//Pre: The cell should was activate before 
	//Post: it will deactivate the cell as a distance/range
	void deactivateDistance();
	
	//Pre
	//Post
	void setRange(int range);
	
	//Pre: ---
	//Post: it will return if the position distance is activate
	boolean isActiveDistance();
	
	
}
