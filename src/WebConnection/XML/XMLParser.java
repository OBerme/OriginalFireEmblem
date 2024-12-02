package WebConnection.XML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import entes.Estado;
import entes.StateSerVivo;
import entes.md.Ente;
import entes.md.Persona;
import mapa.md.Posicion;
import mapa.md.PosicionXml;
import turner.md.enums.TurnerEnumConstant;

public class XMLParser {
	private static final String ROOT_ENTES_NODE = "damagedEntes";
	private static final String ROOT_POSITIONS_NODE = "movedEntes";
	private DocumentBuilderFactory dbf;
	private DocumentBuilder builder;

	public XMLParser() {
		super();
		dbf = DocumentBuilderFactory.newInstance();
		try {
			builder = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public static void saveGameXmlData(GameXmlData gameXml, String fileName) {
		try {
			JAXBContext context = JAXBContext.newInstance(GameXmlData.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(gameXml, new File(fileName));
		} catch (JAXBException e) {e.printStackTrace();}
	}
	
	//Pre: The file should exists 
	//Post: The GameXmlData will be null if something happend, else it will filled with the data 
	public static GameXmlData getGameXmlData( String fileName) {
		try {
			JAXBContext context = JAXBContext.newInstance(GameXmlData.class);
			Unmarshaller um = context.createUnmarshaller();
			FileReader file = new FileReader(fileName);
			GameXmlData gameData = (GameXmlData) um.unmarshal(file);
			
			return gameData;
		}
		catch (JAXBException | FileNotFoundException e) {e.printStackTrace();}
		return null;
	}
//	
//	//Pre: The file should exists and should be a xml file 
//	//Post: It will return a list of entes, empty if ins't some ente in the file 
//	public List<Ente> getEntes(File file) {
//		List<Ente> entes = new ArrayList<Ente>();
//		try {
//			DocumentBuilder builder = dbf.newDocumentBuilder();
//			Document doc =  builder.parse(file);
//			
//			// Elemento raíz
//			Element root =  doc.getDocumentElement();
//			
//			
//			NodeList itemList = doc.getElementsByTagName(ROOT_ENTES_NODE);
//			Element rootEntesNode = (Element) itemList.item(0);
//			NodeList enteList = rootEntesNode.getElementsByTagName("ente");
//			
//			for (int i = 0; i < enteList.getLength(); i++) {
//				 Node itemNodeEnte = enteList.item(i);
//				 if (itemNodeEnte.getNodeType() == Node.ELEMENT_NODE) {
//	                   	Ente nEnte = getEntFromeNode(itemNodeEnte);
//	                    entes.add(nEnte);
//	                    
//				 }
//			}
//			
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SAXException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// Parseo el fichero para conseguir el árbol DOM
//		
//		
//		return entes;
//	}
//	
//		//Pre: The file should exists and should be a xml file 
//		//Post: It will return a list of positions moved, empty if ins't some ente in the file 
//		public List<PosicionXml> getPositions(File file) {
//			List<PosicionXml> posiciones = new ArrayList<PosicionXml>();
//			try {
//				DocumentBuilder builder = dbf.newDocumentBuilder();
//				Document doc =  builder.parse(file);
//				
//				// Elemento raíz
//				Element root =  doc.getDocumentElement();
//				
//				
//				NodeList itemList = doc.getElementsByTagName(ROOT_POSITIONS_NODE);
//				
//				
//				for (int i = 0; i < itemList.getLength(); i++) {
//					 Node itemNode = itemList.item(i);
//					 if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
//						 posiciones.add(getPosicion(itemNode));
//					 }
//				}
//				
//			} catch (ParserConfigurationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SAXException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			return posiciones;
//		}
//		
//		//Pre: the rootNode should be an element
//		//Post: It will return a ente with the hp and id 
//		private Ente getEntFromeNode(Node rootNode) {
//			 Element itemElement = (Element) rootNode;
//             int hp = Integer.parseInt(itemElement.getElementsByTagName("hp").item(0).getTextContent());
//             int numb= Integer.parseInt(itemElement.getElementsByTagName("numb").item(0).getTextContent());
//             Ente nEnte = new Ente(numb);
//             nEnte.setHp(hp);
//             return nEnte;
//		}
//		
//		
//		//Pre: the rootNode should be an element
//		//Post: It will return a position with an ente inside
//		private PosicionXml getPosicion(Node rootNode){
//			Element rootElement = (Element)rootNode;
//			
//			 int x = Integer.parseInt(rootElement.getElementsByTagName("x").item(0).getTextContent());
//	         int y = Integer.parseInt(rootElement.getElementsByTagName("y").item(0).getTextContent());
//	         Node enteNode = rootElement.getElementsByTagName("ente").item(0);
//	         Ente ente = null;
//	         if (enteNode.getNodeType() == Node.ELEMENT_NODE) {
//	        	 ente = getEntFromeNode(enteNode);
//	         }
//	         return new PosicionXml(x,y,ente);
//		}
}
