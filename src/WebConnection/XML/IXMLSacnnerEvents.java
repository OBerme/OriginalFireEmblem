package WebConnection.XML;

import java.io.File;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("e11cac74-07a9-4aeb-8d98-1be7b102e1e3")
public interface IXMLSacnnerEvents {
    @objid ("c6c743d0-01f1-4a60-a685-b91215fbd1d7")
    void onXMLScanned(File file);

}
