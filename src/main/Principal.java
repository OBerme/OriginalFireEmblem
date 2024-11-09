package main;

import main.ln.acciones.ILNAccion;
import main.ln.acciones.LNAtaque;
import main.ln.mapa.INLMapa;
import main.ln.mapa.LNMapaMatrix;
import main.md.acciones.ataque.Ataque;
import main.md.acciones.ataque.Tipo;
import main.md.ente.*;
import main.md.mapa.*;

public class Principal {
	public static void main(String[] args) {
		MapaMatrix mapa = new MapaMatrix(3);
		INLMapa<Integer, Integer> lnMapa = new LNMapaMatrix(mapa);
		
		System.out.println(mapa.toString());
		Posicion<Integer, Integer> p = new Posicion<Integer, Integer>(1,1);
		
		
		lnMapa.moverEnte( new Persona(200, "Ronaldo", new Estado(StateSerVivo.NORMAL)), p);
		
		System.out.println(mapa.toString());
		 p = new Posicion<Integer, Integer>(2,2);
		
		Ente pe1 =  new Persona(200, "Ronaldo", new Estado(StateSerVivo.NORMAL));
		lnMapa.moverEnte(pe1, p);
		
		Ente pe2 =  new Persona(200, "Ronaldo", new Estado(StateSerVivo.NORMAL));
		lnMapa.moverEnte( pe2, p);
		
		System.out.println(mapa.toString());
		
		p = new Posicion<Integer, Integer>(1,2);
		
		lnMapa.moverEnte( pe2, p);
		System.out.println(mapa.toString());
		
		Ataque ata1 = new Ataque("megapuño", 20, Tipo.FUEGO);
		
		ILNAccion action = new LNAtaque(pe2, ata1);
		action.appendAtaque(ata1);
		action.appendAtaque(ata1);
		
		int damage = action.getDamage();
		
		System.out.println("The person " + pe2 + " recibes! " + damage);
		
		
	}
}
