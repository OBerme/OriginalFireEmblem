package main.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import main.interfaces.console.CI_ClientStream;

public abstract class BasicClientSocket {
	
	protected  static final boolean DEBUG_MODE = true;
	protected Socket clientSocket;
	protected  CI_ClientStream cCI;
	
	//Pre: The interface should be created before start this method
	protected void getConnection() {
		try {
			this.clientSocket = new Socket(InetAddress.getLocalHost(), BasicServer.PORT) ;
			
			if(DEBUG_MODE ) this.cCI.print("Conexion iniciada");			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	protected void close() {
		try {
			this.clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

