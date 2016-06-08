package power_of_Two;

public class Power_of_Two {

    public static boolean isPowerOfTwo(int n) {
    	
    	if (n <= 0) return false;
    	while (n % 2 == 0) {
    		n = n >> 1;
    	}
        return n == 1;
    }
    
    // There is a n & (n - 1) trick in leetcode
    // See "number of 1 bits"
    public static boolean isPowerOfTwo_trick(int n) {
    	return n > 0 && (n & (n - 1)) == 0;
    }
    
    public static void main(String[] args) {
		System.out.println(isPowerOfTwo(10));
		System.out.println(isPowerOfTwo_trick(4));
	}
}
