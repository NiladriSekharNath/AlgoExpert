package AlgoExpert.Medium;

import java.util.*;

public class MaxSubsetSumNoAdjacent {

	public static int maxSubsetSumNoAdjacent(int[] array) {
		List<Integer> maxSum = null;
		if (array.length == 0) {
			return 0;
		} else if (array.length == 1) {
			return array[0];
		} else if (array.length == 2) {
			return Math.max(array[0], array[1]);
		} else {

			int totalSum = 0;
			maxSum = new ArrayList<Integer>();
			maxSum.add(array[0]);
			maxSum.add(array[1]);
			for (int i = 2; i < array.length; i++) {
				totalSum = array[i] + max(0, i - 2, maxSum);
				maxSum.add(totalSum);
			}
		}

		return Collections.max(maxSum);
	}

	private static int max(int i, int j, List<Integer> maxSum) {
		if (j == 0 || j == 1) {
			return maxSum.get(j);
		}
		List<Integer> temp = new ArrayList<Integer>();
		while (i <= j) {
			temp.add(maxSum.get(i));
			i++;

		}
		return Collections.max(temp);
	}
}
