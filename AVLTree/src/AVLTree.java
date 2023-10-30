public class AVLTree<T extends Comparable<T>>  {
	private Node<T> root;
	
	public AVLTree() {
		this.root = null;
	}
	
	public AVLTree(Node<T> root) {
		this.root = root;
	}
	
	public void insert(T value) {
		root = insertHelper(root, value);
	}
	
	private Node<T> insertHelper(Node<T> root, T value){
		if(root == null) {
			root = new Node<T>(value);
		}
		int compareValue = compare(value, root.value);
		
		if(compareValue < 0) {
			root.left = insertHelper(root.left, value);
		}
		else if(compareValue > 0) {
			 root.right = insertHelper(root.right, value);
		}
		
		// TODO:
		// 		Balancing/Rotating and updating the weight
		
		return root;
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
}
