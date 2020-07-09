package AlgoExpert.Medium;

import java.util.*;

public class ThreeNumberSum {
	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

		List<Integer[]> list = new ArrayList<Integer[]>();
		Arrays.parallelSort(array);
		int left = 0, right = 0;
		for (int i = 0; i < array.length - 2; i++) {
			left = i + 1;
			right = array.length - 1;
			while (left < right) {
				if (array[i] + array[left] + array[right] == targetSum) {
					Integer[] threeNumberArray = { array[i], array[left], array[right] };
					list.add(threeNumberArray);
					left++;
					right--;
				} else if (array[i] + array[left] + array[right] < targetSum) {
					left++;
				} else if (array[i] + array[left] + array[right] > targetSum) {

					right--;
				}
			}
		}

		return list;
	}

}
