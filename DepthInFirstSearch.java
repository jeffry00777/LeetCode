import java.util.Stack;
import java.util.List;

public class DepthInFirstSearch {
	
	BFISNode root;
	
	public void depth() {
		
		Stack<BFISNode> stack = new Stack<>();
		stack.add(root);
		
		while(!stack.isEmpty()) {
			BFISNode node = stack.pop();
			
			if(!node.isVisited()) {
				node.setVisited(true);
				System.out.print(node.data);
				List<BFISNode> neibgour = node.getNeibours();
				
				for(int i = neibgour.size()-1; i>=0; i--) {
					BFISNode neig = neibgour.get(i);
					if(!neig.visited) {
					stack.push(neig);
					}
				}
			}
		}
		
	}

}
