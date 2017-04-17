package by.htp.linked;

public class Main {

	public static void main(String[] args) {
		
		MyLinkedList<String> list = new MyLinkedList<String>();
		list.add("11");
		list.add("22");
		list.add("33");
		list.add("44");
		list.add("52");
		list.add("66");
		list.add(3, "777");
		
		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println(list.getSize());

	}
}
