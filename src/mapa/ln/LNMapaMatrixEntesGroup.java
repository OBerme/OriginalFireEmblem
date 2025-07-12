package mapa.ln;

import java.util.List;

import entes.md.Ente;
import group.ln.LNGroup;
import group.md.Group;
import mapa.md.MapaMatrixEnteGroup;
import mapa.md.Posicion;
import scanner.md.IGroupMap;

public class LNMapaMatrixEntesGroup extends LNMapaMatrixEntes implements IGroupMap, ILNMapaMatrixEntesGroup{
	private List<LNGroup> groups;
	
	private MapaMatrixEnteGroup mapaVectorGroup;
	public LNMapaMatrixEntesGroup(MapaMatrixEnteGroup mapaVector, List<LNGroup> groups,
			IMapEvents<Integer, Integer>[] mapEvents) {
		super(mapaVector, mapEvents);
		this.groups = groups;
		this.mapaVectorGroup = mapaVector;
	}
	
	@Override
	public String getGroupMapString(Group sGroup) {
		// TODO Auto-generated method stub
		return this.mapaVectorGroup.getGroupMapString(sGroup);
	}

	@Override
	public String getGroupMapStringNum(Group group) {
		// TODO Auto-generated method stub
		return this.mapaVectorGroup.getGroupMapStringNumber(group);
	}

	@Override
	public boolean hasPosition(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return this.mapa.hasPosition(x, y);
	}
	
	
	

}
