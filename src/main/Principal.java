package main;

import MD.Acciones.Ataque.Ataque;
import MD.Acciones.Ataque.Tipo;
import MD.Mapa.Mapa;
import MD.Mapa.MapaMatrix;
import MD.Mapa.Posicion;
import ML.mapa.INLMapa;
import ML.mapa.LNMapaMatrix;
import ln.acciones.ataque.ILNAccion;
import ln.acciones.ataque.LNAtaque;
import md.ente.Ente;
import md.ente.Persona;

public class Principal {
	public static void main(String[] args) {
		MapaMatrix mapa = new MapaMatrix(3);
		INLMapa<Integer, Integer> lnMapa = new LNMapaMatrix(mapa);
		
		System.out.println(mapa.toString());
		Posicion<Integer, Integer> p = new Posicion<Integer, Integer>(1,1);
		
		
		lnMapa.moverEnte( new Persona(), p);
		
		System.out.println(mapa.toString());
		 p = new Posicion<Integer, Integer>(2,2);
		
		Ente pe1 =  new Persona();
		lnMapa.moverEnte(pe1, p);
		
		Ente pe2 =  new Persona();
		lnMapa.moverEnte( pe2, p);
		
		System.out.println(mapa.toString());
		
		p = new Posicion<Integer, Integer>(1,2);
		
		lnMapa.moverEnte( new Persona(), p);
		System.out.println(mapa.toString());
		
		Ataque ata1 = new Ataque("megapuño", 20, Tipo.FUEGO);
		
		ILNAccion action = new LNAtaque(pe2, ata1);
		action.appendAtaque(ata1);
		action.appendAtaque(ata1);
		int damage = action.getDamage();
		
		System.out.println("The person " + pe2 + " recibes! " + damage);
		
		
	}
}
