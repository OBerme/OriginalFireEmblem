package main.controller;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoServer extends BasicServer {
	private DataInputStream dIS;
	private PrintWriter pW;
	
	public static void main(String[] args) {
		new EchoServer();
	}
	
	public EchoServer() {
		super(); //Creates the connection
	}

	protected void procesarCliente(Socket clientSocket) {
		try {
			dIS = new DataInputStream(clientSocket.getInputStream());
			pW = new PrintWriter(clientSocket.getOutputStream());
			int counter = 0;
			
			String echo = null;
			while( (echo = dIS.readLine()) != null &&
					!echo.equals("*") ){
				if(DEBUG_MODE) print("Se ha recibido: " + echo);
				pW.println(echo);
			}
			pW.flush();
			
			
			close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	protected void close() {
		try {
			dIS.close();
			pW.close();
			super.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
