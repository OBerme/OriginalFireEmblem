package main;

import ln.acciones.ILNAccion;
import ln.acciones.LNAtaque;
import md.acciones.ataque.Ataque;
import md.acciones.ataque.Tipo;
import md.ente.Ente;
import md.ente.Persona;
import md.mapa.Mapa;
import md.mapa.MapaMatrix;
import md.mapa.Posicion;
import ml.mapa.INLMapa;
import ml.mapa.LNMapaMatrix;

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
