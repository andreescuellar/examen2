package gt.edu.url.examen2.problema3;
/**
 * @author Andrés Cuéllar
 *  
 */

public class Main {

	public static void main(String[] args) {
		LinkedPositionalList<String> Clist = new LinkedPositionalList<>(); 
		Position<String> ac1,ac2; 
		ac1 = Clist.addFirst("1"); 
		ac2 = Clist.addFirst("2"); 
		 
		
		
		System.out.println(ac1.getElement());
		System.out.println(ac2.getElement());
		
		
		Clist.swap(ac1, ac2);
		String recorrido = null;
		
		do{
		            try{
		                Position<String> tempPos = Clist.first();
		                recorrido = Clist.remove(tempPos);
		                System.out.println(recorrido);
		            }
		            catch(Exception e){
		                System.out.println("Los datos ya han sido swicheados");
		                recorrido =null;
		                break;
		            }
		        }
		while(recorrido != null);  

	}

}