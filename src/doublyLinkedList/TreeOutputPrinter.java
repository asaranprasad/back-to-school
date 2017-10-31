package doublyLinkedList;

public class TreeOutputPrinter {

	public static void asInOrderLinear(DNode root) {
		if (root == null)
			return;
		asInOrderLinear(root.left);
		System.out.println(root.data + " ");
		asInOrderLinear(root.right);

	}

	public static void asTree(DNode root) {
		// first, lets order the tree in top-down left-right format into a queue
		QueueOfDllNodes iterQueue = new QueueOfDllNodes();
		QueueOfDllNodes queue = new QueueOfDllNodes();
		queue.enQueue(root);
		DNode iter = root;
		while (!iterQueue.isEmpty()) {

			if (iter.left != null) {
				queue.enQueue(iter.left);
				iterQueue.enQueue(iter.left);
			}
			if (iter.right != null) {
				queue.enQueue(iter.right);
				iterQueue.enQueue(iter.right);
			}

			iter = iterQueue.deQueue();
		}

		// next, lets print the queue in tree format to Sysout
		int size = queue.getSize();

		for (int i = 0; i < size; i++) {
			
			
		}

	}

	public static void asLinear(int[] array) {

	}

	public static void asHeapTree(int[] array) {

	}

}
