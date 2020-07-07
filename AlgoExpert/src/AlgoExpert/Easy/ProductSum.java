package AlgoExpert.Easy;

import java.util.*;

import java.util.*;

class ProductSum {
  // Tip: You can use `element instanceof ArrayList` to check whether an item
  // is an array or an integer.
  public static int productSum(List<Object> array) {
    int productSum=0;
	productSum=productSumHelper(array,1);
    return productSum;
  }

private static int productSumHelper(List<Object> array, int depth) {
	int productSum=0;
	for (Object item:array) {
		if(item instanceof ArrayList<?>) {
			int sum=productSumHelper(array, depth+1);
			productSum+=sum*depth;
		}
		else
			productSum+=(int)item;
	}
	return productSum;
}
}
