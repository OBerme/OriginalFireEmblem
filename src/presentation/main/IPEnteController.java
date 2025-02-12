package presentation.main;

import java.awt.Menu;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import presentation.graphicOptions.IShowMenus;
import presentation.menu.PMenu;

@objid ("8842578f-910b-45e8-82dd-253a62bfdc27")
public interface IPEnteController extends IPController {
	
    @objid ("14e19687-a507-41a6-9b43-4131d05fce5a")
    void moveEnte();

	void skip();

}
