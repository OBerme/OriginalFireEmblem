package presentation.map.position;

public interface ISubject {
	void registerObserver(IObserver obs);
	void removeObserver(IObserver obs);
	void notifyObservers();
}
