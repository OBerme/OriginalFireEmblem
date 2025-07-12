package presentation.MouseHoverObserver;

import mapa.md.IPosition;
import presentation.map.position.IObserver;
import presentation.map.position.ISubject;

public interface IAtackerSubject extends ISubject{
	
	void setAtackerPosition(IPosition<Integer, Integer> posi);

	IPosition<Integer, Integer> getAtackerPosition();
	
	void registerObserver(IAtackerObserver obs);
}
