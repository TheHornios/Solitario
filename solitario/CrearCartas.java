package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
import java.util.ArrayList;
import java.util.Collections;

public class CrearCartas {
	/* Atributos */
	private ArrayList<Cartas> baraja;
	private ArrayList<Cartas> mazo1;
	private ArrayList<Cartas> mazo2;
	private ArrayList<Cartas> mazo3;
	private ArrayList<Cartas> mazo4;
	private ArrayList<Cartas> mazo5;
	private ArrayList<Cartas> mazo6;
	private ArrayList<Cartas> mazo7;
	private ArrayList<Cartas> mazoIzquierda;
	/* Constructor */
	public CrearCartas(){
		/*
		 * Inicializo el ArrayList<Cartas>--baraja
		 * Ejecuto los metodos que crean todos los objetos Cartas
		 * Y von el metodo collection desordeno el ArrayList<Cartas>--baraja de forma aleatoria 
		 */
		baraja = new ArrayList<>();	
		crearCartasPicas();
		crearCartasCorazones();
		crearCartasRombos();
		crearCartasTreboles();
		Collections.shuffle(baraja);
	}
	/* Parametros:  
	 * Retorna:	ArrayList<Cartas> de la variavle  baraja
	 * Descripcion: Sirve para retornar la variavle baraja qu es un ArrayList<Cartas> que contiene todas las cartas del solitario
	 */
	public  ArrayList<Cartas> crearM(){
		return baraja;
	}
	/* Parametros:  
	 * Retorna:	
	 * Descripcion: Crea los objetos de picas de la clase cartas con un bulcle y cada objeto es añadido a la baraja
	 * 		La varivale m nos sirve para mas tarde poder printear el Jlabel utilizando el JLayeredPane
	 */
	public void crearCartasPicas(){
		int m  = 40;
		for(int i = 1; i<14;i++){
			baraja.add(new Cartas(i,'P',m,1));
			m--;
		}
	}
	/* Parametros:  
	 * Retorna:	
	 * Descripcion: Crea los objetos de corazones de la clase cartas con un bulcle y cada objeto es añadido a la baraja
	 * 		La varivale m nos sirve para mas tarde poder printear el Jlabel utilizando el JLayeredPane
	 */
	public void crearCartasCorazones(){
		int m  = 40;
		for(int i = 1; i<14;i++){
			baraja.add(new Cartas(i,'C',m,2));
			m--;
		}
	}
	/* Parametros:  
	 * Retorna:	
	 * Descripcion: Crea los objetos de rombos de la clase cartas con un bulcle y cada objeto es añadido a la baraja
	 * 		La varivale m nos sirve para mas tarde poder printear el Jlabel utilizando el JLayeredPane
	 */
	public void crearCartasRombos(){
		int m  = 40;
		for(int i = 1; i<14;i++){
			baraja.add(new Cartas(i,'R',m,2));
			m--;
		}
	}
	/* Parametros:  
	 * Retorna:	
	 * Descripcion: Crea los objetos de treboles de la clase cartas con un bulcle y cada objeto es añadido a la baraja
	 * 		La varivale m nos sirve para mas tarde poder printear el Jlabel utilizando el JLayeredPane
	 */
	public void crearCartasTreboles(){
		int m  = 40;
		for(int i = 1; i<14;i++){
			baraja.add(new Cartas(i,'T',m,1));
			m--;
		}
	}
	/* Parametros:  
	 * Retorna:	ArrayList<Cartas>--mazo1
	 * Descripcion: crea el ArrayList<> de mazo1 que contiene la 0 carta de baraja
	 * 		Y llama al metodo posicionCartasMazo() 
	 */
	public ArrayList<Cartas> crearMazo1(){	
		mazo1 = new ArrayList<>();
		mazo1.add(baraja.get(0));
		posicionCartasMazo(mazo1,109);
		return mazo1;
	}
	/* Parametros:  
	 * Retorna:	ArrayList<Cartas>--mazo2
	 * Descripcion: crea el ArrayList<> de mazo2 que contiene la 1,2 carta de baraja
	 * 		Y tambien llama al metodo ponerCartaTrasera()
	 * 		Y llama al metodo posicionCartasMazo() 
	 */
	public ArrayList<Cartas> crearMazo2(){
		mazo2 = new ArrayList<>();
		mazo2.add(baraja.get(1));
		ponerCartaTrasera(mazo2);
		mazo2.add(baraja.get(2));
		posicionCartasMazo(mazo2,209);
		return mazo2;
	}
	/* Parametros:  
	 * Retorna:	ArrayList<Cartas>--mazo3
	 * Descripcion: crea el ArrayList<> de mazo3 que contiene la 3,4,5 carta de baraja
	 * 		Y tambien llama al metodo ponerCartaTrasera()
	 * 		Y llama al metodo posicionCartasMazo() 
	 */
	public ArrayList<Cartas> crearMazo3(){
		mazo3 = new ArrayList<>();
		mazo3.add(baraja.get(3));
		mazo3.add(baraja.get(4));
		ponerCartaTrasera(mazo3);
		mazo3.add(baraja.get(5));
		posicionCartasMazo(mazo3,309);
		return mazo3;
	}
	/* Parametros:  
	 * Retorna:	ArrayList<Cartas>--mazo4
	 * Descripcion: crea el ArrayList<> de mazo4 que contiene la 6,7,8,9 carta de baraja
	 * 		Y tambien llama al metodo ponerCartaTrasera()
	 * 		Y llama al metodo posicionCartasMazo() 
	 */
	public ArrayList<Cartas> crearMazo4(){
		mazo4 = new ArrayList<>();
		mazo4.add(baraja.get(6));
		mazo4.add(baraja.get(7));
		mazo4.add(baraja.get(8));
		ponerCartaTrasera(mazo4);
		mazo4.add(baraja.get(9));
		posicionCartasMazo(mazo4,409);
		return mazo4;
	}
	/* Parametros:  
	 * Retorna:	ArrayList<Cartas>--mazo5
	 * Descripcion: crea el ArrayList<> de mazo5 que contiene la 10,11,12,13,14 carta de baraja
	 * 		Y tambien llama al metodo ponerCartaTrasera()
	 * 		Y llama al metodo posicionCartasMazo() 
	 */
	public ArrayList<Cartas> crearMazo5(){
		mazo5 = new ArrayList<>();
		mazo5.add(baraja.get(10));
		mazo5.add(baraja.get(11));
		mazo5.add(baraja.get(12));
		mazo5.add(baraja.get(13));
		ponerCartaTrasera(mazo5);
		mazo5.add(baraja.get(14));
		posicionCartasMazo(mazo5,509);
		return mazo5;
	}
	/* Parametros:  
	 * Retorna:	ArrayList<Cartas>--mazo6
	 * Descripcion: crea el ArrayList<> de mazo6 que contiene la 15,16,17,18,19,20 carta de baraja
	 * 		Y tambien llama al metodo ponerCartaTrasera()
	 * 		Y llama al metodo posicionCartasMazo() 
	 */
	public ArrayList<Cartas> crearMazo6(){
		mazo6 = new ArrayList<>();
		mazo6.add(baraja.get(15));
		mazo6.add(baraja.get(16));
		mazo6.add(baraja.get(17));
		mazo6.add(baraja.get(18));
		mazo6.add(baraja.get(19));
		ponerCartaTrasera(mazo6);
		mazo6.add(baraja.get(20));
		posicionCartasMazo(mazo6,609);
		return mazo6;
	}
	/* Parametros:  
	 * Retorna:	ArrayList<Cartas>--mazo7
	 * Descripcion: crea el ArrayList<> de mazo7 que contiene la 21,22,23,24,25,26,27 carta de baraja
	 * 		Y tambien llama al metodo ponerCartaTrasera()
	 * 		Y llama al metodo posicionCartasMazo() 
	 */
	public ArrayList<Cartas> crearMazo7(){
		mazo7 = new ArrayList<>();
		mazo7.add(baraja.get(21));
		mazo7.add(baraja.get(22));
		mazo7.add(baraja.get(23));
		mazo7.add(baraja.get(24));
		mazo7.add(baraja.get(25));
		mazo7.add(baraja.get(26));
		ponerCartaTrasera(mazo7);
		mazo7.add(baraja.get(27));
		posicionCartasMazo(mazo7,709);
		return mazo7;
	}
	/* Parametros:  
	 * Retorna:	ArrayList<Cartas>--mazoIzquierda
	 * Descripcion: crea el ArrayList<> de mazoIzquierda que contiene las cartas cobrantes del 28 hasta el 39
	 * 		y  a las cartas se les añade el eje x y se indican que estan en el MazoIz
	 */
	public ArrayList<Cartas> crearMazoIzquierda(){
		mazoIzquierda = new ArrayList<>();
		int numero = baraja.size();
		for(int i=28;i<numero;i++){
			mazoIzquierda.add(baraja.get(i));
		}
		for(Cartas c:mazoIzquierda){
			c.setEjeXa(9);
			c.setMazoIz(false);
		}
		return mazoIzquierda;
	}
	/* Parametros:  
	 * Retorna:	ArrayList<Cartas>--mazoIzquierda
	 * Descripcion: retoena la variavle mazoIzquierda de tipo ArrayList<Cartas>
	 */
	public ArrayList<Cartas> getMazoIzquierda(){
		return mazoIzquierda;
	}
	/* Parametros:  Cartas--c
	 * Retorna:	void
	 * Descripcion: añade un objeto Carta en el ArrayList<> mazo1
	 */
	public void setMazo1(Cartas c){
		mazo1.add(c);
	}
	/* Parametros:  Cartas--c
	 * Retorna:	void
	 * Descripcion: añade un objeto Carta en el ArrayList<> mazo2
	 */
	public void setMazo2(Cartas c){
		mazo2.add(c);
	}
	/* Parametros:  Cartas--c
	 * Retorna:	void
	 * Descripcion: añade un objeto Carta en el ArrayList<> mazo3
	 */
	public void setMazo3(Cartas c){
		mazo3.add(c);	
	}
	/* Parametros:  Cartas--c
	 * Retorna:	void
	 * Descripcion: añade un objeto Carta en el ArrayList<> mazo4
	 */
	public void setMazo4(Cartas c){
		mazo4.add(c);
	}
	/* Parametros:  Cartas--c
	 * Retorna:	void
	 * Descripcion: añade un objeto Carta en el ArrayList<> mazo5
	 */
	public void setMazo5(Cartas c){
		mazo5.add(c);
	}
	/* Parametros:  Cartas--c
	 * Retorna:	void
	 * Descripcion: añade un objeto Carta en el ArrayList<> mazo6
	 */
	public void setMazo6(Cartas c){
		mazo6.add(c);
	}
	/* Parametros:  Cartas--c
	 * Retorna:	void
	 * Descripcion: añade un objeto Carta en el ArrayList<> mazo7
	 */
	public void setMazo7(Cartas c){
		mazo7.add(c);
	}
	/* Parametros: 
	 * Retorna:	ArrayList<Cartas>--mazo1
	 * Descripcion: retorna la variavle mazo1
	 */
	public ArrayList<Cartas> getMazo1(){
		return mazo1;
	}
	/* Parametros: 
	 * Retorna:	ArrayList<Cartas>--mazo2
	 * Descripcion: retorna la variavle mazo2
	 */
	public ArrayList<Cartas> getMazo2(){
		return mazo2;
	}
	/* Parametros: 
	 * Retorna:	ArrayList<Cartas>--mazo3
	 * Descripcion: retorna la variavle mazo3
	 */
	public ArrayList<Cartas> getMazo3(){
		return mazo3;
	}
	/* Parametros: 
	 * Retorna:	ArrayList<Cartas>--mazo4
	 * Descripcion: retorna la variavle mazo4
	 */
	public ArrayList<Cartas> getMazo4(){
		return mazo4;
	}
	/* Parametros: 
	 * Retorna:	ArrayList<Cartas>--mazo5
	 * Descripcion: retorna la variavle mazo5
	 */
	public ArrayList<Cartas> getMazo5(){
		return mazo5;
	}
	/* Parametros: 
	 * Retorna:	ArrayList<Cartas>--mazo6
	 * Descripcion: retorna la variavle mazo6
	 */
	public ArrayList<Cartas> getMazo6(){
		return mazo6;
	}
	/* Parametros: 
	 * Retorna:	ArrayList<Cartas>--mazo7
	 * Descripcion: retorna la variavle mazo7
	 */
	public ArrayList<Cartas> getMazo7(){
		return mazo7;
	}
	/* Parametros: ArrayList<Cartas>--mazo
	 * Retorna:	void
	 * Descripcion: El ArrayList<> pasado por parametro es recorrido y a las cartas se les cambia 
	 * 		la Posicion a False
	 */
	public void ponerCartaTrasera(ArrayList<Cartas> mazo){
		for(Cartas a:mazo){
			a.setPosicion(false);
		}
	}
	/* Parametros: ArrayList<Cartas>--mazo, int--numero
	 * Retorna:	void
	 * Descripcion: El ArrayList<> pasado por parametro es recorrido y a las cartas se les hace un 
	 * setEjeXa(numero) y  setEjeYa(ejeY), ejeY es una variavle local que se aumemnta cada vez que se recore una carta 
	 */
	public void posicionCartasMazo(ArrayList<Cartas> mazo,int numero){
		int ejeY = 85;
		for(Cartas c:mazo){
			c.setEjeXa(numero);
			c.setEjeYa(ejeY);
			ejeY +=20;
		}
	}
}
