package main;

import java.util.ArrayList;
import java.util.List;



import main.ln.acciones.ILNAccion;
import main.ln.acciones.LNAccionesAtaque;
import main.ln.group.LNGroup;
import main.ln.mapa.ILNMapaMatrixEntes;
import main.ln.mapa.ILNMapaMatrixEntesGroup;
import main.ln.mapa.INLMapa;
import main.ln.mapa.LNMapaMatrix;
import main.ln.mapa.LNMapaMatrixEntes;
import main.ln.mapa.LNMapaMatrixEntesGroup;
import main.md.acciones.ataque.Ataque;
import main.md.acciones.ataque.Tipo;
import main.md.ente.*;
import main.md.group.Group;
import main.md.group.Groupable;
import main.md.mapa.*;
import main.md.player.Player;
import main.pl.controller.PL_ConsoleGamePlayerController;
import main.pl.controller.PL_Game;

public class Principal {
	
	
	public static void main(String[] args) {
		new PL_Game();
	}
}
