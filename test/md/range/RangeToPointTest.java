package md.range;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import mapa.md.IMapa;
import mapa.md.IPosition;
import mapa.md.MapaMatrix;
import mapa.md.Posicion;

public class RangeToPointTest {

	@Test
	public void testXRangePositions() {
		int length = 5;
		IMapa<Integer, Integer> mapa = new MapaMatrix(length);
		IPosition<Integer, Integer> sPosi = new Posicion<Integer, Integer>(0, 0);
		IPosition<Integer, Integer> fPosi = new Posicion<Integer, Integer>(3, 0);
		
		List<IPosition<Integer, Integer>> cPositions = new ArrayList<IPosition<Integer,Integer>>();
		cPositions.add(sPosi);
		cPositions.add(new Posicion<Integer, Integer>(1, 0));
		cPositions.add(new Posicion<Integer, Integer>(2, 0));
		cPositions.add(fPosi);
		
		
		List<IPosition<Integer, Integer>> positions = RangeToPoint.getPositions(sPosi, fPosi, mapa);
		
		for(IPosition<Integer, Integer> nPosi : cPositions) {
			assertTrue( positions.contains(nPosi), "Dosen't contain the position");	
		}
		
		
	}
	
	@Test
	public void testXInverseRangePositions() {
		int length = 5;
		IMapa<Integer, Integer> mapa = new MapaMatrix(length);
		IPosition<Integer, Integer> sPosi = new Posicion<Integer, Integer>(3, 0);
		IPosition<Integer, Integer> fPosi = new Posicion<Integer, Integer>(0, 0);
		
		List<IPosition<Integer, Integer>> cPositions = new ArrayList<IPosition<Integer,Integer>>();
		cPositions.add(sPosi);
		cPositions.add(new Posicion<Integer, Integer>(1, 0));
		cPositions.add(new Posicion<Integer, Integer>(2, 0));
		cPositions.add(fPosi);
		
		
		List<IPosition<Integer, Integer>> positions = RangeToPoint.getPositions(sPosi, fPosi, mapa);
		
		for(IPosition<Integer, Integer> nPosi : cPositions) {
			assertTrue( positions.contains(nPosi), "Dosen't contain the position");	
		}
		
		
	}
	
	@Test
	public void testYRangePositions() {
		int length = 5;
		IMapa<Integer, Integer> mapa = new MapaMatrix(length);
		IPosition<Integer, Integer> sPosi = new Posicion<Integer, Integer>(0, 0);
		IPosition<Integer, Integer> fPosi = new Posicion<Integer, Integer>(0, 3);
		
		List<IPosition<Integer, Integer>> cPositions = new ArrayList<IPosition<Integer,Integer>>();
		cPositions.add(sPosi);
		cPositions.add(new Posicion<Integer, Integer>(0, 1));
		cPositions.add(new Posicion<Integer, Integer>(0, 2));
		cPositions.add(fPosi);
		
		
		List<IPosition<Integer, Integer>> positions = RangeToPoint.getPositions(sPosi, fPosi, mapa);
		
		for(IPosition<Integer, Integer> nPosi : cPositions) {
			assertTrue( positions.contains(nPosi), "Dosen't contain the position");	
		}
		
		
	}
	
	@Test
	public void testYInverseRangePositions() {
		int length = 5;
		IMapa<Integer, Integer> mapa = new MapaMatrix(length);
		IPosition<Integer, Integer> sPosi = new Posicion<Integer, Integer>(0, 3);
		IPosition<Integer, Integer> fPosi = new Posicion<Integer, Integer>(0, 0);
		
		List<IPosition<Integer, Integer>> cPositions = new ArrayList<IPosition<Integer,Integer>>();
		cPositions.add(sPosi);
		cPositions.add(new Posicion<Integer, Integer>(0, 1));
		cPositions.add(new Posicion<Integer, Integer>(0, 2));
		cPositions.add(fPosi);
		
		
		List<IPosition<Integer, Integer>> positions = RangeToPoint.getPositions(sPosi, fPosi, mapa);
		
		for(IPosition<Integer, Integer> nPosi : cPositions) {
			assertTrue( positions.contains(nPosi), "Dosen't contain the position");	
		}
		
		
	}
	
	

}

