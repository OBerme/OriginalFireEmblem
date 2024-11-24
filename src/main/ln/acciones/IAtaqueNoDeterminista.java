package main.ln.acciones;

import main.md.acciones.ataque.Ataque;

public interface IAtaqueNoDeterminista {
	Ataque getAtaque1();
	AtaqueDecorator getAtaque2();
	void setAtaque2(AtaqueDecorator atack2);
	
}
