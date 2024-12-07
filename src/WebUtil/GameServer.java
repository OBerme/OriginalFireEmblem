package WebUtil;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import WebUtil.controller.GameServerThread;
import WebUtil.controller.Client;
import WebUtil.controller.enums.ServerConfigurationsNum;

public class GameServer extends BasicServer {
	public static final boolean DEBUG_MODE = false;
	public static final String FILE_PATH = "/home/stallman/eclipse/SIS/Pr2_Concur/txt1.txt";
	public static GameServer gameServer;
	
	
	
	private List<Client> clientsWaiting;
	

	
	//IO variables
	public static final String EXIT_STRING = "";	
	
	
	public GameServer() {
		super();
		
		//init the objects
		clientsWaiting = new ArrayList<Client>();
		getConnection();
		iniciarServidor();
		
	}
	
	public static GameServer getInstance() {
		if(gameServer == null)
			gameServer = new GameServer();
		
		return gameServer;
			
	}
	
	
	

	protected void procesarCliente(Socket client) {
		// TODO Auto-generated method stub
		if(DEBUG_MODE) print("Attended the new client!");
		GameServerThread cST = new GameServerThread(client, this);
		cST.start();
	}
	
	public List<Client> getListClients(){
		return this.clientsWaiting;
	}
	
	public synchronized void addNewClient(Client nClient){
		this.clientsWaiting.add(nClient);
	}
	
	public synchronized void removeClient(Client client){
		this.clientsWaiting.remove(client);
	}
	
	public synchronized boolean isValidId(int id) {
		if(ServerConfigurationsNum.MIN_ID_NUMBER.getNum() > id 
				&& id > ServerConfigurationsNum.MAX_ID_NUMBER.getNum())
			return false;
		
		for(Client nClient : clientsWaiting) {
			if(nClient.getId() == id)
				return false;
		}
		return true;
	}

	
	public void print(String message) {
		System.out.println(message);
	}

}

