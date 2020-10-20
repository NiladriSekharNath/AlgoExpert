package AlgoExpert.Hard;

import java.util.*;

public class SameBST {

	public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {

		return areSameBSTs(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean areSameBSTs(List<Integer> arrayOne, List<Integer> arrayTwo, int rootIdxOne, int rootIdxTwo,
			int minValue, int maxValue) {

		if (rootIdxOne == -1 || rootIdxTwo == -1)
			return rootIdxOne == rootIdxTwo;
		if (arrayOne.get(rootIdxOne).intValue() != arrayTwo.get(rootIdxTwo).intValue())
			return false;
		int leftRootIdxOne = getIdxOfFirstSmaller(arrayOne, rootIdxOne, minValue);
		int leftRootIdxTwo = getIdxOfFirstSmaller(arrayTwo, rootIdxTwo, minValue);
		int rightRootIdxOne = getIdxOfFirstBiggerOrEqual(arrayOne, rootIdxOne, maxValue);
		int rightRootIdxTwo = getIdxOfFirstBiggerOrEqual(arrayTwo, rootIdxTwo, maxValue);
		int currentValue = arrayOne.get(rootIdxOne);
		boolean leftAreSame = areSameBSTs(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minValue, currentValue);
		boolean rightAreSame = areSameBSTs(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, currentValue,
				maxValue);

		return leftAreSame && rightAreSame;
	}

	private static int getIdxOfFirstSmaller(List<Integer> array, int startingIdx, int minValue) {
		/*
		 * Find the index of the first smaller after the startingIdx. Make sure that
		 * this value is greater than or equal to the minValue, which is the value of
		 * the previous node in the BST If it isn't, then that value is located in the
		 * left subtree of the previous parent node
		 */
		for (int i = startingIdx + 1; i < array.size(); i++) {
			if (array.get(i).intValue() < array.get(startingIdx).intValue() && array.get(i).intValue() >= minValue)
				return i;

		}
		return -1;
	}

	private static int getIdxOfFirstBiggerOrEqual(List<Integer> array, int startingIdx, int maxValue) {
		/*
		 * Find the index of the first bigger/equal value after the startingIdx. Make
		 * sure that this value is smaller than maxValue, which is the value of the
		 * previous parent node in the BST. If it isn't, then that value is located in
		 * the right subtree of the previous parent node
		 */
		for (int i = startingIdx + 1; i < array.size(); i++) {
			if (array.get(i).intValue() >= array.get(startingIdx).intValue() && array.get(i).intValue() < maxValue)

				return i;

		}
		return -1;
	}
}
