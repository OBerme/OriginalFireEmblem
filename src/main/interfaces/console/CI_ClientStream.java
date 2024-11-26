package main.interfaces.console;

import static main.interfaces.console.enums.CI_Client.E_GVO;
import static main.interfaces.console.enums.CI_ClientOptionsMenu.*;
import static main.interfaces.console.enums.CalculatorInterfaceMessages.BYE_MESSAGE;
import static main.interfaces.console.enums.CalculatorInterfaceMessages.EXIT_MESSAGE_CONFIRMS_MESSAGE;
import static main.interfaces.console.enums.CalculatorInterfaceMessages.NOT_AN_OPTION;
import static main.interfaces.console.enums.CalculatorInterfaceMessages.PLEASE_GIVE_AN_OPTION;
import static main.interfaces.console.enums.CalculatorInterfaceMessages.WELCOME_MESSAGE;
import static main.interfaces.console.enums.CalculatorInterfaceMessages.WRONG_CONFIRMS_FORMAT;
import static main.interfaces.console.enums.ConsoleInterfaceStaticOptions.NO_CONFIRMS;
import static main.interfaces.console.enums.ConsoleInterfaceStaticOptions.YES_CONFIRMS;

import main.controller.EchoClient;
import main.interfaces.console.enums.CI_ClientOptionsMenu;



public class CI_ClientStream extends DataConsoleInterface{	
	private EchoClient eC;
	 public CI_ClientStream(EchoClient eC) {
		super();
		this.eC = eC;
	}
	 
	 
	 public void startInterface() {
		 start();
	 }
	 
	 //@Override
	public void start(){
        System.out.println(WELCOME_MESSAGE);

        int menuOption;
        while(true){
            showMenu();
            menuOption = getMenuOption(E_GVO.toString());
            if(menuOption== EXIT_OPTION_MESSAGE.getOption()){
                System.out.println(EXIT_MESSAGE_CONFIRMS_MESSAGE);
                if(confims()) break;
            }
            else
                doMenuOption(menuOption);
        }

        System.out.println(BYE_MESSAGE);
    }
	
    
	public boolean isOption(int num) {
    	boolean isOption = false;
    	for(CI_ClientOptionsMenu nOption : CI_ClientOptionsMenu.values()) {
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
        for (CI_ClientOptionsMenu option : CI_ClientOptionsMenu.values()) {
            System.out.println("Option: " + option.getOption() + " - " + option);
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
        int num = getNumber();;
        if(!isOption(num)){
            System.out.println(message);
            showMenu();
            return getMenuOption(message);
        }
        return num;
    }

	public void doMenuOption(int menuOption) {
		if(isOption(menuOption)){
            if(menuOption == SE.getOption())
            	this.eC.sendEcho();
            else if(menuOption == SME.getOption())
            	this.eC.sendMoreEchos();
        }
        else
            System.out.println(NOT_AN_OPTION);
	}
	

    public String getFileName(){
    	String exit =null;
        try{
        	exit=  scn.next();
        	if(exit == null) {	
        		return getLine();
        	}
        }
        catch(IllegalStateException e){
            //its normal its not a number
        	print("Something went wrong getting the name of the file");
        	print("Please try again");
        	return getLine();
        }
        return exit;
    }
	
	public void print(String message) {
		System.out.println(message);
	}

}
