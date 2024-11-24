package main.ln.mapa;

import java.util.List;

import main.ln.group.LNGroup;
import main.md.controller.scanner.IGroupMap;
import main.md.group.Group;
import main.md.mapa.MapaMatrixEnteGroup;

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
