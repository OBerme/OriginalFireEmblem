package presentation.map;

import javax.swing.JPanel;

import mapa.md.Mapa;
import mapa.md.Posicion;

public abstract class GraphicMap<X, Y> extends JPanel {
	protected Mapa<X, Y> map;
	public abstract void showMap();
	
	
	
}
