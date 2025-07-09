// 226. Invert Binary Tree
public class InverseBinaryTree {

	public TreeNode invertTree(TreeNode root) {
        TreeNode head = invert(root);
        return head;
    }
    public TreeNode invert(TreeNode root){
        if(root == null) {
            return root;
        }

        TreeNode left = invert(root.left);

        TreeNode right = invert(root.right);

            root.left = right;
            root.right = left;

        return root;

    }
}
