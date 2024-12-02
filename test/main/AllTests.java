package main;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import WebConnection.XML.XMLParser;
import WebConnection.XML.XMLParserTest;
import acciones.ln.LNAccionesAtaque;
import main.ln.acciones.LNAccionesAtaqueTest;
import main.md.mapa.MapaMatrixTest;

@Suite
@SelectClasses({ MapaMatrixTest.class, LNAccionesAtaqueTest.class, XMLParserTest.class})
public class AllTests {

}
