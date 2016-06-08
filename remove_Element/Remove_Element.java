package remove_Element;

public class Remove_Element {
	
	// There are some cleaner solutions on leetcode, see "Editorial Solution"
	public static int removeElement(int[] nums, int val) {
		
		int head = 0;
		int tail = nums.length - 1;
		while (head < tail) {
			while (head < tail && nums[head] != val) {
				head ++;
			}
			while (head < tail && nums[tail] == val) {
				tail --;
			}
			if (head < tail) {
				nums[head] = nums[tail];
				head ++;
				tail --;
			}
		}
		if (head == tail && nums[head] == val) {
			return tail;
		} else {
			return tail + 1;
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 3, 4, 4, 3, 6, 5, 3};
		int[] nums2 = {3, 3, 3, 3, 3, 3, 3, 3};
		int[] nums3 = {3};
		int[] nums4 = {3, 2, 2, 3};
		int[] nums5 = {2, 2};
		System.out.println(removeElement(nums, 3));
		for (int i : nums)	System.out.print(i);
		System.out.println();
		
		System.out.println(removeElement(nums2, 3));
		for (int i : nums2)	System.out.print(i);
		System.out.println();
		
		System.out.println(removeElement(nums3, 3));
		for (int i : nums3)	System.out.print(i);
		System.out.println();
		
		System.out.println(removeElement(nums4, 3));
		for (int i : nums4)	System.out.print(i);
		System.out.println();
		
		System.out.println(removeElement(nums5, 3));
		for (int i : nums5)	System.out.print(i);
		
	}
}
