// 100. Same Tree

class SameBinaryTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {

		return check(p, q);

	}

	public boolean check(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val != q.val)
			return false;

		return check(p.left, q.left) && check(p.right, q.right);

	}
}
