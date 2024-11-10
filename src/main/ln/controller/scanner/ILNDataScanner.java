package main.ln.controller.scanner;

public interface ILNDataScanner {
	boolean confirms();

    String getLine();

    double getDouble();

    int getInteger();
}
