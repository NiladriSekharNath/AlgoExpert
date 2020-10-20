package AlgoExpert.Medium;

import java.util.*;

public class RemoveKthNodeFromEnd {

	public static void removeKthNodeFromEnd(LinkedList head, int k) {
		LinkedList first = head, second = head;
		for (int i = 0; i < k; i++) {
			second = second.next;
		}
		if(second!=null){ //k==length of the list that is the first node
		while (second.next != null) {
			first = first.next;
			second = second.next;
		}
		first.next = first.next.next;
		}
		else{
		head.value=head.next.value;
		head.next=head.next.next;
		
		}
		return;
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}

}
