package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
import java.util.ArrayList;

public class VerAcciones {	
	/* Atributos */
	private int posibilidades;
	/* Constructor */
	public VerAcciones(){
		/*
		 * Inicializo las variavles 
		 */
		posibilidades =1;
	}
	/* Parametros:  ArrayList<Cartas>--a
	 * Retorna:	int--posibilidades
	 * Descripcion: Este metodo calcula la cantidad de posivilidades que quedan para hacer esto recorremos  ArrayList<Cartas>--a y comprobamos si
	 * 		si en la pantalla existe algun objeto Carta con valor 1 en ese caso la variavle int--posibilidades es aumentada en uno por cada Objeto,
	 * 		despues volvemos a recorrer el ArrayList<Cartas>--a dentro del anterior for() si hay Objetos--carta que se pueden posicionar dentro de Objetos--carta
	 * 		la variavle int--posibilidades aumenta en un por cada Obejto y despues la variavle int--posibilidades es retornada 
	 */
	public int verCantidadAcciones(ArrayList<Cartas> a){
		posibilidades = 0;
		
		for(Cartas c:a){
			if(c.getValor()==1){
				if(c.getEjeXa()>2&&c.getEjeXa()<800&&c.isPosicion()&&c.getEjeYa()<556){
					posibilidades++;
				}
			}
			int contador = 0;
			for(Cartas w:a){
				
				if(c.getValor()==w.getValor()+1 &&c.isPosicion()&&w.isPosicion()&&c.getLetra()==w.getLetra()){
					if(c.getEjeXa()>100&&c.getEjeXa()<800&&w.getEjeXa()>800 &&w.getEjeXa()<900&&c.getEjeYa()<556&&w.getEjeYa()<556){
						posibilidades++;
					}
				}	
				if(c.getValor()==w.getValor()-1 &&c.isPosicion()&&w.isPosicion()&&c.getColor()!=w.getColor()){
					if(c.getEjeXa()>100&&c.getEjeXa()<800&&w.getEjeXa()>100 &&w.getEjeXa()<800&&c.getEjeYa()<556&&w.getEjeYa()<556){
						posibilidades++;
						if(contador == 0){
							if(c.getEjeXa()!=w.getEjeXa()){
								posibilidades++;
							}else{
								contador++;
							}
						}
					} 
				}
			}
		}
		return posibilidades;
	}
}
