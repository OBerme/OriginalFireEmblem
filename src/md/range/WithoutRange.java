package md.range;

import mapa.md.Mapa;
import mapa.md.Posicion;

public final class WithoutRange {	
	public  static final Posicion<Integer, Integer>[] getPositions(Posicion<Integer, Integer> posi,  Mapa<Integer, Integer> map) {
		return map.getPosiciones();
	}
}
