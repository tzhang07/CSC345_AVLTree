class Node<E> {
	private E value;
	private Node<E> right;
	private Node<E> left;
	private Node<E> parent;
	
	public Node(E item){
		this.value = item;
		this.right = null;
		this.left = null;
		this.parent = null;
	}
	
	public Node getRight() {
		return right;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public void setLeft(Node node) {
		this.left = node;
	}
	
	public void setRight(Node node) {
		this.right = node;
	}
	
	public void setParent(Node node) {
		this.parent = node;
	}
	
	
}
