package presentation.MouseHoverObserver;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import mapa.md.IPosition;
import presentation.map.position.IObserver;
import presentation.map.position.ISubject;

@objid ("47f5ba76-8ca7-4dd5-bf74-30bac3a6769d")
public interface IMouseHoverSubject extends ISubject{
    @objid ("8a783e1f-89fc-4adf-b4b5-3a4537905792")
    void setPosition(IPosition<Integer, Integer> posi);
    
    IPosition<Integer, Integer> getRangerPosition();

    @objid ("7cde5e44-e099-43f0-a82c-f3b5eeeb08c1")
    int getRange();  
    
    void registerObserver(IMouseHoverObserver obs);

	IPosition<Integer, Integer> getAtackerPosition();

}
