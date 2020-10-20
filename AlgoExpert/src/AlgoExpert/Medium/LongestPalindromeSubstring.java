package AlgoExpert.Medium;

import java.util.*;

public class LongestPalindromeSubstring {

	public static String longestPalindromicSubstring(String str) {
		int[] currentLongest = { 0, 1 };
		for (int i = 1; i < str.length(); i++) {
			int[] odd = getPalindromicSubString(str, i - 1, i + 1);
			int[] even = getPalindromicSubString(str, i - 1, i);
			int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
			currentLongest = longest[1] - longest[0] > currentLongest[1] - currentLongest[0] ? longest : currentLongest;

		}
		return str.substring(currentLongest[0], currentLongest[1]);
	}

	private static int[] getPalindromicSubString(String str, int leftIdx, int rightIdx) {
		while (leftIdx >= 0 && rightIdx < str.length()) {
			if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
				break;
			}
			leftIdx--;
			rightIdx++;
		}
		return new int[] { leftIdx + 1, rightIdx };
	}

}
