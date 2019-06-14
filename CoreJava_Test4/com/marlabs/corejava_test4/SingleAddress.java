package com.marlabs.corejava_test4;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SingleAddress implements Serializable, Comparable<SingleAddress> {
	private String last_name;
	private String first_name;
	private String street_address;
	private String city;
	private String state;
	@SuppressWarnings("unused")
	private String country;
	@SuppressWarnings("unused")
	private String zipcode;
	
	public SingleAddress(String last_name, String first_name, String street_address, String city, String state,
			String country, String zipcode) {
		super();
		this.last_name = last_name;
		this.first_name = first_name;
		this.street_address = street_address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}

	public String getFirst_name() {
		return first_name;
	}

	@Override
	public String toString() {
		return first_name + ", "+last_name+", "+ street_address + ", " + city + ", "+state ;
	}

	
	@Override
	public int compareTo(SingleAddress s) {
		// TODO Auto-generated method stub
		System.out.println("CompareTo Method");
		return this.first_name.compareTo(s.first_name);
		
	}


}
