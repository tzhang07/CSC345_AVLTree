class Node<T> {
	public T value;
	public Node<T> right;
	public Node<T> left;
	public Node<T> parent;
	public int weight;
	public int height;
	public int quantity;
	
	public Node(T item){
		this.value = item;
		this.right = null;
		this.left = null;
		this.parent = null;
		this.height = 0;
		this.quantity = 1;
	}

	
}
