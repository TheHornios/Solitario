package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
public class Solitario {
	/* Constructor */
	/* Parametros:
	 * Retorna:
	 * Descripcion: crea un objeto Ventana--frame y pone a Ventana--frame que se visivle 
	 */
	public Solitario(){
		Ventana frame = new Ventana();
		frame.setVisible(true);
	}
	/* Parametros:
	 * Retorna:
	 * Descripcion: metodo Main crea un objeto de clse Solitario 
	 */
	public static void main(String[] args){
		new Solitario();
	}
}
