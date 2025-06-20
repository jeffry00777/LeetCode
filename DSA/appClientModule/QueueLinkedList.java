
public class QueueLinkedList {
	
	Node start;
	
	Node end;
	
	public void push(int data) {
		Node newNode = new Node(data);
		 if(start == null && end ==null) {
			 start = newNode;
			 end = newNode;
		 }else {
			 newNode.next = end;
			 end = newNode;
		 }
	}
	
	public void pop() {
		if(start == null) {
			return;
		}
		start = start.next;
		
		if(start ==null) {
			end = null;
		}
	}

}
