
public class DoubleLinkedListLearning {

	// DoubleNode newNode;
	DoubleNode head = null;

	public void append(int data) {
		DoubleNode newdata = new DoubleNode(data, null);

		if (head == null) {
			head = newdata;
			return;
		}

		DoubleNode current = head;

		while (current.next != null) {
			current = current.next;
		}

		current.next = newdata;
		newdata.back = current;

	}

	public void prepend(int data) {

		DoubleNode newdata = new DoubleNode(data, null);

		if (head == null) {
			head = newdata;
			return;
		}

		newdata.next = head;
		head.back = newdata;
		head = newdata;
	}

	public void delete(int data) {

		if (head == null)
			return;

		if (head.data == data) {
			head = head.next;
			if(head != null)
			{
			head.back = null;
			}
			return;
		}

		DoubleNode current = head;

		while (current != null) {

			if (current.data == data) {

				if(current.back !=null) {
					current.back.next = current.next;
				}
				
				if(current.next != null) {
					current.next.back = current.back;
				}
			}
			
			current = current.next;
		}
	}
	
	public void reverse() {
		
		if(head == null) return;
		
		DoubleNode prev;
		DoubleNode newHead = null;
		
		DoubleNode current = head;
		
		while(current != null) {
			
			prev = current.back;
			current.back = current.next;
			current.next = prev;
			
			newHead = current;
			current = current.back;
		}
		
		head = newHead;
	}
}
