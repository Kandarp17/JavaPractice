package com.marlabs.corejava_test4;

public class Demo {
	public static void main(String[] args) {
		AddressBook book= new AddressBook();
		SingleAddress s=new SingleAddress("patel", "Kandarp", "133 garden view","Columbia","md","US", "21046");
		SingleAddress s1=new SingleAddress("patel", "Kan", "133 garden view","Columbia","md","US", "21046");
		SingleAddress s2=new SingleAddress("patel", "Kandarp1", "1813 master st","Philly","md","US", "19121");
		SingleAddress s3=new SingleAddress("patel", "Kanney", "1625 diamond st","philly","pa","US", "19121");
		SingleAddress s4=new SingleAddress("abcd", "Kanney", "1813 master st","Newyork","NY","US", "01101");
		System.out.println("-----------Adding s--------");
		book.addAddress(s);
		System.out.println("-----------Adding s1-------");
		book.addAddress(s1);
		System.out.println("-----------Adding s2-------");
		book.addAddress(s2);
		System.out.println("-----------Adding s3-------");
		book.addAddress(s3);
		System.out.println("------------------After Adding-------------------");
		book.Display();
		book.removeAddress("Kandarp");
		System.out.println("------------------After removing Kandarp-------------");
		book.Display();
		book.removeAddress("Kandy");
		System.out.println("------------------After removing Kandy-------------");
		book.Display();
		System.out.println("-----------Adding s4-------");
		book.addAddress(s4);
	}
}
