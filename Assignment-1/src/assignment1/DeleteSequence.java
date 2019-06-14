package assignment1;

public class DeleteSequence {
	public static void deleteSequence(String input,int start, int end) {
		StringBuffer str= new StringBuffer(input);
		str.delete(start, end+1);
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		deleteSequence("kandarp",2,5);
	}
}
