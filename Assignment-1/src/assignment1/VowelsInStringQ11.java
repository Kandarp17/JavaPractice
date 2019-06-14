package assignment1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class VowelsInStringQ11 {
	public static void allVowels(String input) {
		Character[] v={'a','i','u','e','o'};
		Set<Object> vowels=new TreeSet<>(Arrays.asList(v));
		//boxing concept of java8
		v=input.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
		Set<Object> stringChar=new TreeSet<>(Arrays.asList(v));
		stringChar.retainAll(vowels);
		System.out.println(stringChar);
	
	}
	public static void main(String[] args) {
		allVowels("kandarp patel");
	}
}
