package AlgoExpert.Easy;
import java.util.*;

class BranchSums{
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    List<Integer>sums=new ArrayList<Integer>();
    calculateBranchSums(root,0,sums);
    return sums;
    
  }

private static void calculateBranchSums(BinaryTree root, int runningSum, List<Integer> sums) {
	
	BinaryTree currentNode=root;
	if(currentNode==null)
		return;
	int currentSum=runningSum+currentNode.value;
	if(currentNode.left==null && currentNode.right==null) {
		sums.add(currentSum);
		return;
	}
	calculateBranchSums(currentNode.left,currentSum,sums);
	calculateBranchSums(currentNode.right,currentSum, sums);
}
}