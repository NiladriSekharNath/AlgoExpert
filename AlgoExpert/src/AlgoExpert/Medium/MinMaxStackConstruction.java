package AlgoExpert.Medium;

import java.util.*;

public class MinMaxStackConstruction {
	static class MinMaxStack {
		public Stack<Integer> numbers = new Stack<Integer>();
		public Stack<Map<String, Integer>> minMaxStack = new Stack<Map<String, Integer>>();

		public int peek() {

			return numbers.peek();
		}

		public int pop() {
			minMaxStack.pop();
			return numbers.pop();
		}

		public void push(Integer number) {
			Map<String, Integer> minMax = new HashMap<String, Integer>();
			minMax.put("max", number);
			minMax.put("min", number);
			if (!minMaxStack.empty()) {

				Map<String, Integer> top = new HashMap<String, Integer>(minMaxStack.lastElement());
				minMax.replace("min", Math.min(number, top.get("min")));
				minMax.replace("max", Math.max(number, top.get("max")));

			}
			minMaxStack.add(minMax);
			numbers.add(number);

		}

		public int getMin() {

			return minMaxStack.peek().get("min");
		}

		public int getMax() {

			return minMaxStack.peek().get("max");
		}
	}
}
