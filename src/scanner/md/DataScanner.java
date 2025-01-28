package scanner.md;

import java.util.Scanner;

import entes.md.Ente;
import scanner.md.enums.DataScannerOptions;

public class DataScanner extends BasicScanner {
	
    public DataScanner(Scanner scn) {
		super(scn);
		// TODO Auto-generated constructor stub
	}

	// Métodos según el diagrama
    public String getLine() {
    	String exit =null;
        try{
        	exit= scn.nextLine();
        	if(exit == null) {
        		
        		return getLine();
        	}
        		
            Integer.parseInt(exit);
            
            System.out.println(DataScannerOptions.WRONG_LINE_FORMAT);
            return getLine();
        }
        catch(Exception e){
        	e.printStackTrace();
            //its normal its not a number
        }
        return exit;
    }

    public int getInteger() {
        // Sin implementación
        try{
            int num = scn.nextInt();
            return num;
        }
        catch(Exception e){
            System.out.println(DataScannerOptions.WRONG_INTEGER_FORMAT);
        }
        return getInteger();
    }

    public boolean confirms() {
        // Sin implementación
    	try{
            String choose = scn.next().toLowerCase().trim();
            
            if(choose.equals(DataScannerOptions.YES_CONFIRMS.toString())
                    || choose.equals(DataScannerOptions.NO_CONFIRMS.toString()))
                return choose.toLowerCase().equals(DataScannerOptions.YES_CONFIRMS.toString());
            System.out.println("Please give me a valid option");
        }
        catch(Exception e) {
        	System.out.println(DataScannerOptions.WRONG_CONFIRMS_FORMAT);
        }
        return confirms();
    }

    public double getDouble() {
        // Sin implementación
    	try{
            Double num = scn.nextDouble();
            return num;
        }
        catch(Exception e){
            scn.nextLine();
            System.out.println(DataScannerOptions.WRONG_DOUBLE_FORMAT);
            return getDouble();
        }
    }
}

