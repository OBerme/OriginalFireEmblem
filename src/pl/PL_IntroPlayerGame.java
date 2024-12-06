package pl;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


import WebConnection.IWebConnectionEvents;
import WebConnection.LNWebConnection;
import WebConnection.XML.Util.EnteStack;
import WebConnection.XML.Util.PositionXmlStack;
import WebConnection.XML.Util.ln.LNXmlStack;

import WebUtil.GameClientConsole;
import WebUtil.GameServer;
import acciones.ln.LNAccionesAtaque;
import entes.Estado;
import entes.IEnteEvents;
import entes.ln.ILNEntes;
import entes.ln.LNEntes;
import entes.ln.StateSerVivo;
import entes.md.Ente;
import entes.md.Monstruo;
import entes.md.Persona;
import entes.md.SerVivo;
import group.ln.LNGroup;
import group.md.Group;
import group.md.Groupable;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.ln.IMapEvents;
import mapa.ln.IMapIntegerEvents;
import mapa.ln.LNMapaMatrixEntesGroup;
import mapa.md.MapaMatrixEnteGroupActionable;
import mapa.md.Posicion;
import menu.ln.LNTypeGameMenu;
import menu.md.TypeGameMenu;
import menu.md.enums.TypeGameMenuOptions;
import player.ln.LNPlayer;
import player.md.Player;
import scanner.ln.ILNTypeGameScanner;
import scanner.ln.LNTypeGameScanner;
import scanner.md.DataScanner;
import scanner.md.OwnScanner;
import scanner.md.BasicScanner;
import scanner.md.TypeGameScanner;
import scanner.md.enums.TypeGameScannerOptions;
import turner.ln.LNTurner;
import turner.md.IGameEvent;
import turner.md.Turnable;
import turner.md.Turner;
import turner.md.enums.TurnerEnumConstant;

public class PL_IntroPlayerGame implements IWebConnectionEvents{
	
	private static final boolean DEBUG_MODE = false; //to avoid the starting message 
	private LNTurner lnTurner;
	private List<LNGroup> lnGroups;
	private static final int MAP_LENGTH = 4;
	private Player principalPlayer;
	private IGameEvent[] iGameEvents;
	
	public PL_IntroPlayerGame() {
		if(DEBUG_MODE) {
			generateMokGame();	
			new PL_Game(lnTurner, lnGroups, iGameEvents);
			
		}
		else {
			DataScanner dataScanner = new DataScanner(OwnScanner.getInstance().getScn());
			
			TypeGameMenu typeGameMenu=  new TypeGameMenu();
			ILNTypeGameScanner typeGameScanner = 
					new LNTypeGameScanner(new TypeGameScanner(dataScanner,typeGameMenu ));
			
			System.out.println(TypeGameScannerOptions.INTRO_MESSAGE);	
			typeGameMenu.showMenu();
			int option = typeGameScanner.getTypeGameOption();
			
			if(option == TypeGameMenuOptions.GLG.getOption()) { //Get Local game
				
				generateMokGame();	
				this.iGameEvents  = new IGameEvent[0];
				PL_Game pl_Game = new PL_Game(lnTurner, lnGroups,iGameEvents);
			} 
			else if (option == TypeGameMenuOptions.GWG.getOption()) { //Web server option
				//The server shoudl be up!
				
				((Thread)new GameClientConsole(this)).start();
			}
		}
		
		
	}
	
	private void generateMokGame() {
		
		this.lnGroups = new ArrayList<LNGroup>();
		
		Player oscarP = new Player(1, "Osqui");
		Player jojiP = new Player(2, "Joji");
		
		
		SerVivo[] listPersonas  = getListPersonas();
		Group oscarGroup = getFirstGroup(listPersonas, oscarP);
		Group jojiGroup = getSecondGroup(listPersonas, jojiP);
		LNPlayer oscar = new LNPlayer(new Player(1, "Oscar"));
		
		
		
		
		Turner tuner = new Turner();
		lnTurner = new LNTurner(tuner, null);
		
		LNGroup lnJojiGroup = new LNGroup(jojiGroup,lnTurner);
		LNGroup lnOsquiGroup = new LNGroup(oscarGroup,lnTurner);
		
		lnGroups.add(lnJojiGroup);
		lnGroups.add(lnOsquiGroup);
		
		ILNMapaMatrixEntesGroup lnMapa =  setUpGroupMap(MAP_LENGTH, oscarGroup, jojiGroup, lnTurner, new IMapIntegerEvents[] {});
		
		IEnteEvents[] lnEnteEvents = new IEnteEvents[]{
				(IEnteEvents)lnMapa,
				(IEnteEvents)lnJojiGroup,
				(IEnteEvents)lnOsquiGroup,
		};
		
		//ADD the entes created to LNEntes to control all off them
		List<Ente> entes = new ArrayList<Ente>();
		for(SerVivo nServivo : listPersonas) {
			entes.add(nServivo);	
		}
		
		ILNEntes lnEntes = new LNEntes(lnEnteEvents, entes); 
		LNAccionesAtaque lnAccionesAtaque = new LNAccionesAtaque(lnEntes);
		moverPlayersRandom(lnMapa,listPersonas);
		
		List<Turnable> turnables =   new ArrayList<>();
		
		
		
		PL_ConsoleGamePlayerController consoleP1 = new PL_ConsoleGamePlayerController(
				lnMapa , lnJojiGroup, lnTurner,new LNPlayer(jojiP),lnAccionesAtaque);
		
		PL_ConsoleGamePlayerController consoleP2 = new PL_ConsoleGamePlayerController(
				lnMapa , lnOsquiGroup,lnTurner,new LNPlayer(oscarP),lnAccionesAtaque);
		
		turnables.add((Turnable)consoleP1);
		turnables.add((Turnable)consoleP2);
		
		tuner.setTurnables(turnables);
	}
	

	private void generateMokGameWeb(boolean waitingPlayer, Socket socket, Player player) {
		this.lnGroups = new ArrayList<LNGroup>();
		
		Player oscarP = new Player(1, "Osqui");
		Player jojiP = new Player(2, "Joji");
		
		
		SerVivo[] listPersonas  = getListPersonas();
		
		this.principalPlayer = oscarP;
		
		
		Group oscarGroup = getFirstGroup(listPersonas, !waitingPlayer ? player : oscarP);
		Group jojiGroup = getSecondGroup(listPersonas, waitingPlayer ? player : jojiP);
		LNPlayer oscar = new LNPlayer(new Player(1, "Oscar"));
		
		
		
		
		Turner tuner = new Turner();
		lnTurner = new LNTurner(tuner, null);
		
		LNGroup lnJojiGroup = new LNGroup(jojiGroup,lnTurner);
		LNGroup lnOsquiGroup = new LNGroup(oscarGroup,lnTurner);
		
		lnGroups.add(lnJojiGroup);
		lnGroups.add(lnOsquiGroup);		
		
		PositionXmlStack posiStack = new PositionXmlStack();
		EnteStack enteStack = new EnteStack();
		LNXmlStack xmlStack = new LNXmlStack(posiStack,enteStack);
		
		ILNMapaMatrixEntesGroup lnMapa =  setUpGroupMap(MAP_LENGTH, oscarGroup, jojiGroup, lnTurner, new IMapIntegerEvents[] {xmlStack});
		
		IEnteEvents[] lnEnteEvents = new IEnteEvents[]{
				(IEnteEvents)lnMapa,
				(IEnteEvents)lnJojiGroup,
				(IEnteEvents)lnOsquiGroup,
				(IEnteEvents)xmlStack //added the stack to get record the game
		};
		
		//ADD the entes created to LNEntes to control all off them
		List<Ente> entes = new ArrayList<Ente>();
		for(SerVivo nServivo : listPersonas) {
			entes.add(nServivo);	
		}
		
		ILNEntes lnEntes = new LNEntes(lnEnteEvents, entes); 
		LNAccionesAtaque lnAccionesAtaque = new LNAccionesAtaque(lnEntes);
		moverPlayersRandom(lnMapa,listPersonas);
		
		List<Turnable> turnables =   new ArrayList<>();
		
		LNGroup seleGroup = waitingPlayer ? lnJojiGroup : lnOsquiGroup;
		
		PL_ConsoleGamePlayerController consoleP1 = 
				new PL_ConsoleGamePlayerController(lnMapa ,seleGroup
						, lnTurner,new LNPlayer(player),lnAccionesAtaque);
				
		LNWebConnection webConnection =  new LNWebConnection(lnMapa, lnEntes,
				xmlStack, socket, waitingPlayer ? oscarP  : jojiP);
		//Generate the array of game events
		this.iGameEvents=  new IGameEvent[] {
				webConnection
		};
		
		turnables.add((Turnable)consoleP1);
		turnables.add((Turnable)webConnection);
		
		tuner.setTurnables(turnables);
	}
	

	
	private static ILNMapaMatrixEntesGroup setUpGroupMap(int length, Group gr1, Group gr2,LNTurner lnTurner, IMapIntegerEvents[] iMapEvents) {
		
		List<LNGroup> groups = new ArrayList();
		List<Group> groupsR = new ArrayList();
		
		
		
//		groups.add(new Group())
		
		groupsR.add(gr1);
		groupsR.add(gr2);
		
		MapaMatrixEnteGroupActionable mapa = new MapaMatrixEnteGroupActionable(length, groupsR);
		
		groups.add(new LNGroup(gr1, lnTurner));
		groups.add(new LNGroup(gr2,lnTurner));
		

		ILNMapaMatrixEntesGroup lnMapa = new LNMapaMatrixEntesGroup(mapa, groups, iMapEvents);
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
	public void onConnection(Socket socket, boolean waitingClient, Player player) {
		generateMokGameWeb(waitingClient, socket, player);
		this.principalPlayer.setName(player.getName());
		new PL_Game(lnTurner, lnGroups, waitingClient, iGameEvents);
		
		
	}


	
}
