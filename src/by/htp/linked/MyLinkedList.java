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
		if (e != null) {
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
	}

	public void add(int namber, E e) {
		boolean b1 = (namber > 0);
		boolean b2 = (namber < size);
		boolean a1 = (namber > size);
		boolean a2 = (namber < 0);
		if (e != null) {
			if (namber == 0) {
				addFirst(e);
			}
			if (namber == size) {
				add(e);
			}
			if (b1 && b2) {
				addTheMiddle(namber, e);
			}
			if (a1 || a2) {
				throw new java.lang.IndexOutOfBoundsException();
			}
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
		if (e != null) {
			add(e);
		}
	}

	public void addFirst(E e) {
		if (e != null) {
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

	public void clear() {
		element = null;
		size = 0;
		element = new Element<E>();
		first = element.prev;
		last = element.next;
	}

	private boolean halfValue(int namber) {
		return ((namber) < (size / 2));
	}

	public void remove() {
		if (size > 0) {
			first = first.next;
			size--;
		} else {
			clear();
		}
	}

	public void remove(int namber) {
		int size2 = size - 1;
		boolean b1 = (namber > 0);
		boolean b2 = (namber < size2);
		boolean a1 = (namber >= size);
		boolean a2 = (namber < 0);
		if (namber == 0) {
			remove();
		}
		if (namber == size2) {
			removeLast();
		}
		if (b1 && b2) {
			Element<E> el = elementSearch2(namber);
			Element<E> el2 = el.prev;
			Element<E> el3 = el.next;
			el3.prev = el.prev;
			el2.next = el.next;
			size--;
		}
		if (a1 || a2) {
			throw new java.lang.IndexOutOfBoundsException();
		}
	}

	private void removeLast() {
		if (size > 0) {
			last = last.prev;
			size--;
		} else {
			clear();
		}
	}

	public Object[] toArray() {
		Object[] arrE = new Object[size];
		for (int i = 0; i < size; i++) {
			arrE[i] = get(i);
		}
		return arrE;
	}

	public boolean contains(E e) {
		boolean b = false;
		if (e != null) {
			for (int i = 0; i < size; i++) {
				Element<E> el = elementSearch2(i);
				if ((el.e).equals(e)) {
					b = true;
					break;
				}
			}
		}
		return b;
	}

	public E set(int namber, E e) {
		E elem = null;
		if (e != null) {
			Element<E> el = elementSearch2(namber);
			elem = el.e;
			el.e = e;
		}
		return elem;
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
