package presentation.main.controller;

import java.util.List;

import acciones.ln.LNAccionesAtaque;
import acciones.md.ataque.IAtack;
import entes.md.IEnte;
import mapa.ln.ILNMapaMatrixEntesGroup;
import mapa.md.IPosition;
import presentation.GAtack.IShowAtack;
import presentation.ente.IGEnte;
import presentation.map.IGraphicMap;
import presentation.map.ILNGraphicMapIntegerAtackDistance;
import presentation.map.IPPPositionSubjectData;
import presentation.menu.IPMenu;
import presentation.menu.PMenu;

public interface IPController {
	void skip();

	void setLnGMIAD(ILNGraphicMapIntegerAtackDistance lnGMIAD);

	void setShowAtacks(IShowAtack showAtacks);
}
