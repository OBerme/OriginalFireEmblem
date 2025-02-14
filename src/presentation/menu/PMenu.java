package presentation.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import mapa.md.IPosition;

@objid ("4f6d31ce-4ea8-4adc-b467-4d9252caa9a0")

public class PMenu extends JPopupMenu implements IPMenu<Integer, Integer>{
	private Component invoker;
    private List<IPOption> options; // Lista de botones del menú

    
    public PMenu(List<IPOption> options, Component invoker) {
		// TODO Auto-generated constructor stub
//    	setLayout(new GridLayout(options.size(), 1)); // Configuración de layout (filas dinámicas)
    	this.invoker = invoker;
    	 // Crear los botones
        for (int i = 0; i < options.size(); i++) {
        	IPOption nOption = options.get(i); 
        	
        	JMenuItem nItem = new JMenuItem(nOption.getOption());
        	
        	nItem.addActionListener(e -> {
        		nOption.doAction();
        	});
        	
            add(nItem); // Agregar al panel
        }
        this.options = options;
	}

    
    //Pre: the positions should be in the corner you want to put
    //Post: it will show the popup options in the position
    @Override 
    public void showMenu(IPosition<Integer, Integer> position) {
    	show(invoker, position.getX(), position.getY());
    }
    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return options.toString();
	}
	
	
	
	public List<IPOption> getOptions() {
		return options;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null) return false;
		
		if(obj instanceof PMenu) {
			 PMenu oMenu = (PMenu)obj;
			 return oMenu.getOptions().equals(getOptions());
		}
		return false;
	}
}

