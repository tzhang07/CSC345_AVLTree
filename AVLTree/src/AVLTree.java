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

		if (compareValue < 0) { // Go left
			root.left = insertHelper(root.left, value);
		} else if (compareValue == 1) { // Go right
			root.right = insertHelper(root.right, value);
		} else {
			root.quantity++;
		}

		// Check if rotate is required as you come back up
		root.weight = recalcWeightOfNode(root);

		if (root.weight >= 2) {
			root = rotateLeft(root);
		} else if (root.weight <= -2) {
			root = rotateRight(root);
		}

		root.height = recalcHeightOfNode(root);
		return root;
	}

	/*
	 * Rotate Notes - Nathan Mette Lets look at rotation again. All I really need to
	 * do is take the two nodes and swap them around, specifically if that wont
	 * cause any errors, such as the rotation causing the new root to have two left
	 * children
	 * 
	 * When root.weight == 2: - if root.right.weight >= 0 -> leftRotation - if
	 * root.right.weight == -1 -> rightRotation on root.right, leftRotation on root
	 * 
	 * When root.weight == -2: - if root.left.weight <= 0 -> rightRotation - if
	 * root.left.weight == 1 -> leftRotation on root.left, rightRotation on root
	 */

	/*
	 * Rotates the tree from root to the left Returns the new root. *****NOTE:
	 * REMEMBER TO SET THE PARENT OF THE RETURN OF THIS METHOD TO THE PARENT OF THE
	 * NODE YOU PASSED***** Assumes Node passed is the root of the tree being
	 * rotated.
	 */
	private Node<T> rotateLeft(Node<T> root) {
		if (root.right == null) {
			return null; // I shouldn't reach this
		}

		if (root.right.weight == -1) {
			root.right = rotateRight(root.right); // Only in the event that the right needs to be rotated to keep
													// balance too
		}

		Node<T> origin = root;
		Node<T> newOrigin = root.right;

		origin.right = newOrigin.left;
		newOrigin.left = origin;

		origin.height = recalcHeightOfNode(origin);
		newOrigin.height = recalcHeightOfNode(newOrigin);
		return newOrigin;
	}

	/*
	 * Rotates the tree from root to the right Returns the new root. *****NOTE:
	 * REMEMBER TO SET THE PARENT OF THE RETURN OF THIS METHOD TO THE PARENT OF THE
	 * NODE YOU PASSED***** Assumes Node passed is the root of the tree being
	 * rotated.
	 */
	private Node<T> rotateRight(Node<T> root) {
		if (root.left == null) {
			return null; // I shouldn't reach this
		}

		if (root.left.weight == 1) {
			root.left = rotateLeft(root.left); // Only in the event that the left needs to be rotated to keep balance
												// too
		}

		Node<T> origin = root;
		Node<T> newOrigin = root.left;

		origin.left = newOrigin.right;
		newOrigin.right = origin;

		origin.height = recalcHeightOfNode(origin);
		newOrigin.height = recalcHeightOfNode(newOrigin);
		return newOrigin;
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
		this.root = deleteHelper(root, value);
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

		// Case 1: the quantity is greater than 1 (dupes)
		else if (root.quantity > 1) {
			root.quantity--;
			System.out.print("Quantity of a node has been reduced\n");
			return root;
		}

		// Case 2: The node is a leaf
		else if (root.left == null && root.right == null) {
			root = null;
			size--;
			return root;

		}

		// Case 3: The node only has 1 child
		else if (root.right == null && root.left != null) {
			root = root.left;
			size--;
		} else if (root.left == null && root.right != null) {
			root = root.right;
			size--;
		}

		// Case 4: The node has both children

		else {

			root.value = findNodeToReplace(root.right).value;
			root.right = deleteHelper(root.right, root.value);
			return root;
		}

		root.height = recalcHeightOfNode(root);
		root.weight = recalcWeightOfNode(root);

		if (root.weight >= 2) {
			root = rotateLeft(root);
		} else if (root.weight <= -2) {
			root = rotateRight(root);
		}

		return root;
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

	private int recalcHeightOfNode(Node<T> curr) {
		int rightHeight = (curr.right != null) ? curr.right.height : -1;
		int leftHeight = (curr.left != null) ? curr.left.height : -1;
		return (rightHeight > leftHeight) ? rightHeight + 1 : leftHeight + 1;
	}

	private int recalcWeightOfNode(Node<T> root) {
		root.weight = 0;
		if (root.right != null) {
			root.weight += (root.right.height + 1);
		}
		if (root.left != null) {
			root.weight -= (root.left.height + 1);
		}
		return root.weight;
	}

	public void printTree() {
		Queue<String> queue = new LinkedList<>();
		Queue<Node<T>> treeTraversalQueue = new LinkedList<>();
		if (root != null) {
			treeTraversalQueue.add(root);
		}

		while (!treeTraversalQueue.isEmpty()) {
			Node<T> curNode = treeTraversalQueue.remove();
			queue.add(curNode.value.toString() + " ");
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

	// FOR TESTING PURPOSES ONLY
	public int getLeftHeight() {
		if (root.left == null) {
			return 0;
		}
		return root.left.height;
	}

	// FOR TESTING PURPOSES ONLY
	public int getRightHeight() {
		if (root.right == null) {
			return 0;
		}
		return root.right.height;
	}

}
