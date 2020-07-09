package AlgoExpert.Easy;
import java.util.*;
public class SubsequenceValidator {
	 public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
	 int arrayIndex=0,sequenceIndex=0;
	 while(arrayIndex<array.size() && sequenceIndex<sequence.size()) {
		 if(array.get(arrayIndex)==sequence.get(sequenceIndex)) {
			 sequenceIndex++;
			
		 }
		 arrayIndex++;
		 
	 }
	 return sequenceIndex==sequence.size();
	 }
}
