package presentation.ente;

import javax.swing.Icon;

import entes.md.Ente;
import entes.md.IEnte;

public interface IGEnte extends IEnte{
	Ente getEnte();

	Icon getImage();
}
