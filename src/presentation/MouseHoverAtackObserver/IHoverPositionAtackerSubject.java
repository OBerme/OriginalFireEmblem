package presentation.MouseHoverAtackObserver;

import mapa.md.IPosition;
import presentation.map.position.IObserver;
import presentation.map.position.ISubject;

public interface IHoverPositionAtackerSubject extends ISubject{
	
	void setAtackerPositionHover(IPosition<Integer, Integer> posi);

	IPosition<Integer, Integer> getAtackerPositionHover();
	
	void registerObserver(IHoverPositionAtackerObserver obs);
}
