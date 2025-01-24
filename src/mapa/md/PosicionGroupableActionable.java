package mapa.md;

import entes.md.Ente;
import group.md.Group;
import group.md.Groupable;
import turner.md.Actionable;

public class PosicionGroupableActionable<X, Y> extends PosicionGroupable<X, Y> {

	public PosicionGroupableActionable(X x, Y y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public String getNum(Group sGroup) {
		if(hasSomething() && getSomething() instanceof Ente) {
			Ente ente = (Ente)getSomething();
			if(ente instanceof Groupable) {
				Groupable nMember = (Groupable)ente;
				if(nMember.getGroup().equals(sGroup)) {
					if(nMember instanceof Actionable) {
						Actionable nActiona = (Actionable) nMember;
						return nActiona.hasActions() ? ente.getNumb()+"" : WITHOUT_ACTIONS ;
					}
				}								
			}
		}						
		return EMPTY_STR;
	}

}
