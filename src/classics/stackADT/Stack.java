package stackADT;

public class Stack {
	private Node top;
	private int size = 0;
	private String name = "Unnamed";

	public Stack(String string) {
		this.name = string;
	}

	public Stack() {

	}

	public void push(char data) {
		Node node = new Node();
		node.data = data;
		if (top != null)
			node.next = top;
		top = node;
		size++;
	}

	public char pop() {
		char returnChar = '_';
		if (!this.isEmpty()) {
			returnChar = top.data;
			top = top.next;
			size--;
		}
		return returnChar;

	}

	public boolean isEmpty() {
		return (top == null);
	}

	public String print() {
		String returnVal = "";
		Node iter = top;
		while (iter != null) {
			returnVal += iter.data + " ";
			iter = iter.next;
		}
		return returnVal;
	}

	public char peek() {
		return top.data;
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public String toString() {
		return this.name;
	}
}
