package md.range;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import mapa.md.MapaMatrix;
import mapa.md.Posicion;
import md.range.RangeRectangle;

public class RangeRectangleTest {

	@Test
	public void testRectanglePositions5() {
		
		

		MapaMatrix mapM = new MapaMatrix(5);
		
		Posicion<Integer, Integer> posicion = new Posicion<Integer, Integer>(0, 0);
		List<Posicion<Integer, Integer>> rangedPositions =  RangeRectangle.getPositions(posicion, mapM, 1,2);
		assertTrue(rangedPositions.size()==6,"Has the a good length");
		assertTrue(rangedPositions.contains(new Posicion<Integer, Integer>(1,2)),"Contains the position 1,2 ");	
		assertTrue( rangedPositions.contains(new Posicion<Integer, Integer>(0,1)),"Contains the position 0,1 ");
		assertTrue( rangedPositions.contains(new Posicion<Integer, Integer>(0,0)),"Contains the position 0,0 ");
		
		
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(0,3)),"Not contains the position 0,3 ");
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(2,0)),"Not contains the position 2,0 ");
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(-1,-1)),"Not contains the position -1.-1 ");
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(2,2)),"Not contains the position 2,2 ");

		
	}
	
	@Test
	public void testRectanglePositionsMiddle5() {
		MapaMatrix mapM = new MapaMatrix(5);
		Posicion<Integer, Integer> posicion = new Posicion<Integer, Integer>(2, 2);
		List<Posicion<Integer, Integer>> rangedPositions =  RangeRectangle.getPositions(posicion, mapM, 1, 2);
		assertTrue(rangedPositions.size()==15,"Has the a good length");
		assertTrue(rangedPositions.contains(new Posicion<Integer, Integer>(1,1)),"Contains the position 1.1 ");	
		assertTrue( rangedPositions.contains(new Posicion<Integer, Integer>(2,4)),"Contains the position 1.1 ");
		assertTrue( rangedPositions.contains(new Posicion<Integer, Integer>(3,4)),"Contains the position 0.2 ");
		
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(4,4)),"Not contains the position 5.5 ");
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(-1,-1)),"Not contains the position -1.-1 ");
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(0,0)),"Not contains the position 0,0 ");
		assertFalse( rangedPositions.contains(new Posicion<Integer, Integer>(0,1)),"Not contains the position 0,1 ");
		
	}

}
