package main.pl.controller;

import java.util.ArrayList;
import java.util.List;

import main.ln.group.LNGroup;
import main.ln.mapa.ILNMapaMatrixEntesGroup;
import main.ln.mapa.LNMapaMatrixEntesGroup;
import main.ln.player.LNPlayer;
import main.ln.turner.LNTurner;
import main.md.ente.Estado;
import main.md.ente.Monstruo;
import main.md.ente.Persona;
import main.md.ente.SerVivo;
import main.md.ente.StateSerVivo;
import main.md.group.Group;
import main.md.group.Groupable;
import main.md.mapa.MapaMatrixEnteGroup;
import main.md.mapa.MapaMatrixEnteGroupActionable;
import main.md.mapa.Posicion;
import main.md.player.Player;
import main.md.turner.IGameEvent;
import main.md.turner.ITurnerEvents;
import main.md.turner.Turnable;
import main.md.turner.Turner;
import main.md.turner.constants.TurnerEnumConstant;

public class PL_Game implements IGameEvent{
	private static final int MAP_LENGTH = 4;
	
	private LNTurner lnTurner;
	private List<LNGroup> lnGroups;
	
	public PL_Game() {
		Estado nState =  new Estado(StateSerVivo.NORMAL);
		
		this.lnGroups = new ArrayList<LNGroup>();
		
		Player oscarP = new Player(1, "Osqui");
		Player jojiP = new Player(2, "Joji");
		
		
		SerVivo[] listPersonas  = getListPersonas();
		Group oscarGroup = getFirstGroup(listPersonas, oscarP);
		Group jojiGroup = getSecondGroup(listPersonas, jojiP);
		LNPlayer oscar = new LNPlayer(new Player(1, "Oscar"));
		
		
		LNGroup lnJojiGroup = new LNGroup(jojiGroup);
		LNGroup lnOsquiGroup = new LNGroup(oscarGroup);
		
		lnGroups.add(lnJojiGroup);
		lnGroups.add(lnOsquiGroup);
		
		ILNMapaMatrixEntesGroup lnMapa =  setUpGroupMap(MAP_LENGTH, oscarGroup, jojiGroup);
		moverPlayersRandom(lnMapa,listPersonas);
		
		List<Turnable> turnables =   new ArrayList<>();
		
		Turner tuner = new Turner();
		this.lnTurner = new LNTurner(tuner, this);
		
		PL_ConsoleGamePlayerController consoleP1 = new PL_ConsoleGamePlayerController(
				lnMapa , lnJojiGroup, lnTurner,new LNPlayer(jojiP));
		
		PL_ConsoleGamePlayerController consoleP2 = new PL_ConsoleGamePlayerController(
				lnMapa , lnOsquiGroup,lnTurner,new LNPlayer(oscarP));
		
		turnables.add((Turnable)consoleP1);
		turnables.add((Turnable)consoleP2);
		
		tuner.setTurnables(turnables);
		
		
		this.lnTurner.start();
	}
	

	
	private static ILNMapaMatrixEntesGroup setUpGroupMap(int length, Group gr1, Group gr2) {
		
		List<LNGroup> groups = new ArrayList();
		List<Group> groupsR = new ArrayList();
		
		
		
//		groups.add(new Group())
		
		groupsR.add(gr1);
		groupsR.add(gr2);
		
		MapaMatrixEnteGroupActionable mapa = new MapaMatrixEnteGroupActionable(length, groupsR);
		
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
	
	private static Group getFirstGroup(SerVivo[] listPersonas, Player player) {
		 
		List<Groupable> team = new ArrayList();
		Group oscarGroup =  new Group(listPersonas[0], team, player);
		
		for(int i = 0; i < listPersonas.length/2 ; i++) {
			Groupable nGroupable = listPersonas[i];
			nGroupable.setGroup(oscarGroup);
			team.add(nGroupable);
		}
		
		return oscarGroup;
	}
	
	private static Group getSecondGroup(SerVivo[] listPersonas, Player player) {
		List<Groupable>  team = new ArrayList();
		Group jojiGroup = new Group(listPersonas[listPersonas.length/2],team,
				player);
		
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
				new Persona(200, "Oscar", "O", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost()),
				new Monstruo(1500, "Undyne", "U", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost()),
//				new Monstruo(2700, "Asgore", "A", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost()),
//				new Monstruo(200, "Sans", "S", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost()),
				
				new Persona(700, "Joji", "J", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost()),
				new Monstruo(1200, "Muffet", "M", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost()),
//				new Monstruo(1200, "Alphish", "H", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost()),
//				new Persona(5000, "Varona", "V", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost())
		};
	}



	@Override
	public void onGameEnds() {
		System.out.println("GameOver"
				+ "\nThe winner is");
		
		for(LNGroup nLNGroup : lnGroups) {
			if(!nLNGroup.isDone()) {
				System.out.println("The group of " + nLNGroup.getGroup().getPlayer());
			}
		}
	}
	
}
