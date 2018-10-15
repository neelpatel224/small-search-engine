class Node<X> {
	public X data;
	public Node<X> next;
	public Node(X d, Node<X> n) { data = d; next = n; }
}