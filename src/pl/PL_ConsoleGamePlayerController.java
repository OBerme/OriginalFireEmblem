package pl;


import java.util.Scanner;

import acciones.ln.AtaqueSolo;
import acciones.ln.LNAccion;
import acciones.ln.LNAccionesAtaque;
import acciones.md.ataque.Ataque;
import acciones.md.ataque.Tipo;
import entes.Atacable;
import entes.IEnteEvents;
import entes.Movable;
import entes.md.Ente;
import group.ln.LNGroup;
import group.md.Group;
import group.md.Groupable;
import mapa.ln.IEnteCollection;
import mapa.ln.ILNMapaMatrixEntes;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.ln.INLMapa;
import mapa.ln.LNMapaMatrix;
import mapa.ln.LNMapaMatrixEntes;
import mapa.md.MapaMatrix;
import mapa.md.Posicion;
import menu.ln.ILNGroupMenu;
import menu.ln.IMenuShowable;
import menu.ln.LNGroupMenu;
import menu.md.AttackMenu;
import menu.md.GroupMenu;
import menu.md.enums.ActionableMenuOptions;
import menu.md.enums.BasicMenuOptions;
import menu.md.enums.EnteMenuOptions;
import menu.md.enums.GroupMenuOptions;
import menu.md.enums.PositionMenuOptions;
import pl.enums.ConsoleGameControllerMessages;
import player.ln.LNPlayer;
import scanner.md.IGroupMap;
import scanner.md.OwnScanner;
import scanner.md.BasicScanner;
import turner.md.Actionable;
import turner.md.ITurnerEvents;
import turner.md.Turnable;
import turner.md.enums.TurnerEnumConstant;

public class PL_ConsoleGamePlayerController implements Turnable{	
	private PL_GamePlayerMenu menu;
	private PL_GameScanner scn;
	private LNGroup lnPlayerGroup;
	private LNPlayer lnPlayer;
	private ITurnerEvents turnerEvent;
	private IEnteEvents[] acciones;
	private LNAccionesAtaque lnAccionesAtaque;
	
	private boolean contin;
	
	
	private ILNMapaMatrixEntesGroup lnMapa;
	
	public PL_ConsoleGamePlayerController(ILNMapaMatrixEntesGroup lnMapa, 
			LNGroup lnPlayerGroup,ITurnerEvents turnerEvent, LNPlayer lnPlayer, LNAccionesAtaque lnAccionesAtaque ) {
		this.lnAccionesAtaque = lnAccionesAtaque;
		this.lnMapa = lnMapa;
		this.lnPlayer = lnPlayer;
		this.lnPlayerGroup = lnPlayerGroup;
		
		
		this.turnerEvent = turnerEvent;
		
		
		IEnteCollection iEnteColle = (IEnteCollection) lnMapa;
		BasicScanner scanner = new BasicScanner(OwnScanner.getInstance().getScn()); 
		
		GroupMenu gM = new GroupMenu((IGroupMap)lnMapa);	
		ILNGroupMenu lnGM = new LNGroupMenu(gM, (IMenuShowable)gM);
		
		
		scn = new PL_GameScanner(scanner, iEnteColle);
		this.menu = new PL_GamePlayerMenu(( ConsoleGameControllerMessages.LOOP_MESSAGE.toString() ),
				lnGM);
	}
	
	 //@Override
	public void start(){
        int menuOption;
        if(lnPlayerGroup.isDone()) {
        	turnerEvent.onGiveUp();
        }
        else {
        	System.out.println(ConsoleGameControllerMessages.getPlayerTurnMessage(lnPlayer.getName()));
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
            lnAccionesAtaque.doAtacks();    
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
        	moveEnte();	
        }
        else if(menuOption == EnteMenuOptions.ATEN.getOption()){ //do an atack
        	doAttack();
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
	
	private void moveEnte() {
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
	private void doAttack() {
		System.out.println(this.lnMapa.getGroupMapString(lnPlayerGroup.getGroup()));
		Ente sEnte = this.scn.getEnte(this.lnPlayerGroup.getGroup());
    	if( (sEnte instanceof Actionable )) { //To pay the turn 
    		Actionable sEnteActi = (Actionable) sEnte;
    		
    		Ataque aChoice;
    		if(sEnteActi.hasActions()) {
    			if(sEnte instanceof Atacable) {
    				System.out.println(this.lnMapa.getNumberEntesDesing());
    				Ente eneEnte = this.scn.getEnemyEnte(lnPlayerGroup.getGroup());
    				Ataque cAtack = this.scn.getAtack((Atacable)sEnte);
    				lnAccionesAtaque.appendAtaque(eneEnte, cAtack);
    			}
    			else
    				System.out.println("The player is a fucking big chungus and can't do more atacks");
    		}
    		else
    			System.out.println("The player is a fucking panza and can't do more actions");
    	}		
	}
}
