package AlgoExpert.Medium;

import java.util.*;

public class MonotonicArray {

	public static boolean isMonotonic(int[] array) {
		boolean isIncreasing = true, isDecreasing = true;
		for (int i = 1; i < array.length; i++) {
			/*Fails if the previous value is less than the currentValue*/
			if (array[i - 1] < array[i]) {
				isDecreasing = false;
			}
			/*Fails if the previous value is greater than the currentValue*/
			if (array[i - 1] > array[i]) {
				isIncreasing = false;
			}
		}
		return isDecreasing || isIncreasing;

	}

}
