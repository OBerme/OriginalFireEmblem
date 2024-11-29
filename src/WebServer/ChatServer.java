package WebServer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import WebServer.controller.ChatServerThread;
import WebServer.controller.Client;
import WebServer.controller.enums.ServerConfigurationsNum;

public class ChatServer extends BasicServer {
	public static final boolean DEBUG_MODE = true;
	public static final String FILE_PATH = "/home/stallman/eclipse/SIS/Pr2_Concur/txt1.txt";
	
	private List<Client> clientsWaiting;
	
	
	
	//IO variables
	public static final String EXIT_STRING = "";	
	
	
	public static void main(String[] args) {
		new ChatServer();
	}
	
	public ChatServer() {
		super();
		//init the objects
		
		clientsWaiting = new ArrayList<Client>();
		
		//Init the connection
		getConnection();
		iniciarServidor();
	}
	
	
	

	protected void procesarCliente(Socket client) {
		// TODO Auto-generated method stub
		if(DEBUG_MODE) print("Attended the new client!");
		ChatServerThread cST = new ChatServerThread(client, this);
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

