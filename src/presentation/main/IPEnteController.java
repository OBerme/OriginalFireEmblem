package presentation.main;

import java.awt.Menu;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import entes.md.Ente;
import entes.md.IEnte;
import presentation.graphicOptions.IShowMenus;
import presentation.menu.PMenu;

@objid ("8842578f-910b-45e8-82dd-253a62bfdc27")
public interface IPEnteController extends IPController {
	

	void skip();

	void moveEnte(IEnte ente);

}
