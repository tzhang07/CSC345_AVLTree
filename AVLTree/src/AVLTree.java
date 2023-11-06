import java.util.Queue;

public class AVLTree<T extends Comparable<T>>  {
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
	
	private Node<T> insertHelper(Node<T> root, T value){
		if(root == null) {
			root = new Node<T>(value);
			size++;
			return root;
		}
		int compareValue = compare(value, root.value);
		
		if(compareValue < 0) {
			root.left = insertHelper(root.left, value);
			root.weight += -1; // More left heavy
		}
		else if(compareValue > 0) {
			 root.right = insertHelper(root.right, value);
			 root.weight += 1; // More right heavy
		}
		
		// Check if rotate is required
		if (root.weight >= 2) {
			rotateLeft(root);
		} else if (root.weight <= -2) {
			rotateRight(root);
		}
		
		return root;
	}
	
	// Rotates the tree from root to the left
	private void rotateLeft(Node<T> root) {
		T replaceWith = pullFromRight(root.right);
		T toReplace = root.value;
		root.value = replaceWith;
		pushToLeft(root.left, toReplace);
	}
	
	// Rotates the tree from the root to the right
	private void rotateRight(Node<T> root) {
		T replaceWith = pullFromLeft(root.left);
		T toReplace = root.value;
		root.value = replaceWith;
		pushToRight(root.right, toReplace);
	}
	
	// Pulls items from the right towards the root
	private T pullFromRight(Node<T> curr) {
		T replacement = null;
		if (curr.right != null) {
			replacement = pullFromRight(curr.right);
		} else {
			if (curr.left != null) { // If at end and there is a node to the left, do a swap
				replacement = curr.left.value;
				curr.left = null;
			} else {
				replacement = curr.value;
			}
			return replacement;
		}
		
		if (curr.right.value == replacement) { // Get rid of the edge
			curr.right = null;
		}
		
		// Replace the current with the new guy
		T nextReplacement = curr.value;
		curr.value = replacement;
		
		// Recalc the weight. Should only do this a couple times on average due to how the tree is structured
		curr.weight = heightOfTree(curr.right) - heightOfTree(curr.left);
		
		return nextReplacement;
	}
	
	// Pushes items to the right away from the root
	private void pushToRight(Node<T> curr, T replaceWith) {
		T toReplace = curr.value;
		curr.value = replaceWith;
		
		if (curr.right != null) {
			pushToRight(curr.right, toReplace);
		} else {
			curr.right = new Node<T>(toReplace);
		}
		
		curr.weight = heightOfTree(curr.right) - heightOfTree(curr.left);
	}
	
	// Pulls items from the left of the root
	private T pullFromLeft(Node<T> curr) {
		T replacement = null;
		if (curr.left != null) {
			replacement = pullFromRight(curr.left);
		} else {
			if (curr.left != null) { // If at end and there is a node to the right, do a swap
				replacement = curr.right.value;
				curr.right = null;
			} else {
				replacement = curr.value;
			}
			return replacement;
		}
		
		if (curr.left.value == replacement) { // Get rid of the edge
			curr.left = null;
		}
		
		// Replace the current with the new guy
		T nextReplacement = curr.value;
		curr.value = replacement;
		
		// Recalc the weight. Should only do this a couple times on average due to how the tree is structured
		curr.weight = heightOfTree(curr.right) - heightOfTree(curr.left);
		
		return nextReplacement;
	}
	
	// Pushes values down the left hand side of the tree from the root
	private void pushToLeft(Node<T> curr, T replaceWith) {
		T toReplace = curr.value;
		curr.value = replaceWith;
		
		if (curr.left != null) {
			pushToLeft(curr.left, toReplace);
		} else {
			curr.left = new Node<T>(toReplace);
		}
		
		curr.weight = heightOfTree(curr.right) - heightOfTree(curr.left);
	}
	
	// searching for a specific value
	public T search(T value) {
		return searchHelper(root, value);
	}
	
	// returns null if not found
	private T searchHelper(Node<T> root, T value) {
		Node<T> tempRoot = root;
		
		if(this.root == null) {
			return null;
		}
		
		while(tempRoot != null) {
			if(compare(value, tempRoot.value) == 0) {
				return tempRoot.value;
			}
			else if(compare(value, tempRoot.value) < 0) {
				tempRoot = tempRoot.left;
			}
			else {
				tempRoot = tempRoot.right;
			}
		}
		
		return null;
	}
	
	
	public T getMin(){
		Node<T> tempNode = root;
		if(tempNode == null) {
			return null;
		}
		
		while(tempNode.left != null) {
			tempNode = tempNode.left;
		}
		return tempNode.value;
	}
	
	public T getMax() {
		Node<T> tempNode = root;
		if(tempNode == null) {
			return null;
		}
		
		while(tempNode.right != null) {
			tempNode = tempNode.right;
		}
		return tempNode.value;
	}
	
	
	
	public void deleteValue(T value) {
		deleteHelper(root, value);
	}
	
	private Node<T> deleteHelper(Node<T> root, T value) {
		if(root == null) {
			size = size - 1;
			return null;
		}
		if(compare(value, root.value) < 0) {
			root.left = deleteHelper(root.left, value);
		}
		else if(compare(value, root.value) > 0) {
			root.right = deleteHelper(root.right, value);
		}
		else {
			if(root.left == null) {
				return root.right;
			}
			else if(root.right == null) {
				return root.left;
			}
			
			root.value = minOfSubtree(root.right);
			root.right = deleteHelper(root.right, root.value);
		}
		
		
		// TODO:
		// 		Balancing/Rotating and updating the weight
		
		return root;
	}
	
	
	private T minOfSubtree(Node<T> root) {
		T minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
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
	
	public int heightOfTree(Node<T> curr) { // Is there any fucking trick I can use to make this run better?
		int rightHeight = (curr.right != null) ? heightOfTree(curr.right) : -1;
		int leftHeight = (curr.left != null) ? heightOfTree(curr.left) : -1;
		return (rightHeight > leftHeight) ? rightHeight + 1 : leftHeight + 1;
	}
	
	public void printTree() {
		
	}
	
	
}
