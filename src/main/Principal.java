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

public class Principal {
	
	private static final int MAP_LENGTH = 4;
	public static void main(String[] args) {
		
		
		Estado nState =  new Estado(StateSerVivo.NORMAL);
		
		SerVivo[] listPersonas  = getListPersonas();
		Group oscarGroup = getFirstGroup(listPersonas);
		Group jojiGroup = getSecondGroup(listPersonas);
		
		ILNMapaMatrixEntesGroup lnMapa =  setUpGroupMap(MAP_LENGTH, oscarGroup, jojiGroup);
		moverPlayersRandom(lnMapa,listPersonas);
		
		PL_ConsoleGamePlayerController consoleP1 = new PL_ConsoleGamePlayerController(
				lnMapa , jojiGroup);
		
		consoleP1.start();
	}
	
	
	private static ILNMapaMatrixEntesGroup setUpGroupMap(int length, Group gr1, Group gr2) {
		
		List<LNGroup> groups = new ArrayList();
		List<Group> groupsR = new ArrayList();
		
		
		
//		groups.add(new Group())
		
		groupsR.add(gr1);
		groupsR.add(gr2);
		
		MapaMatrixEnteGroup mapa = new MapaMatrixEnteGroup(length, groupsR);
		
		groups.add(new LNGroup(gr1));
		groups.add(new LNGroup(gr2));
		
		
		ILNMapaMatrixEntesGroup lnMapa = new LNMapaMatrixEntesGroup(mapa, groups);
		
		
		
		
		return lnMapa;
		
	}
	
	private static void moverPlayersRandom(ILNMapaMatrixEntesGroup lnMapa, SerVivo[] listPersonas) {
		int x = 0;
		int y = 0;
		for(SerVivo nSVivo : listPersonas) {
			
			lnMapa.moverEnte(nSVivo, new Posicion<Integer, Integer>(x, y));
			
			if(x != 0 && x % (MAP_LENGTH-1) == 0) {
				x = 0;
				y++;
			}
			else x++;
		}
	}
	
	private static Group getFirstGroup(SerVivo[] listPersonas) {
		 
		List<Groupable> team = new ArrayList();
		Group oscarGroup =  new Group(listPersonas[0], team, new Player(1, "Oscar"));
		
		for(int i = 0; i < listPersonas.length/2 ; i++) {
			Groupable nGroupable = listPersonas[i];
			nGroupable.setGroup(oscarGroup);
			team.add(nGroupable);
		}
		
		return oscarGroup;
	}
	
	private static Group getSecondGroup(SerVivo[] listPersonas) {
		List<Groupable>  team = new ArrayList();
		Group jojiGroup = new Group(listPersonas[listPersonas.length/2],team,
				new Player(2, "Joji"));
		
		for(int i = listPersonas.length/2; i < listPersonas.length ; i++) {
			Groupable nGroupable = listPersonas[i];
			nGroupable.setGroup(jojiGroup);
			team.add(nGroupable);
			
		}
		
		jojiGroup.setTeam(team);
		return jojiGroup;
	}
	
	private static SerVivo[] getListPersonas() {
		return new SerVivo[] {
				new Persona(200, "Oscar", "O", new Estado(StateSerVivo.NORMAL)),
				new Monstruo(1500, "Undyne", "U", new Estado(StateSerVivo.NORMAL)),
				new Monstruo(2700, "Asgore", "A", new Estado(StateSerVivo.NORMAL)),
				new Monstruo(200, "Sans", "S", new Estado(StateSerVivo.NORMAL)),
				
				new Persona(700, "Joji", "J", new Estado(StateSerVivo.NORMAL)),
				new Monstruo(1200, "Muffet", "M", new Estado(StateSerVivo.NORMAL)),
				new Monstruo(1200, "Alphish", "H", new Estado(StateSerVivo.NORMAL)),
				new Persona(5000, "Varona", "V", new Estado(StateSerVivo.NORMAL))
				
		};
	}
	
	
	
	
}
