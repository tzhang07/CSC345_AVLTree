class Node<T> {
	public T value;
	public Node<T> right;
	public Node<T> left;
	public Node<T> parent;
	public int weight;
	
	public Node(T item){
		this.value = item;
		this.right = null;
		this.left = null;
		this.parent = null;
	}

	
}
