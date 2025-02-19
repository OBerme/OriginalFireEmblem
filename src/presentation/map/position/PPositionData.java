package presentation.map.position;

import java.util.List;

import mapa.md.IPosition;
import presentation.main.PDefaultValues;
import presentation.map.IPPPositionSubjectData;

public class PPositionData 
	extends Subject implements IPPPositionSubjectData{
	
	
	public IPosition<Integer, Integer> sPosi;
	
	public PPositionData(List<IObserver> observers) {
		super();
		this.observers = observers;
	}


	@Override
	public void resetPositons() {
		sPosi = null;
		super.notifyObservers();
	}

	@Override
	public void notifyObservers() {
		if(PDefaultValues.DEBUG_MODE_IPositionObserver) System.out.println("IPositionObserver posi selected" + sPosi );
		super.notifyObservers();
	}

	@Override
	public IPosition<Integer, Integer> getPosi() {
		return sPosi;
	}

	@Override
	public void setsPosi(IPosition<Integer, Integer> sPosi) {
		this.sPosi = sPosi;
		super.notifyObservers();
	}
	
	

}
