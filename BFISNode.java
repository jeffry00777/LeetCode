import java.util.List;

public class BFISNode {
	
	int data;
	boolean visited;
	List<BFISNode> neibours;
	
	public BFISNode(int data) {
		this.data = data;
	}
	
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public List<BFISNode> getNeibours() {
		return neibours;
	}
	public void setNeibours(List<BFISNode> neibours) {
		this.neibours = neibours;
	}
	
	
	

}
