// 
// 817. Linked List Components

import java.util.HashSet;
import java.util.Set;

class LinkedListComponents {
	public int numComponents(Node head, int[] nums) {
		Set<Integer> newSet = new HashSet<Integer>();
		int count = 0;
		
		for (int i : nums) {
			newSet.add(i);
		}
		
		Node current = head;
		
		while(current !=null) {
			if(newSet.contains(current.data) && (current.next == null || !newSet.contains(current.next.data))) {
				count++;
			}
			current = current.next;
		}
		
		return count;
	}

}