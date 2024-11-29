package WebServer;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Random;

import WebServer.controller.Client;
import WebServer.controller.IChatClientEvents;
import WebServer.controller.enums.ServerConfigurationsNum;
import WebServer.controller.enums.TypeConnection;
import WebServer.interfaces.console.CI_ClientStream;

public class ChatClient extends BasicClientSocket implements IChatClientEvents{
	//I/O stuff
	public static final int NUM_THREADS = 1;
	public static final int MUM_LOOPS= 1;
	public static final int MOD_REFRESH_LIST_OF_USER = 10;
	
	public static final String GET_USERS_STRING = TypeConnection.GLU.getMessageConnection();
	public static final String EXIT_STRING = TypeConnection.WD.getMessageConnection();
	
	private static final boolean DEBUG_MODE = true;
	private ClientThreadReader cTR;
	
	//I/O variables
	private DataOutputStream dOS;
	private DataInputStream dIS;
	private PrintWriter pW;
	
	private List<Client> cClients ; //Cached clients
	protected  CI_ClientStream cCI;
	
	private boolean isConnectToClient;
	
	
	public static void main(String[] args) {
		new ChatClient();
	}
	
	public ChatClient() {
		super();
		
		this.isConnectToClient = false;
		
		if(DEBUG_MODE)print("Cliente iniciado!");
	}
	
	
	private void print(String message) {
		System.out.println("Interno: " + message);
	}
	
	private void createStreams() {
		try {
			this.pW = new PrintWriter(clientSocket.getOutputStream());
			this.dIS = new DataInputStream(clientSocket.getInputStream());
			this.dOS = new DataOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void closeConnection() {
		
		try {
			
			dOS.close();
			dIS.close();
			pW.close();
			clientSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public void getListOfUsers() {
		cClients = getListClients(clientSocket, pW, dIS);
		
		if(cClients != null) {
			if(DEBUG_MODE) print("Hemos conseguido la lista de usuarios! " + cClients);
			showAvaliableClients();
		}
		else
			if(DEBUG_MODE) print("The list is empty, be the first one!");
	}
	
	private void showAvaliableClients() {
		//Show all the clients
		for(Client nClient : cClients) {
			this.cCI.print(nClient.toString());
		}
	}
	
	
	private List<Client> getListClients(Socket clientSocket, PrintWriter pW, DataInputStream dIS){
		List<Client> clients = null;
		
		sendGetListUsersServer(pW);
		int length;
		try {
			length = dIS.readInt();

			if(length != 0) {
				try(ObjectInputStream oIS = new ObjectInputStream(clientSocket.getInputStream())){
					try {
						clients = (List<Client>)oIS.readObject();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Get the length of the list of clients
		
		return clients;
	}

	public void connectClient() {
		if(this.cClients == null) 
			getListOfUsers();
		
		if(this.cClients != null) {
			this.cCI.print("Aqui tenemos los clients" );
//			showAvaliableClients();
			int nId =  0;
			boolean sResponse = true;
			
//				do {
					if(!sResponse)
						this.cCI.print("Somthing went wrong"
								+ "\n Please try with another id");
					nId = getValidIdClient();
					this.cCI.print("Connecting to the client...");
//					try {
//						
////						dOS.writeInt(nId);
////						dOS.flush();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					
//				}
//				while(!( sResponse = dIS.readBoolean()) );
				
//				ObjectInputStream oIS = new ObjectInputStream(clientSocket.getInputStream());
//				Client nClient = (Client)oIS.readObject();
				for(Client nClient : cClients) {
					if(nClient.getId() == nId) {
						connectToClient(nClient);
						break;
					}
				}
				
					
		}
		
		
		
	}
	
	
	
	private void connectToClient(Client nClient) {
		this.ip = nClient.getIp();
		this.port = nClient.getPort();
		this.isConnectToClient = true;
		this.cCI.setConnectedClient(true);
		getConnection();
	}

	private int getValidIdClient() {
		
		int i = 0;
		this.cCI.print("Dame el id del cliente" );	
		int nId = this.cCI.getNumber();
		
		while(!isValidId(nId)) {
			this.cCI.print("The last id wasen't valid "
					+ "\n Please try again with other id");
			
			if(i % MOD_REFRESH_LIST_OF_USER == 0) 
				getListOfUsers();
			else
				showAvaliableClients();
			
			nId = this.cCI.getNumber();
			
			i++;
		}
		return nId;
	}
	

	private boolean isValidId(int id) {
		if(ServerConfigurationsNum.MIN_ID_NUMBER.getNum() > id 
				&& id > ServerConfigurationsNum.MAX_ID_NUMBER.getNum())
			return false;
		
		boolean exit = false;
		for(Client nClient : cClients ) {
			if(nClient.getId() == id) {
				exit = true;
				break;
			}				
		}
		return exit;
		
	}

	public void waitForConnections() {
		
		this.pW.println(TypeConnection.WOC.getMessageConnection());
		this.pW.flush();
		
		try (ServerSocket serSoc 
				= new ServerSocket(ServerConfigurationsNum.
						WAIT_CLIENT_PORT.getNum())){
			
			this.clientSocket = serSoc.accept();
			
			this.isConnectToClient = true;
			this.cCI.setConnectedClient(true);
			onConnection();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void sendGetListUsersServer(PrintWriter pW) {
		pW.println(getStringGetListUsers());
		pW.flush();
	}
	
	
	private String getStringGetListUsers() {
		
		return GET_USERS_STRING;
	}

	@Override
	protected void onConnection() {
		updateInputsOutputs(); //to refresh the connection			
		if(isConnectToClient()) {
			cTR = new ClientThreadReader(clientSocket,this);
			cTR.start();
			
		}
		else {
			this.cCI = new CI_ClientStream(this);
			this.cCI.print("Vamos a generar un id para ti...");
			int id = getNewId();
			
			
			this.cCI.print("Dame un nombre de usuario que quieras tener");
			String name = this.cCI.getLine();
			
			snedClientToServer(id, name); //Send the client values to server
			
			this.cCI.print("Perfecto\n"
					+ "Todo listo! empecemos!");
			
			
			
		}
		this.cCI.start();
		
		this.cCI.setConnectedClient(isConnectToClient);
			
		
	}
	
	private void updateInputsOutputs() {
		try {
			pW = new PrintWriter(clientSocket.getOutputStream());
			dOS = new DataOutputStream(clientSocket.getOutputStream());
			dIS = new DataInputStream(clientSocket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isConnectToClient() {
		return isConnectToClient;
	}
	
	
	private void snedClientToServer(int id, String name) {
		Client sClient = new Client(id,name);
		
		ObjectOutputStream oOS = null;
		
		try {
			oOS = new ObjectOutputStream(clientSocket.getOutputStream());
			
			oOS.writeObject(sClient);
			oOS.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
	}

	private int getNewId() {
		Random rm = new Random();
		int nId = 0;
		
		try {			
			nId = rm.nextInt(ServerConfigurationsNum.MAX_ID_NUMBER.getNum());
			dOS.writeInt(nId);
			dOS.flush();
			while(!dIS.readBoolean()) {
				nId = rm.nextInt(ServerConfigurationsNum.MAX_ID_NUMBER.getNum());
				dOS.writeInt(nId);
				dOS.flush();
			}
			
			//Get a good id
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return nId;
		
		
	}

	public void writeAMessage(String message) {
		
		pW.println(message);
		pW.flush();
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDisconnect() {
		this.cCI.setConnectedClient(false);
		this.isConnectToClient = false;
		closeConnection();
	}

	@Override
	public void onWaitResponse() {
		cTR.onStop();
		
		closeConnection();
		
	}

	
	
}

