package WebConnection.XML.Util.ln;

import java.util.ArrayList;
import java.util.List;

import WebConnection.XML.Util.EnteStack;
import WebConnection.XML.Util.PositionXmlStack;
import entes.IEnteEvents;
import entes.md.Ente;
import mapa.ln.IMapEvents;
import mapa.ln.IMapIntegerEvents;
import mapa.md.Posicion;
import mapa.md.PosicionXml;

public class LNXmlStack implements IMapIntegerEvents , IEnteEvents{
	private PositionXmlStack positionStack;
	private EnteStack enteStack;
	
	public LNXmlStack(PositionXmlStack positionStack, EnteStack enteStack) {
		super();
		this.positionStack = positionStack;
		this.enteStack = enteStack;
	}
	
	 public List<Ente> getEntes() {
	    // TODO Auto-generated return
		List<Ente> entes =this.enteStack.getEntes();
		this.enteStack.clearEntes();
	    return entes; 
	 }
	 
	 public List<PosicionXml> getPositionsXml(){
		List<PosicionXml> positionsXml = this.positionStack.getPositionsXml();
		this.positionStack.clearPositions();
		return positionsXml;
	 }

	@Override
	public void onEnteDies(Ente ente) {
		this.enteStack.onEnteDies(ente);
	}

	@Override
	public void onEnteReciveAtack(Ente ente) {
		this.enteStack.onEnteReciveAtack(ente);
	}

	@Override
	public void onPositionChange(Posicion<Integer, Integer> posicion) {
		this.positionStack.onPositionChange(posicion);
		
	}
	  
	  
}
