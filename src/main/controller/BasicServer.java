package main.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class BasicServer {
	protected static final boolean DEBUG_MODE = true;
	
	
	public static final int BR_MAGIC_NUMBER = 4096;
	
	public static final int PORT = 55555;
	protected boolean conti;
	
	private ServerSocket serverSocket;
	
	
	public BasicServer() {
		this.conti = true;
		getConnection();
		iniciarServidor();
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
		this.conti= false;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
