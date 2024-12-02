package WebConnection.XML.Util.ln;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import WebConnection.XML.Util.EnteStack;
import WebConnection.XML.Util.PositionStack;
import WebConnection.XML.Util.PositionXmlStack;
import acciones.ln.LNAccionesAtaque;
import acciones.md.ataque.Ataque;
import acciones.md.ataque.Tipo;
import entes.Estado;
import entes.IEnteEvents;
import entes.ln.ILNEntes;
import entes.ln.LNEntes;
import entes.ln.StateSerVivo;
import entes.md.Ente;
import entes.md.Persona;
import mapa.ln.ILNMapaMatrixEntes;
import mapa.ln.IMapEvents;
import mapa.ln.IMapIntegerEvents;
import mapa.ln.LNMapaMatrixEntes;
import mapa.md.MapaMatrix;
import mapa.md.Posicion;
import turner.md.enums.TurnerEnumConstant;

class LNXmlStackTest {

	@Test
	void testGetEnteStack() {
		int length = 2;
		MapaMatrix mapa = new MapaMatrix(length);
		ILNMapaMatrixEntes lnMapa = new LNMapaMatrixEntes(mapa,new IMapIntegerEvents[0]);
		
		Ente pers1 = new Persona(200,"Oscar","O", new Estado(StateSerVivo.NORMAL), TurnerEnumConstant.SPEED_DIVIDER.getCost());
		List<Ente> entes = new ArrayList<Ente>();
		entes.add(pers1);
		
		Ataque ata1 = new Ataque("PunietazoFUEGOOOO", 200, Tipo.FUEGO);
		
		PositionXmlStack posiStack = new PositionXmlStack();
		EnteStack enteStack = new EnteStack();
		LNXmlStack xmlStack = new LNXmlStack(posiStack,enteStack);
				
		lnMapa.addEnte(pers1, new Posicion<Integer, Integer>(0, 0));
		
		IEnteEvents[] iEnteEvents = {
				(IEnteEvents) xmlStack
		};
		
		ILNEntes lnEntes = new LNEntes(iEnteEvents, entes);
		
		LNAccionesAtaque lnAcciones = new LNAccionesAtaque(lnEntes);
		lnAcciones.appendAtaque(pers1, ata1);
		lnAcciones.appendAtaque(pers1, ata1);
		
		lnAcciones.doAtacks();
		
		assertTrue( xmlStack.getEntes().size() != 0, "The entes Stack is empty" );
		
	}
	
	@Test
	void testGetPositionStack() {
		int length = 2;
		
		PositionXmlStack posiStack = new PositionXmlStack();
		EnteStack enteStack = new EnteStack();
		LNXmlStack xmlStack = new LNXmlStack(posiStack,enteStack);
		
		IMapIntegerEvents[] iMapEvents =  {
				(IMapIntegerEvents)xmlStack
		};
		
		MapaMatrix mapa = new MapaMatrix(length);
		ILNMapaMatrixEntes lnMapa = new LNMapaMatrixEntes(mapa, iMapEvents);
		
		Ente pers1 = new Persona(200,"Oscar","O", new Estado(StateSerVivo.NORMAL), TurnerEnumConstant.SPEED_DIVIDER.getCost());
		
		lnMapa.addEnte(pers1, new Posicion<Integer, Integer>(0, 0));
		lnMapa.moverEnte(pers1, new Posicion<Integer, Integer>(1, 1));
		
		assertTrue( xmlStack.getPositionsXml().size() == 1, "The position Stack has more positions!" );
		
	}

}
