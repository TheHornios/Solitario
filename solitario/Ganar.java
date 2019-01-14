package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ganar {
	/* Atributos */
	private int i; 
	private int	r;
	private int	t;
	private int	p;
	private int	w;
	private JLabel ganar;
	private int ejeX;
	private int ejeY;
	/* Constructor */
	public Ganar(){
		/*
		 * Inicializo las variavles 
		 */
		i=0;
		r=0;
		t=0;
		p=0;
		w=0;
		ejeX = 200;
		ejeY = 2;
		
	}
	/* Parametros:  
	 * Retorna:	JLabel--ganar
	 * Descripcion: retorna la variavle ganar de tipo JLabel, se le asigna al Jlabel las cordenas y se 
	 * 		le añade una imagen usando la ruta relativa 
	 */
	public JLabel ganar(){
		ganar = new JLabel();
		ganar.setBounds(ejeX,ejeY,500,70);
		ganar.setIcon(new ImageIcon(getClass().getResource("/img/Ganar.png")));	
		return ganar;
	}
	/* Parametros:  ArrayList<Cartas>--A
	 * Retorna:	boolean--si
	 * Descripcion: El ArrayList<> pasado por parametro es recorrido y se calcula si las cartas K-R, K-P, K-C, K-T 
	 * 		estan en la posicion 799-900, en el caso de estar en esa posicion la variavle int--i se aumenta en 1 y 
	 * 		si la variavle i llega a 4 la variavle si cambia a true 
	 */
	public boolean ganar(ArrayList<Cartas> a){
		boolean si = false;
		for(Cartas c:a){
			if(c.getEjeXa()>799 && c.getEjeXa()<900){
				if(c.getLetra() == 'R' && c.getValor() == 13 && r == 0){
					i++;
					r++;
				}
				if(c.getLetra() == 'T' && c.getValor() == 13 && t == 0){
					i++;
					t++;
				}
				if(c.getLetra() == 'P' && c.getValor() == 13 && p == 0){
					i++;
					p++;
				}
				if(c.getLetra() == 'C' && c.getValor() == 13 && w == 0){
					i++;
					w++;
				}
			}
		}
		if(i == 4){
			si = true;
		}
		return si;
	}
}
