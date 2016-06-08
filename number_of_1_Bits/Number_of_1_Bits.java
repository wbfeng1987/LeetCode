package number_of_1_Bits;

public class Number_of_1_Bits {
	
	// The straight-forward algorithm
	public static int hammingWeight(int n) {
		
		int weight = 0;
		String s = Integer.toBinaryString(n);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				weight ++;
			}
		}
        return weight;
    }
	
	// Bit-wise
	public static int hammingWeight_bit(int n) {
		
		int weight = 0;
		for (int i = 0; i < 32; i ++) {
			if (n << i < 0) weight ++;
		}
        return weight;
    }
	
	// A even more efficient way (according to leetcode solution)
	public static int hammingWeight_eff(int n) {
		
		int weight = 0;
		while (n != 0) {
			n &= n - 1;
			weight ++;
		}
        return weight;
    }
	
	public static void main(String[] args) {
		System.out.println(hammingWeight_eff(11));
	}

}
