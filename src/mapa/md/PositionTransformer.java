package mapa.md;

public class PositionTransformer {
	public static PosicionXml getPosicionXml(Posicion<Integer, Integer> posi) {
		return new PosicionXml(posi.getX(), posi.getY(), (Ente)posi.getSomething());
	}	
	
	public static Posicion<Integer, Integer> getPosicion(PosicionXml posiXml) {
		return new Posicion<Integer, Integer>(posiXml.getX(), posiXml.getY(), (IPositionable) posiXml.getEnte());
	}
}
