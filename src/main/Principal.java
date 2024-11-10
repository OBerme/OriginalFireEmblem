package main;

import main.ln.acciones.ILNAccion;
import main.ln.acciones.LNAtaque;
import main.ln.mapa.ILNMapaMatrixEntes;
import main.ln.mapa.INLMapa;
import main.ln.mapa.LNMapaMatrix;
import main.ln.mapa.LNMapaMatrixEntes;
import main.md.acciones.ataque.Ataque;
import main.md.acciones.ataque.Tipo;
import main.md.ente.*;
import main.md.mapa.*;
import main.pl.controller.PL_ConsoleGameController;

public class Principal {
	
	private static final int MAP_LENGTH = 3;
	public static void main(String[] args) {
		MapaMatrix mapa = new MapaMatrix(MAP_LENGTH);
		ILNMapaMatrixEntes lnMapa = new LNMapaMatrixEntes(mapa);
		
		Estado nState =  new Estado(StateSerVivo.NORMAL);
		
		Persona p1 = new Persona(200, "Oscar", "O", new Estado(StateSerVivo.NORMAL));
		Persona p2 = new Persona(700, "Joji", "J", new Estado(StateSerVivo.NORMAL));
		
		lnMapa.moverEnte(p1, new Posicion<Integer, Integer>(0, 0));
		lnMapa.moverEnte(p2, new Posicion<Integer, Integer>(2, 2));
		
		PL_ConsoleGameController console = new PL_ConsoleGameController(lnMapa);
		console.start();
	}
}
