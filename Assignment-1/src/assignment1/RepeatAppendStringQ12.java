package assignment1;
/*
 Repeat a String number of times and append it
Ex: hello 4
hellohellohellohello
 */
public class RepeatAppendStringQ12 {
	public static void repeatAppendStr(String input,int num) {
		StringBuffer result= new StringBuffer();
		for(int i=0;i<num;i++) {
			result.append(input);
		}
		System.out.println("Appended String: "+result);
	
	}
	public static void main(String[] args) {
		repeatAppendStr("kandarp",4);
	}
}
