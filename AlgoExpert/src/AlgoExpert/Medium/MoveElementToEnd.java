package AlgoExpert.Medium;

import java.util.*;

public class MoveElementToEnd {
	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		int i=0,j=array.size()-1;
		while(i<j) {
			if(i<j && array.get(j)==toMove) {
				j--;
			}
			if(array.get(i)==toMove) {
				swap(array,i,j);
				
			}
		i++;
		}
		return array;
	}

	private static void swap(List<Integer> array, int i, int j) {
		int temp=array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
		return;
		
	}

	
}
