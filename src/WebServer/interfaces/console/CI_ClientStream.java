package WebServer.interfaces.console;

import static WebServer.interfaces.console.enums.CI_Client.E_GVO;
import static WebServer.interfaces.console.enums.CI_ClientDisco_OptionsMenu.*;
import static WebServer.interfaces.console.enums.CalculatorInterfaceMessages.*;
import static WebServer.interfaces.console.enums.ConsoleInterfaceStaticOptions.*;

import java.io.File;

import WebServer.ChatClient;
import WebServer.controller.Client;
import WebServer.interfaces.console.enums.CI_ClientConnect_OptionsMenu;
import WebServer.interfaces.console.enums.CI_ClientDisco_OptionsMenu;



public class CI_ClientStream extends DataConsoleInterface implements Runnable{
	private static final boolean DEBUG_MODE = true;
	private static final String DEBUG_STRING_CONSOLE = DEBUG_MODE ? "Consola " : "" ;
	public void setConnectedClient(boolean isConnectedClient) {
		this.isConnectedClient = isConnectedClient;
	}

	private ChatClient eC;
	private boolean isConnectedClient;
	
	 public CI_ClientStream(ChatClient eC) {
		super();
		this.eC = eC;
	}
	 
	 
	 
	 //@Override
	public void run(){
		 System.out.println(WELCOME_MESSAGE);

	        int menuOption;
	        if(!isConnectedClient) {
	        	while(true){
	                showMenu();
	                menuOption = getMenuOption(E_GVO.toString());
	                if(menuOption== EXIT_OPTION_MESSAGE.getOption()){
	                    System.out.println(EXIT_MESSAGE_CONFIRMS_MESSAGE);
	                    if(confims()) {
	                    	eC.closeConnection();
	                    	break;
	                    }
	                }
	                else
	                    doMenuOption(menuOption);
	            }

	        }
	        else {
	        	String nLine = null;
//	        	showMenu();
	        	do {
	        		nLine = getLine();
	        		eC.writeAMessage(nLine);
	        	}
	        	while(!wantsToDisconnect(nLine) && eC.isConnectToClient()); 
//	        	this.eC.onWaitResponse();
	        	
	        	eC.onDisconnect();
	        }
	        
	        
	        System.out.println(BYE_MESSAGE);
    }

	@Override
	public void start() {
		System.out.println(WELCOME_MESSAGE);

        int menuOption;
        if(!isConnectedClient) {
        	while(true){
                showMenu();
                menuOption = getMenuOption(E_GVO.toString());
                if(menuOption== EXIT_OPTION_MESSAGE.getOption()){
                    System.out.println(EXIT_MESSAGE_CONFIRMS_MESSAGE);
                    if(confims()) {
                    	eC.closeConnection();
                    	break;
                    }
                }
                else
                    doMenuOption(menuOption);
            }

        }
        else {
        	String nLine = null;
//        	showMenu();
        	do {
        		nLine = getLine();
        		eC.writeAMessage(nLine);
        	}
        	while(!wantsToDisconnect(nLine) && eC.isConnectToClient()); 
//        	this.eC.onWaitResponse();
        	
        	
        }
        
        
        System.out.println(BYE_MESSAGE);
		
	}

	
	
	
    
	private boolean wantsToDisconnect(String nLine) {
		// TODO Auto-generated method stub
		return nLine.equals(CI_ClientConnect_OptionsMenu.EXIT_OPTION_MESSAGE.getMessage());
	}


	public boolean isOption(int num) {
    	boolean isOption = false;
    	for(CI_ClientDisco_OptionsMenu nOption : CI_ClientDisco_OptionsMenu.values()) {
    		if(nOption.getOption()== num) {
    			isOption = true;
    			break;
    		}
    	}
    	
    	return isOption;
    }
    
	public void  showMenu() {

//        if(! options)
		
        System.out.println(PLEASE_GIVE_AN_OPTION);
        if(!this.eC.isConnectToClient()) {
        	for (CI_ClientDisco_OptionsMenu option : CI_ClientDisco_OptionsMenu.values()) {
                System.out.println("Option: " + option.getOption() + " - " + option);
            }	
        }
        else {
        	for (CI_ClientConnect_OptionsMenu option : CI_ClientConnect_OptionsMenu.values()) {
                System.out.println("Option: " + option.getOption() + " - " + option);
            }
        }
        
        
//        else
//            System.out.println(NO_OPTIONS);
        
    }
    
	public boolean confims() {
        try{
            String choose = scn.next().toLowerCase().trim();

            if(choose.equals(YES_CONFIRMS.toString())
                    || choose.equals(NO_CONFIRMS.toString()))
                return choose.toLowerCase().equals(YES_CONFIRMS.toString());
            System.out.println("Please give me a valid option");
        }
        catch(Exception e) {
        	System.out.println(WRONG_CONFIRMS_FORMAT);
        }
        return confims();
    }
    
	@Override
	public int getMenuOption(String message) {
        int num = getNumber();
        
        if(!isOption(num)){
            System.out.println(message);
            showMenu();
            return getMenuOption(message);
        }
        return num;
    }

	public void doMenuOption(int menuOption) {
		
        if(menuOption == RLU.getOption())
        	this.eC.getListOfUsers();
        else if(menuOption == CTU.getOption())
        	this.eC.connectClient();
        else if(menuOption == WFC.getOption())
        	this.eC.waitForConnections();            
        
	}
	

    public String getFileName(){
    	String exit =null;
        try{
        	exit =  scn.next();
        
        	if(exit == null) 
        		throw new NullPointerException(exit);
        	else {
        		File nF = new File(exit);
            	if(!nF.exists()) {
            		print(GF_SWW.toString());
            		print(GF_SWW_FDE.toString());
            		print(GF_SWW_PTA.toString());
            		return getFileName();
            	}	
        	}
        	
        }
        catch(IllegalStateException e){
            //its normal its not a number
        	print(GF_SWW.toString());
        	print(GF_SWW_PTA.toString());
        	return getFileName();
        }
        catch(NullPointerException e) {
        	print(GF_SWW.toString());
    		print(GF_SWW_PTA.toString());
    		return getFileName();
        }
        return exit;
    }
	
	@Override
	public void print(String message) {
		System.out.println( DEBUG_STRING_CONSOLE + message );
	}




	
	

}
