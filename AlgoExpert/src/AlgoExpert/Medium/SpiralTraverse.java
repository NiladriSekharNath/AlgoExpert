package AlgoExpert.Medium;

import java.util.*;

public class SpiralTraverse {
	public static List<Integer> spiralTraverse(int[][] array) {
		if (array.length == 0)
			return new ArrayList<Integer>();
		int leftPos = 0, rightPos = array[0].length - 1, topPos = 0, bottomPos = array.length - 1;
		List<Integer> spiralTraverse = new ArrayList<Integer>();
		while (leftPos <= rightPos && topPos <= bottomPos) {

			for (int column = leftPos; column <= rightPos; column++) {
				spiralTraverse.add(array[topPos][column]);

			}

			for (int row = topPos + 1; row <= bottomPos; row++) {
				spiralTraverse.add(array[row][rightPos]);
			}
			for (int column = rightPos - 1; column >= leftPos; column--) {
				/*
				 * Handle the edge case when there's a single row in the middle of the matrix.
				 * In this case, we don't want to double count the values in this row,which
				 * we've already counted in the first for loop above Test Case 8: {"array": [[1,
				 * 2, 3, 4], [10, 11, 12, 5], [9, 8, 7, 6]]}
				 */
				if (topPos == bottomPos)
					break;

				spiralTraverse.add(array[bottomPos][column]);
			}
			for (int row = bottomPos - 1; row > topPos; row--) {
				/*
				 * Handle the edge case when there's a single column in the middle of the
				 * matrix. In this case, we don't want to double count the values in this
				 * column,which we've already counted in the second for loop above Test Case 9:
				 * {"array": [[1, 2, 3], [12, 13, 4], [11, 14, 5], [10, 15, 6], [9, 8, 7]]}
				 */
				if (leftPos == rightPos)
					break;
				spiralTraverse.add(array[row][leftPos]);
			}
			leftPos++;
			rightPos--;
			topPos++;
			bottomPos--;
		}

		return spiralTraverse;
	}

}
