package doublyLinkedList;

public class QueueOfDllNodes {
	private SLLnodeToHoldDLLNode head;
	private SLLnodeToHoldDLLNode tail;
	private int size = 0;

	public void enQueue(DNode data) {
		size++;
		if (head == null) {
			head = new SLLnodeToHoldDLLNode(data);
			tail = head;
			return;
		}
		SLLnodeToHoldDLLNode node = new SLLnodeToHoldDLLNode(data);
		tail.next = node;
		tail = node;
	}

	public DNode deQueue() {
		if (head == null) {
			return null;
		}
		size--;
		DNode returnData = head.data;
		head = head.next;
		return returnData;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public int getSize() {
		return size;
	}

}
