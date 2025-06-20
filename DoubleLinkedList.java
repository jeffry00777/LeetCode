
public class DoubleLinkedList {
	
	DoubleNode head; 
	int data; 
	
	public DoubleLinkedList(int data) {
		this.data = data;
	}
	
	public void append(int data) {
		
		DoubleNode current = head; 
		
		DoubleNode newNode = new DoubleNode(data,null);
		if(head == null) {
			head = newNode;
			return;
		}
		
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = newNode;
		newNode.back = current;
		
	}
	
	public void reverse() {
		
		DoubleNode current = head;
		DoubleNode temp = null;
		DoubleNode prev = null;
		
		while(current != null) {
			prev = current;

			temp = current.back; 
			current.back = current.next;
			current.next = temp;
			
			current = current.back;
		}
		
		head = prev;
	}
	
	public Boolean check(Node data) {
		Node fast = data;
		Node slow = data;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	
	// remove Node from nth step 
	
	public Node removeNode(Node node, int step) {

		Node first = node;
		Node second = node;
		
		for(int i=0; i< step; i++) {
			if (first == null) return node; 
			first = first.next;
		}
		

		if(first == null) {
			return node.next;
		}
		
		
		while(first.next!= null) {
			first = first.next;
			second = second.next;
		}
		
		second.next = second.next.next;
		
		return node;
	}
}
