package AlgoExpert.Hard;

import java.util.*;

public class ZigZagTraverse {

	public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
		int height = array.size() - 1, width = array.get(0).size() - 1;
		List<Integer> result = new ArrayList<Integer>();
		int row = 0, col = 0;
		boolean goingDown = true;
		while (!isOutOfBounds(row, col, height, width)) {
			result.add(array.get(row).get(col));
			if (goingDown) {
				if (col == 0 || row == height) {
					goingDown = false;
					if (row == height) {
						col++;
					} else {
						row++;
					}
				} else {
					row++;
					col--;

				}
			}

			else {
				if (row == 0 || col == width) {
					goingDown = true;
					if (col == width) {
						row++;
					} else {
						col++;
					}
				} else {
					row--;
					col++;
				}
			}
		}
		return result;

	}

	private static boolean isOutOfBounds(int row, int col, int height, int width) {
		// TODO Auto-generated method stub
		return row < 0 || row > height || col < 0 || col > width;
	}

}
