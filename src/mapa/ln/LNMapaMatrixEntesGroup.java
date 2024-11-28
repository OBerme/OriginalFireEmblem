package mapa.ln;

import java.util.List;

import group.ln.LNGroup;
import group.md.Group;
import mapa.md.MapaMatrixEnteGroup;
import scanner.md.IGroupMap;

public class LNMapaMatrixEntesGroup extends LNMapaMatrixEntes implements IGroupMap, ILNMapaMatrixEntesGroup{
	private List<LNGroup> groups;
	private MapaMatrixEnteGroup mapaVectorGroup;
	public LNMapaMatrixEntesGroup(MapaMatrixEnteGroup mapaVector, List<LNGroup> groups) {
		super(mapaVector);
		this.groups = groups;
		this.mapaVectorGroup = mapaVector;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getGroupMapString(Group sGroup) {
		// TODO Auto-generated method stub
		return this.mapaVectorGroup.getGroupMapString(sGroup);
	}
}
