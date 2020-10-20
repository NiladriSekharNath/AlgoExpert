package AlgoExpert.Hard;

import java.util.*;

public class LargestRange {

	public static int[] largestRange(int[] array) {
		int bestRange[] = new int[2];
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		int longestLength = 0;
		for (int num : array) {
			map.put(num, true);
		}
		for (int num : array) {
			if (!map.get(num)) {
				continue;
			}
			map.put(num, false);
			int leftNum = num - 1;
			int rightNum = num + 1;
			int currentLengthOfRange = 1;
			while (map.containsKey(leftNum)) {
				map.put(leftNum, false);
				currentLengthOfRange++;
				leftNum--;
			}
			while (map.containsKey(rightNum)) {
				map.put(rightNum, false);
				currentLengthOfRange++;
				rightNum++;
			}
			if (currentLengthOfRange > longestLength) {
				longestLength = currentLengthOfRange;
				bestRange = new int[] { leftNum + 1, rightNum - 1 };

			}
		}
		return bestRange;
	}

}
