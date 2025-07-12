package presentation.MouseHoverAtackObserver;

import mapa.md.IPosition;
import presentation.map.position.IObserver;
import presentation.map.position.Subject;

public class PositionAtackerHoverSubject extends Subject implements IHoverPositionAtackerSubject{
	private IPosition<Integer, Integer> atackerPosition;
	
	
	@Override
	public void notifyObservers() {
		for(IObserver nOb : observers) {
			((IHoverPositionAtackerObserver)nOb).updateHoverAtacker();
		}	
	}

	@Override
	public void registerObserver(IHoverPositionAtackerObserver obs) {
		super.registerObserver(obs);	
	}

	@Override
	public void setAtackerPositionHover(IPosition<Integer, Integer> posi) {
		// TODO Auto-generated method stub
		this.atackerPosition = posi;
		notifyObservers();
	}

	@Override
	public IPosition<Integer, Integer> getAtackerPositionHover() {
		// TODO Auto-generated method stub
		return atackerPosition;
	}

}
