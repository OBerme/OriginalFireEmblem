package presentation.map.position;

import mapa.md.IPosition;

public interface ILastPositionSubject extends  ISubject{
	 
	    IPosition<Integer, Integer> getLastPosition();
	    
	    void setLastPosition(IPosition<Integer, Integer> lastPosi);
	    
	    
	    void registerObserver(ILastPositionObserver obs);
}
