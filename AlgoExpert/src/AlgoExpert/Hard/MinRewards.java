package AlgoExpert.Hard;

import java.util.*;
import java.util.stream.IntStream;

public class MinRewards {
	public static int minRewards(int[] scores) {
		int[] rewards = new int[scores.length];
		Arrays.fill(rewards, 1);
		List<Integer> localMins = getLocalMin(scores);
		for (Integer localMin : localMins) {
			expandFromLocalMins(localMin, rewards, scores);
		}
		return IntStream.of(rewards).sum();
	}

	private static void expandFromLocalMins(Integer localMin, int[] rewards, int[] scores) {
		int leftIdx = localMin - 1;
		while (leftIdx >= 0 && scores[leftIdx + 1] < scores[leftIdx]) {
			rewards[leftIdx] = Math.max(rewards[leftIdx], rewards[leftIdx + 1] + 1);
			leftIdx--;
		}
		int rightIdx = localMin + 1;
		while (rightIdx < scores.length && scores[rightIdx - 1] < scores[rightIdx]) {
			rewards[rightIdx] = rewards[rightIdx - 1] + 1;
			rightIdx++;
		}

	}

	private static List<Integer> getLocalMin(int[] array) {
		List<Integer> localMinIndxs = new ArrayList<Integer>();
		if (array.length == 1) {
			localMinIndxs.add(0);
			return localMinIndxs;
		}
		for (int i = 0; i < array.length; i++) {
			if (i == 0 && array[i] < array[i + 1])
				localMinIndxs.add(i);
			if (i == array.length - 1 && array[i] < array[i - 1])
				localMinIndxs.add(i);
			if (i == 0 || i == array.length - 1)
				continue;
			if (array[i] < array[i - 1] && array[i] < array[i - 1])
				localMinIndxs.add(i);
		}
		return localMinIndxs;
	}

	/*
	 * best method public static int minRewards(int[] scores) { int[] rewards=new
	 * int[scores.length]; Arrays.fill(rewards, 1); for(int i=1;i<scores.length;i++)
	 * { if(scores[i]>scores[i-1]) rewards[i]=rewards[i-1]+1; } for(int
	 * i=scores.length-2;i>=0;i--) { if(scores[i]>scores[i+1]) {
	 * rewards[i]=Math.max(rewards[i],rewards[i+1]+1); } } return
	 * IntStream.of(rewards).sum(); }
	 */
}
