package presentation.map;

import java.awt.Component;

import javax.swing.Icon;

import mapa.md.IPosition;

public interface IGraphicPosition<X, Y> extends IPosition<X, Y> {

	Icon getCellImage();


}
