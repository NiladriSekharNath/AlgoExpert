package AlgoExpert.Medium;

import java.util.*;

public class SmallestDifference {
	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		int pointOne=0, pointTwo=0,smallest=Integer.MAX_VALUE,current=0;
		int result[]=new int[2];
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		
		while(pointOne<arrayOne.length && pointTwo<arrayTwo.length) {
			int first = arrayOne[pointOne];
			int second=arrayTwo[pointTwo];
			if(first<second) {
				current=second-first;
				pointOne++;
			}
			else if (second<first) {
				current=first-second;
				pointTwo++;
			}
			else {
				return new int[] {first,second};
			}
			if(smallest>current) {
				smallest=current;
				result=new int[] {first,second};
			}
		}
		return result;
	}
	

}
