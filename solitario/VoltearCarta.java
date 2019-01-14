package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
import java.util.ArrayList;

public class VoltearCarta {
	/* Constructor */
	public VoltearCarta(){
		
	}
	/* Parametros:Cartas--c, ArrayList<Cartas>--b
	 * Retorna:	Cartas--carta
	 * Descripcion: se recorre el ArrayList<Cartas>--b y se comprueba si el eje X de Cartas--c y las cartas del ArrayList<Cartas>--b son iguales y si an sido movidas 
	 * 		en el caso de que si un contador aumenta en 1 si el contador se queda en 0 retorna la Cartas--c
	 */
	public Cartas voltear(Cartas c,ArrayList<Cartas> b){
		Cartas carta = null;
		int contador = 0;
		for(Cartas w:b){
			if(w.getEjeXa()==c.getEjeXa()&&w.isPosicion() == true){
				contador = 1;
			}
		}
		if(contador==0){
			carta = c;
		}
		return carta;
	}
}
