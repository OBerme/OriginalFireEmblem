package mapa.ln;

import group.md.Group;

public interface ILNMapaMatrixEntesGroup extends ILNMapaMatrixEntes {

	String getGroupMapString(Group group);
	String getGroupMapStringNum(Group group);
	boolean hasPosition(Integer x, Integer y);
	boolean isEmptyPosition(Integer x, Integer y);
}
