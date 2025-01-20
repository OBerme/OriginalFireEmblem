package presentation.map;

import mapa.md.Mapa;
import mapa.md.Posicion;

public abstract class GraphicMap<X, Y> {
	protected Mapa<X, Y> map;
	public abstract void showMap();
	
}
