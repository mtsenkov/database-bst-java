// Matthew Tsenkov
// COSC 311
// Project 3

public class Index {
	private IndexRecord top;

	public Index() {
		top = null;
	}

	public IndexRecord getTop() {
		return top;
	}

	public void setTop(IndexRecord front) {
		this.top = front;
	}

	// Find the IndexRecord that we are looking for and return it.
	public IndexRecord find(String key) {
		IndexRecord rover = top;
		int compVal;
		while (rover != null) {
			compVal = rover.getKey().compareTo(key);
			if (compVal == 0) break;
			if (compVal < 0)
				rover = rover.getRight();
			else
				rover = rover.getLeft();
		}
		return rover;
	}
	
	public void insert(String key, int pos) {
		IndexRecord newNode = new IndexRecord(key, pos);
		IndexRecord prev = null;
		IndexRecord current = top;
		boolean wentLeft = false;
		if (current == null)
			top = newNode;
		else {
			while (current != null) {
				prev = current;
				if(current.getKey().compareTo(key) < 0) {
					current = current.getRight();
					wentLeft = false;
				} else {
					current = current.getLeft();
					wentLeft = true;
				}
			}
			if (wentLeft)
				prev.setLeft(newNode);
			else
				prev.setRight(newNode);
		}
	}
	

	// Code used from the book.
	public boolean delete(String key) {
		IndexRecord current = top;
		IndexRecord parent = top;
		boolean isLeftChild = true;

		while (current.getKey().compareTo(key) != 0) {
			parent = current;
			if (current.getKey().compareTo(key) > 0) {
				isLeftChild = true;
				current = current.getLeft();
			} else {
				isLeftChild = false;
				current = current.getRight();
			}
			if (current == null)
				return false;
		}
		System.out.println("parent is: " + parent);
		System.out.println("Current is: " + current);
		System.out.println("Current.getRight is : " + current.getRight());
		System.out.println("Current.getLeft is : " + current.getLeft());
		if (current.getLeft() == null && current.getRight() == null) {
			if (current == top)
				top = null;
			else if (isLeftChild)
				parent.setLeft(null);
			else
				parent.setRight(null);
		} else if (current.getRight() == null) {
			if (current == top)
				top = current.getLeft();
			else if (isLeftChild)
				parent.setLeft(current.getLeft());
			else
				parent.setRight(current.getLeft());
		} else if (current.getLeft() == null) {
			if (current == top)
				top = current.getRight();
			else if (isLeftChild)
				parent.setLeft(current.getRight());
			else
				parent.setRight(current.getRight());
		} else {
			IndexRecord successor = getSuccessor(current);
			if (current == top)
				top = successor;
			else if (isLeftChild)
				parent.setLeft(successor);
			else
				parent.setRight(successor);
			successor.setLeft(current.getLeft());
		}
		return true;
	}

	// Used by the else statement to find the successor.
	private IndexRecord getSuccessor(IndexRecord delNode) {
		IndexRecord successorParent = delNode;
		IndexRecord successor = delNode;
		IndexRecord current = delNode.getRight();
		while (current != null) {
			System.out.println("5");
			successorParent = successor;
			successor = current;
			current = current.getLeft();
		}
		if (successor != delNode.getRight()) {
			System.out.println("6");
			successorParent.setLeft(successor.getRight());
			successor.setRight(delNode.getRight());
		}
		return successor;
	}
	
}
