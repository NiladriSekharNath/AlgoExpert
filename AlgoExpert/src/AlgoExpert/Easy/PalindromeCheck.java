package AlgoExpert.Easy;

public class PalindromeCheck {
	public static boolean isPalindrome(String str) {
		int left = 0, right = str.length() - 1;
		while (left <= right) {
			if (str.charAt(left) == str.charAt(right)) {
				left++;
				right--;
			} else
				return false;
		}
		return true;

	}
}