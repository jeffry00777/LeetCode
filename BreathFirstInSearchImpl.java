import java.util.Queue;
import java.util.LinkedList;

public class BreathFirstInSearchImpl {
	
	BinaryNode root;
	BFISNode node;
	
	public void Order() {
		
		Queue<BinaryNode> newQueue = new LinkedList<>();
		newQueue.add(root);
		
		while(!newQueue.isEmpty()) {
			
			BinaryNode current = newQueue.poll();
			
			System.out.print(current.data);
			
			if(current.left != null) {
				newQueue.add(current.left);
			}
			
			if(current.right != null) {
				newQueue.add(current.right);
			}
		}
	}
	public void Orders() {
		if(node == null) return;
		Queue<BFISNode> newQueue = new LinkedList<>();
		newQueue.add(node);
		
		while(!newQueue.isEmpty()) {
			
			BFISNode current = newQueue.poll();
			
			if(!current.visited) {
				current.setVisited(true);
				System.out.print(current.data);
				newQueue.addAll(current.getNeibours());
			}
			
		}
		
	}
	
	

}
