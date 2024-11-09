package main.md.mapa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.ln.mapa.INLMapa;
import main.ln.mapa.LNMapaMatrix;
import main.md.ente.Estado;
import main.md.ente.Persona;
import main.md.ente.StateSerVivo;
import main.md.mapa.MapaMatrix;
import main.md.mapa.Posicion;

public class MapaMatrixTest {

	@Test
	public void checkLengthHigh() {
		int length = 3;
		MapaMatrix mapa = new MapaMatrix(length);
		
		assertEquals( mapa.getHigh(),length, "The high its correct");
		assertEquals( mapa.getLength(),length, "The length its correct");
	}
	
	@Test
	public void isPositionEmpty() {
		int length = 2;
		MapaMatrix mapa = new MapaMatrix(length);
		
		Posicion<Integer, Integer> position = new Posicion<Integer, Integer>(1, 1);
		
		assertTrue( mapa.isEmptyPosicion(position), "The position is empty");
	}
	
	@Test
	public void isNotEmptyPosition() {
		int length = 2;
		
		
		MapaMatrix mapa = new MapaMatrix(length);
		INLMapa<Integer, Integer> lnMapa = new LNMapaMatrix(mapa);
		
		Posicion<Integer, Integer> position = new Posicion<Integer, Integer>(1, 1);
		
		Persona nP = new Persona(200, "Ronaldo", new Estado(StateSerVivo.NORMAL));
		lnMapa.moverEnte( nP, position);
		
		assertFalse( mapa.isEmptyPosicion(position), "The position is not empty");
		
		position = new Posicion<Integer, Integer>(0, 0);
		lnMapa.moverEnte(nP, position);
		
		assertFalse( mapa.isEmptyPosicion(position), "The position is not empty");
	}
}
