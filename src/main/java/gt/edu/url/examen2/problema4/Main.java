package gt.edu.url.examen2.problema4;
/**
 * 
 * @author Andrés Cuéllar
 *
 */
public class Main {

	public static void main(String[] args) {
		LinkedPositionalList<String> EV = new LinkedPositionalList<>(); 
		//ingresar elementos
		EV.addFirst("Evany");
		EV.addLast("Anuel");
		EV.addLast("Hector");
		

		//indicar indice a buscar y mostrar su contenido.
		System.out.println(EV.positionAtIndex(2).getElement());
	}
}
