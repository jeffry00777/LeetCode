

public class FindDiameter {
	
	TreeNode head = null;
	int dia  = 0;
	public int findDia() {
		return diameter(head);
	}
	
	
	public int diameter(TreeNode nodes) {
		
		if(nodes == null) {
			return 0;
		}
		int leftDia =  diameter(nodes.left);
		int rightDia = diameter(nodes.right);
		
		dia = Math.max(dia, leftDia+rightDia);
		
		return (1+Math.max(leftDia, rightDia));
	}
}
