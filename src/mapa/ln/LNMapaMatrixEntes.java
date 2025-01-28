 package mapa.ln;


import java.util.HashMap;

import entes.IEnteEvents;
import entes.md.Ente;
import entes.md.EnteCounter;
import mapa.md.IPosition;
import mapa.md.MapaMatrix;
import mapa.md.Posicion;

public class LNMapaMatrixEntes extends LNMapaMatrix 
	implements ILNMapaMatrixEntes, IEnteCollection, IEnteNumberShowable, IEnteEvents{
	private IMapEvents<Integer, Integer>[] mapEvents;
	private HashMap<Integer, Ente> entes;
	
	public LNMapaMatrixEntes(MapaMatrix mapaVector, IMapEvents<Integer, Integer>[] mapEvents) {
		super(mapaVector);
		// TODO Auto-generated constructor stub
		this.entes = new HashMap<Integer, Ente>();
		this.mapEvents = mapEvents;
	}
	
	public boolean isEmptyPosition(Integer x, Integer y) {
		return mapa.isEmptyPosicion(AbstractFactoryPositionInteger.getPosition(x, y,(MapaMatrix)mapa));
	}
	

	/**
	 * Pre: Ente no tiene que ser null, 
	 * 	posicion tiene que ser una posicion valida del mapa
	 */
	@Override
	public boolean moverEnte(Ente ente, Integer x, Integer y) {
		IPosition<Integer, Integer> aPosi = AbstractFactoryPositionInteger.getPosition(x, y,(MapaMatrix)mapa);
		if(mapa.isEmptyPosicion(aPosi)) {
			if(isEnteInMap(ente)) {
				IPosition<Integer, Integer> lPosition = this.mapa.getEntePosition(ente);
				lPosition.setSomething(null);
				onChangedPosition(aPosi);
			}
			else 
				appendEnte(ente);
			setEntePosition(ente, aPosi);
				
			
			return true;
		}
		return false;
	}
	
	
	
	private void onChangedPosition(IPosition<Integer, Integer> posi) {
		for(IMapEvents<Integer, Integer> nMapEvent : mapEvents) {
			nMapEvent.onPositionChange(posi);
		}
	}
	
	
	private void appendEnte(Ente ente) {
		entes.put(ente.getNumb(), ente);
	}
	
	public boolean isEnteInMap(Ente ente) {
		if(entes.size() == 0) 
			return false;
		
		for(Ente nEnte : entes.values()) {
			if(nEnte.equals(ente)) 
				return true;		
		}
		
		return false;
	}

	//Pre: the number shoudl be >= 0
	//Post: return nulls if the number of the ente is not in the map
	@Override
	public Ente getEnte(int number) {
		if(entes.containsKey(number)) {
			return entes.get(number);
		}
		return null;
	}



	@Override
	public String getNumberEntesDesing() {
		return mapa.toStringWithNumber();
		
	}

	@Override
	public String getMapaDesing() {
		// TODO Auto-generated method stub
		return super.getMapaDesing();
	}
	
	

	@Override
	public void onEnteDies(Ente ente) {
		if(isEnteInMap(ente)) {
			removeEnte(ente);
		}
	}
	


	protected void setEntePosition(Ente ente, IPosition<Integer, Integer> posi) {
		posi.setSomething(ente);
		mapa.setPosicion(posi);
	}
	
	
	/**
	 * Pre: posicion tiene que ser una posicion valida del mapa
	 * Post: posi.getEnte() == null
	 */
	@Override
	public void removeEnteFromPosition(Posicion<Integer, Integer> posi) {
		posi.setSomething(null);	
	}
	
	

	@Override
	public boolean removeEnte(Ente ente) {
		IPosition<Integer,Integer> fPosition = null;
		for(IPosition<Integer, Integer> nPosi : mapa.getPosiciones()) {
			if(nPosi.hasSomething() && nPosi.getSomething() instanceof Ente) {
				Ente nEnte = (Ente)nPosi.getSomething();
					if(nEnte.equals(ente)) {
						fPosition = nPosi;
						break;
					}
				}
			}
		
		if(fPosition == null)
			return false;
		
		//Change the value of ente
		fPosition.setSomething(null);
		this.entes.remove(ente.getNumb());
		
		return true;
	}

	@Override
	public void addEnte(Ente ente, Posicion<Integer, Integer> posi) {
		this.entes.put(ente.getNumb(), ente);
		setEntePosition(ente, posi);
		
	}

	@Override
	public void onEnteReciveAtack(Ente ente) {
		if(ente.isDied())
			removeEnte(ente);
		
	}

	@Override
	public void onEnteChangeHp(Ente ente) {
		if(ente.isDied())
			removeEnte(ente);
		
	}

	@Override
	public boolean isValidPosition(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return this.mapa.hasPosition(x,y) && isEmptyPosition(x, y);
	}
	

	@Override
	public String getErrorMessageInvalidPosition(Integer x, Integer y) {
		// TODO Auto-generated method stub
		if(!this.mapa.hasPosition(x,y) ) 
			return "The positions dosen't exists";
		
		else if (!isEmptyPosition(x, y)) 
			return "The position it's ocupped";
		
		return "Something went wrong";
	}

	
	
}
