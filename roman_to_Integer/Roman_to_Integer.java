package roman_to_Integer;

public class Roman_to_Integer {
	
	public static int romanToInt(String s) {
		
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'M':
				num += 1000;
				break;
			case 'D':
				num += 500;
				break;
			case 'C':
				if (i != s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
					num -= 100;
				} else {
					num += 100;
				}
				break;
			case 'L':
				num += 50;
				break;
			case 'X':
				if (i != s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
					num -= 10;
				} else {
					num += 10;
				}
				break;
			case 'V':
				num += 5;
				break;
			case 'I':
				if (i != s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
					num -= 1;
				} else {
					num += 1;
				}
				break;
			default:
				break;
			}
		}
        return num;
    }
	
	public static void main(String[] args) {
		System.out.println(romanToInt("I"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("VIII"));
		System.out.println(romanToInt("XIV"));
		System.out.println(romanToInt("XIX"));
		System.out.println(romanToInt("XXIV"));
		System.out.println(romanToInt("LXXVI"));
		System.out.println(romanToInt("MDCCC"));
		System.out.println(romanToInt("CM"));
		System.out.println(romanToInt("XCIX"));
	}

}
