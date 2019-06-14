package com.marlabs.corejava_test4.testing;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.marlabs.corejava_test4.SingleAddress;

public class TestSingleAddress {
	private static SingleAddress add;
	@BeforeClass
	public static void init() {
		add=new SingleAddress("patel", "Kanney", "1625 diamond st","philly","pa","US", "19121");
	}
	
	@AfterClass
	public static void distroy() {
		add=null;
	}
	
	
	@Test
	public void testToString() {
		String result=add.toString();
		String str="Kanney, patel, 1625 diamond st, philly, pa";
		assertEquals(str,result);
	}
	
	

}
