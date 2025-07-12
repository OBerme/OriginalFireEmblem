package presentation.main;

import java.awt.Color;

public final class PDefaultValues {
	public static final int HEADER_HEIGHT = 35 ;
	public static final boolean DEBUG_MODE = false;
	public static final boolean DEBUG_MODE_JBUTTONS = false;
	public static final boolean DEBUG_MODE_MENU = false;
	
	public static final boolean DEBUG_MODE_PPOSITIONS = true;
	public static final boolean DEBUG_MODE_IPositionObserver = true;
	
	public static final boolean DEBUG_MODE_CONTROLLER = true;
	
	public static final boolean DEBUG_MODE_PGPIAD = false; //PGraphicOPositionIntegerAtackDistance
	
	public static String IMAGES_PATH = "/home/stallman/Documents/SIS/FireRules/GameServer/media/photos/";
	
	public static String getPathImage(String image) {
		return IMAGES_PATH + "/" + image;
	}
	
	public static int REC_HEIGHT = 40; //in pxls
	public static int REC_WIDTH = 40; //in pxls
	
	
	//PGraphicPositionInteger
	public static Color D_CELL_COLOR_DESA = Color.LIGHT_GRAY;
	public static Color D_CELL_COLOR_ACTI = Color.GREEN;
	
	//PGraphicPositionIntegerAtack
	public static final Color D_CELL_COLOR_ACTI_ATACK = Color.RED;
	public static final Color D_CELL_COLOR_DEAC_ATACK = D_CELL_COLOR_DESA;
	
	//PGraphicPositionIntegerAtackDistance
	public static final Color D_CELL_COLOR_DIST_ACTI = Color.CYAN;
	public static final Color D_CELL_COLOR_DIST_DEAC = D_CELL_COLOR_DESA;

	
}
