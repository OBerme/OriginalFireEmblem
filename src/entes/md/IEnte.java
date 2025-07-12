package entes.md;

import mapa.md.IPositionable;

public interface IEnte extends IPositionable{

	int getNumb();

	int getHp();

	void setHp(int i);

	boolean isDied();

}
