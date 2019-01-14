package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Cartas {
	/* Atributos */
	private int valor;
	private boolean posicion;
	private int tipo;
	private JLabel imagen;
	private JLabel trasera;
	private char letra;
	private int ejeXa;
	private int ejeYa;
	private boolean movida;
	private int ejeXa2;
	private int ejeYa2;
	private boolean prinetarMazoIz;
	private int color;
	private boolean mazoIz;
	/* Constructor */
	public Cartas(int a,char b,int c,int e){
		/*
		 * Inicializo las variavles 
		 */
		valor = a;
		letra = b;
		posicion = true;
		tipo = c;
		movida = false;
		prinetarMazoIz = true;
		color = e;
		mazoIz = true;
		setMovida(false);
	}
	/* Parametros: booelan--b 
	 * Retorna:	void 
	 * Descripcion: metodo set para indicar si esta en el mazo 
	 */
	public void setMazoIz(boolean b){
		mazoIz = b;
	}
	/* Retorna:	boolean "variavle=mazoIz" 
	 * Descripcion: metodo retorna el estado de la variavle mazoIz
	 */
	public boolean isMazoIz(){
		return mazoIz;
	}
	/* Retorna:	un int que contien el color de la carta 
	 * Descripcion: retorna el color de la carta que puede ser 1 o 2 
	 */
	public int getColor(){
		return color;
	}
	/* Parametros: booelan--a 
	 * Retorna:	void 
	 * Descripcion: sirve para indicar si  la carta ha sido movida o no ser movida 'false' 
	 *		se llama al metodo guaradarPosicionesAnterires()
	 */
	public void setMovida(boolean a){
		movida = a;
		if(movida == false){
			guaradarPosicionesAnterires();
		}
	}
	/* Retorna:	void 
	 * Descripcion: sirve para que las posiciones que se guarden las variavles ejeXa,ejeYa se copien a 
	 * 		las variavles ejeXa2,ejeYa2
	 */
	public void guaradarPosicionesAnterires(){
		ejeXa2 = ejeXa;
		ejeYa2 = ejeYa;
	}
	/* Parametros:  
	 * Retorna:	boolean de la variavle  prinetarMazoIz
	 * Descripcion: sirve para retornar la variavle prinetarMazoIz
	 */
	public boolean isprinetarMazoIz(){
		return prinetarMazoIz;
	}
	/* Parametros: boolean--b
	 * Retorna: void
	 * Descripcion: sirve para guardar el boolean indicado por paramentro en la variavle prinetarMazoIz
	 */
	public void setprinetarMazoIz(boolean b){
		prinetarMazoIz = b;
	}
	/* Parametros:
	 * Retorna: boolean
	 * Descripcion: sirve para que nos retorne la variavle movida que nos sirve para saber si as movido o no la carta 
	 */
	public boolean isMovida(){
		return movida;
	}
	/* Parametros: char--letra
	 * Retorna: void
	 * Descripcion: El char pasado por parametro es guardado en la variavle letra
	 */
	public void setLetra(char letra){
		this.letra = letra;
	}
	/* Parametros: int--tipo
	 * Retorna: void
	 * Descripcion: El int pasado por parametro es guardado en la variavle tipo
	 */
	public void setTipo(int tipo){
		this.tipo = tipo;
	}
	/* Parametros: int--valor
	 * Retorna: void
	 * Descripcion: El int pasado por parametro es guardado en la variavle valor
	 */
	public void setValor(int valor){
		this.valor = valor;
	}
	/* Parametros: boolean--posicionamiento
	 * Retorna: void
	 * Descripcion: El boolean pasado por parametro es guardado en la variavle posicion
	 */
	public void setPosicion(boolean posicionamiento){
		this.posicion = posicionamiento;
	}
	/* Parametros: 
	 * Retorna: int
	 * Descripcion: retorna la variavle valor
	 */
	public int getValor(){
		return valor;
	}
	/* Parametros: 
	 * Retorna: boolean
	 * Descripcion: retorna la variavle posicion
	 */
	public boolean isPosicion(){
		return posicion;
	}
	/* Parametros: 
	 * Retorna: int
	 * Descripcion: retorna la variavle tipo
	 */
	public int getTipo(){
		return tipo;
	}
	/* Parametros: 
	 * Retorna: char
	 * Descripcion: retorna la variavle letra
	 */
	public char getLetra(){
		return letra;
	}
	/* Parametros: int--a
	 * Retorna: void
	 * Descripcion: El int pasado por parametro se guarda en la variavle ejeXa
	 */
	public void setEjeXa(int a){
		ejeXa = a;
	}
	/* Parametros: int--a
	 * Retorna: void
	 * Descripcion: El int pasado por parametro se guarda en la variavle ejeYa
	 */
	public void setEjeYa(int a){
		ejeYa = a;
	}
	/* Parametros: 
	 * Retorna: int
	 * Descripcion: retorna la variavle ejeXa
	 */
	public int getEjeXa(){ 
		return ejeXa;
	}
	/* Parametros: 
	 * Retorna: int
	 * Descripcion: retorna la variavle ejeYa
	 */
	public int getEjeYa(){
		return ejeYa;
	}
	/* Parametros: int--a
	 * Retorna: void
	 * Descripcion: El int pasado por parametro se guarda en la variavle setEjeXa2
	 */
	public void setEjeXa2(int a){
		ejeXa2 = a;
	}
	/* Parametros: int--a
	 * Retorna: void
	 * Descripcion: El int pasado por parametro se guarda en la variavle setEjeYa2
	 */
	public void setEjeYa2(int a){
		ejeYa2 = a;
	}
	/* Parametros: 
	 * Retorna: int
	 * Descripcion: retorna la variavle getEjeXa2
	 */
	public int getEjeXa2(){ 
		return ejeXa2;
	}
	/* Parametros: 
	 * Retorna: int
	 * Descripcion: retorna la variavle getEjeYa2
	 */
	public int getEjeYa2(){
		return ejeYa2;
	}
	/* Parametros: 
	 * Retorna: JLabel
	 * Descripcion: retorna la variavle imagen de tipo JLabel, se le asigna al Jlabel las cordenas y se 
	 * 		le añade una imagen usando la variavle letra y valor.   
	 */
	public JLabel getlabel(){
		imagen = new JLabel();
		imagen.setBounds(getEjeXa(),getEjeYa(),82,123);
		imagen.setIcon(new ImageIcon(getClass().getResource("/img/"+getLetra()+getValor()+".png")));
		return imagen;
	}
	/* Parametros: 
	 * Retorna: JLabel
	 * Descripcion: retorna la variavle trasera de tipo JLabel, se le asigna al Jlabel las cordenas y se 
	 * 		le añade una imagen usando la variavle letra y valor   
	 */
	public JLabel getLabelTrasera(){
		trasera = new JLabel();
		trasera.setBounds(getEjeXa(),getEjeYa(),82,123);
		trasera.setIcon(new ImageIcon(getClass().getResource("/img/Solapa.png")));
		return trasera;
	}
	/* Parametros: 
	 * Retorna: void
	 * Descripcion: la variavle trasera de tipo JLabel se hace invisible
	 */
	public void setPosicionTrasera(){
		trasera.setVisible(false);
	}
	/* Parametros: 
	 * Retorna: void
	 * Descripcion: la variavle imagen de tipo JLabel es printeada en una nueva posicion usando 
	 * 		las variavles EjeXa y EjeYa
	 */
	public void setposicionImagen(){
		imagen.setBounds(getEjeXa(),getEjeYa(),82,123);
	}
}
