package com.marlabs.corejava_test4;
import java.util.Set;
import java.util.TreeSet;

public interface AddressBookImpl {
	public Set<SingleAddress> Address_set= new TreeSet<SingleAddress>();
	
	void addAddress(SingleAddress address);
	
	SingleAddress removeAddress(String first_name);
	
	void Display();
		
}
