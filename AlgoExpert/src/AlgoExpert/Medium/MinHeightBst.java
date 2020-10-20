package AlgoExpert.Medium;

import java.util.*;

public class MinHeightBst {

	public static BST minHeightBst(List<Integer> array) {
		if (array.isEmpty()) {
			return null;
		} else {
			int mid = array.size() / 2;
			return minHeightBstHelper(array, 0, array.size() - 1);
		}

	}

	private static BST minHeightBstHelper(List<Integer> array, int startIdx, int endIdx) {

		if (startIdx > endIdx) {
			return null;
		}
		int midIdx = (startIdx + endIdx) / 2;
		BST bst = new BST(array.get(midIdx));
		bst.left = minHeightBstHelper(array, startIdx, midIdx - 1);
		bst.right = minHeightBstHelper(array, midIdx + 1, endIdx);

		return bst;

	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		public void insert(int value) {
			if (value < this.value) {
				if (left == null) {
					left = new BST(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new BST(value);
				} else {
					right.insert(value);
				}
			}
		}
	}

}
