package AlgoExpert.Medium;

import java.util.*;

public class KadaneAlgorithm {
	public static int kadanesAlgorithm(int[] array) {
		int maxEndingHere = array[0], maxSoFar = array[0];

		int arraySum[] = new int[array.length];
		arraySum[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			int currentNum = array[i];
			maxEndingHere = Math.max(maxEndingHere + currentNum, currentNum);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}

}
