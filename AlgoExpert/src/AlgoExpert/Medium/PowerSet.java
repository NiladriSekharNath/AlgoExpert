package AlgoExpert.Medium;

import java.util.*;

public class PowerSet {

	// Not the correct implementaion
	/*
	 * public static List<List<Integer>> powerset(List<Integer> array) {
	 * List<List<Integer>>powerSetList=new ArrayList<List<Integer>>();
	 * powerSetList.add(new ArrayList<Integer>()); for(int
	 * subSetCount=1;subSetCount<=array.size();subSetCount++) { for(int
	 * j=0;j<array.size()-subSetCount+1;j++) { List<Integer>subList=array.subList(j,
	 * j+subSetCount); powerSetList.add(subList); } } return powerSetList; }
	 */
	public static List<List<Integer>> powerset(List<Integer> array) {
		List<List<Integer>> powerSetList = new ArrayList<List<Integer>>();
		powerSetList.add(new ArrayList<Integer>());
		for (Integer ele : array) {
			int length = powerSetList.size();
			for (int i = 0; i < length; i++) {
				List<Integer> currentElementList = new ArrayList<Integer>(powerSetList.get(i));
				currentElementList.add(ele);
				powerSetList.add(currentElementList);
			}
		}
		return powerSetList;
	}

}
