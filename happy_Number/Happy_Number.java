package happy_Number;

public class Happy_Number {
	
	public static boolean isHappy(int n) {
		
		if (n <= 0) return false;
		int happy = n;
		while (happy != 1) {
			n = happy;
			happy = 0;
			while (n > 0) {
				happy += (n % 10) * (n % 10);
				n /= 10;
			}
			// The fact that unhappy numbers always end in cycle:
			// 4, 16, 37, 58, 89, 145, 42, 20, 4, ...
			if (happy == 4) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			if (isHappy(i)) System.out.println(i);;
		}
	}
}
