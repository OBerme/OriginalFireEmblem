package main;

import java.util.ArrayList;
import java.util.List;

import acciones.ln.ILNAccion;
import acciones.ln.LNAccionesAtaque;
import acciones.md.ataque.Ataque;
import acciones.md.ataque.Tipo;
import entes.*;
import group.ln.LNGroup;
import group.md.Group;
import group.md.Groupable;
import mapa.ln.ILNMapaMatrixEntes;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.ln.INLMapa;
import mapa.ln.LNMapaMatrix;
import mapa.ln.LNMapaMatrixEntes;
import mapa.ln.LNMapaMatrixEntesGroup;
import mapa.md.*;
import pl.PL_ConsoleGamePlayerController;
import pl.PL_Game;
import pl.PL_IntroPlayerGame;
import player.md.Player;

public class Principal {
	
	
	public static void main(String[] args) {
		new PL_IntroPlayerGame();
	}
}
