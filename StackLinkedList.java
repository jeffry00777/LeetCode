
public class StackLinkedList {
	
	Node top;
	int size = 0;
	
	public void push(int data) {
		
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		size += 1;
	}
	
	public int pop() throws Throwable {
		
		if(size == 0) {
			throw new Exception("");
		}
		
		int data = top.data;
		top = top.next;
		size -= 1;
		return data;		
	}
	
	public int size() {		
		return size;
	}
}
