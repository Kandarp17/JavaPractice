package com.marlabs.corejava_test4;

import java.util.Iterator;

public class AddressBook implements AddressBookImpl {

	@Override
	public void addAddress(SingleAddress address) {
		// TODO Auto-generated method stub
			if(!Address_set.add(address)) {
				throw new DuplicateAddressException("This address already exists");
			}
	}

	@Override
	public SingleAddress removeAddress(String first_name) {
		// TODO Auto-generated method stub
		Iterator<SingleAddress> iterator= Address_set.iterator();
		while( iterator.hasNext()) {
			SingleAddress s= iterator.next();
			System.out.println("Comparing first name:"+ s.getFirst_name());
			if(s.getFirst_name().equals(first_name)) {
				iterator.remove();
				return s;
			}
		}
		return null;
	}

	@Override
	public void Display() {
		// TODO Auto-generated method stub
		Iterator<SingleAddress> iterator= Address_set.iterator();
		while( iterator.hasNext()) {
			SingleAddress s= iterator.next();
			System.out.println(s.toString());
		}
		
	}
	
}
