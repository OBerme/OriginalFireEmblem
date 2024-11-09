package main.ln.acciones;

import main.md.acciones.ataque.Ataque;

public class AtaqueSolo extends AtaqueDecorator{
	private Ataque ataque1;
    public AtaqueSolo(Ataque ataque1) {
        this.ataque1 = ataque1;
    }
    
	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return ataque1.getDamage();
	}
	

}
