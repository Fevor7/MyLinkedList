package by.htp.linked;

public class Main {

	public static void main(String[] args) {
		String s=null;
		MyLinkedList<String> list = new MyLinkedList<String>();
		list.add("11");
		list.add("22");
		//list.clear();
		list.add("33");
		list.add("44");
		list.add("52");
		list.add("66");
		s=list.set(1, "222");
		System.out.println(s);
		//list.add(2, "777");
		//list.remove();
		System.out.println(list.contains("52"));
		list.remove(3);
		Object [] st = new String [list.getSize()];
		st =list.toArray();
		s=null;
		for (int i = 0; i < list.getSize(); i++) {
			s=(String)st[i];
			System.out.println(s);
		}
		
		System.out.println(list.getSize());

	}
}
