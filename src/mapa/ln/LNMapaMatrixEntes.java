 package mapa.ln;


import java.util.HashMap;

import entes.IEnteEvents;
import entes.md.Ente;
import entes.md.EnteCounter;
import entes.md.IEnte;
import mapa.md.IMapEnte;
import mapa.md.IPosition;
import mapa.md.IPositionForEnte;
import mapa.md.IPositionable;
import mapa.md.MapaMatrix;
import mapa.md.MapaMatrixEnte;
import mapa.md.Posicion;

public class LNMapaMatrixEntes extends LNMapaMatrix 
	implements ILNMapaMatrixEntes, IEnteCollection, IEnteEvents{
	private IMapEvents<Integer, Integer>[] mapEvents;
	private HashMap<Integer, IEnte> entes;
	
	public LNMapaMatrixEntes(MapaMatrix mapaVector, IMapEvents<Integer, Integer>[] mapEvents) {
		super(mapaVector);
		// TODO Auto-generated constructor stub
		this.entes = new HashMap<Integer, IEnte>();
		
		this.mapEvents = mapEvents;
		updateEntes();
	}
	
	private void updateEntes() {
		for(IPosition<Integer, Integer> nPosi:  mapa.getPosiciones()) {
			if(nPosi instanceof IPositionForEnte) {
				IPositionForEnte posiEnte = (IPositionForEnte)nPosi;
				if(posiEnte.hasEnte()) {
					IEnte nEnte = posiEnte.getEnte();
					
					appendEnte(nEnte);
//					setEntePosition(nEnte, posiEnte);
				}
			}
		}
	}
	
	private void onChangedPosition(IPosition<Integer, Integer> posi) {
		for(IMapEvents<Integer, Integer> nMapEvent : mapEvents) {
			nMapEvent.onPositionChange(posi);
		}
	}
	
	
	private void appendEnte(IEnte ente) {
		entes.put(ente.getNumb(), ente);
	}
	
	public boolean isEnteInMap(IEnte ente) {
		if(entes.size() == 0) 
			return false;
		
		for(IEnte nEnte : entes.values()) {
			if(nEnte.equals(ente)) 
				return true;		
		}
		
		return false;
	}

	//Pre: the number shoudl be >= 0
	//Post: return nulls if the number of the ente is not in the map
	@Override
	public IEnte getEnte(int number) {
		if(entes.containsKey(number)) {
			return entes.get(number);
		}
		return null;
	}




	@Override
	public String getMapaDesing() {
		// TODO Auto-generated method stub
		return super.getMapaDesing();
	}
	
	

	@Override
	public void onEnteDies(IEnte ente) {
		if(isEnteInMap(ente)) {
			removeEnte(ente);
		}
	}
	

	protected void addMapPosition(Ente ente, IPosition<Integer, Integer> posi) {
		mapa.setPosicion(posi);
	}
	
	protected void setEntePosition(IEnte ente, IPosition<Integer, Integer> posi) {
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
	

	/**
	 * Pre: Ente no tiene que ser null, 
	 * 	posicion tiene que ser una posicion valida del mapa
	 * Post: it will put the ente if its not on the map and if its on the map it will be change
	 * 	 his position to the other one 
	 */
	@Override
	public boolean moverEnte(IEnte ente, Integer x, Integer y) {
		IPosition<Integer, Integer> aPosi = AbstractFactoryPositionInteger.getPositionInteger(x, y,(MapaMatrix)mapa);
		if(mapa.isEmptyPosicion(aPosi)) {
			if(isEnteInMap(ente)) {
				IPosition<Integer, Integer> lPosition = ((IMapEnte<Integer, Integer>)this.mapa).getEntePosition(ente);
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
	
	

	@Override
	public boolean removeEnte(IEnte ente) {
		IPosition<Integer,Integer> fPosition = null;
		
		
		if(fPosition == null)
			return false;
		
		//Change the value of ente
		fPosition.setSomething(null);
		this.entes.remove(ente.getNumb());
		
		return true;
	}

	@Override
	public void addEnte(IEnte ente, Posicion<Integer, Integer> posi) {
		this.entes.put(ente.getNumb(), ente);
		setEntePosition(ente, posi);
		
	}

	@Override
	public void onEnteReciveAtack(IEnte ente) {
		if(ente.isDied())
			removeEnte(ente);
		
	}

	@Override
	public void onEnteChangeHp(IEnte ente) {
		if(ente.isDied())
			removeEnte(ente);
		
	}

	@Override
	public String getEnteDesingNumber() {
		// TODO Auto-generated method stub
		return ((MapaMatrixEnte)mapa).getEnteDesingNumber();
	}

	
	@Override
	public IPosition<Integer, Integer> getPositionEnte(IEnte ente) {
		// TODO Auto-generated method stub
		for(IPosition<Integer, Integer> nPosi : mapa.getPosiciones()) {
			if(nPosi.hasSomething() && nPosi instanceof IPositionForEnte) {
				IPositionForEnte nPEnte = (IPositionForEnte)nPosi;
					if(nPEnte.hasEnte() && nPEnte.getEnte().equals(ente)) {
						return nPosi;
					}
				}
			}
		return null;
	}
	

	
	
}
