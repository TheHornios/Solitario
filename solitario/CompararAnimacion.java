package solitario;
/*
 * Rodrigo Pascual Arnaiz
 */
import java.util.Comparator;

public class CompararAnimacion implements Comparator<Cartas>{
	/* Parametros: Cartas--o1,Cartas--o2
	 * Retorna: int
	 * Descripcion: sirve para comparar las dos cartas pasadas por parametro y lo que compara es la variavle valor
	 * 		el resultado de la comparacion es retornado como int
	 */
	@Override
	public int compare(Cartas o1, Cartas o2) {
		return new Integer(o2.getValor()).compareTo(new Integer(o1.getValor()));
	}

}
