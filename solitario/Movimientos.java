package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Movimientos{
	/* Constructor */
	public Movimientos(){
	}
	/* Parametros: MouseEvent--e, ArrayList<Cartas>--c
	 * Retorna:	Cartas--carta
	 * Descripcion: recorremos ArrayList<Cartas>--c y si el ejeY del MouseEvent--e esta entre el ejeY de las cartas y el ejeY+85 de las cartas
	 * 		la carta es retornada 
	 */
	public Cartas cartaSelecionada(MouseEvent e,ArrayList<Cartas> c){
		Cartas carta=null;
		for(Cartas cart:c){
			if(cart.getEjeYa()>=e.getY()+85&&cart.getEjeYa()<=e.getY()){
				carta = cart;
			}
		}		
		return carta;
	}
}
