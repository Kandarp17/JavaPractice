package assignment1;

import java.util.StringTokenizer;

//13. Split a string without using split()
public class SplitStringQ13 {
	public static void split(String input,int index){
		StringTokenizer stringtokenizer = new StringTokenizer(input, ""+input.charAt(index)); 
		while (stringtokenizer.hasMoreElements()) { 
			System.out.println(stringtokenizer.nextToken()); 
			} 

		
	}
	public static void main(String[] args) {
		split("kandarp patel",5);
	}
}
