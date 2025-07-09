// 110. Balanced Binary Tree

public class BalanceBinaryTree {

	class Solution {
		public boolean isBalanced(TreeNode root) {
			return check(root) != -1;

		}

		public int check(TreeNode root) {

			if (root == null)
				return 0;

			int leftHeight = check(root.left);
			if (leftHeight == -1)
				return -1;

			int rightHeight = check(root.right);
			if (rightHeight == -1)
				return -1;

			if (Math.abs(leftHeight - rightHeight) > 1)
				return -1;

			return (1 + Math.max(leftHeight, rightHeight));
		}

	}
}
