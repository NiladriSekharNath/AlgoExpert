package AlgoExpert.Easy;

import java.util.*;


public class SumOfNodeDepthsBinaryTree {
	public static int nodeDepths(BinaryTree root) {
		int sumOfDepths = nodeDepthHelper(root, 0);
		return sumOfDepths;
	}

	private static int nodeDepthHelper(BinaryTree root, int depth) {
		if (root == null) {
			return 0;
		} else
			return depth + nodeDepthHelper(root.left, depth + 1) + nodeDepthHelper(root.right, depth + 1);
	}

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}

	}
}
