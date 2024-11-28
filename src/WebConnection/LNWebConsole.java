package WebConnection;

import WebConnection.XML.LNXMLScanner;
import WebConnection.XML.Socket;
import mapa.ln.LNMapaMatrixEntesGroup;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("8675d924-8c15-4471-a745-711675e4f5b8")
public class LNWebConsole implements Turnable, Conectable {
	
	
	    @objid ("2ec63203-1453-4b39-bca3-7738ac2cfd35")
    private WebConsole webConsole;

    @objid ("5c30c25b-2184-48fe-9ffe-bedc4a96ae9d")
    private LNEntes lnEntes;

    @objid ("534ed7d9-d87c-4dc5-8e88-17c8c801503e")
    private LNMapaMatrixEntesGroup lnMapa;

    @objid ("44b4fbc2-376a-467d-83b1-edfcb9a532aa")
    private LNXMLScanner lnXmlScanner;

    @objid ("dd113fab-7416-48da-b618-4b62b70c1621")
    public void doTurn() {
    }

    @objid ("e0dea19a-fed2-417f-9c17-9918beae9851")
    public Socket getConnection() {
        // TODO Auto-generated return
        return null;
    }

	@Override
	public void skipTurn() {
		// TODO Auto-generated method stub
		
	}

}
