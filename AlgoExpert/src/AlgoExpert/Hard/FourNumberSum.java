package AlgoExpert.Hard;

import java.util.*;

public class FourNumberSum {

	public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
		List<Integer[]> fourNumberSums = new ArrayList<Integer[]>();
		Map<Integer, List<Integer[]>> allPairSums = new HashMap<Integer, List<Integer[]>>();
		int i;
		for (i = 1; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int currentSum = array[i] + array[j];
				int difference = targetSum - currentSum;
				if (allPairSums.containsKey(difference)) {
					for (Integer[] pair : allPairSums.get(difference)) {
						Integer[] newQuadruplates = { pair[0], pair[1], array[i], array[j] };
						fourNumberSums.add(newQuadruplates);
					}

				}
			}
			for (int k = 0; k < i; k++) {
				int currentSum = array[k] + array[i];
				Integer[] pair = { array[k], array[i] };
				if (!allPairSums.containsKey(currentSum)) {
					List<Integer[]> pairList = new ArrayList<Integer[]>();
					pairList.add(pair);
					allPairSums.put(currentSum, pairList);
				} else {
					allPairSums.get(currentSum).add(pair);
				}

			}
		}
		return fourNumberSums;

	}
}
