package doublyLinkedList;

public class BinaryTreeWithDoubly {
	DNode root;
	static String tempString;

	public void insert(int data) {
		DNode node = new DNode();
		node.data = data;
		if (root == null) {
			root = node;
			return;
		}
		BFSInsert(node);
	}

	private void BFSInsert(DNode node) {
		QueueOfDllNodes queue = new QueueOfDllNodes();
		DNode curr = root;
		while (curr != null) {
			if (curr.left != null)
				queue.enQueue(curr.left);
			else {
				curr.left = node;
				break;
			}
			if (curr.right != null)
				queue.enQueue(curr.right);
			else {
				curr.right = node;
				break;
			}
			curr = queue.deQueue();
		}
	}

	public void DFS(DNode Node) {
		if (Node == null)
			return;
		System.out.print(Node.data + " ");
		DFS(Node.left);
		DFS(Node.right);
	}

	public void convertToMirrorTree(DNode Node) {
		if (Node == null)
			return;
		DNode temp = Node.left;
		Node.left = Node.right;
		Node.right = temp;
		convertToMirrorTree(Node.left);
		convertToMirrorTree(Node.right);

	}

	public static void inOrder(DNode root) {
		if (root != null) {
			inOrder(root.left);
			tempString += root.data + "-";
			inOrder(root.right);
		}
	}

	public static void preOrder(DNode root) {
		if (root != null) {
			tempString += root.data + "-";
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static DNode constructBinaryTreeWithInorderAndPreOrder(String inOrder, String preOrder) {
		String preOrderList[] = preOrder.split("-");
		String inOrderList[] = inOrder.split("-");
		DNode root = new DNode();
		root.data = Integer.parseInt(preOrderList[0]);

		return root;
	}

	public static String diameterOfTheBinaryTree(DNode root, int height) {
		try {
			if (root == null)
				return "0-0";

			int lh = 0, rh = 0;
			String tempString = diameterOfTheBinaryTree(root.left, lh);
			int diameterOfLeftSubtreeOfCurrentRootNode = Integer.parseInt(tempString.split("-")[0]);
			lh = Integer.parseInt(tempString.split("-")[1]);

			tempString = diameterOfTheBinaryTree(root.right, rh);
			int diameterOfRightSubtreeOfCurrentRootNode = Integer.parseInt(tempString.split("-")[0]);
			rh = Integer.parseInt(tempString.split("-")[1]);

			height = Math.max(lh, rh) + 1;
			return Math.max(lh + rh + 1, Math.max(diameterOfLeftSubtreeOfCurrentRootNode, diameterOfRightSubtreeOfCurrentRootNode) + 1) + "-" + height;
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
			return "";
		}
	}

	public static void main(String[] args) {
		BinaryTreeWithDoubly bt = new BinaryTreeWithDoubly();
		for (int i = 1; i < 20; i++)
			bt.insert(i);
		System.out.println("Depth First Search: ");
		bt.DFS(bt.root);

		bt.convertToMirrorTree(bt.root);
		System.out.println("\nDFS Post Converting To Mirror Tree: ");
		bt.DFS(bt.root);
		System.out.println("\n\nDiameter of this tree: " + diameterOfTheBinaryTree(bt.root, 0).split("-")[0]);
		System.out.println("Height of this tree: " + diameterOfTheBinaryTree(bt.root, 0).split("-")[1]);
		//
		tempString = "";
		inOrder(bt.root);
		String inOrder = tempString.substring(0, tempString.lastIndexOf("-"));
		tempString = "";
		preOrder(bt.root);
		String preOrder = tempString.substring(0, tempString.lastIndexOf("-"));
		DNode newTreeRoot = constructBinaryTreeWithInorderAndPreOrder(inOrder, preOrder);
		System.out.println("Depth First Search of new Tree: ");
		bt.DFS(newTreeRoot);
	}
}
