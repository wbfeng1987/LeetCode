package valid_Anagram;

import java.util.Arrays;

public class ValidAnagram {
	
	// O(n^2) time scale
	public static boolean isAnagram(String s, String t) {
		
		StringBuilder tBuilder = new StringBuilder(t);
		for (char letter : s.toCharArray()) {
			for (int i = 0; i < tBuilder.length(); i++) {
				if (letter == tBuilder.charAt(i)) {
					tBuilder.deleteCharAt(i);
					break;
				}
				if (i == tBuilder.length() - 1) {
					return false;
				}
			}
		}
		
		return tBuilder.length() == 0;
    }
	
	// O(n) time scale
	public static boolean isAnagramFast(String s, String t) {
		
		//check null?
		char[] sCharArray = s.toCharArray();
		Arrays.sort(sCharArray);
		char[] tCharArray = t.toCharArray();
		Arrays.sort(tCharArray);
		
		return Arrays.equals(sCharArray, tCharArray);
	}
	
	public static void main(String[] args) {
		
		System.out.println(isAnagram("car", "rat"));
		System.out.println(isAnagram("car", "rac"));
		System.out.println(isAnagram("car", "ract"));
		System.out.println(isAnagram("car", "ra"));
		System.out.println(isAnagramFast("car", "rat"));
		
	}

}
