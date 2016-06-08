package house_Robber;

public class House_Robber {

	public static int rob(int[] nums) {
	
		if (nums.length == 0) return 0;
		int max = nums[0];
		int preMax = 0;
		int temp;
		int flag = 1; // indicates whether or not the 'max' includes the
						// the last element in the current range
		for (int i = 1; i < nums.length; i++) {
			if (flag == 1) {
				if (preMax + nums[i] > max) {
					temp = max;
					max = preMax + nums[i];
					preMax = temp;
				} else {
					preMax = max;
					flag = 0;
				}
			} else {
				preMax = max;
				max = max + nums[i];
				flag = 1;
			}
			
		}
		return max;
	}
	
	// This one is from leetcode, which is much cleaner.
	public static int rob_leet(int[] nums) {
		
		int robCurrent = 0;
		int notRobCurrent = 0;
		for (int i = 0; i < nums.length; i++) {
			int temp = robCurrent;
			robCurrent = nums[i] + notRobCurrent;
			notRobCurrent = Math.max(temp, notRobCurrent);
		}
		return Math.max(robCurrent, notRobCurrent);
	}
	
	public static void main(String[] args) {
		
		int[] nums = {2, 7, 8, 4, 9, 8, 1, 9, 9, 2, 1, 8};
		int[] nums2 = {2, 7, 8, 4, 9, 100, 11, 1, 9, 9, 1, 8};
		int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] nums4 = {1};
		int[] nums5 = {};
		System.out.println(rob(nums) + "\t" + rob_leet(nums));
		System.out.println(rob(nums2) + "\t" + rob_leet(nums2));
		System.out.println(rob(nums3) + "\t" + rob_leet(nums3));
		System.out.println(rob(nums4) + "\t" + rob_leet(nums4));
		System.out.println(rob(nums5) + "\t" + rob_leet(nums5));
	}
}
