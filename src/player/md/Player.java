package player.md;
public class Player {
    private int id;
    private String name;

    // Constructor con todos los parámetros
    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Método para obtener el nombre del jugador
    public String getName() {
        return name;
    }

    // Método para obtener el id del jugador
    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return this.name;
    }
}