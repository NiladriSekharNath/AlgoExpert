package AlgoExpert.Medium;

import java.util.*;

public class MinHeapConstruction {

	static class MinHeap {
		List<Integer> heap = new ArrayList<Integer>();

		public MinHeap(List<Integer> array) {
			heap = buildHeap(array);
		}

		public List<Integer> buildHeap(List<Integer> array) {
			int firstParentIdx = (array.size() - 2) / 2;
			for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
				siftDown(currentIdx, array.size() - 1, array);
			}
			return array;
		}

		public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
			int nextIdx = currentIdx * 2 + 1;

			while (nextIdx <= endIdx) {
				if (nextIdx + 1 <= endIdx && heap.get(nextIdx + 1) < heap.get(nextIdx)) {
					nextIdx++;
				}
				if (heap.get(nextIdx) < heap.get((nextIdx - 1) / 2)) {
					swap(nextIdx, (nextIdx - 1) / 2, heap);
					nextIdx = nextIdx * 2 + 1;
				} else {
					return;
				}

			}
		}

		public void siftUp(int currentIdx, List<Integer> heap) {
			int parentIdx = (currentIdx - 1) / 2;
			while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
				swap(currentIdx, parentIdx, heap);
				currentIdx = parentIdx;
				parentIdx = (currentIdx - 1) / 2;
			}

		}

		public int peek() {

			return heap.get(0);
		}

		public int remove() {
			swap(0, heap.size() - 1, heap);
			int valueToRemove = heap.get(heap.size() - 1);
			heap.remove(heap.size() - 1);
			siftDown(0, heap.size() - 1, heap);
			return valueToRemove;
		}

		public void insert(int value) {
			heap.add(value);
			siftUp(heap.size() - 1, heap);
		}

		private void swap(int currentIdx, int parentIdx, List<Integer> heap) {
			int temp = heap.get(currentIdx);
			heap.set(currentIdx, heap.get(parentIdx));
			heap.set(parentIdx, temp);

		}
	}

}
