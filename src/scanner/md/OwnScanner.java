package scanner.md;

import java.util.Scanner;

public class OwnScanner {
	protected Scanner scn;
	
	private static OwnScanner ownScannerSingleton;
	
	private OwnScanner(Scanner scn) {
		super();
		this.scn = scn;
	}
	
	public static OwnScanner getInstance() {
		if(ownScannerSingleton == null)
			ownScannerSingleton = new OwnScanner(new Scanner (System.in));
		return ownScannerSingleton;
	}

	public Scanner getScn() {
		return scn;
	}
	
	
	

	
	
}