package mapa.md;

public interface IPosition<X, Y> {
	 boolean isEmpty();
	 boolean hasSomething();
	 IPositionable getSomething();
	 X getX();
	 Y getY();
	void setSomething(IPositionable positi);
}
