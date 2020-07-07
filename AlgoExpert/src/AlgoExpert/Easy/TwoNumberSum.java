package AlgoExpert.Easy;

import java.util.*;

class TwoNumberSum {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    Map<Integer,Boolean>map=new HashMap<Integer,Boolean>();
    int []arr=null;
		for(Integer elements:array){
			if(map.containsKey(targetSum-elements)) {
				return new int[]{targetSum-elements,elements};
			}
			map.put(elements, true);
				
		}
		
    return new int[0];
  }
}