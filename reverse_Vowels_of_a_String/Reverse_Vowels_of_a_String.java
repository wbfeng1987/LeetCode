package reverse_Vowels_of_a_String;

public class Reverse_Vowels_of_a_String {

	public static String reverseVowels(String s) {
		
		if (s == "") return s;
		
		StringBuilder sBuilder = new StringBuilder(s);
		int head = 0;
		int tail = sBuilder.length() - 1;
		char temp;
		
		while (head < tail) {
			while (head < tail && sBuilder.charAt(head) != 'a' && sBuilder.charAt(head) != 'o' && 
					sBuilder.charAt(head) != 'e' && sBuilder.charAt(head) != 'i' && 
					sBuilder.charAt(head) != 'u' && sBuilder.charAt(head) != 'A' && 
					sBuilder.charAt(head) != 'O' && sBuilder.charAt(head) != 'E' && 
					sBuilder.charAt(head) != 'I' && sBuilder.charAt(head) != 'U')
				head ++;
			while (head < tail && sBuilder.charAt(tail) != 'a' && sBuilder.charAt(tail) != 'o' && 
					sBuilder.charAt(tail) != 'e' && sBuilder.charAt(tail) != 'i' && 
					sBuilder.charAt(tail) != 'u' && sBuilder.charAt(tail) != 'A' && 
					sBuilder.charAt(tail) != 'O' && sBuilder.charAt(tail) != 'E' && 
					sBuilder.charAt(tail) != 'I' && sBuilder.charAt(tail) != 'U')
				tail --;
			temp = sBuilder.charAt(head);
			sBuilder.setCharAt(head, sBuilder.charAt(tail));
			sBuilder.setCharAt(tail, temp);
			head ++;
			tail --;
			
		}
		return sBuilder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(reverseVowels("s"));
		System.out.println(reverseVowels("Weibo"));
		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("leetcode"));
	}
}
