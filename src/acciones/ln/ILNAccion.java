package acciones.ln;

import acciones.md.ataque.Ataque;
import acciones.md.ataque.IAtack;
import entes.md.Ente;
import entes.md.IEnte;

public interface ILNAccion {

    // Método para agregar un nuevo ataque al ataque decorador
    public void appendAtaque(IEnte ente, IAtack ataque) ;
    // Método para agregar un nuevo ataque al ataque decorador
    public void removeAtaque(Ente ente, IAtack ataque) ;
    public void doAtacks();
}
