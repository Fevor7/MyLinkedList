package by.htp.linked;
 
 public class MyLinkedList<E> {
 	private int size = 0;
 	private Element<E> element;
 	private Element<E> first;
 	private Element<E> last;
 
 	public MyLinkedList() {
 		element = new Element<E>();
 		first = element.prev;
 		last = element.next;
 	}
 
 	public int getSize() {
 		return size;
 	}
 
 	public void add(E e) {
 		if (size == 0) {
 			Element<E> element = new Element<E>();
 			first = last = element;
 			element.next = element.prev = first;
 			element.e = e;
 		} else {
 			Element<E> element = new Element<E>(e, last, first);
 			Element<E> element2 = last;
 			element2.next = element;
 			last = element;
 		}
 		element.e = e;
 		size  ;
 	}
 
 	public E get(int namber) {
 
 		Element<E> element = first;
 		for (int i = 0; i < namber; i  ) {
 			element = element.next;
 		}
 		return element.e;
 	}
 
 	public E get2(int namber) {
 
 		Element<E> element = last;
 		for (int i = size; i > namber; i--) {
 			element = element.next;
 		}
 		return element.e;
 	}
 
 	public E get3(int namber) {
 
 		Element<E> element = first;
 		for (int i = 0; i < namber; i  ) {
 			element = element.next;
 		}
 		return element.e;
 	}
 
 	public E get4(int namber) {
 		boolean b = ((namber) < (size / 2));
 		if (b) {
 			Element<E> element = first;
 			for (int i = 0; i < namber; i  ) {
 				element = element.next;
 			}
 			return element.e;
 		} else {
 			Element<E> element = last;
 			for (int i = (size-1); i > namber; i--) {
 				element = element.prev;
 			}
 			return element.e;
 		}
 
 		//return element.e;
 
 	}
 
 	private class Element<E> {
 		private E e;
 		private Element<E> prev;
 		private Element<E> next;
 
 		public Element() {
 			this.e = null;
 			this.prev = null;
 			this.next = null;
 		}
 
 		public Element(E e, Element prev, Element next) {
 			this.e = e;
 			this.prev = prev;
 			this.next = next;
 		}
 	}
 }