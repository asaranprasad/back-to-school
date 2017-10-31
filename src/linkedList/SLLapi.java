package linkedList;

public class SLLapi {
	private SLLnode head;

	public void push(int data) {
		if (head == null) {
			head = new SLLnode(data);
			return;
		}
		SLLnode node = new SLLnode(data);
		SLLnode curr = head;
		while (curr.next != null)
			curr = curr.next;
		curr.next = node;
	}

	private void delete(SLLnode prev, SLLnode node) {
		prev.next = node.next;
	}

	public void print() {
		SLLnode curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}

	public void deleteFirstOccuranceOfData(int data) {
		SLLnode curr = head;
		SLLnode prev = curr;
		while (curr.next != null) {
			if (curr.data == data)
				break;
			prev = curr;
			curr = curr.next;
		}
		delete(prev, curr);
	}

	public int findIndexOf(int data) {
		SLLnode curr = head;
		int index = -1;
		int iter = -1;
		while (curr != null) {
			iter++;
			if (curr.data == data) {
				index = iter;
				break;
			}
			curr = curr.next;

		}
		return index;
	}

	public static void main(String args[]) {
		SLLapi mySinglyLinkedList = new SLLapi();
		mySinglyLinkedList.push(1);
		mySinglyLinkedList.push(2);
		mySinglyLinkedList.push(3);
		mySinglyLinkedList.push(4);
		mySinglyLinkedList.push(5);

		mySinglyLinkedList.print();
		System.out.println();

		mySinglyLinkedList.deleteFirstOccuranceOfData(3);

		mySinglyLinkedList.print();
		System.out.println();

		System.out.println(mySinglyLinkedList.findIndexOf(5));
		System.out.println(mySinglyLinkedList.findIndexOf(1));
		System.out.println(mySinglyLinkedList.findIndexOf(3));
	}
}
