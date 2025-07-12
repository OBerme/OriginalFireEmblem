package entes.md;

public class EnteCounter {
	private static int numberEntes=0;
	
	public static int getNextNumb() {
		return numberEntes++;
	}
}
