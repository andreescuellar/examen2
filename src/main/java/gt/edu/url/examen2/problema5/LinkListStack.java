package gt.edu.url.examen2.problema5;

public class LinkListStack {

LinkList li = new LinkList();

public void push(int data) {
    li.insertFirst(data);
}

public void pop() {
    while(!li.isEmpty()){
    li.deleteFirst();
    }
}

public void displayStack() {
    System.out.println("  ");
    li.displayList();
  }
}