package gt.edu.url.examen2.problema4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Andrés Cuéllar
 *  
 */

public class LinkedPositionalList<E> implements PositionalList<E>, Iterable<E> {

	//Nodos de siguiente y anterior
	private static class Node<E> implements Position<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		public E getElement() throws IllegalStateException {
			if (next == null) 
				throw new IllegalStateException("Posicion invalida");
			return element;
		}
		
		public void setElement(E e) {
			element = e;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

	}
	
	private class PositionIterator implements Iterator<Position<E>> {
		private Position<E> cursor = first(); 
		private Position<E> recent = null;
		public boolean hasNext() { return (cursor != null); }
		
		public Position<E> next( ) throws NoSuchElementException {
			if (cursor == null) throw new NoSuchElementException("No queda mas elemento");
			recent = cursor;
			cursor = after(cursor);
			return recent;
		}
		
		public void remove( ) throws IllegalStateException {
			if (recent == null) throw new IllegalStateException("No hay elemento para remover");
			LinkedPositionalList.this.remove(recent);
			recent = null;
		}
	}
	
	private class PositionIterable implements Iterable<Position<E>> {
		public Iterator<Position<E>> iterator() { return new PositionIterator(); }
	}
	
	public Iterable<Position<E>> positions( ) {
		return new PositionIterable();
	}
	
	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> posIterator = new PositionIterator( );
		public boolean hasNext( ) { return posIterator.hasNext( ); }
		public E next( ) { return posIterator.next( ).getElement( ); } 
		public void remove( ) { posIterator.remove( ); }
	}
	
	public Iterator<E> iterator( ) { return new ElementIterator( ); }
	
	

	private Node<E> header = null;
	private Node<E> trailer = null;
	private int size = 0;

	public LinkedPositionalList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("P invalido");
		Node<E> node = (Node<E>) p; 
		if (node.getNext() == null)
			throw new IllegalArgumentException("P ya NO esta en el Stack");
		return node;
	}

	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer)
			return null; // 
		return node;
	}



	public int size() {return size;}

	public boolean isEmpty() {return size == 0;}

	public Position<E> first( ) {
		return position(header.getNext());
	}

	public Position<E> last( ) {
		return position(trailer.getPrev());
	}
	
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getPrev());
	}

	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}
	
	//agregar entre dos referencias
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest = new Node<>(e, pred, succ);
		succ.setPrev(newest);
		pred.setNext(newest);
		size++;
		return newest;
	}
	//agregar primero
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}
	//agregar de ultimo
	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}
	//añadir antes de una referencia 
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}
	//agregar despues de una referencia
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{ 
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}
	//incluir elemento 
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}
	// eliminar elemento 
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return answer;
	}
	//metodo para buscar elemento 
	public Position<E> positionAtIndex(int i) throws IndexOutOfBoundsException {
		Node top = header.getNext();
		int lu = 0;
		
		while(top != null)
		{
			if(lu == i -1)
			
				return top;
			lu++;
			top = top.getNext();
	   }
		return null;
		
			
	 }

}
