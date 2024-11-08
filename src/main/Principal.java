package main;

import MD.Ente.Persona;
import MD.Mapa.Mapa;
import MD.Mapa.MapaMatrix;
import MD.Mapa.Posicion;
import ML.mapa.INLMapa;
import ML.mapa.LNMapaMatrix;

public class Principal {
	public static void main(String[] args) {
		MapaMatrix mapa = new MapaMatrix(3);
		INLMapa<Integer, Integer> lnMapa = new LNMapaMatrix(mapa);
		
		System.out.println(mapa.toString());
		Posicion<Integer, Integer> p = new Posicion<Integer, Integer>(1,1);
		
		
		lnMapa.moverEnte( new Persona(), p);
		
		System.out.println(mapa.toString());
		 p = new Posicion<Integer, Integer>(2,2);
		
		
		lnMapa.moverEnte( new Persona(), p);
		
		lnMapa.moverEnte( new Persona(), p);
		System.out.println(mapa.toString());
		
		p = new Posicion<Integer, Integer>(1,2);
		
		lnMapa.moverEnte( new Persona(), p);
		System.out.println(mapa.toString());
	}
}
