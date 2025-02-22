package acciones.ln;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.IAtack;

public class AtaqueSolo extends AtaqueDecorator implements IAtaqueDeterminista{
	private IAtack ataque1;
    public AtaqueSolo(IAtack ataque1) {
        this.ataque1 = ataque1;
    }
    
	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return ataque1.getDamage();
	}
	
	public IAtack getAtaque() {
		return ataque1;
	}
	

}
