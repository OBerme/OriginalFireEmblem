package presentation.menu;

import mapa.md.IPosition;

public interface IPMenu<X, Y> {

	void showMenu(IPosition<X, Y> position);

	void onFinishedAddedOptions();

}
