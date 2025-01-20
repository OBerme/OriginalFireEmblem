package main;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import WebConnection.LNWebConnection;
import WebConnection.LNWebConnectionTest;
import WebConnection.XML.XMLParser;
import WebConnection.XML.XMLParserTest;
import acciones.ln.LNAccionesAtaque;
import main.ln.acciones.LNAccionesAtaqueTest;
import main.md.mapa.MapaMatrixTest;
import md.range.RangeDiagonal;
import md.range.RangeDiagonalTest;
import md.range.RangeRectangleTest;
import md.range.RangeSquareTest;

@Suite
@SelectClasses({ MapaMatrixTest.class, LNAccionesAtaqueTest.class,
	XMLParserTest.class, LNWebConnectionTest.class,
	//the ranges tests
	RangeRectangleTest.class, RangeDiagonalTest.class, RangeSquareTest.class})
public class AllTests {

}
