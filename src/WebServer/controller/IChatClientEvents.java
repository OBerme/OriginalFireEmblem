package WebServer.controller;

public interface IChatClientEvents {
	void onDisconnect();
	void onWaitResponse();
}
