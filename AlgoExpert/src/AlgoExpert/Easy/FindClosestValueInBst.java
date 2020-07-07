package AlgoExpert.Easy;
import java.util.*;

class FindClosestValueInBst {
  public static int findClosestValueInBst(BST tree, int target) {
    return findClosestValueInBst(tree,target,tree.value);
    
  }

  private static int findClosestValueInBst(BST tree, int target, int closest) {
	BST currentNode=tree;
	int closestValue=closest;
	while(currentNode!=null) {
		if(Math.abs(currentNode.value-target)<Math.abs(closest-target)) {
			closestValue=currentNode.value;
		}
		if(target<currentNode.value)
		{
			currentNode=currentNode.left;
			
		}
		else if (target>currentNode.value) {
			currentNode=currentNode.right;
		}
		else break;
	}
	return closest;
}
  
  
static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }

}