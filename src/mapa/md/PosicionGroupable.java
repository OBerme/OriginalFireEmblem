package mapa.md;

import entes.md.Ente;
import group.md.Group;
import group.md.Groupable;
import turner.md.Actionable;

public class PosicionGroupable<X, Y> extends Posicion<X, Y> {

	public PosicionGroupable(X x, Y y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public String getRepresentation(Group sGroup) {
		
		if(hasEnte() ) {
			Ente ente = getEnte();
			if(ente instanceof Groupable) {
				Groupable nMember = (Groupable)ente;
				if(nMember.getGroup().equals(sGroup))
					return ente.getNumb()+"";
			}
		}
		return  EMPTY_STR;
	}
}
