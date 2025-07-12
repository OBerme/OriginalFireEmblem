package presentation.MouseHoverObserver;

import mapa.md.IPosition;
import presentation.map.position.IObserver;
import presentation.map.position.Subject;

public class MouseHoverSubject
		extends Subject implements IMouseHoverSubject, IAtackerObserver{
	
	private int range;
	private IPosition<Integer, Integer> rangerPosition; 
	
	private IAtackerSubject atackSubject;
	private IPosition<Integer, Integer> atackerPosition;
	
	public MouseHoverSubject(IAtackerSubject atackSubject) {		
		super();
		this.atackSubject = atackSubject;
		range = 0;
		this.atackerPosition = null;
		this.rangerPosition = null;
	}

	//Pre: All the observers should be mouse observers 
	//Post: it will advice all the mouse observers that the range changed
	@Override
	public void notifyObservers() {
		for(IObserver nOb : observers) {
			IMouseHoverObserver nMouseObserver = (IMouseHoverObserver)nOb;
			nMouseObserver.updateMouseRange();
		}	
		
	}

	@Override
	public int getRange() {
		// TODO Auto-generated method stub
		return range;
	}

	@Override
	public void registerObserver(IMouseHoverObserver obs) {
		super.registerObserver(obs);
	}

	@Override
	public void setPosition(IPosition<Integer, Integer> posi) {
		
		if(atackerPosition != null && !posi.equals(atackerPosition)) {
			this.rangerPosition = posi;
			this.range = PCalculatorRange.getRange(posi, atackerPosition);
			notifyObservers();	
		}
	}

	@Override
	public void updateAtacker() {
		this.atackerPosition = atackSubject.getAtackerPosition();
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public IPosition<Integer, Integer> getAtackerPosition() {
		return atackerPosition;
	}

	@Override
	public IPosition<Integer, Integer> getRangerPosition() {
		// TODO Auto-generated method stub
		return rangerPosition;
	}

}
