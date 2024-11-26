package main.pl.controller;


import java.util.Scanner;

import main.ln.acciones.LNAccion;
import main.ln.controller.menu.ILNGroupMenu;
import main.ln.controller.menu.IMenuShowable;
import main.ln.controller.menu.LNGroupMenu;
import main.ln.group.LNGroup;
import main.ln.mapa.IEnteCollection;
import main.ln.mapa.ILNMapaMatrixEntes;
import main.ln.mapa.ILNMapaMatrixEntesGroup;
import main.ln.mapa.INLMapa;
import main.ln.mapa.LNMapaMatrix;
import main.ln.mapa.LNMapaMatrixEntes;
import main.ln.player.LNPlayer;
import main.md.controller.menu.AttackMenu;
import main.md.controller.menu.GroupMenu;
import main.md.controller.menu.enums.ActionableMenuOptions;
import main.md.controller.menu.enums.BasicMenuOptions;
import main.md.controller.menu.enums.EnteMenuOptions;
import main.md.controller.menu.enums.GroupMenuOptions;
import main.md.controller.menu.enums.PositionMenuOptions;
import main.md.controller.scanner.IGroupMap;
import main.md.controller.scanner.OwnScanner;
import main.md.ente.Ente;
import main.md.ente.Movable;
import main.md.group.Group;
import main.md.group.Groupable;
import main.md.mapa.MapaMatrix;
import main.md.mapa.Posicion;
import main.md.turner.Actionable;
import main.md.turner.ITurnerEvents;
import main.md.turner.Turnable;
import main.md.turner.constants.TurnerEnumConstant;
import main.pl.controller.enums.ConsoleGameControllerMessages;

public class PL_ConsoleGamePlayerController implements Turnable{	
	private PL_GamePlayerMenu menu;
	private PL_GameScanner scn;
	private LNGroup lnPlayerGroup;
	private LNPlayer lnPlayer;
	private ITurnerEvents turnerEvent;
	
	private boolean contin;
	
	
	private ILNMapaMatrixEntesGroup lnMapa;
	
	public PL_ConsoleGamePlayerController(ILNMapaMatrixEntesGroup lnMapa, 
			LNGroup lnPlayerGroup,ITurnerEvents turnerEvent, LNPlayer lnPlayer) {
		this.lnMapa = lnMapa;
		this.lnPlayer = lnPlayer;
		this.lnPlayerGroup = lnPlayerGroup;
		
		this.turnerEvent = turnerEvent;
		
		
		IEnteCollection iEnteColle = (IEnteCollection) lnMapa;
		OwnScanner scanner = new OwnScanner(new Scanner(System.in)); 
		
		GroupMenu gM = new GroupMenu((IGroupMap)lnMapa);	
		ILNGroupMenu lnGM = new LNGroupMenu(gM, (IMenuShowable)gM);
		
		
		scn = new PL_GameScanner(scanner, iEnteColle);
		this.menu = new PL_GamePlayerMenu(( ConsoleGameControllerMessages.LOOP_MESSAGE.toString() ),
				lnGM);
	}
	
	 //@Override
	public void start(){
        System.out.println(ConsoleGameControllerMessages.getPlayerTurnMessage(lnPlayer.getName()));

        int menuOption;
        
        if(lnPlayerGroup.isDone())
        	turnerEvent.onGiveUp();
        
        lnPlayerGroup.resetNumActions();
        while(lnPlayerGroup.hasActions() && contin){
        	
    		System.out.println(lnMapa.getMapaDesing()); //Show the map
            this.menu.showMenu();
            
            
            menuOption = getMenuOption();       
            
            if(menuOption== GroupMenuOptions.WDG.getOption()){
                System.out.println(ConsoleGameControllerMessages.CONFIRM_EXIT);
                if(scn.confims()) {
                	turnerEvent.onGiveUp();
                	lnPlayerGroup.giveUp();
                	break;
                }
            }
            else
                doMenuOption(menuOption);
        }
        
    }
	

	private int getMenuOption() {
		int menuOption = this.scn.getInteger();
		
		if(!menu.isAnOption(menuOption)){
			System.out.println(ConsoleGameControllerMessages.NOT_AN_OPTION);
			
			return getMenuOption();
		}
		// TODO Auto-generated method stub
		return menuOption;
	}

	public void doMenuOption(int menuOption) {
        //---------------------------ENTE OPTIONS--------------------------
        if(menuOption == EnteMenuOptions.SHEN.getOption()) { //Show number of the entes
        	System.out.println(this.lnMapa.getNumberEntesDesing());
        }
        else if(menuOption == EnteMenuOptions.DAEN.getOption())  { //Status of the ente
        	System.out.println("Give me the number of the ente");
        	System.out.println(this.lnMapa.getNumberEntesDesing());

        	int numbEnte = this.scn.getInteger();
        	Ente sEnte = lnMapa.getEnte(numbEnte);
        	System.out.println(sEnte.getStatus());
        }
        else if(menuOption == EnteMenuOptions.MOEN.getOption()){ //move ente 
        	System.out.println("Give me the number of the ente");
        	System.out.println(this.lnMapa.getGroupMapString(lnPlayerGroup.getGroup()));
        	
    		int numbEnte = this.scn.getInteger();
        	Ente sEnte = lnMapa.getEnte(numbEnte);
        	
        	//to check if the ente is in the player lnPlayerGroup
        	while( !((Groupable)sEnte).getGroup().equals(this.lnPlayerGroup.getGroup())){ 
        		System.out.println("Please give a valid number");
        		sEnte = lnMapa.getEnte(this.scn.getInteger());
        	}
        	
        	if( (sEnte instanceof Movable && sEnte instanceof Actionable)) { //To pay the turn 
        		Actionable sEnteActi = (Actionable) sEnte;
        		if(sEnteActi.hasActions()) {
        			System.out.println("Give me the new position");
                	
                	Posicion<Integer, Integer> nPosition = this.scn.getPosition();
                	if(!this.lnMapa.moverEnte(sEnte, nPosition)) {
                		System.out.println("You cant move to an ocuped position");
                	}
                	else {
                		sEnteActi.subtractNumActions(TurnerEnumConstant.MOVE_COST.getCost());
                		System.out.println("The player was moved");
                	}
        		}
        		else
        			System.out.println("The player can't moved");
        		
        	}
        	else {
        		System.out.println("The ente is very bigchungus and you can't move it");
        	}
        	
        	
        		
        }
        else if(menuOption == EnteMenuOptions.ATEN.getOption()){ //move ente 
        	System.out.println("Give me the number of the ente");
        	System.out.println(this.lnMapa.getGroupMapString(lnPlayerGroup.getGroup()));
        	
    		int numbEnte = this.scn.getInteger();
        	Ente sEnte = lnMapa.getEnte(numbEnte);
        	
        	//to check if the ente is in the player lnPlayerGroup
        	while( !((Groupable)sEnte).getGroup().equals(this.lnPlayerGroup.getGroup())){ 
        		System.out.println("Please give a valid number");
        		sEnte = lnMapa.getEnte(this.scn.getInteger());
        	}
        	
        	if( (sEnte instanceof Movable && sEnte instanceof Actionable)) { //To pay the turn 
        		Actionable sEnteActi = (Actionable) sEnte;
        		if(sEnteActi.hasActions()) {
                	Scanner sc = new Scanner(System.in);
        			int i=0;
        			while(i != 50 && i != 51) {
        			System.out.println("Give me the attack");
        			
                	AttackMenu attackMenu = new AttackMenu();
                	System.out.println(attackMenu.toString());
                	i = sc.nextInt();
                	}
        			System.out.println("Give me the number of the ente");
                	System.out.println(this.lnMapa.getNumberEntesDesing());
                	
            		numbEnte = this.scn.getInteger();
                	sEnte = lnMapa.getEnte(numbEnte);
                	while(((Groupable)sEnte).getGroup().equals(this.lnPlayerGroup.getGroup())){ 
                		//si es un ente del otro equipo
                		//sEnte.setHP();
                		System.out.println("The ente was attacked!");
                		
                	}
        		}
        		else
        			System.out.println("The player can't attack");
        		}
        	else {
        		System.out.println("The ente is very bigchungus and you can't attack with it");
        	}
        }
        else if(menuOption == PositionMenuOptions.SHPO.getOption()) {
        	System.out.println(this.lnMapa.toStringNumberPositions());
        }
        //---------------------------GROUP OPTIONS--------------------------
        else if(menuOption == GroupMenuOptions.SHEN.getOption()) { //Show entes LNGroup of the player
        	System.out.println(this.lnMapa.getGroupMapString(lnPlayerGroup.getGroup()));
        }
        else if(menuOption == GroupMenuOptions.WDG.getOption()) { //Show entes LNGroup of the player
        	System.out.println(this.lnMapa.getGroupMapString(lnPlayerGroup.getGroup()));
        }
        //---------------------------ACTIONABLE OPTIONS--------------------------
        else if(menuOption == ActionableMenuOptions.WTS.getOption()) { //Wants to skip
        	skipTurn();
        }
        else if(menuOption == ActionableMenuOptions.DAA.getOption()) { //Wants to skip, but do all atacks and moves
        	setMovesAndAtacks();
        }
	}

	@Override
	public void doTurn() {
		this.contin =  true;
		start();
	}

	@Override
	public void skipTurn(){
		//Should rmeove all the actions in the map, but we are going to skip for now
		this.contin = false;
		
		
	}
	
	private void setMovesAndAtacks() {
		//lnAtack do all things
		skipTurn();
	}
}
