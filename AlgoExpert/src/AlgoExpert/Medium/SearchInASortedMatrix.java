package AlgoExpert.Medium;

import java.util.*;

public class SearchInASortedMatrix {
	public static int[] searchInSortedMatrix(int[][] matrix, int target) {
		int row = 0, column = matrix[0].length - 1;
		while (row < matrix.length && column >= 0) {
			if (target < matrix[row][column]) {
				column--;
			} else if (target > matrix[row][column]) {
				row++;

			} else
				return new int[] { row, column };
		}

		return new int[] { -1, -1 };
	}
}
