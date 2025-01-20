package md.range;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import mapa.md.MapaMatrix;
import mapa.md.Posicion;

public class RangeSquareTest {

	@Test
	public void testRectanglePositions5() {
		
		MapaMatrix mapM = new MapaMatrix(5);
		
		Posicion<Integer, Integer> posicion = new Posicion<Integer, Integer>(0, 0);
		List<Posicion<Integer, Integer>> rangedPositions =  RangeSquare.getPositions(posicion, mapM, 4);
		assertTrue(rangedPositions.size()==5*5,"Has the a good length");
		assertTrue(rangedPositions.contains(new Posicion<Integer, Integer>(0,0)),"Contains the position 0.0 ");	
		assertTrue( rangedPositions.contains(new Posicion<Integer, Integer>(2,2)),"Contains the position 1.1 ");
		assertTrue( rangedPositions.contains(new Posicion<Integer, Integer>(0,2)),"Contains the position 0.2 ");
		
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(5,5)),"Not contains the position 5.5 ");
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(-1,-1)),"Not contains the position -1.-1 ");
		
	}
	
	@Test
	public void testRectanglePositionsMiddle5() {
		
		MapaMatrix mapM = new MapaMatrix(5);
		
		Posicion<Integer, Integer> posicion = new Posicion<Integer, Integer>(2, 2);
		List<Posicion<Integer, Integer>> rangedPositions =  RangeSquare.getPositions(posicion, mapM, 1);
		assertTrue(rangedPositions.size()==3*3,"Has the a good length");
		assertTrue(rangedPositions.contains(new Posicion<Integer, Integer>(2,2)),"Contains the position 2.2 ");	
		assertTrue( rangedPositions.contains(new Posicion<Integer, Integer>(1,1)),"Contains the position 1.1 ");
		assertTrue( rangedPositions.contains(new Posicion<Integer, Integer>(3,1)),"Contains the position 3.1 ");
		assertTrue( rangedPositions.contains(new Posicion<Integer, Integer>(1,3)),"Contains the position 1.3 ");
		
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(0,0)),"Not contains the position 0.0 ");
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(0,4)),"Not contains the position 0.4 ");
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(-1,-1)),"Not contains the position -1.-1 ");
		
		
	}

}
