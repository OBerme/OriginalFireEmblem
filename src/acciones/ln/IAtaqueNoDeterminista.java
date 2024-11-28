package acciones.ln;

import acciones.md.ataque.Ataque;

public interface IAtaqueNoDeterminista {
	Ataque getAtaque1();
	AtaqueDecorator getAtaque2();
	void setAtaque2(AtaqueDecorator atack2);
	
}
