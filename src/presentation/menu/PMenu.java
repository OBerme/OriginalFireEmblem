package presentation.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("4f6d31ce-4ea8-4adc-b467-4d9252caa9a0")

public class PMenu extends JPanel {

    private List<IPOption> options; // Lista de botones del menú

    
    public PMenu(List<IPOption> options) {
		// TODO Auto-generated constructor stub
    	setLayout(new GridLayout(options.size(), 1)); // Configuración de layout (filas dinámicas)
    	
    	 // Crear los botones
        for (int i = 0; i < options.size(); i++) {
        	IPOption nOption = options.get(i); 
            JButton button = createMenuButton(nOption);
            add(button); // Agregar al panel
        }
        this.options = options;
	}

	private JButton createMenuButton(IPOption nOption) {
		// TODO Auto-generated method stub
		JButton button = new JButton(nOption.getOption());
        button.addActionListener(e -> nOption.doAction()); // Acción asociada al botón
        button.setBackground(Color.LIGHT_GRAY);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return options.toString();
	}
}

