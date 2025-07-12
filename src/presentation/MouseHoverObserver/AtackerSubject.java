package presentation.MouseHoverObserver;

import mapa.md.IPosition;
import presentation.map.position.IObserver;
import presentation.map.position.Subject;

public class AtackerSubject extends Subject implements IAtackerSubject{
	private IPosition<Integer, Integer> posi;
	
	
	@Override
	public void setAtackerPosition(IPosition<Integer, Integer> posi) {
		// TODO Auto-generated method stub
		this.posi = posi;
		notifyObservers();
	}
	
	@Override
	public void notifyObservers() {
		for(IObserver nOb : observers) {
			((IAtackerObserver)nOb).updateAtacker();
		}	
	}

	@Override
	public IPosition<Integer, Integer> getAtackerPosition() {
		// TODO Auto-generated method stub
		return posi;
	}

	@Override
	public void registerObserver(IAtackerObserver obs) {
		super.registerObserver(obs);	
	}

}
