package com.marlabs.corejava_test4.testing;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.marlabs.corejava_test4.*;

public class TestAddressBook {
	private static AddressBook book;
	
	@BeforeClass
	public static void init() {
		book= new AddressBook();
	}
	
	@AfterClass
	public static void destroy() {
		book=null;
	}
	
	@Test
	public void testAddAddress1() {
		
		try {
			SingleAddress s=new SingleAddress("patel", "Kandarp", "133 garden view","Columbia","md","US", "21046");
			book.addAddress(s);
		}catch(DuplicateAddressException ex) {
			fail();
		}
		
	}
	
	@Test(expected = DuplicateAddressException.class)
	public void testAddAddress2() {
			SingleAddress s=new SingleAddress("patel", "Kandarp", "133 garden view","Columbia","md","US", "21046");
			SingleAddress s1=new SingleAddress("p", "Kandarp", "133 view","Columbia","va","US", "21046");
			book.addAddress(s);
			book.addAddress(s1);
	}

	@Test
	public void testRemoveAddress() {
		SingleAddress s=new SingleAddress("p", "abcd", "133 view","Columbia","va","US", "21046");
		book.addAddress(s);
		SingleAddress result=book.removeAddress("abcd");
		assertEquals(s, result);
	}
	
	@Test
	public void testRemoveAddress1() {
		
		SingleAddress result=book.removeAddress("patel");
		assertEquals(null, result);
	}
	
	@Test
	public void testDisplay() {	
		try {
			book.addAddress(new SingleAddress("patel", "Kanney", "1625 diamond st","philly","pa","US", "19121"));
			book.Display();
		}catch (Exception e) {
			// TODO: handle exception
			fail();
		}
	}
}
