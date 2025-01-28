package presentation.main;

import java.awt.Color;

public final class PDefaultValues {
	public static String IMAGES_PATH = "/home/stallman/Downloads/Trash/game/";
	
	public static String getPathImage(String image) {
		return IMAGES_PATH + "/" + image;
	}
	
	public static int REC_HEIGHT = 40; //in pxls
	public static int REC_WIDTH = 40; //in pxls
	
	public static Color D_CELL_COLOR_DESA = Color.LIGHT_GRAY;
	public static Color D_CELL_COLOR_ACTI = Color.GREEN;
}
