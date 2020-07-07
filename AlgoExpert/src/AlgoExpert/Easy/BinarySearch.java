package AlgoExpert.Easy;

import java.util.*;

class BinarySearch {
 public static int binarySearch(int[] array, int target) {
	int low=0,high=array.length-1,mid=0;
	while(low<=high) {
		mid=(low+high)/2;
		if(array[mid]<target) {
			low=mid+1;
		}
		else if (array[mid]>target){
			high=mid-1;
		}
		else 
			return mid;
	}
	
    return -1;
  }
}
