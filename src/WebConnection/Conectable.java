package WebConnection;

import java.net.Socket;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("ee11f1bc-0bfe-43f8-a93c-36f525a5ebf4")
public interface Conectable {
    @objid ("b4ba8b95-5b3d-4301-901e-2ecda12f171c")
    Socket getConnection();

}
