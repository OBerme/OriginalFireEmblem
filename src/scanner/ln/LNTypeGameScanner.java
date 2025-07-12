package scanner.ln;

import scanner.md.TypeGameScanner;

public class LNTypeGameScanner implements ILNTypeGameScanner  {
    protected TypeGameScanner typeGameScanner;

    // Constructor
    public LNTypeGameScanner(TypeGameScanner typeGameScanner) {
        this.typeGameScanner = typeGameScanner;
    }

	@Override
	public Integer getTypeGameOption() {
		// TODO Auto-generated method stub
		return this.typeGameScanner.getTypeGameOption();
	}

}
