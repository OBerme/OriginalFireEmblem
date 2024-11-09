package main.ln.acciones;

import main.md.acciones.ataque.Ataque;

public interface ILNAccion {

    // Método para agregar un nuevo ataque al ataque decorador
    public void appendAtaque(Ataque ataque) ;

    // Método para obtener el daño total de todos los ataques combinados
    public int getDamage() ;
}
