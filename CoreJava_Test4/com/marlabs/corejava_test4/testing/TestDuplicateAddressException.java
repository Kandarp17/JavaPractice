package com.marlabs.corejava_test4.testing;

import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;
import com.marlabs.corejava_test4.DuplicateAddressException;

public class TestDuplicateAddressException {
	
	@Test(expected= DuplicateAddressException.class )
	public void test1() {
		Set<String> s=new TreeSet<String>();
		s.add("abcd");
		if(!s.add("abcd")) {
			throw new DuplicateAddressException("This address already exists");
		}
	}
	
	@Test(expected= DuplicateAddressException.class )
	public void test2() {
		Set<String> s=new TreeSet<String>();
		s.add("abcd");
		if(!s.add("abcd")) {
			throw new DuplicateAddressException();
		}
	}
}
