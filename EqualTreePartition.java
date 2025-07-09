import java.util.List;
import java.util.ArrayList;

public class EqualTreePartition {
	
	List<Integer> sumAdd = new ArrayList<>();
	
	public boolean equalTree(TreeNode root) {
		
		int total = recursive( root);
		sumAdd.remove(sumAdd.size()-1);
		return (total%2 == 0)&&(sumAdd.contains(total/2));
	}
	
	public int recursive(TreeNode root) {
		
		int left = recursive(root.left);
		int right = recursive(root.right);
		
		int sum = left+right+root.val;
		sumAdd.add(sum);
		return sum;
		
	}

}
