package mapa.md;

import entes.md.Ente;

public interface IMapa<X, Y> {


	IPosition<X, Y> getPosition(X x, Y y);

	String toStringNumberPositions();

	void setPosicion(X x, Y y, IPosition<X, Y> posicion);

	IPosition<X,Y>[] getPosiciones();

	int getHeight();

	int getWidth();

	boolean isEmptyPosicion(IPosition<X, Y> positionInteger);

	void setPosicion(IPosition<X, Y> posi);

	boolean hasPosition(X x, Y y);


}
