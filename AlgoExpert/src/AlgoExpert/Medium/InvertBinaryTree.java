package AlgoExpert.Medium;

class InvertBinaryTree {

	public static void invertBinaryTree(BinaryTree tree) {
		if (tree == null) {
			return;
		}
		swapLeftRight(tree);

		invertBinaryTree(tree.left);
		invertBinaryTree(tree.right);

	}

	private static void swapLeftRight(BinaryTree tree) {
		BinaryTree temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;

	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
}