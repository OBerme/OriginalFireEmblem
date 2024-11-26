package main.interfaces.console;

import static main.interfaces.console.enums.CalculatorInterfaceMessages.*;

import java.util.Scanner;

public abstract class  DataConsoleInterface {    
    protected Scanner scn;
    public DataConsoleInterface(){
        scn = new Scanner(System.in);
    }

    public abstract boolean confims();
    
    public abstract int getMenuOption(String message);
    
    public abstract boolean isOption(int num);

    public abstract void showMenu();
    
    public abstract void start();
    
    public abstract void doMenuOption(int menuOption);
    

    public int getNumber(){
        try{
            int num = scn.nextInt();
            return num;
        }
        catch(Exception e){
            scn.nextLine();
            System.out.println(WRONG_INTEGER_FORMAT);
            return getNumber();
        }
    }

    public Double getDouble(){
        try{
            Double num = scn.nextDouble();
            return num;
        }
        catch(Exception e){
            scn.nextLine();
            System.out.println(WRONG_DOUBLE_FORMAT);
            return getDouble();
        }
    }
    

    public String getLine(){
    	String exit =null;
        try{
        	exit= scn.next();
        	if(exit == null) {
        		
        		return getLine();
        	}
        		
            Integer.parseInt(exit);
            
            print("Please give me a valid string not a number");
            return getLine();
        }
        catch(Exception e){
            //its normal its not a number
        }
        return exit;
    }   
    
    
    public abstract void print(String message);
}
