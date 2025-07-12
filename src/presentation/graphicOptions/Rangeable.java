package presentation.graphicOptions;

import java.awt.font.NumericShaper.Range;

public interface Rangeable {
	//Pre: The range should be valid in the map
	//Post: It will show the 
	public void showRange(Range range);
}
