package reverse_String;

public class Reverse_String {
	
	public static String reverseString(String s) {
		char[] sa = s.toCharArray();
		char temp;
		for (int i = 0; i < sa.length / 2; i ++) {
			temp = sa[i];
			sa[i] = sa[sa.length - 1 - i];
			sa[sa.length - 1 - i] = temp;
		}
		return new String(sa);
    }
	
	public static String reverseStringWithSB(String s) {
		return new StringBuilder(s).reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println("with reverseString method:" + reverseString("diablowarcraft"));
		System.out.println("with reverseStringWithSB method:" + reverseStringWithSB("diablowarcraft"));
	}

}
