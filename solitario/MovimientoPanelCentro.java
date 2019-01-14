package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
import java.util.ArrayList;

public class MovimientoPanelCentro {
	/* Atributos */
	private MazoDerecha mazoDe;
	/* Constructor */
	public MovimientoPanelCentro(MazoDerecha a){
		/*
		 * Inicializo las variavles 
		 */
		mazoDe = a;
	}
	/* Parametros: Cartas--a, ArrayList<Cartas>--b
	 * Retorna:	void 
	 * Descripcion: Si el objeto Carta a tiene la variavle EjeXa entre 50 y 750 y EjeYa entre 75 y 650 llama al metodo primeraColumna(a,b)
	 * 		si no llama al metodo volverOriginal(a)
	 */
	public void moverCartas(Cartas a,ArrayList<Cartas> b){
		if(a.getEjeXa()>=50 && a.getEjeXa()<=750 /*eje Y */&& a.getEjeYa()>=75 && a.getEjeYa()<=650){
			primeraColumna(a,b);
		}else{
			volverOriginal(a);
		}
	}
	/* Parametros: Cartas--a
	 * Retorna:	void 
	 * Descripcion: El objeto carta--a se le añade la posicion que tiene en EjeXa2 y EjeYa2 a EjeXa y EjeYa y se llama al metodo setposicionImagen() de Carta 
	 */
	public void volverOriginal(Cartas a){
		a.setEjeXa(a.getEjeXa2());
		a.setEjeYa(a.getEjeYa2());
		a.setposicionImagen();
		
	}
	/* Parametros: ArrayList<Cartas>--b, int--x1, int--x2
	 * Retorna:	Cartas--carta
	 * Descripcion: recorro el ArrayList b si se cumple que esta ente las variavles x1, x1 y isMovida() es false 
	 * 		del ArrayList sacamos la carta mas alta en el eje Y, la carat amas alta es retornada 
	 */
	public Cartas getCartaMasEnlaCara(ArrayList<Cartas> b,int x1,int x2){
		Cartas carta = null;
		int num = 1;
		for(Cartas c:b){
			if(c.getEjeXa() >=x1 && c.getEjeXa() <=x2 &&c.isMovida() == false){
				if(c.getEjeYa()>num){
					carta = c;
					num = c.getEjeYa();
				}
			}
		}
		return carta;
	}
	/* Parametros: Cartas a, ArrayList<Cartas>--b, int--x1, int--x2
	 * Retorna:	void 
	 * Descripcion: llamamos al metodo getCartaMasEnlaCara(b,x1,x2) y la carta retornada es guardada en Cartas--carta si no es null lo que retorna, 
	 * 		se compruba si el color de Cartas--carta y deCartas-- a es distinto  y que el valor de Cartas--a es mas alto que el de Cartas--carta si 
	 * 		esto es cierto a la Carta--a se le añade las posiciones de el objeto Cartas--carta y si no es asi se ejecuta el metodo volverOriginal(a)
	 */
	public void verSiesValido(Cartas a,ArrayList<Cartas> b,int x1,int x2){
		Cartas carta =getCartaMasEnlaCara(b,x1,x2);
		if(carta != null){
			if(carta.getColor()!=a.getColor() && a.getValor()+1 ==carta.getValor()){
				a.setEjeXa(carta.getEjeXa());
				a.setEjeYa(carta.getEjeYa()+20);
				a.setposicionImagen();
				if(a.isMazoIz()==false){
					mazoDe.removCartas(a);
				}
			}else{
				volverOriginal(a);
			}
		}else{
			volverOriginal(a);
		}
	}
	/* Parametros: ArrayList<Cartas>--b, int--a, int--i
	 * Retorna:	boolean--si 
	 * Descripcion: se recorre el ArrayList<Cartas>--b y si hay cartas entre la variavle int--a y int--i la variavle boolean--si se pone a false 
	 * 		despues boolean--si es retornada 
	 */
	public boolean verEsistenciaCartas(ArrayList<Cartas> b,int a,int i){
		boolean si = true;
		for(Cartas c:b){
			if(c.getEjeXa()>=a && c.getEjeXa()<=i && c.isMovida() == false){
				si = false;
			}
		}
		return si;
	}
	/* Parametros: Cartas--a, ArrayList<Cartas>--b
	 * Retorna:	void
	 * Descripcion: se comprueba que Cartas--a  se encuentra entre 50 y 150 en ese caso se llama al metodo verSiesValido(a,b,100,200) despues se llamam al metodo 	
	 * 		verEsistenciaCartas(b,100,200) si retorna true se comprueba si el valor de Cartas--a es 13 y si es el Cartas--a se posiciona el ejeX en 109 y el ejeY en 85,
	 * 		en el caso de que el primer if fuera falso se llama al metodo segundaColumna(a,b)
	 */
	public void primeraColumna(Cartas a,ArrayList<Cartas> b){
		if(a.getEjeXa()>=50 && a.getEjeXa()<=150 /*eje Y */&& a.getEjeYa()>=75 && a.getEjeYa()<=650){
			verSiesValido(a,b,100,200);
			if(verEsistenciaCartas(b,100,200)){
				if(a.getValor()==13){
					a.setEjeXa(109);
					a.setEjeYa(85);
					a.setposicionImagen();
					if(a.isMazoIz()==false){
						mazoDe.removCartas(a);
					}
				}
			}
		}else{
			segundaColumna(a,b);
		}
	}
	/* Parametros: Cartas--a, ArrayList<Cartas>--b
	 * Retorna:	void
	 * Descripcion: se comprueba que Cartas--a  se encuentra entre 151 y 250 en ese caso se llama al metodo verSiesValido(a,b,201,300) despues se llamam al metodo 	
	 * 		verEsistenciaCartas(b,201,300) si retorna true se comprueba si el valor de Cartas--a es 13 y si es el Cartas--a se posiciona el ejeX en 209 y el ejeY en 85,
	 * 		en el caso de que el primer if fuera falso se llama al metodo terceraColumna(a,b)
	 */
	public void segundaColumna(Cartas a,ArrayList<Cartas> b){
		if(a.getEjeXa()>=151 && a.getEjeXa()<=250 /*eje Y */&& a.getEjeYa()>=75 && a.getEjeYa()<=650){
			verSiesValido(a,b,201,300);
			if(verEsistenciaCartas(b,201,300)){
				if(a.getValor()==13){
					a.setEjeXa(209);
					a.setEjeYa(85);
					a.setposicionImagen();
					if(a.isMazoIz()==false){
						mazoDe.removCartas(a);
					}
				}
			}
		}else{
			terceraColumna(a,b);
		}
	}
	/* Parametros: Cartas--a, ArrayList<Cartas>--b
	 * Retorna:	void
	 * Descripcion: se comprueba que Cartas--a  se encuentra entre 251 y 350 en ese caso se llama al metodo verSiesValido(a,b,301,400) despues se llamam al metodo 	
	 * 		verEsistenciaCartas(b,301,400) si retorna true se comprueba si el valor de Cartas--a es 13 y si es el Cartas--a se posiciona el ejeX en 309 y el ejeY en 85,
	 * 		en el caso de que el primer if fuera falso se llama al metodo cuartaColumna(a,b)
	 */
	public void terceraColumna(Cartas a,ArrayList<Cartas> b){
		if(a.getEjeXa()>=251 && a.getEjeXa()<=350 /*eje Y */&& a.getEjeYa()>=75 && a.getEjeYa()<=650){
			verSiesValido(a,b,301,400);
			if(verEsistenciaCartas(b,301,400)){
				if(a.getValor()==13){
					a.setEjeXa(309);
					a.setEjeYa(85);
					a.setposicionImagen();
					if(a.isMazoIz()==false){
						mazoDe.removCartas(a);
					}
				}
			}
		}else{
			cuartaColumna(a,b);
		}
	}
	/* Parametros: Cartas--a, ArrayList<Cartas>--b
	 * Retorna:	void
	 * Descripcion: se comprueba que Cartas--a  se encuentra entre 351 y 450 en ese caso se llama al metodo verSiesValido(a,b,401,500) despues se llamam al metodo 	
	 * 		verEsistenciaCartas(b,401,500) si retorna true se comprueba si el valor de Cartas--a es 13 y si es el Cartas--a se posiciona el ejeX en 409 y el ejeY en 85,
	 * 		en el caso de que el primer if fuera falso se llama al metodo quintaColumna(a,b)
	 */
	public void cuartaColumna(Cartas a,ArrayList<Cartas> b){
		if(a.getEjeXa()>=351 && a.getEjeXa()<=450 /*eje Y */&& a.getEjeYa()>=75 && a.getEjeYa()<=650){
			verSiesValido(a,b,401,500);
			if(verEsistenciaCartas(b,401,500)){
				if(a.getValor()==13){
					a.setEjeXa(409);
					a.setEjeYa(85);
					a.setposicionImagen();
					if(a.isMazoIz()==false){
						mazoDe.removCartas(a);
					}
				}
			}
		}else{
			quintaColumna(a,b);
		}
	}
	/* Parametros: Cartas--a, ArrayList<Cartas>--b
	 * Retorna:	void
	 * Descripcion: se comprueba que Cartas--a  se encuentra entre 451 y 550 en ese caso se llama al metodo verSiesValido(a,b,501,600) despues se llamam al metodo 	
	 * 		verEsistenciaCartas(b,501,600) si retorna true se comprueba si el valor de Cartas--a es 13 y si es el Cartas--a se posiciona el ejeX en 509 y el ejeY en 85,
	 * 		en el caso de que el primer if fuera falso se llama al metodo sestaColumna(a,b)
	 */
	public void quintaColumna(Cartas a,ArrayList<Cartas> b){
		if(a.getEjeXa()>=451 && a.getEjeXa()<=550 /*eje Y */&& a.getEjeYa()>=75 && a.getEjeYa()<=650){
			verSiesValido(a,b,501,600);
			if(verEsistenciaCartas(b,501,600)){
				if(a.getValor()==13){
					a.setEjeXa(509);
					a.setEjeYa(85);
					a.setposicionImagen();
					if(a.isMazoIz()==false){
						mazoDe.removCartas(a);
					}
				}
			}
		}else{
			sestaColumna(a,b);
		}
	}
	/* Parametros: Cartas--a, ArrayList<Cartas>--b
	 * Retorna:	void
	 * Descripcion: se comprueba que Cartas--a  se encuentra entre 551 y 650 en ese caso se llama al metodo verSiesValido(a,b,601,700) despues se llamam al metodo 	
	 * 		verEsistenciaCartas(b,601,700) si retorna true se comprueba si el valor de Cartas--a es 13 y si es el Cartas--a se posiciona el ejeX en 609 y el ejeY en 85,
	 * 		en el caso de que el primer if fuera falso se llama al metodo septimaColumna(a,b)
	 */
	public void sestaColumna(Cartas a,ArrayList<Cartas> b){
		if(a.getEjeXa()>=551 && a.getEjeXa()<=650 /*eje Y */&& a.getEjeYa()>=75 && a.getEjeYa()<=650){
			verSiesValido(a,b,601,700);
			if(verEsistenciaCartas(b,601,700)){
				if(a.getValor()==13){
					a.setEjeXa(609);
					a.setEjeYa(85);
					a.setposicionImagen();
					if(a.isMazoIz()==false){
						mazoDe.removCartas(a);
					}
				}
			}
		}else{
			septimaColumna(a,b);
		}
	}
	/* Parametros: Cartas--a, ArrayList<Cartas>--b
	 * Retorna:	void
	 * Descripcion: se comprueba que Cartas--a  se encuentra entre 651 y 750 en ese caso se llama al metodo verSiesValido(a,b,701,799) despues se llamam al metodo 	
	 * 		verEsistenciaCartas(b,701,799) si retorna true se comprueba si el valor de Cartas--a es 13 y si es el Cartas--a se posiciona el ejeX en 609 y el ejeY en 85,
	 * 		en el caso de que el primer if fuera falso se llama al metodo volverOriginal(a)
	 */
	public void septimaColumna(Cartas a,ArrayList<Cartas> b){
		if(a.getEjeXa()>=651 && a.getEjeXa()<=750 /*eje Y */&& a.getEjeYa()>=75 && a.getEjeYa()<=650){
			verSiesValido(a,b,701,799);
			if(verEsistenciaCartas(b,701,799)){
				if(a.getValor()==13){
					a.setEjeXa(709);
					a.setEjeYa(85);
					a.setposicionImagen();
					if(a.isMazoIz()==false){
						mazoDe.removCartas(a);
					}
				}
			}
		}else{
			volverOriginal(a);
		}
	}
	
}
