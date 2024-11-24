package main;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import main.ln.acciones.LNAccionesAtaque;
import main.md.mapa.MapaMatrixTest;

@Suite
@SelectClasses({ MapaMatrixTest.class, LNAccionesAtaque.class})
public class AllTests {

}
