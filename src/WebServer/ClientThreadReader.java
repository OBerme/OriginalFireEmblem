package WebServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import WebServer.controller.enums.ServerConfigurationsNum;
import WebServer.controller.enums.TypeConnection;

public class ClientThreadReader extends Thread{
	private DataInputStream dataInputStream;
	private boolean disconect;  
	private ChatClient chatClient;
    // Constructor que recibe un socket y crea el DataInputStream
    public ClientThreadReader(Socket socket,ChatClient chatClient) {
        try {
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.disconect = false;
            this.chatClient = chatClient;
            
        } catch (IOException e) {
            System.err.println("Error al crear el DataInputStream: " + e.getMessage());
        }
    }
    
 // Método run() que se ejecutará cuando el thread empiece
    @Override
    public void run() {
        try {
            String message;
            // Leer continuamente los mensajes del DataInputStream
            while (!disconect) {
                message = dataInputStream.readLine(); // Lee un mensaje de tipo UTF
                if(message == null || message.equals(TypeConnection.WD.getMessageConnection())) {
                	disconect = true;
                	System.out.println("The other user wants to quit the conversation");
                }
                else
                	System.out.println("Mensaje recibido: " + message);
            }
            this.chatClient.onDisconnect();
            
        } catch (IOException e) {
            System.err.println("Error al leer del socket: " + e.getMessage());
        } 
    }
    
    
    public void onStop() {
    	this.disconect = true;
    }
}
