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

import eje5.Noticia;
import entes.Estado;
import entes.StateSerVivo;
import entes.md.Ente;
import entes.md.Persona;
import mapa.md.PosicionXml;
import turner.md.enums.TurnerEnumConstant;

public class XMLParser {

	public static void saveGameXmlData(GameXmlData gameXml) {
		try {
			JAXBContext context = JAXBContext.newInstance(GameXmlData.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(gameXml, new File("tmpGameData.xml"));
		} catch (JAXBException e) {e.printStackTrace();}
	}
	
	public static void getEntes(File file) {
		URL url;
		
		try {

			url = new URL("https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/portada");
			URLConnection connection = url.openConnection();
			// TODO Auto-generated method stub
		
			// Consigo el constructor de documentos (JAXP)
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			
			  BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	          PrintWriter pWriter = new PrintWriter(new File("RSS.xml"));
	          String inputLine;
	
	          while ((inputLine = in.readLine()) != null) {
	        	  pWriter.println(inputLine);
	          }
	          pWriter.flush();
	          in.close();
			
	          
			builder = dbf.newDocumentBuilder();
			File file = new File("RSS.xml");
			
			Document doc =  builder.parse(file);
			
			// Elemento raíz
			Element root =  doc.getDocumentElement();
			System.out.println("Nombre del elemento raíz: "+root.getNodeName());
			
			NodeList itemList = doc.getElementsByTagName("item");
			List<Noticia> noticias = new ArrayList<Noticia>();
			for (int i = 0; i < 3; i++) {
				 Node itemNode = itemList.item(i);
				 if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
	                    Element itemElement = (Element) itemNode;
	                    String title = itemElement.getElementsByTagName("title").item(0).getTextContent();
	                    String pubDate = itemElement.getElementsByTagName("pubDate").item(0).getTextContent();

	                    System.out.println("Titulo " + title);
				 }
				
			}
			
//			Pizza pizza = new Pizza(root.getAttribute("nombre"), Float.parseFloat( root.getAttribute("precio")) );
//			
//		
//			pizza.setOferta(root.getElementsByTagName("oferta").getLength() != 0);//has oferta 
//		
//			NodeList ingredientes  = root.getElementsByTagName("ingredientes");
//			if(ingredientes.getLength() != 0) {
//				Node ingredientesNode = ingredientes.item(0);
//				
//				NodeList nodeList = ((Element)ingredientesNode).getElementsByTagName("ingrediente");
//				
//				for(int i = 0; i <  nodeList.getLength(); i++) {// if has ingredientes
//					Node nNode = nodeList.item(i);
//					pizza.addIngrediente(nNode.getTextContent());
//					
//				}
//			}
//			System.out.println(pizza);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Parseo el fichero para conseguir el árbol DOM
		
		
		
		
	}
}
