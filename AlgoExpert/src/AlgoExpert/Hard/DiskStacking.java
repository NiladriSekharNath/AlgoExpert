package AlgoExpert.Hard;

import java.util.*;

public class DiskStacking {
	public static List<Integer[]> diskStacking(List<Integer[]> disks) {
		disks.sort((disk1, disk2) -> disk1[2].compareTo(disk2[2]));
		int heights[] = new int[disks.size()];
		for (int i = 0; i < disks.size(); i++) {
			heights[i] = disks.get(i)[2];
		}
		int[] sequences = new int[disks.size()];
		int maxHeightIdx = 0;
		for (int i = 0; i < disks.size(); i++) {
			sequences[i] = Integer.MIN_VALUE;
		}
		for (int i = 1; i < disks.size(); i++) {
			Integer[] currentDisk = disks.get(i);
			for (int j = 0; j < i; j++) {
				Integer[] otherDisk = disks.get(j);
				if (isValidDimensions(otherDisk, currentDisk)) {
					if (heights[i] <= currentDisk[2] + heights[j]) {
						heights[i] = currentDisk[2] + heights[j];
						sequences[i] = j;
					}
				}
			}
			if (heights[i] >= heights[maxHeightIdx]) {
				maxHeightIdx = i;
			}
		}
		return buildSequence(disks, sequences, maxHeightIdx);
	}

	private static List<Integer[]> buildSequence(List<Integer[]> array, int[] sequences, int currentIdx) {
		List<Integer[]> sequence = new ArrayList<Integer[]>();
		while (currentIdx != Integer.MIN_VALUE) {
			sequence.add(0, array.get(currentIdx));
			currentIdx = sequences[currentIdx];
		}
		return sequence;
	}

	private static boolean isValidDimensions(Integer[] otherDisk, Integer[] currentDisk) {

		return otherDisk[0] < currentDisk[0] && otherDisk[1] < currentDisk[1] && otherDisk[2] < currentDisk[2];
	}

}
