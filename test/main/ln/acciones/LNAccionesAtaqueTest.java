package main.ln.acciones;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import acciones.ln.AtaqueDecorator;
import acciones.ln.IAtaqueDeterminista;
import acciones.ln.IAtaqueNoDeterminista;
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
import mapa.ln.INLMapa;
import mapa.ln.LNMapaMatrix;
import mapa.ln.LNMapaMatrixEntes;
import mapa.md.MapaMatrix;
import mapa.md.Posicion;
import turner.md.enums.TurnerEnumConstant;

public class LNAccionesAtaqueTest {

	@Test
	public void testRemovedAtack() {
		ILNEntes lnEntes = new LNEntes(null, null);
		
		LNAccionesAtaque lnAcciones = new LNAccionesAtaque(null);
		Ente pers1 = new Persona(200,"Oscar","O", new Estado(StateSerVivo.NORMAL), TurnerEnumConstant.SPEED_DIVIDER.getCost());
		lnEntes.addEnte(pers1);
		
		Ataque ata1 = new Ataque("PunietazoFUEGOOOO", 200, Tipo.FUEGO);
		
		lnAcciones.appendAtaque(pers1, ata1);
		lnAcciones.appendAtaque(pers1, ata1);
		int totalDamage = lnAcciones.getAtacks(pers1).getDamage();
		
		assertEquals(totalDamage,ata1.getDamage()*2, "The damage is 400");
		
		lnAcciones.appendAtaque(pers1, ata1);
		Ataque ata2 = new Ataque("PunietazoAGUAAA", 200, Tipo.AGUA);
		lnAcciones.appendAtaque(pers1, ata2);
		
		
		lnAcciones.removeAtaque(pers1, ata2);
		
		AtaqueDecorator ataqueDecorator = lnAcciones.getAtacks(pers1);
		IAtaqueNoDeterminista iAND = (IAtaqueNoDeterminista) ataqueDecorator;
		
		assertEquals( iAND.getAtaque1(),ata1, "The atack is removed");
		
		lnAcciones.removeAtaque(pers1, ata1);
		
		ataqueDecorator = lnAcciones.getAtacks(pers1);
		
		assertEquals( getNumAtacks(ataqueDecorator) ,2, "The num of atacks are 3");
		
		
	}
	
	@Test
	public void testOnEnteDiesMap() {
		int length = 2;
		
		MapaMatrix mapa = new MapaMatrix(length);
		ILNMapaMatrixEntes lnMapa = new LNMapaMatrixEntes(mapa, new IMapIntegerEvents[0]);
		
		Ente pers1 = new Persona(200,"Oscar","O", new Estado(StateSerVivo.NORMAL), TurnerEnumConstant.SPEED_DIVIDER.getCost());
		List<Ente> entes = new ArrayList<Ente>();
		entes.add(pers1);
		
		Ataque ata1 = new Ataque("PunietazoFUEGOOOO", 200, Tipo.FUEGO);
		
		lnMapa.addEnte(pers1, new Posicion<Integer, Integer>(0, 0));
		
		IEnteEvents[] iEnteEvents = {
				(IEnteEvents) lnMapa
		};
		
		ILNEntes lnEntes = new LNEntes(iEnteEvents, entes);
		
		LNAccionesAtaque lnAcciones = new LNAccionesAtaque(lnEntes);
		lnAcciones.appendAtaque(pers1, ata1);
		lnAcciones.appendAtaque(pers1, ata1);
		
		lnAcciones.doAtacks();
		boolean isEnteInMap = lnMapa.isEnteInMap(pers1);
		
		assertFalse( isEnteInMap, "Ente is not in the map because is died" );
		
	}
	
	
	private int getNumAtacks(AtaqueDecorator node) {
    	if(node instanceof IAtaqueDeterminista) {
    		return  1;
    	}
    		
    	else { //Not determinista
    		IAtaqueNoDeterminista iAtaNDeter = (IAtaqueNoDeterminista) node;
			return 1 + getNumAtacks(iAtaNDeter.getAtaque2());
    	}
    }

}
