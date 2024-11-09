package ln.acciones.ataque;

import MD.Acciones.Ataque.Ataque;

public interface ILNAccion {

    // Método para agregar un nuevo ataque al ataque decorador
    public void appendAtaque(Ataque ataque) ;

    // Método para obtener el daño total de todos los ataques combinados
    public int getDamage() ;
}
