package MD.Mapa;

import MD.Ente.Ente;

public class Posicion<X,Y> {
	private X x;
	private Y y;
	private Ente ente;
	

	public Posicion(X x, Y y) {
		this(x, y, null);
	}
	
	public Posicion(X x, Y y, Ente ente) {
		super();
		this.x = x;
		this.y = y;
		this.ente = ente;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ente.toString();
	}
	
	public X getX() {
		return x;
	}
	public void setX(X x) {
		this.x = x;
	}
	public Y getY() {
		return y;
	}
	public void setY(Y y) {
		this.y = y;
	}
	public Ente getEnte() {
		return ente;
	}
	public void setEnte(Ente ente) {
		this.ente = ente;
	}
	
	
}
