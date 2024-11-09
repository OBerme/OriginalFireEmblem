package main.ln.acciones;

import main.md.acciones.ataque.Ataque;

class AtaqueCombinado extends AtaqueDecorator {
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
}

