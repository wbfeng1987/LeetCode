package majority_Element;

import java.util.HashMap;
import java.util.Map;

public class Majority_Element {
	
	public static int majorityElement(int[] nums) {
		
		if (nums.length == 1) return nums[0];
		Map<Integer, Integer> counter = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (counter.containsKey(nums[i])) {
				if (counter.get(nums[i]) + 1 > nums.length / 2) {
					return nums[i];
				}
				counter.put(nums[i], counter.get(nums[i]) + 1);
			} else {
				counter.put(nums[i], 1);
			}
		}
        return 0;
    }
	
	// Boyer¨CMoore majority vote algorithm
	public static int majorityElement2(int[] nums) {
		
		int major = nums[0];
		int counter = 0;
		
		for (int i : nums) {
			if (i == major) counter ++;
			else counter --;
			
			if (counter == 0) {
				major = i;
				counter = 1;
			}
		}
		
		return major;
    }

	public static void main(String[] args) {

		int[] nums = {11, 1, 2, 12, 4, 5, 6, 7, 8, 9, 9};
		int[] nums2 = {11, 11, 11, 11, 11, 11, 13, 14, 15, 16, 16};
		int[] nums3 = {3, 3};
		int[] nums4 = {-1, 9};
		int[] nums5 = {-1, -1, -1, -1, -1, -1, -1, -1, -9};
		int[] nums6 = {1,0};
		
		System.out.println("The majority element in nums: " + 
				majorityElement2(nums));
		System.out.println("The majority element in nums2: " + 
				majorityElement2(nums2));
		System.out.println("The majority element in nums3: " + 
				majorityElement2(nums3));
		System.out.println("The majority element in nums4: " + 
				majorityElement2(nums4));
		System.out.println("The majority element in nums5: " + 
				majorityElement2(nums5));
		System.out.println("The majority element in nums6: " + 
				majorityElement2(nums6));
	}
}
