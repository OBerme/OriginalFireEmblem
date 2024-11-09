package main;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import main.md.mapa.MapaMatrixTest;

@Suite
@SelectClasses({ MapaMatrixTest.class })
public class AllTests {

}
