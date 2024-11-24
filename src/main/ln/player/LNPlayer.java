
// Clase LNPlayer
package main.ln.player;

import main.md.player.Player;

public class LNPlayer {
    private Player player;

    // Constructor que recibe un objeto Player
    public LNPlayer(Player player) {
        this.player = player;
    }

    // Métodos que delegan la funcionalidad a los métodos de Player
    public String getName() {
        return player.getName();
    }

    public int getId() {
        return player.getId();
    }
}