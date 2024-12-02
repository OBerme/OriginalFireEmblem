package WebUtil;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import WebUtil.controller.enums.ServerConfigurationsNum;

public abstract class BasicClientSocket extends Thread {
	
	protected  static final boolean DEBUG_MODE = true;
	protected Socket clientSocket;
	protected InetAddress ip; 
	protected int port = ServerConfigurationsNum.SERVER_PORT.getNum();
	
	public BasicClientSocket() {
		try {
			this.ip = InetAddress.getLocalHost();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		getConnection();
	}
	
	public void start() {
		getConnection();
	}
	
	//Pre: The interface should be created before start this method
	protected void getConnection() {
		try {
			this.clientSocket = new Socket(ip, port) ;
			
			onConnection();
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
	
	protected abstract void onConnection();
	
}

