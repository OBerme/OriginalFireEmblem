package presentation.map.jbutton;

public interface IPGraphicPositionIntegerAtack {
	//Pre: ---
	//Post: it will show the cell as that will recive the atack
	void activateAtack();
	
	//Pre: The cell should was activate before 
	//Post: it will deactivate the cell from the atack
	void deactivateAtack();
	
	//Pre: The Position should be activate as an atack
	//Post: it will say to the position that would be the center of the atack
	void setCenterPositionAtack();
	
}
