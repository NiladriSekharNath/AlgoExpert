package AlgoExpert.Hard;

import java.util.*;
import java.util.stream.IntStream;

public class WaterArea {
	/*
	 * public static int waterArea(int[] heights) { int[] maxesLeft = new
	 * int[heights.length]; int[] maxesRight = new int[heights.length]; int[] maxes
	 * = new int[heights.length]; int maxHeightLeft = 0; for (int i = 1; i <
	 * heights.length; i++) { maxHeightLeft = Math.max(heights[i - 1],
	 * maxHeightLeft); maxesLeft[i] = maxHeightLeft; } int maxHeightRight = 0; for
	 * (int i = heights.length - 2; i >= 0; i--) { maxHeightRight =
	 * Math.max(heights[i + 1], maxHeightRight); maxesRight[i] = maxHeightRight; }
	 * for (int i = 0; i < heights.length; i++) { int minHeight =
	 * Math.min(maxesLeft[i], maxesRight[i]); if (heights[i] < minHeight) { maxes[i]
	 * = minHeight - heights[i]; } else maxes[i] = 0; } return
	 * IntStream.of(maxes).sum(); }
	 */
	
	public static int waterArea(int[] heights) {
		if (heights.length == 0)
			return 0;
		int leftIdx = 0, rightIdx = heights.length - 1, leftMax = heights[leftIdx], rightMax = heights[rightIdx],
				surfaceArea = 0;
		while (leftIdx < rightIdx) {
			if (heights[leftIdx] < heights[rightIdx]) {
				leftIdx++;
				leftMax = Math.max(leftMax, heights[leftIdx]);
				surfaceArea += leftMax - heights[leftIdx];
			} else {
				rightIdx--;
				rightMax = Math.max(rightMax, heights[rightIdx]);
				surfaceArea += rightMax - heights[rightIdx];
			}
		}
		return surfaceArea;
	}
}
