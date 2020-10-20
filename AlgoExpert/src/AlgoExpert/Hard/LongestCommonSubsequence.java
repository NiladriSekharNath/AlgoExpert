package AlgoExpert.Hard;

import java.util.*;

public class LongestCommonSubsequence {
	/*
	 * This solution is talking a list of Character in every cell of a Matrix so
	 * List<List<List>>>
	 * 
	 * public static List<Character> longestCommonSubsequence(String str1, String
	 * str2) { List<List<List<Character>>> lcs = new
	 * ArrayList<List<List<Character>>>(); for (int row = 0; row < str2.length() +
	 * 1; row++) { lcs.add(new ArrayList<List<Character>>()); for (int column = 0;
	 * column < str1.length() + 1; column++) { lcs.get(row).add(new
	 * ArrayList<Character>()); } } for (int row = 1; row < str2.length() + 1;
	 * row++) { for (int column = 1; column < str1.length() + 1; column++) { if
	 * (str2.charAt(row - 1) == str1.charAt(column - 1)) { List<Character> copy =
	 * new ArrayList<Character>(lcs.get(row - 1).get(column - 1));
	 * lcs.get(row).set(column, copy); lcs.get(row).get(column).add(str2.charAt(row
	 * - 1)); } else { if (lcs.get(row - 1).get(column).size() >
	 * lcs.get(row).get(column - 1).size()) { lcs.get(row).set(column, lcs.get(row -
	 * 1).get(column));
	 * 
	 * } else { lcs.get(row).set(column, lcs.get(row).get(column - 1)); } } } }
	 * 
	 * return lcs.get(str2.length()).get(str1.length()); }
	 */
	public static List<Character> longestCommonSubsequence(String str1, String str2) {
		int[][] lengths = new int[str2.length() + 1][str1.length() + 1];
		for (int row = 1; row < str2.length() + 1; row++) {
			for (int column = 1; column < str1.length() + 1; column++) {
				if (str2.charAt(row - 1) == str1.charAt(column - 1)) {
					lengths[row][column] = lengths[row - 1][column - 1] + 1;

				} else {
					lengths[row][column] = Math.max(lengths[row - 1][column], lengths[row][column - 1]);
				}
			}
		}
		return buildSequence(lengths, str1);
	}

	private static List<Character> buildSequence(int[][] lengths, String str) {
		List<Character> sequence = new ArrayList<Character>();
		int row = lengths.length - 1, column = lengths[0].length - 1;
		while (row != 0 && column != 0) {
			if (lengths[row][column] == lengths[row - 1][column]) {
				row--;
			} else if (lengths[row][column] == lengths[row][column - 1]) {
				column--;
			} else {
				sequence.add(0, str.charAt(column - 1));
				row--;
				column--;
			}
		}

		return sequence;
	}
}
