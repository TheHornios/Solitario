package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
import java.awt.Color;

import javax.swing.JPanel;

public class PanelSu {
	/* Atributos */
	private JPanel panel;
	/* Constructor */
	public PanelSu(){
		
	}
	/* Parametros:
	 * Retorna:	JPanel--panel
	 * Descripcion: se crea el JPanel--panel y se le añade un color al fondo  y despues se le añade la posicion y lo que ocupa 
	 */
	public JPanel panelSuperior(){
		panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(0, 0, 915, 75);
		return panel;
	}
}
