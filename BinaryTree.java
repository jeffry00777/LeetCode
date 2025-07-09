
public class BinaryTree {
	BinaryNode root;

	public void insert(int data) {

		root = insertRec(root, data);

	}

	public BinaryNode insertRec(BinaryNode root, int data) {

		BinaryNode newNode = new BinaryNode(data);
		if (root == null) {
			return newNode;
		} else if (data < root.data) {
			root.left = insertRec(root.left, data);
		} else if (data > root.data) {
			root.right = insertRec(root.right, data);
		}

		return root;
	}

	public void inOrder() {
		inorderRec(root);
	}

	public void inorderRec(BinaryNode root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.data);
			inorderRec(root.right);
		}
	}

	public void preorder() {
		preOrderRec(root);
	}

	public void preOrderRec(BinaryNode root) {
		if(root != null) {
		System.out.println(root.data);
		preOrderRec(root.left);
		preOrderRec(root.right);
		}
	}
	
	public void postOrder() {
		postOrderRec(root);
	}

	public void postOrderRec(BinaryNode root) {
		if(root != null) {
			postOrderRec(root.left);
			postOrderRec(root.right);
			System.out.print(root.data);
		}
	}
}
