package AlgoExpert.Medium;

import java.util.*;

public class NoOfWaysToMakeChange {

	public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		int minCoins[] = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			minCoins[i] = Integer.MAX_VALUE;
		}
		minCoins[0] = 0;
		int toCompare = 0;
		for (int denom : denoms) {
			for (int amount = 0; amount < n + 1; amount++) {
				if (denom <= amount) {
					if (minCoins[amount - denom] == Integer.MAX_VALUE) {
						toCompare = minCoins[amount - denom];
					} else {
						toCompare = minCoins[amount - denom] + 1;
					}
					minCoins[amount] = Math.min(minCoins[amount], toCompare);

				}
			}
		}
		return minCoins[n] != Integer.MAX_VALUE ? minCoins[n] : -1;
	}
}
