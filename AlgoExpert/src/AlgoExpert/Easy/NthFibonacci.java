package AlgoExpert.Easy;

import java.util.*;

class NthFibonacci {
	//Their solution 
	/*
	public static int getNthFib(int n) {
		Map<Integer, Integer> memoize = new HashMap<Integer, Integer>();
		memoize.put(1, 0);
		memoize.put(2, 1);
		return getFibo(n, memoize);

	}

	private static int getFibo(int n, Map<Integer, Integer> memoize) {
		if (memoize.containsKey(n)) {
			return memoize.get(n);
		} else {
			memoize.put(n, getFibo(n - 1, memoize) + getFibo(n - 2, memoize));
			return memoize.get(n);
		}

	}*/
	//My Solution
			 public static int getNthFib(int n) {
			    int a=0,b=1,c=0,counter=3;
			    if(n==1){
						return 0;
					}
			    else if (n==2){
						return 1;
					}
			    while(counter<=n){
						c=a+b;
						counter++;
						a=b;
						b=c;
					}
			    
			    return c;
			  }

}
