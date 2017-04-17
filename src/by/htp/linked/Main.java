package by.htp.linked;
 
 public class Main {
 
 	public static void main(String[] args) {
 		// TODO Auto-generated method stub
 		//String line = new String();
 		String s="11";
 		//System.out.println(s);
 		MyLinkedList<String> list = new MyLinkedList<String>();
 		list.add(s);
 		list.add("22");
 		list.add("33");
 		list.add("44");
 		list.add("52");
 		list.add("66");
 		System.out.println(list.get4(5));
 		System.out.println(list.get(1));
 		for (int i =0; i<list.getSize(); i  ){
 			System.out.println(list.get4(i));
 		}
 		System.out.println(list.getSize());
 		//System.out.println(list.getFirst());
 		
 	}
 }