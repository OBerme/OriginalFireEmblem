package WebConnection.XML;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import entes.Estado;
import entes.ln.StateSerVivo;
import entes.md.Ente;
import entes.md.Persona;
import mapa.md.PosicionXml;
import turner.md.enums.TurnerEnumConstant;

public class XMLParserTest {
	private static final String SAVE_FILE_NAME = "tmpGameData.xml";
	@Test
	void parseTest() {
		// TODO Auto-generated method stub
		List<PosicionXml> posiciones = new ArrayList<PosicionXml>();
		
		Ente osqui = new Persona(200, "Oscar", "O", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost());
		Ente jiji = new Persona(700, "jiji", "O", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost());
		posiciones.add(new PosicionXml(0, 0, osqui));
		posiciones.add(new PosicionXml(1, 1, jiji));
		
		
		List<Ente> entes = new ArrayList<Ente>();
		entes.add(osqui);
		entes.add(jiji);
		
		GameXmlData gameXml = new GameXmlData(entes,posiciones);
		
		XMLParser.saveGameXmlData(gameXml, SAVE_FILE_NAME);
		File file = new File(SAVE_FILE_NAME);
		assertTrue(file.exists(), "The file not exists");
	}

	
	@Test
	void getEntesAndPositionsTest() {
		List<PosicionXml> posiciones = new ArrayList<PosicionXml>();
		
		Ente osqui = new Persona(200, "Oscar", "O", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost());
		Ente jiji = new Persona(700, "jiji", "O", new Estado(StateSerVivo.NORMAL),TurnerEnumConstant.SPEED_DIVIDER.getCost());
		posiciones.add(new PosicionXml(0, 0, osqui));
		posiciones.add(new PosicionXml(1, 1, jiji));
		
		
		List<Ente> entes = new ArrayList<Ente>();
		entes.add(osqui);
		entes.add(jiji);
		
		GameXmlData gameXml = XMLParser.getGameXmlData(SAVE_FILE_NAME);
		assertNotNull(gameXml, "The game wasen't saved");
		
		
		assertEquals(gameXml.getDamagedEntes().size(), entes.size(), "The list is the same size as the other");
		assertEquals(gameXml.getMovedEntes().size(), posiciones.size(), "The list is the same size as the other");
		
	}

}
