package mapa.md;

import javax.xml.bind.annotation.XmlRootElement;

import entes.md.Ente;

@XmlRootElement(name = "posicion")
public class PosicionXml {

	private int x;
	private int y;
	private Ente ente;
	public PosicionXml() {	}
	
	public PosicionXml(int x, int y, Ente ente) {
		super();
		this.x = x;
		this.y = y;
		this.ente = ente;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Ente getEnte() {
		return ente;
	}

	public void setEnte(Ente ente) {
		this.ente = ente;
	}
}
