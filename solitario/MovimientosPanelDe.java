package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
import java.util.ArrayList;
public class MovimientosPanelDe{
	/* Atributos */
	private int picas;
	private int rombos;
	private int corazones;
	private int treboles;
	private MazoDerecha mazoIze;
	/* Constructor */
	public MovimientosPanelDe(MazoDerecha a){
		/*
		 * Inicializo las variavles 
		 */
		mazoIze = a;
		treboles =1;
		picas = 1;
		rombos = 1;
		corazones =1;
	}
	/* Parametros:  Cartas--a,ArrayList<Cartas>--b
	 * Retorna:	void
	 * Descripcion: Si la  Cartas--a esta entre 751 y 900 se llamam al metodo dejarEnCorazonesDe(a,b) si Cartas--a no esta en el 
	 * 		rango anterior se llama al metodo volverOriginal(a)
	 */
	public void panelDerecha(Cartas a,ArrayList<Cartas> b){
		if(a.getEjeXa()>=751 && a.getEjeXa()<=900 /*eje Y */&& a.getEjeYa()>=75 && a.getEjeYa()<=650){
			dejarEnCorazonesDe(a,b);
		}else{
			volverOriginal(a);
		}
	}
	/* Parametros:  Cartas--a, ArrayList<Cartas>--b
	 * Retorna:	void
	 * Descripcion: Si  Cartas--a esta entre 751 y 900 en el eje X y si ademas el valor de Cartas--a es igual a rombos y la letra igual a 'R'
	 * 		La carta es posicionada en 809-220 y  se llama a borrarCarta(b,var-1,'R') la carta retoanda es enviada a la posicion 800-1000 (Esta es la carta que se encontraria en 
	 * 		debajo de la carta recien posicionada es decir si dejamos el 2 en la derecha el 1 se va fuera de la pantalla), y en el caso de que los anteriores if 
	 * 		sean falsos se llama al metodo  dejarEnPicasDe(a,b)
	 */
	public void dejarEnRombosDe(Cartas a,ArrayList<Cartas> b){
		if(a.getEjeXa()>=751 && a.getEjeXa()<=900 /*eje Y */&& a.getEjeYa()>=147 && a.getEjeYa()<=281){
			if(a.getValor()==rombos &&a.getLetra() =='R'){
				a.setEjeXa(809);
				a.setEjeYa(220);
				a.setposicionImagen();
				int var = rombos;
				Cartas carta =borrarCarta(b,var-1,'R');
				if(carta !=null){
					carta.setEjeXa(800);
					carta.setEjeYa(1000);
					carta.setposicionImagen();
				}
				rombos++;
				if(a.isMazoIz()==false){
					mazoIze.removCartas(a);
				}
			}else{
				dejarEnPicasDe(a,b);
			}
		}else{
			dejarEnPicasDe(a,b);
		}
	}
	/* Parametros:  Cartas--a, ArrayList<Cartas>--b
	 * Retorna:	void
	 * Descripcion: Si  Cartas--a esta entre 751 y 900 en el eje X y si ademas el valor de Cartas--a es igual a rombos y la letra igual a 'R'
	 * 		La carta es posicionada en 809-355 y  se llama a borrarCarta(b,var-1,'R') la carta retoanda es enviada a la posicion 800-1000 (Esta es la carta que se encontraria en 
	 * 		debajo de la carta recien posicionada es decir si dejamos el 2 en la derecha el 1 se va fuera de la pantalla), y en el caso de que los anteriores if 
	 * 		sean falsos se llama al metodo  dejarEnTrebolesDe(a,b)
	 */
	public void dejarEnPicasDe(Cartas a,ArrayList<Cartas> b){
		if(a.getEjeXa()>=751 && a.getEjeXa()<=900 /*eje Y */&& a.getEjeYa()>=282 && a.getEjeYa()<=390){
			if(a.getValor()==picas &&a.getLetra() == 'P'){
				a.setEjeXa(809);
				a.setEjeYa(355);
				a.setposicionImagen();
				int var = picas;
				Cartas carta =borrarCarta(b,var-1,'P');
				if(carta !=null){
					carta.setEjeXa(800);
					carta.setEjeYa(1000);
					carta.setposicionImagen();
				}
				picas++;
				if(a.isMazoIz()==false){
					mazoIze.removCartas(a);
				}
			}else{
				dejarEnTrebolesDe(a,b);
			}
		}else{
			dejarEnTrebolesDe(a,b);
		}
	}
	/* Parametros:  Cartas--a, ArrayList<Cartas>--b
	 * Retorna:	void
	 * Descripcion: Si  Cartas--a esta entre 751 y 900 en el eje X y si ademas el valor de Cartas--a es igual a rombos y la letra igual a 'R'
	 * 		La carta es posicionada en 809-85 y  se llama a borrarCarta(b,var-1,'R') la carta retoanda es enviada a la posicion 800-1000 (Esta es la carta que se encontraria en 
	 * 		debajo de la carta recien posicionada es decir si dejamos el 2 en la derecha el 1 se va fuera de la pantalla), y en el caso de que los anteriores if 
	 * 		sean falsos se llama al metodo  dejarEnRombosDe(a,b)
	 */
	public void dejarEnCorazonesDe(Cartas a,ArrayList<Cartas> b){
		if(a.getEjeXa()>=751 && a.getEjeXa()<=900 /*eje Y */&& a.getEjeYa()>=75 && a.getEjeYa()<=146){
			if(a.getValor()==corazones &&a.getLetra() =='C'){
				a.setEjeXa(809);
				a.setEjeYa(85);
				a.setposicionImagen();
				int var = corazones;
				Cartas carta =borrarCarta(b,var-1,'C');
				if(carta !=null){
					carta.setEjeXa(800);
					carta.setEjeYa(1000);
					carta.setposicionImagen();
				}
				corazones++;
				if(a.isMazoIz()==false){
					mazoIze.removCartas(a);
				}
			}else{
				dejarEnRombosDe(a,b);
			}
		}else{
			dejarEnRombosDe(a,b);
		}
	}
	/* Parametros:  Cartas--a, ArrayList<Cartas>--b
	 * Retorna:	void
	 * Descripcion: Si  Cartas--a esta entre 751 y 900 en el eje X y si ademas el valor de Cartas--a es igual a rombos y la letra igual a 'R'
	 * 		La carta es posicionada en 809-490 y  se llama a borrarCarta(b,var-1,'R') la carta retoanda es enviada a la posicion 800-1000 (Esta es la carta que se encontraria en 
	 * 		debajo de la carta recien posicionada es decir si dejamos el 2 en la derecha el 1 se va fuera de la pantalla), y en el caso de que los anteriores if 
	 * 		sean falsos se llama al metodo  volverOriginal(a)
	 */
	public void dejarEnTrebolesDe(Cartas a,ArrayList<Cartas> b){
		if(a.getEjeXa()>=751 && a.getEjeXa()<=900 /*eje Y */&& a.getEjeYa()>=390 && a.getEjeYa()<=613){
			if(a.getValor()==treboles &&a.getLetra() =='T'){
				a.setEjeXa(809);
				a.setEjeYa(490);
				a.setposicionImagen();
				int var = treboles;
				Cartas carta =borrarCarta(b,var-1,'T');
				if(carta !=null){
					carta.setEjeXa(800);
					carta.setEjeYa(1000);
					carta.setposicionImagen();
				}
				treboles++;
				if(a.isMazoIz()==false){
					mazoIze.removCartas(a);
				}
			}else{
				volverOriginal(a);
			}
		}else{
			volverOriginal(a);
		}
	}
	/* Parametros:  Cartas--a
	 * Retorna:	void
	 * Descripcion: El objeto Cartas--a se le añade la posicion que tiene en EjeXa2 y EjeYa2 a EjeXa y EjeYa y se llama al metodo setposicionImagen() de Carta 
	 */
	public void volverOriginal(Cartas a){
		a.setEjeXa(a.getEjeXa2());
		a.setEjeYa(a.getEjeYa2());
		a.setposicionImagen();
		
	}
	/* Parametros:  ArrayList<Cartas>--a, int--i, char--j
	 * Retorna:	Cartas--carta
	 * Descripcion: Se recorre ArrayList<Cartas>--a pasado por parametro y si una carta es igual al al valor int--i y al char--j esa Objeto Carta es retornado 
	 */
	public Cartas borrarCarta(ArrayList<Cartas> a,int i,char j){
		Cartas carta = null;
		for(Cartas c:a){
			if(c.getLetra()==j && c.getValor()==i){
				carta = c;
			}
		}
		return carta;
	}
}
