
public class LinkedList {

	Node head;
	Node tail;
	int count;
	int data;

	public void append(int data) {

		Node newdata = new Node(data);

		if (head == null) {
			head = newdata;
			return;
		}

		Node current = head;

		while (current != null && current.next != null) {
			current = current.next;
		}

		current.next = newdata;
	}

	public void prepend(int data) {

		Node newdata = new Node(data);

		if (head == null) {
			head = newdata;
			return;
		}

		newdata.next = head;
		head = newdata;
	}

	public void delete(int data) {

		if (head == null)
			return;

		if (head != null && head.data == data) {
			head = head.next;
			return;
		}

		Node current = head;

		while (current != null && current.next != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
				return;
			} else {

				current = current.next;
			}
		}

	}
	
	public void insertAfterNode(int prev, int data) {
		
		Node newdata = new Node(data);
		
		if(head == null) return;
		
		Node current = head;
		
		while(current != null) {
			
			if(current.data == prev) {
				newdata.next = current.next;
				current.next = newdata;
				break;
			}
			current = current.next;
		}
		
	}

	public void reverse() {
		
		if(head == null) return;
		Node prev = null; 
		Node current = head;
		
		while(current != null) {
			Node nxtNode = current.next;
			current.next = prev;
			prev = current;
			current = nxtNode;
		}
		
		head = prev;
	}
}
