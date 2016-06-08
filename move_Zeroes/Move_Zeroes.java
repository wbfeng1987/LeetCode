package move_Zeroes;

import java.util.Arrays;

public class Move_Zeroes {
	
	public static void moveZeroes(int[] nums) {
		
		int	nonZeroCount= 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) nums[nonZeroCount++] = nums[i];
		}
		
	    for (int i = nonZeroCount; i < nums.length; i++) {
			nums[i] = 0;
		}
	    
	}
	
	public static void main(String[] args) {
		
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
		
	}

}
