package WebUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import WebUtil.controller.enums.ServerConfigurationsNum;

public abstract class BasicServer {
	protected static final boolean DEBUG_MODE = true;
	
	public static final int PORT = ServerConfigurationsNum.SERVER_PORT.getNum();
	protected boolean conti;
	
	private ServerSocket serverSocket;
	
	
	public BasicServer() {
		this.conti = true;
		
	}
	
	
	protected void getConnection() {
		try {
			
			this.serverSocket = new ServerSocket(PORT);
			if(DEBUG_MODE) print("Servidor iniciado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public void iniciarServidor() {
		while(conti) {
			try {
				Socket clientSocket = serverSocket.accept();
				procesarCliente(clientSocket); //Procesamos peticion
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				close();
			}
		}
		//Close the server
		
	}
	protected abstract void procesarCliente(Socket clientSocket);
	
	protected void print(String message) {
		System.out.println(message);
	}
	
	protected void close() {	
		if(DEBUG_MODE) print("Servidor shutting down");
		this.conti= false;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
