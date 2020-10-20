package AlgoExpert.Medium;

import java.util.*;

public class YoungestCommonAncestor {
	public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne,
			AncestralTree descendantTwo) {
		int descendantOneDepth = depth(descendantOne), descendantTwoDepth = depth(descendantTwo),
				depthDiffercence = Math.abs(descendantOneDepth - descendantTwoDepth);
		AncestralTree lowerDescendant = null, higherDescendant = null;
		if (descendantOneDepth < descendantTwoDepth) {
			lowerDescendant = descendantTwo;
			higherDescendant = descendantOne;
		} else if (descendantOneDepth >= descendantTwoDepth) {
			lowerDescendant = descendantOne;
			higherDescendant = descendantTwo;

		}
		while (depthDiffercence > 0) {
			lowerDescendant = lowerDescendant.ancestor;
			depthDiffercence--;
		}
		while (lowerDescendant != higherDescendant) {
			lowerDescendant = lowerDescendant.ancestor;
			higherDescendant = higherDescendant.ancestor;
		}

		return lowerDescendant; 
	}

	private static int depth(AncestralTree descendant) {
		int depth = 0;
		while (descendant.ancestor != null) {
			depth++;
			descendant = descendant.ancestor;

		}
		return depth;
	}

	static class AncestralTree {
		public char name;
		public AncestralTree ancestor;

		AncestralTree(char name) {
			this.name = name;
			this.ancestor = null;
		}

		// This method is for testing only.
		void addAsAncestor(AncestralTree[] descendants) {
			for (AncestralTree descendant : descendants) {
				descendant.ancestor = this;
			}
		}
	}
}
