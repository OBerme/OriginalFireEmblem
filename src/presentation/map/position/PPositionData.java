package presentation.map.position;

import java.util.List;

import mapa.md.IPosition;
import presentation.map.IPPPositionSubjectData;

public class PPositionData implements IPPPositionSubjectData{
	public List<IObserver> observers;
	
	public IPosition<Integer, Integer> sPosi;
	
	public PPositionData(List<IObserver> observers) {
		super();
		this.observers = observers;
	}


	@Override
	public void registerObserver(IObserver obs) {
		observers.add(obs);
	}

	
	//Pre: The observer should be not null and implement the equal method
	//Post: It will remove the observer from the list
	@Override
	public void removeObserver(IObserver obs) {
		observers.remove(obs);
	}

	@Override
	public void notifyObservers() {
		for(IObserver nOb : observers) {
			nOb.update();
		}
	}

	@Override
	public IPosition<Integer, Integer> getPosi() {
		return sPosi;
	}

	@Override
	public void setsPosi(IPosition<Integer, Integer> sPosi) {
		this.sPosi = sPosi;
		notifyObservers();
	}
	
	

}
