package presentation.map;

import mapa.md.IPosition;

public interface IPPositionSubject {
	void registerObserver(IObserver obs);
	void removeObserver(IObserver obs);
	void notifyObservers();
	
}
