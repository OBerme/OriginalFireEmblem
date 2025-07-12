package presentation.map.position;

import mapa.md.IPosition;

public class LastPositionSubject extends Subject
	implements ILastPositionSubject{

	private IPosition<Integer, Integer> lastPosition;
	

	@Override
	public IPosition<Integer, Integer> getLastPosition() {
		// TODO Auto-generated method stub
		return lastPosition;
	}

	@Override
	public void setLastPosition(IPosition<Integer, Integer> lastPosi) {
		this.lastPosition = lastPosi;
	}

	@Override
	public void registerObserver(ILastPositionObserver obs) {
		super.registerObserver((IObserver)obs);
		
	}
	

}
