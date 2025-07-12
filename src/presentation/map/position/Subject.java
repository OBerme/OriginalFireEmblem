package presentation.map.position;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject implements ISubject{
	protected List<IObserver> observers;
	
	public Subject() {
		super();
		this.observers = new ArrayList<IObserver>();
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
	
	
}
