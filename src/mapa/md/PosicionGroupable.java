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

	public String getNum(Group sGroup) {
		if(hasConsolable()) {
			Ente ente = (Ente) getSomething();
			if(ente instanceof Groupable) {
				Groupable nMember = (Groupable)ente;
				if(nMember.getGroup().equals(sGroup))
					return nMember.getNum()+"";
			}
		}
		return  EMPTY_STR;
	}
}
