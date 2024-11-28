package pl;

import java.util.ArrayList;
import java.util.List;

import acciones.ln.LNAccionesAtaque;
import entes.Estado;
import entes.IEnteEvents;
import entes.StateSerVivo;
import entes.md.Monstruo;
import entes.md.Persona;
import entes.md.SerVivo;
import group.ln.LNGroup;
import group.md.Group;
import group.md.Groupable;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.ln.LNMapaMatrixEntesGroup;
import mapa.md.MapaMatrixEnteGroup;
import mapa.md.MapaMatrixEnteGroupActionable;
import mapa.md.Posicion;
import player.ln.LNPlayer;
import player.md.Player;
import turner.ln.LNTurner;
import turner.md.IGameEvent;
import turner.md.ITurnerEvents;
import turner.md.Turnable;
import turner.md.Turner;
import turner.md.enums.TurnerEnumConstant;

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
		
		Turner tuner = new Turner();
		this.lnTurner = new LNTurner(tuner, this);
		
		LNGroup lnJojiGroup = new LNGroup(jojiGroup,lnTurner);
		LNGroup lnOsquiGroup = new LNGroup(oscarGroup,lnTurner);
		
		lnGroups.add(lnJojiGroup);
		lnGroups.add(lnOsquiGroup);
		
		ILNMapaMatrixEntesGroup lnMapa =  setUpGroupMap(MAP_LENGTH, oscarGroup, jojiGroup, lnTurner);
		
		IEnteEvents[] lnEnteEvents = new IEnteEvents[]{
				(IEnteEvents)lnMapa,
				(IEnteEvents)lnJojiGroup,
				(IEnteEvents)lnOsquiGroup,
		};
		
		LNAccionesAtaque lnAccionesAtaque = new LNAccionesAtaque(lnEnteEvents);
		moverPlayersRandom(lnMapa,listPersonas);
		
		List<Turnable> turnables =   new ArrayList<>();
		
		
		
		PL_ConsoleGamePlayerController consoleP1 = new PL_ConsoleGamePlayerController(
				lnMapa , lnJojiGroup, lnTurner,new LNPlayer(jojiP),lnAccionesAtaque);
		
		PL_ConsoleGamePlayerController consoleP2 = new PL_ConsoleGamePlayerController(
				lnMapa , lnOsquiGroup,lnTurner,new LNPlayer(oscarP),lnAccionesAtaque);
		
		turnables.add((Turnable)consoleP1);
		turnables.add((Turnable)consoleP2);
		
		tuner.setTurnables(turnables);
		
		
		this.lnTurner.start();
	}
	

	
	private static ILNMapaMatrixEntesGroup setUpGroupMap(int length, Group gr1, Group gr2,LNTurner lnTurner) {
		
		List<LNGroup> groups = new ArrayList();
		List<Group> groupsR = new ArrayList();
		
		
		
//		groups.add(new Group())
		
		groupsR.add(gr1);
		groupsR.add(gr2);
		
		MapaMatrixEnteGroupActionable mapa = new MapaMatrixEnteGroupActionable(length, groupsR);
		
		groups.add(new LNGroup(gr1, lnTurner));
		groups.add(new LNGroup(gr2,lnTurner));
		
		
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
