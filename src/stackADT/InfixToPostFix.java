package stackADT;

import stackADT.Stack;

public class InfixToPostFix {

	public static void main(String[] args) {
		System.out.println(infixToPostFix("a+b*(c^d-e)^(f+g*h)-i"));
		System.out.println(infixToPostFix("a+b*c+d"));
		System.out.println(infixToPostFix("(A+b)*D+e/(F-G*D)+c"));
		//

	}

	private static String infixToPostFix(String string) {
		String returnVal = "";
		Stack stack = new Stack();
		for (int i = 0; i < string.length(); i++) {
			char curr = string.charAt(i);
			// System.out.println(stack.print());
			while ((!stack.isEmpty()) && (getPriority(curr) <= getPriority(stack.peek())))
				if ((stack.peek() != '('))
					returnVal += stack.pop();
				else
					break;

			switch (curr) {
			case '+':
			case '-':
			case '*':
			case '/':
			case '^':
			case '(':
				stack.push(curr);
				break;
			case ')':
				char popped = stack.pop();
				while (popped != '(') {
					returnVal += popped;
					popped = stack.pop();
				}
				break;
			default:
				returnVal += curr;

			}
		}
		while (!stack.isEmpty())
			returnVal += stack.pop();
		return returnVal;
	}

	private static int getPriority(char curr) {
		switch (curr) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		case '_':
			return 0;
		default:
			return 1000;
		}
	}

}
