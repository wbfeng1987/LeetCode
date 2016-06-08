package climbing_Stairs;

public class Climbing_Stairs {
	
	public static int climbStairs(int n) {
		
		if (n == 1 || n == 0) return 1;
		return climbStairs(n - 1) + climbStairs(n - 2);
	}
	
	public static int climbStairs_itr2(int n) {
		
		if (n == 1 || n == 0) return 1;
		
		int ways1 = 1;
		int ways2 = 1;
		int ways = 0;
		
		for (int i = 2; i <= n; i ++) {
			ways = ways1 + ways2;
			ways1 = ways2;
			ways2 = ways;
		}
		return ways;
	}
	
	// doesn't seem to be the right approach.
	public static int climbStairs_itr(int n) {
		
		int ways = n;
		int factorial = 1;
		int numerator = 1;
		for (int i = 2; i <= n / 2; i++) {
			
			for (int j = i; j > 0; j--) {
				
				for (int k = 1; k <= j; k++) {
					factorial *= k;
					numerator *= n - 2 * i - j + k + 1;
				}
				ways += numerator / factorial;
			}
			System.out.println("i = " + i + " | " + "ways = " + ways);
		}
		return ways;
	}
	
	public static void main(String[] args) {
		System.out.println(climbStairs(1));
		System.out.println(climbStairs_itr2(1));
	}

}
