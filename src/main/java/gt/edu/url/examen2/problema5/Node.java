package gt.edu.url.examen2.problema5;
/**
 * 
 * @author Andrés Cuéllar
 *
 */

//funcion nodo
public class Node {

public int data;
public Node next;

public Node(int data) {
    this.data = data;
}

public void displayNode() {
    System.out.print(data);
    System.out.print("  ");

 }
}