package gt.edu.url.examen2.problema5;
/**
 * 
 * @author Andrés Cuéllar
 *
 */
public class LinkList {

private Node first = null;
//insertar primero
public void insertFirst(int data) {
    Node n = new Node(data);
    n.next = first;
    first = n;
}
//eliminar primero
public Node deleteFirst() {
    Node temp = first;
    first = first.next;
    return temp;
}
//mostrar
public void displayList() {
    Node current = first;
    while (current != null) {
        current.displayNode();
        current = current.next;
    }
}
//verificar si esta vacio
public boolean isEmpty() {
    return (first == null);
  }
}