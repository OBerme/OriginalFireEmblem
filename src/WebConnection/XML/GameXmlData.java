package WebConnection.XML;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import entes.md.Ente;
import mapa.md.PosicionXml;

@XmlRootElement(name = "actions")
public class GameXmlData implements Serializable{
	private List<Ente> damagedEntes;
	private List<PosicionXml> movedEntes; 
	
	public GameXmlData(List<Ente> damagedEntes, List<PosicionXml> movedEntes) {
		super();
		this.damagedEntes = damagedEntes;
		this.movedEntes = movedEntes;
	}

	public GameXmlData() {}
	
	@XmlElementWrapper(name = "damageEntes")
	@XmlElement(name = "ente")
	public List<Ente> getDamagedEntes() {
		return damagedEntes;
	}

	public void setDamagedEntes(List<Ente> damagedEntes) {
		this.damagedEntes = damagedEntes;
	}
	
	@XmlElementWrapper(name = "movedEntes")
	@XmlElement(name = "position")
	public List<PosicionXml> getMovedEntes() {
		return movedEntes;
	}

	public void setMovedEntes(List<PosicionXml> movedEntes) {
		this.movedEntes = movedEntes;
	}
	
	
}
