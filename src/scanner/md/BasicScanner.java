package scanner.md;

import java.util.Scanner;

//Singleton
public class BasicScanner {
	protected Scanner scn;
	private static BasicScanner ownScannerSingleton;
	public BasicScanner(Scanner scn) {
		super();
		this.scn = scn;
	}
	
	public Scanner getScn() {
		
		return scn;
	}
	
	
	

	
	
}