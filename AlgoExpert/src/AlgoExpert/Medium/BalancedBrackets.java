package AlgoExpert.Medium;

import java.util.*;

public class BalancedBrackets {
	public static boolean balancedBrackets(String str) {
		List<Character> openingBrackets = Arrays.asList('(', '{', '[');// Immutable List is created
		List<Character> closingBrackets = new ArrayList<Character>(Arrays.asList(')', '}', ']'));// Mutable List is created
		Map<Character, Character> bracketsMap = new HashMap<Character, Character>();
		bracketsMap.put(')', '(');
		bracketsMap.put('}', '{');
		bracketsMap.put(']', '[');

		Stack<Character> stack = new Stack<Character>();
		for (Character ch : str.toCharArray()) {
			if (openingBrackets.contains(ch)) {
				stack.push(ch);
			}
			else if (closingBrackets.contains(ch)) {
				if (stack.isEmpty()) {
					return false;
				} else {
					if (bracketsMap.get(ch) == stack.peek()) {
						stack.pop();
					} else {
						return false;
					}
				}

			}

		}
		

		return stack.size()==0;
	}

}
