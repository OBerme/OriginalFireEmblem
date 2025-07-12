package presentation.MouseHoverObserver;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import mapa.md.IPosition;

@objid ("84901d5d-7433-45e3-8b07-d99681ffb1e3")
public class PCalculatorRange {
    @objid ("6ccfd159-572c-47f5-b157-c0339352fb55")
    public static int getRange(IPosition<Integer, Integer> fPosi, IPosition<Integer, Integer> sPosi) {
    	int dX = fPosi.getX() - sPosi.getX(); 
    	int dY = fPosi.getY() -  sPosi.getY();
    	if(dX < 0) {
    		dX = -1* dX;
    	}
    	if(dY < 0) {
    		dY = -1* dY;
    	}
    	
    	return dX + dY;
    	
    }

}
