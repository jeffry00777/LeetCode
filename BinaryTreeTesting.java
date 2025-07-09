import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;


public class BinaryTreeTesting {
	
	Trees head = null;
	
	Nodes root = null;
	
	public class Nodes{
		int data;
		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public boolean isVisited() {
			return isVisited;
		}

		public void setVisited(boolean isVisited) {
			this.isVisited = isVisited;
		}

		public List<Nodes> getNeigbours() {
			return neigbours;
		}

		public void setNeigbours(List<Nodes> neigbours) {
			this.neigbours = neigbours;
		}

		boolean isVisited;
		List<Nodes> neigbours;
		
		public Nodes(int data) {
			this.data = data;
		}
	}
	
	public class Trees{
		int data;
		Trees left;
		Trees right;
		
		public Trees(int data) {
			this.data = data;
		}
	}
	
	public void append(int data) {
		
		head = appendrec(head, data);
	}
	
	public Trees appendrec(Trees head, int data) {
		
		if(head == null) {
			Trees newNode = new Trees(data);
			head = newNode;
			return head;
		}else if(head.data < data){
			head.left = appendrec(head.left, data);
		}else if(head.data > data) {
			head.right = appendrec(head.right, data);
		}
		return head;
	}
	
	

	public void BreathFirstIn() {
		Trees root = head;
		
		Queue<Trees> list = new LinkedList<>();
		list.add(root);
		
		while(!list.isEmpty()) {
			
			Trees firstElement = list.poll();
			
			System.out.println(firstElement.data);
			
			if(firstElement.left != null) {
				list.add(firstElement.left);
			}
			
			if(firstElement.right != null) {
				list.add(firstElement.right);
			}
		}
		
	}
	
	public void breathInFirstSearac() {
		
		Queue<Nodes> list = new LinkedList<>();
		list.add(root);
		
		while(!list.isEmpty()) {
			
			Nodes firstElement = list.poll();
			
			if(!firstElement.isVisited) {				
				firstElement.setVisited(true);
				System.out.print(firstElement.data);
				list.addAll(firstElement.getNeigbours());
			}
		}
		
	}
	
	public void depthInFirstSearch() {
		
		Stack<Nodes> stack = new Stack<>();
		stack.add(root);
		
		while(!stack.isEmpty()) {			
			Nodes firstElement  = stack.pop();
			
			if(!firstElement.isVisited){
				firstElement.setVisited(true);
				System.out.print(firstElement.data);
				for(int i = firstElement.neigbours.size() -1 ; i >=0 ; i--) {
					Nodes firstNeighbour = firstElement.neigbours.get(i);
					if(!firstNeighbour.isVisited) {
					stack.push(firstNeighbour);
					}
				}
			}
		}
	}
}
