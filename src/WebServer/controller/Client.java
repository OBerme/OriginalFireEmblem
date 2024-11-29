package WebServer.controller;

import java.io.Serializable;
import java.net.InetAddress;

public class Client implements Serializable{
	private int id;
	private InetAddress ip;
	private String name;
	private int port;
	
	public Client(int id) {
		this.id = id;
	}
	
	public Client(int id, String name) {
		this(id, null, name);
		
	}

	public Client(int id, InetAddress ip, String name) {
		super();
		this.id = id;
		this.ip = ip;
		this.name = name;
	}
	


	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getId() {
		return id;
	}


	public InetAddress getIp() {
		return ip;
	}

	public void setIp(InetAddress ip) {
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Client) {
			Client cObj = (Client) obj;
			return cObj.getId() == this.getId();
		}

		return false;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id" + this.id + ",name: "+ this.name + ",ip:" + this.ip;
	}
	
	
	

}
