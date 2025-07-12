package presentation.MouseHoverObserver;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import presentation.map.position.IObserver;

@objid ("f6fc2805-1bde-441c-83c2-5a9670bb88d3")
public interface IMouseHoverObserver extends IObserver{
	void updateMouseRange();
}
