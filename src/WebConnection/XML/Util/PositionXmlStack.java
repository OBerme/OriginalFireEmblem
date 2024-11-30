package WebConnection.XML.Util;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageTypeSpecifier;

import mapa.md.Posicion;
import mapa.md.PosicionXml;

public class PositionXmlStack extends PositionStack{
	public List<PosicionXml> getPositionsXml(){
		List<PosicionXml> positionsXml = new ArrayList<PosicionXml>();
		for(Posicion<Integer, Integer> nPosition : positionsChanged) {
			positionsXml.add(new PosicionXml(nPosition.getX(), nPosition.getY(), nPosition.getEnte()));
		}
		return positionsXml;
	}
}
