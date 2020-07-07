package AlgoExpert.Easy;

public class ThreeLargestNumber {
	public static int[] findThreeLargestNumbers(int[] array) {
		int threeLargest[] = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
		for (int item : array) {
			updateLargest(item, threeLargest);
		}
		return threeLargest;
	}

	private static void updateLargest(int item, int[] threeLargest) {
		if (item > threeLargest[2]) {
			shiftAndUpdate(threeLargest, item, 2);
		} else if (item > threeLargest[1]) {
			shiftAndUpdate(threeLargest, item, 1);
		}
		else if(item>threeLargest[0])
			shiftAndUpdate(threeLargest, item, 0);
		return;
	}

	private static void shiftAndUpdate(int[] threeLargest, int item, int index) {
		for(int i=0;i<=index;i++) {
			if(i==index) {
				threeLargest[i]=item;
			}
			else
				threeLargest[i]=threeLargest[i+1];
		}
		return;
	}
	
}
