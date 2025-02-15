package presentation.map;

import java.awt.Component;

import javax.swing.Icon;

import mapa.md.IPosition;
import mapa.md.IPositionable;

public interface IGraphicPosition<X, Y> extends IPosition<X, Y> {

	Icon getCellImage();
	
	void setSomething(IPositionable positionable);

	
}
