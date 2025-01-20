package md.range;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import mapa.md.MapaMatrix;
import mapa.md.Posicion;
import md.range.RangeDiagonal;

public class RangeDiagonalTest {

	@Test
	public void testDiagonalPositions5() {
		
		MapaMatrix mapM = new MapaMatrix(5);
		
		Posicion<Integer, Integer> posicion = new Posicion<Integer, Integer>(0, 0);
		List<Posicion<Integer, Integer>> rangedPositions =  RangeDiagonal.getPositions(posicion, mapM, 2);
		assertTrue(rangedPositions.size()==6,"Has the a good length");
		assertTrue(rangedPositions.contains(new Posicion<Integer, Integer>(0,0)),"Contains the position 0.0 ");	
		assertTrue( rangedPositions.contains(new Posicion<Integer, Integer>(1,1)),"Contains the position 1.1 ");
		assertTrue( rangedPositions.contains(new Posicion<Integer, Integer>(0,2)),"Contains the position 0.2 ");
		
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(-1,0)),"Not contains the position -1.0 ");
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(-1,-1)),"Not contains the position -1.-1 ");
	}
	
	@Test
	public void testDiagonalPositionsMiddle5() {
		
		MapaMatrix mapM = new MapaMatrix(5);
		
		Posicion<Integer, Integer> posicion = new Posicion<Integer, Integer>(2, 2);
		List<Posicion<Integer, Integer>> rangedPositions =  RangeDiagonal.getPositions(posicion, mapM, 2);
		assertTrue(rangedPositions.size()==13,"Has the a good length");
		assertTrue(rangedPositions.contains(new Posicion<Integer, Integer>(2,2)),"Contains the position 2.2 ");	
		assertTrue( rangedPositions.contains(new Posicion<Integer, Integer>(1,1)),"Contains the position 1.1 ");
		assertTrue( rangedPositions.contains(new Posicion<Integer, Integer>(3,1)),"Contains the position 3.1 ");
		assertTrue( rangedPositions.contains(new Posicion<Integer, Integer>(1,3)),"Contains the position 1.3 ");
		
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(0,0)),"Not contains the position 0.0 ");
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(0,4)),"Not contains the position 0.4 ");
		
		
	}

}
