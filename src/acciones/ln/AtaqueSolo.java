package acciones.ln;

import acciones.md.ataque.Ataque;

public class AtaqueSolo extends AtaqueDecorator implements IAtaqueDeterminista{
	private Ataque ataque1;
    public AtaqueSolo(Ataque ataque1) {
        this.ataque1 = ataque1;
    }
    
	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return ataque1.getDamage();
	}
	
	public Ataque getAtaque() {
		return ataque1;
	}
	

}
