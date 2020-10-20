package AlgoExpert.Medium;

import java.util.*;

public class MinNumberOfCoinsForChange {

	public static int minNumberOfCoinsForChange(int n, int[] denoms) {
	    int minCoins[]=new int[n+1];
	    for(int i=0;i<n+1;i++){
				minCoins[i]=Integer.MAX_VALUE;
			}
		
	    for(int denom:denoms) {
	    	for(int amount=1;amount<n+1;amount++) {
	    		if(denom<=amount) {
						minCoins[amount]=Math.min(minCoins[amount],minCoins[amount-denom]+1);
	    			
	    		}
	    	}
	    }
	    return (minCoins[n]==Integer.MAX_VALUE)?-1:minCoins[n];
	    }	
}

