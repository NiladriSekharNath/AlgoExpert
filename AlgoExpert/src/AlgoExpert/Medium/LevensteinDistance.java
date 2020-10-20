package AlgoExpert.Medium;

import java.util.*;

public class LevensteinDistance {
	
	public static int levenshteinDistance(String str1, String str2) {
	    int edits[][]=new int[str1.length()+1][str2.length()+1];
	    int r,c;
	    for(r=0;r<str1.length()+1;r++) {
	    	for(c=0;c<str2.length()+1;c++) {
	    		edits[r][c]=c;
	    	}
	    	edits[r][0]=r;
	    }
	    
	    for(r=1;r<str1.length()+1;r++) {
	    	for (c = 1; c < str2.length()+1; c++) {
	    		if(str1.charAt(r-1)==str2.charAt(c-1)) {
	    			edits[r][c]=edits[r-1][c-1];
	    		}
	    		else
	    			edits[r][c]=Math.min(Math.min(edits[r-1][c-1], edits[r-1][c]),edits[r][c-1])+1;
			}
	    }
	    return edits[str1.length()][str2.length()];
	   
	  }
}
