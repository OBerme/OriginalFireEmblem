package main.pl.controller;


import java.util.Scanner;

import main.ln.controller.menu.ILNGroupMenu;
import main.ln.controller.menu.IMenuShowable;
import main.ln.controller.menu.LNGroupMenu;
import main.ln.mapa.IEnteCollection;
import main.ln.mapa.ILNMapaMatrixEntes;
import main.ln.mapa.ILNMapaMatrixEntesGroup;
import main.ln.mapa.INLMapa;
import main.ln.mapa.LNMapaMatrix;
import main.ln.mapa.LNMapaMatrixEntes;
import main.md.controller.menu.GroupMenu;
import main.md.controller.menu.enums.BasicMenuOptions;
import main.md.controller.menu.enums.EnteMenuOptions;
import main.md.controller.menu.enums.GroupMenuOptions;
import main.md.controller.menu.enums.PositionMenuOptions;
import main.md.controller.scanner.IGroupMap;
import main.md.controller.scanner.OwnScanner;
import main.md.ente.Ente;
import main.md.group.Group;
import main.md.group.Groupable;
import main.md.mapa.MapaMatrix;
import main.md.mapa.Posicion;
import main.pl.controller.enums.ConsoleGameControllerMessages;

public class PL_ConsoleGamePlayerController {	
	private PL_GamePlayerMenu menu;
	private PL_GameScanner scn;
	private Group playerGroup;
	
	
	private ILNMapaMatrixEntesGroup lnMapa;
	
	public PL_ConsoleGamePlayerController(ILNMapaMatrixEntesGroup lnMapa, Group playerGroup) {
		this.lnMapa = lnMapa;
		this.playerGroup = playerGroup;
		
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
        System.out.println(ConsoleGameControllerMessages.WELCOME_MESSAGE);

        int menuOption;
        
    	while(true){
    		System.out.println(lnMapa.getMapaDesing()); //Show the map
            this.menu.showMenu();
            
            
            menuOption = getMenuOption();       
            
            if(menuOption== BasicMenuOptions.EXIT.getOption()){
                System.out.println(ConsoleGameControllerMessages.CONFIRM_EXIT);
                if(scn.confims()) {
                	break;
                }
            }
            else
                doMenuOption(menuOption);
        }
        System.out.println(ConsoleGameControllerMessages.BYE_MESSAGE);
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
        	System.out.println(this.lnMapa.getGroupMapString(playerGroup));
        	
    		int numbEnte = this.scn.getInteger();
        	Ente sEnte = lnMapa.getEnte(numbEnte);
        	
        	//to check if the ente is in the player group
        	while( !((Groupable)sEnte).getGroup().equals(this.playerGroup)){ 
        		System.out.println("Please give a valid number");
        		sEnte = lnMapa.getEnte(this.scn.getInteger());
        	}
        	
        	System.out.println("Give me the new position");
        	
        	Posicion<Integer, Integer> nPosition = this.scn.getPosition();
        	if(!this.lnMapa.moverEnte(sEnte, nPosition)) {
        		System.out.println("You cant move to an ocuped position");
        	}
        } 
        else if(menuOption == PositionMenuOptions.SHPO.getOption()) {
        	System.out.println(this.lnMapa.toStringNumberPositions());
        }
        else if(menuOption == GroupMenuOptions.SHEN.getOption()) { //Show entes group of the player
        	System.out.println(this.lnMapa.getGroupMapString(playerGroup));
        }
	}
}
