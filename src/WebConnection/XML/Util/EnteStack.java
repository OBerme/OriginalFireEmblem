package WebConnection.XML.Util;

import java.util.List;
import java.util.Stack;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import entes.IEnteEvents;
import entes.md.Ente;
import mapa.md.Posicion;

@objid ("d1f7b25c-9b29-4297-9f89-4b2a12e0072d")
public class EnteStack implements IEnteEvents {
	
	protected Stack<Ente> entesChanged;
	public EnteStack() {
		this.entesChanged = new Stack<Ente>();
	}
	
    @objid ("5b8a8fdc-aa79-4b54-8d0e-81af1d976c8e")
    public List<Ente> getEntes() {
        // TODO Auto-generated return
        return (List<Ente>)entesChanged.clone();
    }

	@Override
	public void onEnteDies(Ente ente) {
		if(!entesChanged.contains(ente)) { 
			entesChanged.add(ente);
		} //else the ente is inside and the health will be modify automaticly 
	}

	@Override
	public void onEnteReciveAtack(Ente ente) {
		if(!entesChanged.contains(ente)) { 
			entesChanged.add(ente);
		} //else the ente is inside and the health will be modify automaticly
		
	}
	public void clearEntes() {
		this.entesChanged.clear();
	}
	
	public int getLength() {
		return this.entesChanged.size();
	}

	@Override
	public void onEnteChangeHp(Ente ente) {
		// TODO Auto-generated method stub
		
	}

}
