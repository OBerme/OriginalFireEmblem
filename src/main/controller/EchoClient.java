package main.controller;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import main.interfaces.console.CI_ClientStream;

public class EchoClient extends BasicClientSocket {
	//I/O stuff
	protected DataInputStream dIS;
	protected PrintWriter pW;
	
	//To format the message of the server
	private String ip;
	private DateTimeFormatter dtf;
	private int port;
	private InetAddress inetAddressConnect;
	
	public static void main(String[] args) {
		new EchoClient();
	}
	
	public EchoClient() {
		//I/O streams
		this.cCI = new CI_ClientStream(this);
		getConnection();
		getInputOutputs();
		
		//Formats for the message
		dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		this.port = this.clientSocket.getPort();
		this.inetAddressConnect = this.clientSocket.getInetAddress();
		this.cCI.startInterface();
	}
	
	private void getInputOutputs() {
		try {
			this.pW = new PrintWriter(this.clientSocket.getOutputStream());
			this.dIS = new DataInputStream(this.clientSocket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendEcho() {
		this.cCI.print("Give the echo message");
		String echo = this.cCI.getLine();
		sendEcho(echo);
		sendEcho("*");
		
		try {
			echo = this.dIS.readLine();
			this.cCI.print(getFormatMessageEcho(echo));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendEcho(String message) {
		this.pW.println(message);
		this.pW.flush();
	}
	
	
	public void sendMoreEchos() {
		int counter = 0;
		String echo = null;
		boolean contiE = true;
		do {
			this.cCI.print("Give the echo message");
			echo = this.cCI.getLine();
			
			if(echo.equals("*")) 
				contiE = false;
			else
				counter++;
			sendEcho(echo);
				
		}
		while(contiE);
		
		
		String message;
		try {
			for(int i = 0; i < counter; i++) {
				message = this.dIS.readLine();
				this.cCI.print(getFormatMessageEcho(message));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		if(DEBUG_MODE) this.cCI.print("Saliendo del bucle de echos!");
	}
	
	@Override
	protected void close() {
		
		try {
			this.pW.println();
			this.dIS.close();
			this.pW.close();
			
			super.close();//Close superior close
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getFormatMessageEcho(String echo) {
		return "Echo server at " + getServerIpPort() 
		+ " [" + getCurrentTime() + "]: " + echo;
	}
	
	private String getCurrentTime() {
		  return dtf.format(LocalDateTime.now());
	}
	
	private String getServerIpPort() {
		  return this.inetAddressConnect.getHostAddress() + ":" + this.port; 
	}
	
	
}
