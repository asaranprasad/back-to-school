package queue;

import linkedList.SLLnode;

public class Queue {
	private SLLnode head;
	private SLLnode tail;

	public void enQueue(int data) {
		if (head == null) {
			head = new SLLnode(data);
			tail = head;
			return;
		}
		SLLnode node = new SLLnode(data);
		tail.next = node;
		tail = node;
	}

	public int deQueue() {
		if (head == null) {
			return -999;
		}
		int returnData = head.data;
		head = head.next;
		return returnData;
	}
}
