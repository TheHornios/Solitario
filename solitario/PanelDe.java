package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDe {
	/* Atributos */
	private JPanel panel2;
	private JLabel dejarCorazones,dejarPicas,dejarTreboles,dejarRombos;
	/* Constructor */
	public PanelDe(){
		
	}
	/* Parametros:
	 * Retorna:	JPanel--panel2
	 * Descripcion: se crea el JPanel--panel2 y se le añade un color al fondo  y despues se le añade la posicion y lo que ocupa 
	 */
	public JPanel panelDerecho(){
		panel2 = new JPanel();
		panel2.setBackground(new Color(61, 124, 9));
		panel2.setBounds(799,75, 100, 556);
		return panel2;
	}
	/* Parametros:
	 * Retorna:	JLabel--dejarCorazones
	 * Descripcion: se crea el JLabel--dejarCorazones y se le añade una posicion en el panel y el tamano 
	 * 		despues se le añade una Imagen 
	 */
	public JLabel mostrarDejarCorazones(){
		dejarCorazones = new JLabel();
		dejarCorazones.setBounds(809,85,82,123);
		dejarCorazones.setIcon(new ImageIcon(getClass().getResource("/img/DejarCorazones.png")));
		return dejarCorazones;
	}
	/* Parametros:
	 * Retorna:	JLabel--dejarPicas
	 * Descripcion: se crea el JLabel--dejarPicas y se le añade una posicion en el panel y el tamano 
	 * 		despues se le añade una Imagen 
	 */
	public JLabel mostrarDejarPicas(){
		dejarPicas = new JLabel();
		dejarPicas.setBounds(809,355,82,123);
		dejarPicas.setIcon(new ImageIcon(getClass().getResource("/img/DejarPikas.png")));
		return dejarPicas;
	}
	/* Parametros:
	 * Retorna:	JLabel--dejarTreboles
	 * Descripcion: se crea el JLabel--dejarTreboles y se le añade una posicion en el panel y el tamano 
	 * 		despues se le añade una Imagen 
	 */
	public JLabel mostrarDejarTreboles(){
		dejarTreboles = new JLabel();
		dejarTreboles.setBounds(809,490,82,123);
		dejarTreboles.setIcon(new ImageIcon(getClass().getResource("/img/DejarTreboles.png")));
		return dejarTreboles;
	}
	/* Parametros:
	 * Retorna:	JLabel--dejarRombos
	 * Descripcion: se crea el JLabel--dejarRombos y se le añade una posicion en el panel y el tamano 
	 * 		despues se le añade una Imagen 
	 */
	public JLabel mostrarDejarRombos(){
		dejarRombos = new JLabel();
		dejarRombos.setBounds(809,220,82,123);
		dejarRombos.setIcon(new ImageIcon(getClass().getResource("/img/DejarRombos.png")));
		return dejarRombos;
	}
}
