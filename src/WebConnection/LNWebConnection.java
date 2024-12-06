package WebConnection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
	
	
	private DataInputStream dIS;
	private DataOutputStream dOS;
	
	private static final String DF_FILE_NAME = "tmpGameData.xml";
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
    		dOS.writeBoolean(stack.hasSomething());
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
    	return DF_FILE_NAME + rival.getName();
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
    		  mapaEntes.moverEnte(nPosition.getEnte(), PositionTransformer.getPosicion(nPosition));
    	  }
    	  
    	  for(Ente nEnte : gameXml.getDamagedEntes()) {
    		  lnEntes.onEnteChangeHp(nEnte);
    	  }  
      }
      
      //Pre:---
      //Post: it will return null if something went wrong, the GameXmlData if all goes good
      private GameXmlData getGameXmlData() {
    	  downloadXmlFile();
    	  File file = new File(getSaveFileName());
    	  if(file.exists()) {
    		  return XMLParser.getGameXmlData(DF_FILE_NAME);
    	  }
    	  return null;
      }
    

	private void downloadXmlFile() {		
		
		try {
			long size = dIS.readLong();
			OutputStream oS = new FileOutputStream(new File(getSaveFileName()));
	        if (size <= 0) {
	            System.out.println("El tamaño del archivo no es válido o el archivo no existe.");
	            return;
	        }

	        // Definir un búfer constante de tamaño razonable (2 KB en este caso)
	        byte[] buffer = new byte[2048];
	        int length;
	        long remainingSize = size;

	        // Leer el archivo por bloques usando el búfer
	        while (remainingSize > 0) {
	            length = dIS.read(buffer, 0, (int) Math.min(buffer.length, remainingSize));
	            oS.write(buffer,0, (int) Math.min(buffer.length, remainingSize));
	            
	            if (length == -1) {
	                System.out.println("Se alcanzó el final del flujo antes de completar la descarga.");
	                break; // Salir del bucle si no hay más datos que leer
	            }

	            // Actualizar el tamaño restante del archivo
	            remainingSize -= length;

	            // Procesar los datos leídos (por ejemplo, escribir en un archivo, etc.)
	            // Aquí solo imprimimos la longitud de los datos leídos
	            System.out.println("Leídos " + length + " bytes, restante: " + remainingSize + " bytes.");

	            // Puedes añadir aquí la lógica para escribir los bytes a un archivo si es necesario
	        }
			oS.flush();
			oS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Pre: The file should exists
	//Post it will send the length of the file and the file throw internet
	private void sendFile(File file) {
		 try {
			 
	            long length = file.length();
	            dOS.writeLong(length);  // Enviar el tamaño del archivo
	            dOS.flush();

	            // Enviar el contenido del archivo utilizando un búfer de bytes
	            byte[] buffer = new byte[2048];  // Tamaño del búfer fijo
	            int bytesRead;

	            try (FileInputStream fis = new FileInputStream(file)) {
	                while ((bytesRead = fis.read(buffer)) != -1) {
						dOS.write(buffer, 0, bytesRead);
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
