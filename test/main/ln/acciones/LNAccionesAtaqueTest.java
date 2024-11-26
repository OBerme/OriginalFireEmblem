package main.ln.acciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.ln.mapa.ILNMapaMatrixEntes;
import main.ln.mapa.INLMapa;
import main.ln.mapa.LNMapaMatrix;
import main.ln.mapa.LNMapaMatrixEntes;
import main.md.acciones.ataque.Ataque;
import main.md.acciones.ataque.Tipo;
import main.md.ente.Ente;
import main.md.ente.Estado;
import main.md.ente.IEnteEvents;
import main.md.ente.Persona;
import main.md.ente.StateSerVivo;
import main.md.mapa.MapaMatrix;
import main.md.mapa.Posicion;
import main.md.turner.constants.TurnerEnumConstant;

public class LNAccionesAtaqueTest {

	@Test
	public void testRemovedAtack() {
		
		LNAccionesAtaque lnAcciones = new LNAccionesAtaque(null);
		Ente pers1 = new Persona(200,"Oscar","O", new Estado(StateSerVivo.NORMAL), TurnerEnumConstant.SPEED_DIVIDER.getCost());
		
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
		ILNMapaMatrixEntes lnMapa = new LNMapaMatrixEntes(mapa);
		
		Ente pers1 = new Persona(200,"Oscar","O", new Estado(StateSerVivo.NORMAL), TurnerEnumConstant.SPEED_DIVIDER.getCost());
		Ataque ata1 = new Ataque("PunietazoFUEGOOOO", 200, Tipo.FUEGO);
		
		lnMapa.addEnte(pers1, new Posicion<Integer, Integer>(0, 0));
		
		IEnteEvents[] mapsEntes = {
				(IEnteEvents) lnMapa
		};
		
		LNAccionesAtaque lnAcciones = new LNAccionesAtaque(mapsEntes);
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
