package WebConnection;

import static org.junit.jupiter.api.Assertions.*;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

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
import group.ln.LNGroup;
import group.md.Group;
import mapa.ln.ILNMapaMatrixEntes;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.ln.IMapIntegerEvents;
import mapa.ln.LNMapaMatrixEntes;
import mapa.md.MapaMatrix;
import pl.PL_ConsoleGamePlayerController;
import player.ln.LNPlayer;
import player.md.Player;
import turner.ln.LNTurner;
import turner.md.IGameEvent;
import turner.md.Turnable;
import turner.md.Turner;
import turner.md.enums.TurnerEnumConstant;

class LNWebConnectionTest {
	
	@Test
	public void testEntesDamaged() {
		
		PositionXmlStack posiStack = new PositionXmlStack();
		EnteStack enteStack = new EnteStack();
		LNXmlStack xmlStack = new LNXmlStack(posiStack,enteStack);
		
//		int length = 2;
//		MapaMatrix mapa = new MapaMatrix(length);
//		ILNMapaMatrixEntes lnMapa = new LNMapaMatrixEntes(mapa, new IMapIntegerEvents[] {xmlStack});
		
		IEnteEvents[] lnEnteEvents = new IEnteEvents[]{
				(IEnteEvents)xmlStack //added the stack to get record the game
		};
		
		List<Ente> entes = new ArrayList<Ente>();
		for(SerVivo nServivo : new SerVivo[] {
				new Persona(200, "Oscar", "O", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost()),
				new Monstruo(1500, "Undyne", "U", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost()),
		}) {
			
			entes.add(nServivo);	
		}
		
		ILNEntes lnEntes = new LNEntes(lnEnteEvents, entes); 
		
		
		LNAccionesAtaque lnAccionesAtaque = new LNAccionesAtaque(lnEntes);
		lnAccionesAtaque.appendAtaque(entes.get(0), new Ataque("punie", 400000, Tipo.AGUA));
		lnAccionesAtaque.doAtacks(); //kill the ente
		
		List<Ente> entesXml = xmlStack.getEntes();
		
		assertEquals(entesXml.size(), 1, "The list of entes is empty!");
		
	}

}
