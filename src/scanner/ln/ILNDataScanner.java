package scanner.ln;

public interface ILNDataScanner {
	boolean confirms();

    String getLine();

    double getDouble();

    int getInteger();
}
