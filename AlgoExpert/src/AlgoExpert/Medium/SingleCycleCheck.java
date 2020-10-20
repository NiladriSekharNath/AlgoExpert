package AlgoExpert.Medium;

import java.util.*;

public class SingleCycleCheck {
	 public static boolean hasSingleCycle(int[] array) {
		    int currentIndex=0,nodesVisited=0;
		    while(nodesVisited<array.length) {
		    	if(nodesVisited>0 && currentIndex==0) {
		    		return false;
		    	}
		    	nodesVisited++;
		    	currentIndex=getNextIndex(currentIndex,array);
		    	
		    }
		    return currentIndex==0;
		  }

	private static int getNextIndex(int currentIndex, int[] array) {
		int nextIndex=(currentIndex+array[currentIndex])%array.length;
		return nextIndex<0?nextIndex+array.length:nextIndex;
		}
	
}
