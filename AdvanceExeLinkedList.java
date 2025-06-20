
public class AdvanceExeLinkedList {
	
	NodeF head = null;
	
	// Flattern a Linked List
	
	public void flattern() {
		
		NodeF current = head;
		
		while(current != null) {
			
			if(current.child != null) {
				
				NodeF nxtNode = current.next;
				NodeF child = current.child;
				
				NodeF tail = child;
				
				while(tail.next != null) {
					tail = tail.next;
				}
				
				tail.next = nxtNode;
				current.next = child;
				current.child = null;
			}
			
			current = current.next;
		}
	}

	
	// flattern a multi level linked List 
	
	public NodeF multiFlattern(NodeF ss) {
		
		NodeF current = ss;
		NodeF tail = ss;
		
		while(current != null) {
			
			if(current.child != null){
				
				NodeF nextNode = current.next;
				NodeF child = current.child;
				
				NodeF newTail = multiFlattern(child);
				
				newTail.next = nextNode;
				current.next = child;
				current.child = null;
				
				current = newTail;
				
			}else {
			current = current.next;
			}
			
			if(current != null) {
				tail = current;
			}
		}
		
		return tail;
	}
	

	
}
