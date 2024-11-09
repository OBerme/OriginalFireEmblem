package ln.acciones;

<<<<<<< HEAD:src/ln/acciones/ataque/LNAtaque.java
import MD.Acciones.Ataque.Ataque;
=======
import md.acciones.ataque.Ataque;
>>>>>>> IEnteEvent:src/ln/acciones/LNAtaque.java
import md.ente.Ente;

public class LNAtaque extends LNAccion implements ILNAccion{
	private AtaqueDecorator ataqueDecorator;

    // Constructor de LNAtaque, acepta un ente y un ataque inicial
    public LNAtaque(Ente ente, Ataque ataque) {
    	this.ente = ente;
    	ataque.setEnte(ente);
        this.ataqueDecorator = new AtaqueSolo(ataque);
    }

    // Método para agregar un nuevo ataque al ataque decorador
    public void appendAtaque(Ataque ataque) {
    	ataque.setEnte(ente);
        this.ataqueDecorator = new AtaqueCombinado(ataque, ataqueDecorator);
    }

    // Método para obtener el daño total de todos los ataques combinados
    public int getDamage() {
        return ataqueDecorator.getDamage();
    }

}
