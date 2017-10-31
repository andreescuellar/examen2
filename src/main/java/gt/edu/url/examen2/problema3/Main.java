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
		String recorrer = null;
		
		do{
		            try{
		                Position<String> tempPos = Clist.first();
		                recorrer = Clist.remove(tempPos);
		                System.out.println(recorrer);
		            }
		            catch(Exception e){
		                System.out.println("Los datos ya han sido swicheados");
		                recorrer =null;
		                break;
		            }
		        }
		while(recorrer != null);  

	}

}