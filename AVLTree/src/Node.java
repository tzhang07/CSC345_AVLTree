class Node<T> {
	private T value;
	private Node<T> right;
	private Node<T> left;
	private Node<T> parent;
	
	public Node(T item){
		this.value = item;
		this.right = null;
		this.left = null;
		this.parent = null;
	}
	
	public Node<T> getRight() {
		return right;
	}
	
	public Node<T> getLeft() {
		return left;
	}
	
	public Node<T> getParent() {
		return parent;
	}
	
	public void setLeft(Node<T> node) {
		this.left = node;
	}
	
	public void setRight(Node<T> node) {
		this.right = node;
	}
	
	public void setParent(Node<T> node) {
		this.parent = node;
	}
	
	
}
