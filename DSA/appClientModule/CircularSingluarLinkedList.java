
public class CircularSingluarLinkedList {
	
	Node head = null;
	int data;
	
	
	public void append(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head =  newNode;
			newNode.next = head;
			return;
		}
		
		Node current = head;
		
		while(current.next != head){
			current = current.next;
		}
		
		current.next = newNode;
		newNode.next = head;
		
	}
	
	public void prepend(int data) {
		Node newNode = new Node(data);
		
		if(head == null){
			head = newNode;
			newNode.next = head;
			return;
		}
		Node current = head; 
		 
		while(current.next != head) {
			current = current.next;
		}
		newNode.next = head;
		head = newNode;
		current.next = head;
		

	}
	
	public void reverse() {
		
		Node prev = null;
		Node nextNode = null;
		Node current = head;
		
		do {
			nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
			
		}while(current != head);
		
		head.next = prev;
		head = prev;
	
	}
}
