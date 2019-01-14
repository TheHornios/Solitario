package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
import java.util.ArrayList;
import java.util.Stack;

public class MazoDerecha {
	/* Atributos */
	private ArrayList<Cartas> mazoIzquierda;
	private Stack<Cartas> stackCartas;
	private ArrayList<Cartas> stackCartas2;
	/* Constructor */
	public MazoDerecha(ArrayList<Cartas> a){
		/*
		 * Inicializo las variavles 
		 * llamamos al metodo retornaElStack()
		 * añadimos a la variavle stackCartas2 las cartas del stackCartas
		 */
		mazoIzquierda = a;
		stackCartas = new Stack<Cartas>();
		stackCartas2 = new ArrayList<Cartas>();
		retornaElStack(mazoIzquierda);
		for(Cartas c:stackCartas){
			stackCartas2.add(c);
		}
	}
	/* Parametros: Cartas--c
	 * Retorna:	void 
	 * Descripcion: La Carta pasada por parametro si esta entre el ejeX 900 y el ejeX 100
	 * 		la carta es setprinetarMazoIz(false)
	 */
	public void borrarCartas(Cartas c){
		if(c.getEjeXa()<=900 && c.getEjeXa()>=100){
			c.setprinetarMazoIz(false);
		}
	}
	/* Parametros: ArrayList<Cartas>--a
	 * Retorna:	void 
	 * Descripcion: El ArrayList<> pasado por parametro es recorrido y las Cartas del ArrayList son añadidas a la varivale Stack<Cartas>--stackCartas
	 */
	public void retornaElStack(ArrayList<Cartas> a){
		for(Cartas c:mazoIzquierda){
			stackCartas.push(c);
		}
	}
	/* Parametros: Cartas--c
	 * Retorna:	void 
	 * Descripcion: El objeto carta pasado por parametro es borrado de la varivale Stack<Cartas>--stackCartas y la carta es 
	 * 		setMazoIz(true)
	 */
	public void removCartas(Cartas c){
		stackCartas2.remove(c);
		c.setMazoIz(true);
	}
	/* Parametros: 
	 * Retorna:	ArrayList<Cartas> 
	 * Descripcion: es retornada la variavle stackCartas2 
	 */
	public ArrayList<Cartas> getStackCartas(){
		return stackCartas2;
	}
	/* Parametros: 
	 * Retorna:	ArrayList<Cartas>--listaCartas
	 * Descripcion: Se comprueba si stackCartas esta vacio en ese caso se recorre el stackCartas2 y las cartas son añadidas a stackCartas
	 * 		con un for() de 3  si el stackCartas no esta vacio es removida la carta de la pila y esa carta es añadida al la variavle listaCartas
	 * 		despues de esto se recorre listaCartas y todas las cartas de dentro son posicionaadas en el eje X e Y 
	 * 		despues es retornada la variavle listaCartas
	 */
	public ArrayList<Cartas> retornaCartasDelMazo(){
		ArrayList<Cartas> listaCartas = new ArrayList<Cartas>();
		if(stackCartas.empty()){
			for(Cartas c:stackCartas2){
				stackCartas.push(c);
			}
		}
		for(int i = 0;i<3;i++){
			Cartas c = null;
			if(stackCartas.empty() == false){
				c = stackCartas.pop();
				if(c != null){
					listaCartas.add(c);
				}
			}
		}
		int i = 85+123+9;
		for(Cartas c:listaCartas){
			c.setPosicion(true);
			c.setEjeYa(i);
			c.setEjeXa(9);
			i +=123;
			i=i+9;
		}
		for(Cartas car:listaCartas){
			car.setMovida(false);
		}
		return listaCartas;
	}
}
