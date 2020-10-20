package AlgoExpert.Medium;

import java.util.*;

public class RiverSizes {
	//O(wh)Time | O(wh) Space
	public static List<Integer> riverSizes(int[][] matrix) {
		List<Integer> riverSizes = new ArrayList<Integer>();
		boolean visited[][] = new boolean[matrix.length][matrix[0].length];
		

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (visited[row][column]) {
					continue;
				}
				traverseMatrix(row, column, matrix, visited, riverSizes);
			}
		}
		return riverSizes;
	}

	private static void traverseMatrix(int row, int column, int[][] matrix, boolean[][] visited,
			List<Integer> riverSizes) {
		int riverSize = 0;
		Stack<Integer[]> nodesToVisit = new Stack<Integer[]>();
		nodesToVisit.push(new Integer[] { row, column });
		while (!nodesToVisit.empty()) {
			Integer[] top = nodesToVisit.pop();
			row = top[0];
			column = top[1];

			if (visited[row][column]) {
				continue;
							
			}
			
			visited[row][column]=true;
				if (matrix[row][column] == 0) {
					continue;
				} 
					riverSize++;
					List<Integer[]> neighboursUnvisited = getUnvisitedNeighbours(row, column, matrix, visited);
					nodesToVisit.addAll(neighboursUnvisited);
				
			
		}
		if(riverSize>0)
		 riverSizes.add(riverSize);

	}

	private static List<Integer[]> getUnvisitedNeighbours(int row, int column, int[][] matrix, boolean[][] visited) {
		List<Integer[]> neighboursUnvisited = new ArrayList<Integer[]>();
		if (row > 0 && !visited[row - 1][column]) {
			neighboursUnvisited.add(new Integer[] { row - 1, column });

		}
		if (row < matrix.length - 1 && !visited[row + 1][column]) {
			neighboursUnvisited.add(new Integer[] { row + 1, column });
		}
		if (column > 0 && !visited[row][column - 1]) {
			neighboursUnvisited.add(new Integer[] { row, column - 1 });
		}
		if (column < matrix[0].length-1 && !visited[row][column + 1]) {
			neighboursUnvisited.add(new Integer[] { row, column + 1 });
		}
		return neighboursUnvisited;
	}

}
