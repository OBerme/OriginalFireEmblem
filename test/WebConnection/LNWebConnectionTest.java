package WebConnection;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;

import WebConnection.XML.GameXmlData;
import WebConnection.XML.Util.EnteStack;
import WebConnection.XML.Util.PositionXmlStack;
import WebConnection.XML.Util.ln.LNXmlStack;
import acciones.ln.LNAccionesAtaque;
import acciones.md.ataque.Ataque;
import acciones.md.ataque.Tipo;
import entes.Estado;
import entes.IEnteEvents;
import entes.ln.ILNEntes;
import entes.ln.LNEntes;
import entes.ln.StateSerVivo;
import entes.md.Ente;
import entes.md.Monstruo;
import entes.md.Persona;
import entes.md.SerVivo;
import mapa.ln.ILNMapaMatrixEntes;
import mapa.ln.IMapIntegerEvents;
import mapa.ln.LNMapaMatrixEntes;
import mapa.md.MapaMatrix;
import mapa.md.Posicion;
import mapa.md.PosicionXml;
import turner.md.enums.TurnerEnumConstant;

public class LNWebConnectionTest {
	
	@Test
	public void testStackEntesAndPositionsChanged() {

		PositionXmlStack posiStack = new PositionXmlStack();
		EnteStack enteStack = new EnteStack();
		LNXmlStack xmlStack = new LNXmlStack(posiStack,enteStack);
		
		
		MapaMatrix mapa = new MapaMatrix(2);
		ILNMapaMatrixEntes lnMapa = new LNMapaMatrixEntes(mapa, new IMapIntegerEvents[] {posiStack});
		
		
		
//		int length = 2;
//		MapaMatrix mapa = new MapaMatrix(length);
//		ILNMapaMatrixEntes lnMapa = new LNMapaMatrixEntes(mapa, new IMapIntegerEvents[] {xmlStack});
		
		IEnteEvents[] lnEnteEvents = new IEnteEvents[]{
				(IEnteEvents)xmlStack //added the stack to get record the game
		};
		
		SerVivo osqui = new Persona(200, "Oscar", "O", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost());
		List<Ente> entes = new ArrayList<Ente>();
		for(SerVivo nServivo : new SerVivo[] {
				osqui,
				new Monstruo(1500, "Undyne", "U", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost()),
		}) {
			
			entes.add(nServivo);	
		}
		
		lnMapa.moverEnte(osqui, new Posicion<Integer, Integer>(0, 0));
		
		ILNEntes lnEntes = new LNEntes(lnEnteEvents, entes); 
		
		
		
		LNAccionesAtaque lnAccionesAtaque = new LNAccionesAtaque(lnEntes);
		lnAccionesAtaque.appendAtaque(entes.get(0), new Ataque("punie", 400000, Tipo.AGUA));
		lnAccionesAtaque.doAtacks(); //kill the ente
		
		List<Ente> entesXml = xmlStack.getEntes();
		List<PosicionXml> positionsXml = xmlStack.getPositionsXml();
		
		assertEquals(entesXml.size(), 1, "The list of entes is empty!");
		assertEquals(positionsXml.size(), 1, "The list of positions is empty!");	
	}
	
	
	
	

}
