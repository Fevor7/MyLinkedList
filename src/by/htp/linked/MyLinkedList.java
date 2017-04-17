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
			Element<E> el = new Element<E>();
			first = last = el;
			el.next = el.prev = first;
			el.e = e;
		} else {
			Element<E> el = new Element<E>(e, last, first);
			last.next = el;
			last = el;
		}
		size++;
	}

	public void add(int namber, E e) {
		int si=size-1;
		if (namber == 0) {
			addFirst(e);
		}
		if (namber == si) {
			add(e);
		}
		if ((namber > 0) && (namber < si)) {
			addTheMiddle(namber, e);
		}
		if (namber > si){
			throw new java.lang.IndexOutOfBoundsException();
		}
	}

	private void addTheMiddle(int namber, E e) {
			Element<E> el = elementSearch2(namber);
			Element<E> el2 = new Element<E>(e, el.prev, el);
			Element<E> el3 = el.prev;
			el.prev = el2;
			el3.next = el2;
			size++;
	}

	public void addLast(E e) {
		add(e);
	}

	public void addFirst(E e) {
		if (size == 0) {
			Element<E> el = new Element<E>(e, first, first);
			first = last = el;

		} else {
			Element<E> el = new Element<E>(e, first.prev, first);
			Element<E> el2 = first;
			el2.prev = el;
			first = el;

		}
		size++;
	}

	public E getFirst() {
		return first.e;
	}

	public E getLast() {
		return last.e;
	}

	public E get(int namber) {
		E el = null;
		if ((namber >= 0) && (namber < size)) {
			el = elementSearch(namber);
		} else {
			throw new java.lang.IndexOutOfBoundsException();
		}
		return el;
	}

	private E elementSearch(int namber) {
		if (halfValue(namber)) {
			Element<E> el = first;
			for (int i = 0; i < namber; i++) {
				el = el.next;
			}
			return el.e;
		} else {
			Element<E> el = last;
			for (int i = (size - 1); i > namber; i--) {
				el = el.prev;
			}
			return el.e;
		}
	}

	private Element<E> elementSearch2(int namber) {
		if (halfValue(namber)) {
			Element<E> el = first;
			for (int i = 0; i < namber; i++) {
				el = el.next;
			}
			return el;
		} else {
			Element<E> el = last;
			for (int i = (size - 1); i > namber; i--) {
				el = el.prev;
			}
			return el;
		}
	}

	private boolean halfValue(int namber) {
		return ((namber) < (size / 2));
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

		public Element(E e) {
			this.e = e;
		}

		public Element(E e, Element prev, Element next) {
			this.e = e;
			this.prev = prev;
			this.next = next;
		}
	}
}
