package acciones.ln;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.IAtack;

public interface IAtaqueNoDeterminista {
	IAtack getAtaque1();
	AtaqueDecorator getAtaque2();
	void setAtaque2(AtaqueDecorator atack2);
	
}
