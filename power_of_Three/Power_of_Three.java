package power_of_Three;

public class Power_of_Three {
	
	public static boolean isPowerOfThree(int n) {
		
		if (n <= 0) return false;
		
        return ((int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE)/Math.log(3)))) % n == 0;
    }
	
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(9));
	}
}
