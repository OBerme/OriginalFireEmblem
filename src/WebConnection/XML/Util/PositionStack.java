package WebConnection.XML.Util;

import java.util.List;
import java.util.Stack;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import mapa.ln.IMapEvents;
import mapa.md.Posicion;
import mapa.md.PosicionXml;

@objid ("f99a1ade-3081-4b49-905e-2266c8a1b699")
public class PositionStack implements IMapEvents<Integer, Integer> {
	protected Stack<Posicion<Integer, Integer>> positionsChanged;
	public PositionStack() {
		this.positionsChanged = new Stack<Posicion<Integer,Integer>>();
	}

	
    

	@Override
	public void onPositionChange(Posicion<Integer, Integer> posi) {
		this.positionsChanged.add(posi);
		
	}
	
	public void clearPositions() {
		this.positionsChanged.clear();
	}

}
