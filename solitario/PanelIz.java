package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelIz { 
	/* Atributos */
	private JLabel mazo;
	private JPanel panel1;
	/* Constructor */
	public PanelIz(){
	}
	/* Parametros:
	 * Retorna:	JLabel--mazo
	 * Descripcion: se crea el JLabel--mazo y se le añade una posicion en el panel y el tamano 
	 * 		despues se le añade una Imagen 
	 */
	public JLabel mazo(){
		mazo = new JLabel();
		mazo.setBounds(9,85,82,123);
		ImageIcon e = new ImageIcon(getClass().getResource("/img/Solapa.png"));
		mazo.setIcon(e);
		return mazo;
	}
	/* Parametros:
	 * Retorna:	JPanel--panel1
	 * Descripcion: se crea el JPanel--panel1 y se le añade un color al fondo  y despues se le añade la posicion y lo que ocupa 
	 */
	public JPanel panelLateral(){
		panel1 = new JPanel();
		panel1.setBackground(new Color(61, 124, 9));
		panel1.setBounds(0,75, 100, 556);
		return panel1;
	}
}
