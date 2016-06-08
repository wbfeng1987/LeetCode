package traping_Rain_Water;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Trapping_Rain_Water {
	
	// My O(n^2) solution
	public static int trap(int[] height) {
		
		int trappedWater = 0;
		Integer temp;
		
		// Using a list to store the positions of each bar
		List<Integer> positions = new ArrayList<>();
		for (int i = 0; i < height.length; i ++) {
			positions.add(i);
		}
		
		// Sort the bars from the highest to the lowest
		Collections.sort(positions, 
				(p1, p2) -> (height[p2] - height[p1]));
		System.out.println(positions);
		
		/*	The idea is: water is trapped in puddles, which are formed
		 *	with the locally highest bars. So the algorithm 
		 *	is to find these puddles and calculate the amount of water 
		 *	trapped within them.
		 */
		while (positions.size() >= 2) {
			
			// Starting from the highest and the 2nd highest bar of all.
			// They defines the puddle.
			Integer puddleBoundary1 = positions.get(0);
			Integer puddleBoundary2 = positions.get(1);
			
			// Locate the bars between and calculate the water filled.
			// After the calculation, wipe out of this region for the next step.
			Iterator<Integer> it = positions.iterator();
			while (it.hasNext()) {
				temp = it.next();
				if (temp >= Math.min(puddleBoundary1, puddleBoundary2) 
						&& temp < Math.max(puddleBoundary1, puddleBoundary2)) {
					if (height[temp] < height[puddleBoundary2]) {
						trappedWater += (height[puddleBoundary2] - height[temp]);
					}
					it.remove();
				}
			}
		}
		
		return trappedWater;
    }
	
	// My O(n) solution
	public static int trap2(int[] height) {

		int left =0;
		int right = height.length - 1;
		int trappedWater = 0;
		int markerL = left;
		int markerR = right;
		while (left < right) {
			if (height[left] < height[right]) {
				left ++;
				if (height[markerL] > height[left]) {
					trappedWater += height[markerL] - height[left];
				} else {
					markerL = left;
				}
			} else {
				right --;
				if (height[markerR] > height[right]) {
					trappedWater += height[markerR] - height[right];
				} else {
					markerR = right;
				}
			}
		}
		return trappedWater;
	}
	
	public static void main(String[] args) {
		
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println(trap(height));
		System.out.println(trap2(height));
		
	}

}
