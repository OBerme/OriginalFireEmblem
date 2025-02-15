package presentation.map;

import javax.swing.JComponent;

import mapa.md.IPosition;

public interface IPGraphicPosition<X, Y>{

	void activePosition();

	void setgPosition(IGraphicPosition<Integer, Integer> gPosition);

	IGraphicPosition<Integer, Integer> getgPosition();

	IJButtonAction getGraAction();
	
	//Pre: the image should be updated first
	//Post: It will refresh the button
	void setAction(IJButtonAction action);

	void refreshButton();
	

}
