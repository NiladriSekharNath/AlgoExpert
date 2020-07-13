package AlgoExpert.Medium;

import java.util.*;

public class ValidateBST {
	
	  public static boolean validateBst(BST tree) {
		  return validateBstHelper(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);
		  
	  }

	 

	private static boolean validateBstHelper(BST tree, int minValue, int maxValue) {
		if(tree==null) {
			return true;
		}
		else if(tree.value<minValue || tree.value>=maxValue) {
			return false;
		}
		else 
			return validateBstHelper(tree.left, minValue, tree.value) && validateBstHelper(tree.right, tree.value, maxValue);
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



