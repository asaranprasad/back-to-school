package misc;

import java.util.HashMap;
import java.util.Scanner;
import doublyLinkedList.DNode;
import doublyLinkedList.TreeOutputPrinter;

public class ConstructBinaryTreeFromParentChildRelationshipMapping {

	public static void main(String[] args) {
		DNode root = null;
		HashMap<Integer, DNode> nodeMap = new HashMap<Integer, DNode>();
		//					Input(Child Parent isLeft):
		//						15 20 true
		//						19 80 true
		//						17 20 false
		//						16 80 false
		//						80 50 false
		//						50 null false
		//						20 50 true
		//						END
		//					Output:
		//						15 20 17 50 19 80 16 

		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String line = scan.nextLine();
			if (line.equals("END"))
				break;
			DNode temp = mapIt(nodeMap, line);
			if (temp != null)
				root = temp;
		}
		scan.close();

		TreeOutputPrinter.asInOrderLinear(root);
	}

	private static DNode mapIt(HashMap<Integer, DNode> nodeMap, String nextLine) {
		String tempArr[] = nextLine.split(" ");
		int childID = Integer.parseInt(tempArr[0]);
		boolean isLeft = Boolean.parseBoolean(tempArr[2]);
		int parentID;

		DNode parentNode = null;
		DNode childNode = null;

		if ((childNode = nodeMap.get(childID)) == null)
			childNode = new DNode(childID);

		if (tempArr[1].equals("null"))
			return childNode;
		else
			parentID = Integer.parseInt(tempArr[1]);

		if ((parentNode = nodeMap.get(parentID)) == null)
			parentNode = new DNode(parentID);

		if (isLeft)
			parentNode.left = childNode;
		else
			parentNode.right = childNode;

		nodeMap.put(parentID, parentNode);
		nodeMap.put(childID, childNode);

		return null;
	}

}
