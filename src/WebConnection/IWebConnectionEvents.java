package WebConnection;

import java.net.Socket;

import player.md.Player;

public interface IWebConnectionEvents {
	void onConnection(Socket socket, boolean waitingClient, Player player);
}
