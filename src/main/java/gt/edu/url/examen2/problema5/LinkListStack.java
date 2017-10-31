package gt.edu.url.examen2.problema5;
/**
 * 
 * @author Andrés Cuéllar
 *
 */
public class LinkListStack {

LinkList li = new LinkList();
//ingrear a stack
public void push(int data) {
    li.insertFirst(data);
}
//sacar de stack
public void pop() {
    while(!li.isEmpty()){
    li.deleteFirst();
    }
}
//mostrar stack
public void displayStack() {
    System.out.println("  ");
    li.displayList();
  }
}