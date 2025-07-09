import java.util.*;

public class GraphValidTree {
	
	public boolean valid(int n, int[][] edges) {
		
		// n is the number of nodes -1
		
		Map<Integer, List<Integer>> graph = new HashMap<>();
		
		for(int i = 0; i<n; i++) {
			graph.put(i, new ArrayList<>());
		}
		
		Set<Integer> visited = new HashSet<>();
		
		if(!dfs(0, -1, graph, visited)); return false;
		
	}
	
	public boolean dfs(int node, int parent, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
		if(visited.contains(node)) return false;
		visited.add(node);
		
		for(int neibour : graph.get(node)) {
			if(neibour == parent) return false;
			
			if(!dfs(parent, node, graph, visited)) return false;
		}
		
		return true;
	}

}
