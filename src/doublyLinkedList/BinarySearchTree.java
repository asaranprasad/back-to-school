package doublyLinkedList;

public class BinarySearchTree {
	DNode root;

	public void insert(int data) {
		DNode node = new DNode();
		node.data = data;
		if (root == null) {
			root = node;
			return;
		}

		DNode iterNode = root;
		while (iterNode != null) {
			if (data < iterNode.data) {
				if (iterNode.left == null) {
					iterNode.left = node;
					return;
				}
				iterNode = iterNode.left;
			} else {
				if (iterNode.right == null) {
					iterNode.right = node;
					return;
				}
				iterNode = iterNode.right;
			}
		}
	}

	public DNode delete(DNode root, int data) {
		// base case
		if (root == null)
			return root;
		// traversal to the required node
		if (root.data < data)
			root = delete(root.right, data);
		else if (root.data > data)
			root = delete(root.left, data);
		// deletion of node
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else
				return inOrderSuccessorOf(root.right);
		}
		return null;
	}

	private DNode inOrderSuccessorOf(DNode root) {
		DNode temp = null;
		while (root != null) {
			temp = root;
			root = root.left;
		}
		return temp;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(8);
		bst.insert(3);
		bst.insert(2);
		bst.insert(4);
		bst.insert(7);
		bst.insert(6);
		bst.insert(8);
		bst.insert(5);
		bst.insert(75);
		bst.insert(-6);

		System.out.println("inorder traversal: ");
		bst.inorderTraversal(bst.root);
	}

	public void DFS(DNode Node) {
		if (Node == null)
			return;
		System.out.print(Node.data + " ");
		DFS(Node.left);
		DFS(Node.right);
	}

	public void inorderTraversal(DNode node) {
		if (node == null)
			return;
		inorderTraversal(node.left);
		System.out.print(node.data + " ");
		inorderTraversal(node.right);
	}

}
