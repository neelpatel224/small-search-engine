class MyLinkedList<X> {
	public Node<X> head;
	public int size = 0;
	public MyLinkedList() {
		head = null;
	}
	public Boolean isEmpty() { return size==0; }
	public void addFirst(X d) {
    	head = new Node<X>(d, head);
    	size++;
	}
	public void addLast(X d) {
		if(head==null) {
			head = new Node<X>(d, head);
		}
		else {
	  		Node<X> temp = head;
	  		while(temp.next!=null) { temp = temp.next; }
			temp.next = new Node<X>(d, null);
		}
		size++;
	}
	public X removeFirst() {
		if (isEmpty()) return null;
		X temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}