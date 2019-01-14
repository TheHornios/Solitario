package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Toolkit;

public class Ventana extends JFrame implements MouseListener{	
	/* Atributos */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelIz paneIz;
	private JLayeredPane posicion;
	private CrearCartas orden;
	private Cartas carta;
	private MovimientosPanelDe movimientos;
	private MazoDerecha mazoDerecha;
	private int Clicks =1;
	private MovimientoPanelCentro movPanelCe;
	private VoltearCarta voltear;
	private ArrayList<Cartas> animacion;
	private Ganar win;
	private int animacionMazoIz;
	private VerAcciones posibilidad;
	private int [] repeticion ;
	private int contador = 1;
	private int contadorRep = 1;
	/**
	 * Create the frame.
	 */
	/* Constructor */
	public Ventana() {
		/*
		 * Se crea la ventana, se le añade un icono, le añadimos el tamaño a la venta, ponemos que la ventana no pueda ser ampliada de tamaño,
		 * 		y ademas creamos un contentPane y le ponemos un borde 
		 */
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/img/Icono.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 660); 
		setResizable(false);
		this.setLocationRelativeTo(null);
		this.addMouseListener(this);
		posicion = getLayeredPane();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		/*
		 * Añadimos todos los paneles al  contentPane y ademas utilizamos el LayeredPane para posicionar los paneles y los Labels en la posicion mas a delante o mas a tras 
		 */
		//Parte Izquierda
		paneIz = new PanelIz();
		contentPane.add(paneIz.mazo());
		contentPane.add(paneIz.panelLateral());
			//posiciones
			posicion.add(paneIz.panelLateral(),new Integer(1));
			posicion.add(paneIz.mazo(),new Integer(2));
		//Parte Superior
		PanelSu panelSu = new PanelSu();
		contentPane.add(panelSu.panelSuperior());
		
		//Parte Derecha
		PanelDe panelDe = new PanelDe();
		contentPane.add(panelDe.panelDerecho());
		contentPane.add(panelDe.mostrarDejarCorazones());
		contentPane.add(panelDe.mostrarDejarPicas());
		contentPane.add(panelDe.mostrarDejarRombos());
		contentPane.add(panelDe.mostrarDejarTreboles());
			//posiciones
			posicion.add(panelDe.panelDerecho(),new Integer(1));
			posicion.add(panelDe.mostrarDejarCorazones(),new Integer(2));
			posicion.add(panelDe.mostrarDejarPicas(),new Integer(2));
			posicion.add(panelDe.mostrarDejarRombos(),new Integer(2));
			posicion.add(panelDe.mostrarDejarTreboles(),new Integer(2));
			
		//Parte Medio
		PanelCe panelCe = new PanelCe();
		contentPane.add(panelCe.panelMedio());
			//posiciones
			posicion.add(panelCe.panelMedio(),new Integer(1));
			
		//printear las cartas
		orden = new CrearCartas();	
		
		//mazo1	
		pintarMazos(orden.crearMazo1());
		//mazo2
		pintarMazos(orden.crearMazo2());
		//Mazo3
		pintarMazos(orden.crearMazo3());
		//Mazo4
		pintarMazos(orden.crearMazo4());
		//Mazo5
		pintarMazos(orden.crearMazo5());
		//mazo6
		pintarMazos(orden.crearMazo6());
		//Mazo7
		pintarMazos(orden.crearMazo7());
		
		/*
		 * Inicializamos todos los objetos necesarios para el funcionamiento de la ventana 
		 */
		mazoDerecha = new MazoDerecha(orden.crearMazoIzquierda());	
		movimientos = new MovimientosPanelDe(mazoDerecha);
		movPanelCe = new MovimientoPanelCentro(mazoDerecha);
		voltear = new VoltearCarta();
		win = new Ganar();
		posibilidad = new VerAcciones();
		/*
		 * Inicializamos  el array--repeticion y lo rellenamos con numeros del 1 al 20 y despues recorrewmos todo el Mazo de cartas llamando al metodo setMovida(false)
		 */
		repeticion=new int[20];
		for(int i=1;i<20;i++){
			repeticion[i]=i;
		}
		for(Cartas w:orden.crearM()){
			w.setMovida(false);
		}
	}
	/* Parametros: ArrayList<Cartas>--a
	 * Retorna:	void 
	 * Descripcion: Este metodo se encarga de de recorrer el ArrayList<Cartas>--a que le pases por parametro y el JLabel que quine cada Objeto Carta lo ñade al contentPane
	 * 		Ademas utiliza el JLayeredPane--posicion para posicionarlo utilizando el valor Tipo de cada Objeto Carta
	 */
	public void pintarMazos(ArrayList<Cartas> a){
		int pos = 5;
		for(Cartas c:a){	
			if(c.isPosicion()==true){
				contentPane.add(c.getlabel());
				posicion.add(c.getlabel(),new Integer(c.getTipo()));
			}else{
				contentPane.add(c.getLabelTrasera());
				posicion.add(c.getLabelTrasera(),new Integer(pos));
			}
			pos ++;
		}
	}
	/* Parametros: 
	 * Retorna:	void 
	 * Descripcion: Este metodo recorre el ArrayList<Cartas>--orden.crearM() "Este ArrayList contiene todas las cartas" y si hay alguna carta entre 0 y 100 en el eje X
	 * 		la printea en la posicion 1000--0
	 */
	public void borrarCartas(){
		for(Cartas a:orden.crearM()){
			if(a.getEjeXa()>=0 && a.getEjeXa()<=100 &&a.getEjeYa()>=75 &&a.getEjeYa()<=556){
				a.setEjeXa(1000);
				a.setEjeYa(0);
				a.setposicionImagen();
			}
		}
	}
	/* Parametros: MouseEvent--e
	 * Retorna:	Cartas--carta
	 * Descripcion: Este metodo recorre el ArrayList<Cartas>--orden.crearM() y utilizando el MouseEvent--e se calcula que carta se esta pulsando usando las cordenas 
	 * 		en el eje X e Y despues de esto se comprueba que la carta pulsada tiene la posicion en false y el Objeto carta se guarda en la variavle Cartas--carta, que mas tarde va a ser retornada 
	 * 		para calcular que carta es la que estas pulsando se guarda la carta que este volteada y la que tiene el eje Y mas alto 
	 */
	public Cartas buscarCartaTraseraPulsada(MouseEvent e){
		Cartas carta = null;
		int num = 1000;
		for(Cartas c:orden.crearM()){
			if(e.getX()>=c.getEjeXa() && e.getX()<= c.getEjeXa()+82  && e.getY() >= c.getEjeYa() && e.getY() <=c.getEjeYa()+123 &&c.isPosicion() == false){
				if(c.getEjeYa()<num){
					num = c.getEjeXa();
					carta = c;
				}
			}
		}
		return carta;
	}
	/* Parametros:
	 * Retorna:	boolean--si
	 * Descripcion: este metodo llama a el metodo verCantidadAcciones(orden.crearM()) del objeto VerAcciones--posibilidad y el int reornado por el metodo es gradando en 
	 * 		int a, utilizamos el arry repeticion para guardar los ints retornados por el metodo anterior y cuando se llena el array se sobrescrive desde el principio,
	 * 		Despues se recorre el array--repeticion y se comrpueba que todos los numeros que contine son iguales que el primer numero de la primera posicion del array--repeticion
	 * 		si todos los numeros son iguales el boolean--si pasa a contener un true y despues es retornado
	 */
	public boolean perder(){
		boolean si = false;
		int a=posibilidad.verCantidadAcciones(orden.crearM());
		if(contador<20){
			repeticion[contador]=a;
			contador++;
		}else{
			contador = 1;
		}
		contadorRep = 1;
		int valorPrimero = repeticion[2];
		for(int i=1;i<20;i++){
			if(repeticion[i]==valorPrimero){
				contadorRep++;
			}
		}
		if(contadorRep==20){
			si = true;
		}
		return  si;
	}
	/* Parametros: boolean--a
	 * Retorna:	JLabel--perder
	 * Descripcion: Este metodo si boolean--a es true crea el JLabel--perder con una posicion y le añade la imagen de perder, despues el JLabel--perder es retornado 
	 */
	public JLabel printearPerder(boolean a){
		JLabel perder = null;
		if(a == true){
			perder = new JLabel();
			perder.setBounds(200,2,500,70);
			perder.setIcon(new ImageIcon(getClass().getResource("/img/Perder.png")));
		}
		return perder;
	}
	/*												 Action Listener 
	 * Parametros: MouseEvent--e
	 * Retorna:	void
	 * Descripcion: si haces click a la imagen de la izquierda de un mazo, el primer click printea las tres cartas correspondientes, 
	 * 		en el caso de que queden dos cartas en el mazo se printeara la imagen del mazo tachado,
	 * 		en el segundo click borran las tres cartas llamando al metodo borrarCartas().
	 *		En el otro if se encarga de voltear las cartas que estan dadas la vuelta y lo que hace es borra el label trasero y printea el label de la carta en le 
	 *		misma posicion 
	 */
	public void mouseClicked(MouseEvent e) {
		if(e.getX()>=9 && e.getX()<=9+82 &&e.getY()>=85 &&e.getY()<=85+123){
			if(Clicks == 2){
				borrarCartas();
				Clicks = 1;
			}
			if(Clicks == 1){
				pintarMazos(mazoDerecha.retornaCartasDelMazo());
				Clicks++;
				if(mazoDerecha.getStackCartas().size()<=3){
					animacionMazoIz++;
					if(animacionMazoIz==2){
						JLabel trasera;
						trasera = new JLabel();
						trasera.setBounds(9,85,82,123);
						trasera.setIcon(new ImageIcon(getClass().getResource("/img/Solapa1.png")));
						posicion.add(trasera,new Integer (10));
					}
				}
			}
		}
		if(e.getX()>=100 && e.getX()<=799 &&e.getY()>=75 &&e.getY()<=650){
			Cartas carta =buscarCartaTraseraPulsada(e);
			if(carta != null){
				carta=voltear.voltear(carta,orden.crearM());
				if(carta != null){
					carta.setPosicionTrasera();
					carta.setPosicion(true);
					posicion.add(carta.getlabel(),new Integer(carta.getTipo()));

				}
			}					
		}
	}
	/* Parametros: MouseEvent--e
	 * Retorna:	Cartas--carta
	 * Descripcion: Este metodo recorre el ArrayList<>--orden.crearM() y cada carta la añade a ArrayList<Cartas--cartas1 despues con el metodo Collections.sort odenamos el 
	 * 		ArrayList<Cartas--cartas1ArrayList<Cartas--cartas1 despues de ordenarlo recorremos ArrayList<Cartas--cartas1 y se calcula cual es la carta que estas pulsando	
	 * 		utilizanlo el eje Y del MouseEvent--e y calcuando cual es la carta con el eje Y mas cercano a el despues la carta es retornada 
	 */
	public Cartas cartasArrastradas(MouseEvent e){ /*retorna carta que estas pulsando*/
		Cartas carta = null;
		ArrayList<Cartas> cartas1 = new ArrayList<>();
		for(Cartas c:orden.crearM()){
			cartas1.add(c);
		}
		Collections.sort(cartas1,new CompararAnimacion());
		int num = 0;
		int cos = 0;
			for(Cartas c:cartas1){
				if(e.getX()>=c.getEjeXa() && e.getX() <=c.getEjeXa()+82 &&c.isPosicion()==true && c.getEjeXa() <799){
					if(e.getY()-34>=c.getEjeYa() &&e.getY()-34<=c.getEjeYa()+20){
						if(c.getEjeYa()>num){
							num = c.getEjeYa();
							carta = c;
						}
					}else{
						if(e.getY()-34>=c.getEjeYa() && e.getY()-34 <=c.getEjeYa()+123){
							if(c.getEjeYa()>cos){
							carta =c;
							cos = c.getEjeYa();
							}
						}	
					}
				}
			}
		return carta;
	}
	/* Parametros: Cartas--a
	 * Retorna:	ArrayList<Cartas>--ani
	 * Descripcion: añadimos todas las cartas del ArrayList<>--orden.crearM() a ArrayList<Cartas>--cartas1 despues ordenamos el ArrayList<Cartas>--cartas1 y lo recorremos	
	 * 		y utilizando la Cartas--a pasada por parametro calcuamos las cartas que tengan el eje x igual y y tengan el eje y mas alto y las añadimos al ArrayList<Cartas>--ani
	 * 		y despues añadimos a ese arrayList la Cartas--a, despues es retornado  ArrayList<Cartas>--ani
	 */
	public ArrayList<Cartas> retornaArrayCartas(Cartas a){
		ArrayList<Cartas> ani = new ArrayList<>();
		ArrayList<Cartas> cartas1 = new ArrayList<>();
		for(Cartas c:orden.crearM()){
			cartas1.add(c);
		}
		Collections.sort(cartas1,new CompararAnimacion());
		if(a != null){
			for(Cartas w:cartas1){
				if(a.getEjeYa()< w.getEjeYa() && a.getEjeXa() == w.getEjeXa() && a.isPosicion() == true &&a.getEjeXa() >100 && a.getEjeXa() <799){
					ani.add(w);
				}	
			}
			if(a.isPosicion() == true){
				ani.add(a);	
			}
		}
		return ani;
	}
	/*												 Action Listener 
	 * Parametros: MouseEvent--e
	 * Retorna:	void
	 * Descripcion: Cada vez que clikemos y arrastremos al mismo tiempo el raton se ejecuta el metodo printearPerder(perder()) que retorna un Jlabel que lo guardamos en
	 * 		JLabel--p si JLabel--p no es null lo printeamos en la pantalla, despues  se ejecuta el metodo cartasArrastradas(e) que retorna un objeto Cartas que es cuardado en
	 * 		Cartas--carta si el objeto no es null se le añade al ArrayList<>--animacion las cartas que retorne el metodo retornaArrayCartas(carta).
	 * 		en este momento necesitamos implementar otro  Action Listener para poder mover las cartas. 
	 */
	public void mousePressed(MouseEvent e) {
		JLabel p =printearPerder(perder());
		if(p != null){
			posicion.add(p ,new Integer(5));
		}
		carta = cartasArrastradas(e);
		if(carta !=null){
			animacion = new ArrayList<>();
			animacion = retornaArrayCartas(carta);
			Collections.sort(animacion,new CompararAnimacion());
		}
		this.addMouseMotionListener(new MouseMotionListener() {	
			/*Parametros: MouseEvent--e
			 * Retorna:	void
			 * Descripcion: este metodo reccorre todo el  ArrayList<>--animacion y las cartas que contine las mueve utilizando el valor X e Y de MouseEvent--e y si la carta es
			 * 		movida la variavle de la carta Movida se pone a true 
			 */
			public void mouseDragged(MouseEvent e) {
				if(carta !=null){	
					int i = 0;
					for(Cartas c:animacion){
						c.setEjeXa(e.getX()-45);
						c.setEjeYa(e.getY()-96+i);
						c.setposicionImagen();
						c.setMovida(true);
						i += 20;
					}
				}
			}
			public void mouseMoved(MouseEvent e) {}		
		});
	}
	/*												 Action Listener 
	 * Parametros: MouseEvent--e
	 * Retorna:	void
	 * Descripcion: Este metodo se encaraga de de calcular cuando as sotado el raton, se llama al metodo arrayCartasMovidas() que retorna un ArrayList<Cartas> este array
	 * 		es guardado en ArrayList<Cartas>--cartaRe, si el ArrayList<Cartas>--cartaRe solo tiene un objeto se comprueba si el lugar donde esta es valido llamando al metodo 
	 * 		movimientos.panelDerecha(w,orden.crearM()) o movPanelCe.moverCartas(w,orden.crearM()) y despues la carta se le pone el valor movida a false,
	 * 		En el caso de que ArrayList<Cartas>--cartaRe tenga mas de una carta se comprueba que todas las cartas estan en una posicion valida llamando a
	 * 		movimientos.panelDerecha(w,orden.crearM()) o movPanelCe.moverCartas(w,orden.crearM()) y despues se pone a todas las cartas movida en false
	 * 		En el caso de que el metodo win.ganar() retorne un true se printe en pantalla el label de ganar
	 */
	public void mouseReleased(MouseEvent e) {
		ArrayList<Cartas> cartaRe = new ArrayList<>();
		cartaRe = arrayCartasMovidas();
		Collections.sort(cartaRe,new CompararAnimacion());
		if(cartaRe.size() > 1){	/*Sirve para el movimiento de muchas cartas*/
			animacion.clear();
			for(Cartas w:cartaRe){
				if(w.getEjeXa()>=-400 && w.getEjeXa()<=750 && w.isPosicion()){
					movPanelCe.moverCartas(w,orden.crearM());
					w.setMovida(false);
				}
				if(w.getEjeXa()>=751 && w.getEjeXa()<=900){
					movimientos.volverOriginal(w);
				}
			}	
		}
		if(cartaRe.size() == 1){ /*movimiento de una carta*/
			animacion.clear();
			for(Cartas w:cartaRe){
				if(w.getEjeXa()>=751 && w.getEjeXa()<=900){
					movimientos.panelDerecha(w,orden.crearM());
					w.setMovida(false);
				}
				if(w.getEjeXa()>=-400 && w.getEjeXa()<=750 && w.isPosicion()){
					movPanelCe.moverCartas(w,orden.crearM());
					w.setMovida(false);
				}
			}
		}
		if(win.ganar(orden.crearM())){
			posicion.add(win.ganar(),new Integer(10));
		}
	}
	/*Action Listener  
	 */
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	/* Parametros:
	 * Retorna:	ArrayList<Cartas>--catas
	 * Descripcion: este metodo se encarga de recorrer el ArrayList<Cartas>--orden.crearM() y ver todas las cartas que Movida es true,
	 * 		estas cartas son añadidas a ArrayList<Cartas>--catas que mas tarde va a ser retornado 
	 */
	public ArrayList<Cartas> arrayCartasMovidas(){
		ArrayList<Cartas> catas = new ArrayList<>();
		for(Cartas c:orden.crearM()){
			if(c.isMovida()){
				catas.add(c);
			}
		}
		return catas;
	}
}
