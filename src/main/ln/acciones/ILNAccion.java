package main.ln.acciones;

import main.md.acciones.ataque.Ataque;
import main.md.ente.Ente;

public interface ILNAccion {

    // Método para agregar un nuevo ataque al ataque decorador
    public void appendAtaque(Ente ente, Ataque ataque) ;
    // Método para agregar un nuevo ataque al ataque decorador
    public void removeAtaque(Ente ente, Ataque ataque) ;
    public void doAtacks();
}
