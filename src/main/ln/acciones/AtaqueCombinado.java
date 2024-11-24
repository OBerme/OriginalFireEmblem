package main.ln.acciones;

import main.md.acciones.ataque.Ataque;

class AtaqueCombinado extends AtaqueDecorator implements IAtaqueNoDeterminista{
    private Ataque ataque1;
    private AtaqueDecorator ataque2;

    public AtaqueCombinado(Ataque ataque1, AtaqueDecorator ataque2) {
        this.ataque1 = ataque1;
        this.ataque2 = ataque2;
    }

    @Override
    public int getDamage() {
        return ataque1.getDamage() + ataque2.getDamage();
    }

	public Ataque getAtaque1() {
		return ataque1;
	}

	public AtaqueDecorator getAtaque2() {
		return ataque2;
	}

	@Override
	public void setAtaque2(AtaqueDecorator atack2) {
		this.ataque2 = atack2;
		
	}
    
    
}

