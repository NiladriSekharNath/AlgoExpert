package AlgoExpert.Medium;

import java.util.*;

public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(List<String> words) {
	   List<List<String>>anagrams=new Stack<List<String>>();
	   Map<String,List<String>>anagramsMap=new  HashMap<String, List<String>>();
	   for(String word:words) {
		   char[] wordArray = word.toCharArray();
		   Arrays.parallelSort(wordArray);
		   String sortedWord =new String(wordArray);
		   if(anagramsMap.containsKey(sortedWord)) {
			   anagramsMap.get(sortedWord).add(word);
		   }
		   else {
			   anagramsMap.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));
		   }
	   }
	    return new ArrayList<>(anagramsMap.values());
	  }
	
}
