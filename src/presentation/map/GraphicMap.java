package presentation.map;

import javax.swing.JPanel;

import mapa.md.Mapa;
import mapa.md.Posicion;

public abstract class GraphicMap<X, Y> extends JPanel implements IGraphicMap{
	protected Mapa<X, Y> map;
	public abstract void showMap();
	
	
	
}
