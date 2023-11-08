import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>> {
	private Node<T> root;
	private int size;

	public AVLTree() {
		this.root = null;
		size = 0;
	}

	public AVLTree(Node<T> root) {
		this.root = root;
		size = 1;
	}

	public void insert(T value) {
		root = insertHelper(root, value);
	}

	private Node<T> insertHelper(Node<T> root, T value) {
		if (root == null) {
			root = new Node<T>(value);
			size++;
			return root;
		}
		int compareValue = compare(value, root.value);

		if (compareValue <= 0) {
			root.left = insertHelper(root.left, value);
		} else if (compareValue > 0) {
			root.right = insertHelper(root.right, value);
		}

		// TODO:
		// Balancing/Rotating and updating the weight

		return root;
	}

	// searching for a specific value
	public T search(T value) {
		return searchHelper(root, value);
	}

	// returns null if not found
	private T searchHelper(Node<T> root, T value) {
		Node<T> tempRoot = root;

		if (this.root == null) {
			return null;
		}

		while (tempRoot != null) {
			if (compare(value, tempRoot.value) == 0) {
				return tempRoot.value;
			} else if (compare(value, tempRoot.value) < 0) {
				tempRoot = tempRoot.left;
			} else {
				tempRoot = tempRoot.right;
			}
		}

		return null;
	}

	public T getMin() {
		Node<T> tempNode = root;
		if (tempNode == null) {
			return null;
		}

		while (tempNode.left != null) {
			tempNode = tempNode.left;
		}
		return tempNode.value;
	}

	public T getMax() {
		Node<T> tempNode = root;
		if (tempNode == null) {
			return null;
		}

		while (tempNode.right != null) {
			tempNode = tempNode.right;
		}
		return tempNode.value;
	}

	public void deleteValue(T value) {
		deleteHelper(root, value);
	}

	private Node<T> deleteHelper(Node<T> root, T value) {
		if (root == null) {
			return root;
		}

		if (compare(value, root.value) < 0) {
			root.left = deleteHelper(root.left, value);
			return root;
		} else if (compare(value, root.value) > 0) {
			root.right = deleteHelper(root.right, value);
			return root;
		}

		// Case 1: When node is a leaf
		if (root.left == null && root.right == null) {
			root = null;
			return root;
		}

		// Case 2: When the node has 1 children
		if (root.left == null) {
			root = root.right;
			size = size - 1;
			return root;
		} else if (root.right == null) {
			root = root.left;
			size = size - 1;
			return root;
		} else {

			// Case 3: When Node has both children
			root.value = findNodeToReplace(root.right).value;

			root.right = deleteHelper(root.right, root.value);
			size = size - 1;
			return root;
		}

		// TODO:
		// Balancing/Rotating and updating the weight

//		return root;
	}

	private Node<T> findNodeToReplace(Node<T> root) {
		Node<T> minValueNode = root;
		while (root.left != null) {
			minValueNode = root.left;
			root = root.left;
		}
		return minValueNode;
	}

	private int compare(T insertValue, T nodeValue) {
		return insertValue.compareTo(nodeValue);
	}

	public int getSize() {
		return size;
	}

	public T getLeft() {
		return root.left.value;
	}

	public T getRight() {
		return root.right.value;
	}

	public void printTree() {
		Queue<String> queue = new LinkedList<>();
		Queue<Node<T>> treeTraversalQueue = new LinkedList<>();
		treeTraversalQueue.add(root);

		while (!treeTraversalQueue.isEmpty()) {
			Node<T> curNode = treeTraversalQueue.remove();
			queue.add(curNode.value.toString()+ " ");
			if (curNode.left != null) {
				treeTraversalQueue.add(curNode.left);
			}
			if (curNode.right != null) {
				treeTraversalQueue.add(curNode.right);
			}
		}

		while (!queue.isEmpty()) {
			System.out.print(queue.remove());
		}
		

	}

}