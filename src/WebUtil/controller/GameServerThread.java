package WebUtil.controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.Callable;

import WebUtil.GameServer;
import WebUtil.controller.enums.ServerConfigurationsNum;
import WebUtil.controller.enums.TypeConnection;

public class GameServerThread extends Thread{
	private static final boolean DEBUG_MODE = true;
	private static final String STR_DISCON = TypeConnection.WD.getMessageConnection();
	
	private Socket client;
	private GameServer server;
	
	private Client aClient;
	
	public GameServerThread(Socket client, GameServer server) {
		this.client = client;
		this.server = server;
		
	}	

	@Override
	public void run() {
		
		String nLine = null;
		
		try (DataInputStream dIS = new DataInputStream(client.getInputStream());
				BufferedReader bR = new BufferedReader(new InputStreamReader(client.getInputStream()));
				DataOutputStream dOS = new DataOutputStream(client.getOutputStream())){
			this.aClient = getClientData();
			
			nLine = bR.readLine();
			while(!wantsToDisconect(nLine)) {
				if(isWaitForAnotherClient(nLine)){
					server.addNewClient(aClient);
					nLine = STR_DISCON;
				}
				else {
					if(isGetListUsers(nLine)) {
						sendListOfClients();
					}
//					else if(wantsDisconnect(nLine)) {
//						server.removeClient(aClient);
//					}
					nLine = bR.readLine();
				}			
			}
			
			closeConnection();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	private void closeConnection() {
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private boolean wantsToDisconect(String nLine) {
		return nLine.equals(STR_DISCON);
	
	}	

	private void sendListOfClients(){
		List<Client> clients = this.server.getListClients();
		
		int length = clients.size();
		DataOutputStream dOS;
		
		try { 
			dOS = new DataOutputStream(client.getOutputStream());
			dOS.writeInt(length);
			dOS.flush();

			if(length != 0) {
				ObjectOutputStream oOS = new ObjectOutputStream(client.getOutputStream());
				oOS.writeObject(clients);
				oOS.flush();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Get the length of the list of clients
		
	}	
	
	
	
	
	public Client getClientData() {
		Client eClient = null;
		int nId = 0;
		DataInputStream dIS;
		DataOutputStream dOS;
		ObjectInputStream oIS;
		
		try {
			dIS = new DataInputStream(client.getInputStream());
			dOS = new DataOutputStream(client.getOutputStream());
			
			nId = dIS.readInt();
			while(!server.isValidId(nId)) {
				dOS.writeBoolean(false);
				dOS.flush();
				
				nId = dIS.readInt(); 
			}
			//Send to server is valid id
			dOS.writeBoolean(true);
			dOS.flush();
			
			//Get the final Object with all his data
			oIS = new ObjectInputStream(client.getInputStream());
			Client nClient = (Client)oIS.readObject();
			
			if(nClient.getId() == nId) { //its the correct client
				nClient.setIp(client.getInetAddress());
				nClient.setPort(ServerConfigurationsNum.WAIT_CLIENT_PORT.getNum());
			}
			else nClient = null;
			
			eClient = nClient;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eClient;		
	}
	
	public void print(String message) {
		System.out.println(message);
	}
	

	
	private boolean isGetListUsers(String nLine) {
		return nLine.equals(TypeConnection.GLU.getMessageConnection());
	}
	
	private boolean isWaitForAnotherClient(String nLine) {
		return nLine.equals(TypeConnection.WOC.getMessageConnection());
	}
	
	private boolean wantsDisconnect(String request) {
		return request.equals(TypeConnection.WD.getMessageConnection());
	}
	

	public boolean isValidId(int id) {
		return this.server.isValidId(id);
		
	}


}
