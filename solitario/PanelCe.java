package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
import java.awt.Color;
import javax.swing.JPanel;

public class PanelCe {
	/* Atributos */
	private JPanel panel3;
	/* Constructor */
	public PanelCe(){
	}
	/* Parametros:
	 * Retorna:	JPanel--panel3
	 * Descripcion: se crea el JPanel--panel3 y se le añade un color al fondo  y despues se le añade la posicion y lo que ocupa 
	 */
	public JPanel panelMedio(){
		panel3 = new JPanel();
		panel3.setBackground(new Color(111, 200, 37));
		panel3.setBounds(100,75,699,556);
		return panel3;
	}

}
