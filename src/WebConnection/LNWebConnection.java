package WebConnection;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import WebConnection.XML.GameXmlData;
import WebConnection.XML.XMLParser;
import WebConnection.XML.Util.ln.LNXmlStack;
import WebUtil.GameServer;
import entes.IEnteEvents;
import entes.ln.ILNEntes;
import entes.md.Ente;
import mapa.ln.ILNMapaMatrixEntes;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.md.PosicionXml;
import mapa.md.PositionTransformer;
import player.md.Player;
import turner.md.IGameEvent;
import turner.md.Turnable;

@objid ("0bdacb02-eacb-42de-991d-cd2f6c185712")
public class LNWebConnection implements Turnable, IGameEvent{
	
	//to control the modifications of the map
	private ILNMapaMatrixEntes mapaEntes;
	private ILNEntes lnEntes;
	
	
	private LNXmlStack stack;
	private static final int BUFFER_SIZE = 2048;
	
	private DataInputStream dIS;
	private DataOutputStream dOS;
	
	private static final String DF_FILE_NAME = "tmpGameData";
	private Player rival;

	@objid ("91ac6059-7837-4e75-a906-8dd46eea112c")
    private Socket socket;
	
	
    public LNWebConnection(ILNMapaMatrixEntes mapaEntes, ILNEntes lnEntes, LNXmlStack stack, 
    		Socket socket, Player player) {
		super();
		this.mapaEntes = mapaEntes;
		this.lnEntes = lnEntes;
		this.stack = stack;
		this.socket = socket;
		this.rival = player;
		
		try {
			this.dIS = new  DataInputStream(socket.getInputStream());
			this.dOS = new  DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


    //Pre: the stack should have something to send
	//Post:
    private void sendGameXmlData() {
    	try {
    		boolean wantSkip = !stack.hasSomething();
    		dOS.writeBoolean(wantSkip);
    		dOS.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	if(stack.hasSomething()) { //if the player dind't skip
    		GameXmlData gameXml =  new GameXmlData(stack.getEntes(), stack.getPositionsXml());
        	XMLParser.saveGameXmlData(gameXml, getSaveFileName());
        	File xmlFile = new File(getSaveFileName());
        	if(xmlFile.exists()) {
        		sendFile(xmlFile);	
        	}
    	}
    	//else will not send nothing
    	
    }
    
    private String getSaveFileName() {
    	return DF_FILE_NAME + rival.getName() + ".xml";
    }
    
	//Pre: the stack should have something to send
	//Post:
      public void turnOtherPlayer() {
    	  
      	try {
      		boolean wantsSkip = dIS.readBoolean();
      		if(!wantsSkip) { //if the player dind't skip
          		GameXmlData gameXml =  getGameXmlData();
          		doActions(gameXml);
          	}
          	//else will not send nothing
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
      }
      
      private void doActions(GameXmlData gameXml) {
    	  
    	  //change the positions
    	  for(PosicionXml nPosition : gameXml.getMovedEntes()) {
    		  mapaEntes.moverEnte(lnEntes.getEnte(nPosition.getEnte()), PositionTransformer.getPosicion(nPosition));
    	  }
    	  
    	  for(Ente nEnte : gameXml.getDamagedEntes()) {
    		  lnEntes.changeEnte(nEnte);
    	  }  
      }
      
      //Pre:---
      //Post: it will return null if something went wrong, the GameXmlData if all goes good
      private GameXmlData getGameXmlData() {
    	  downloadXmlFile();
    	  File file = new File(getSaveFileName());
    	  if(file.exists()) {
    		  return XMLParser.getGameXmlData(getSaveFileName());
    	  }
    	  return null;
      }
    

	private void downloadXmlFile() {		
		
		try (FileOutputStream fOS = new FileOutputStream(new File(getSaveFileName()))){
			long size = dIS.readLong();
			
	        if (size <= 0) {
	            System.out.println("El tamaño del archivo no es válido o el archivo no existe.");
	            return;
	        }

	        // Definir un búfer constante de tamaño razonable (2 KB en este caso)
	        byte[] buffer = new byte[(int) Math.min(BUFFER_SIZE, size)];
	        
	        int length=0;
	        long remainingSize = size;

	        // Leer el archivo por bloques usando el búfer
	        while (remainingSize > 0 && length != -1) {
	        	length = dIS.read(buffer, 0, (int) Math.min(BUFFER_SIZE, remainingSize));
	            fOS.write(buffer,0, (int) Math.min(BUFFER_SIZE, remainingSize));
	            // Actualizar el tamaño restante del archivo
	            remainingSize -= length;
	        }
	        
	        fOS.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Pre: The file should exists
	//Post it will send the length of the file and the file throw internet
	public void sendFile(File file) {
		 try {
			 
	            long length = file.length();
	            dOS.writeLong(length);  // Enviar el tamaño del archivo
	            dOS.flush();

	            byte[] buffer =  new byte[(int)Math.min(length, BUFFER_SIZE)];
	            try (FileInputStream fIS = new FileInputStream(file)) {
	            	int readed = fIS.read(buffer);
	                while (readed != -1 && length >0) {
	                	
	                	
						dOS.write(buffer, 0 , (int)Math.min(length, BUFFER_SIZE));
						
						readed = fIS.read(buffer,0,(int)Math.min(length, BUFFER_SIZE));
						length -= readed;
	                }
	                dOS.flush();
	            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void doTurn() {
		System.out.print("Waiting for the player...");
		sendGameXmlData(); //sends to other client the information
		turnOtherPlayer(); //Change the map with the actions of the other player
		
	}
	
	
	
	private void closeConnections() {
		try {
			dIS.close();
			dOS.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	@Override
	public void skipTurn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGameEnds() {
		sendGameXmlData(); //sends to other client the information
		closeConnections();
	}
    
    
    
}