package AlgoExpert.Hard;

import java.util.*;

public class SubArraySort {
	public static int[] subarraySort(int[] array) {
		int minOutOfOrder = Integer.MAX_VALUE, maxOutOfOrder = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			if (isOutOfOrder(i, num, array)) {
				minOutOfOrder = Math.min(num, minOutOfOrder);
				maxOutOfOrder = Math.max(num, maxOutOfOrder);

			}

		}
		if (minOutOfOrder == Integer.MAX_VALUE) {
			return new int[] { -1, -1 };
		}

		int subArrayLeftIdx = 0;
		while (array[subArrayLeftIdx] <= minOutOfOrder) {
			subArrayLeftIdx++;
		}

		int subArrayRightIdx = array.length - 1;
		while (maxOutOfOrder <= array[subArrayRightIdx]) {
			subArrayRightIdx--;
		}
		return new int[] { subArrayLeftIdx, subArrayRightIdx };
	}

	private static boolean isOutOfOrder(int index, int num, int[] array) {
		if (index == 0) {
			return num > array[index + 1];
		}
		if (index == array.length - 1) {
			return num < array[index - 1];
		}
		return array[index - 1] > num || num > array[index + 1];
	}
}
