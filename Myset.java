class Myset<X> {
	public MyLinkedList set = new MyLinkedList();
	public Boolean IsEmpty() { return set.isEmpty(); }
	public Boolean IsMember(X o) {
		Node<X> temp = set.head;
		while(temp!=null) {
			if(temp.data==o) return true;
			temp = temp.next;
		}
		return false;
	}
	public void Insert(X o) { if(!IsMember(o)) set.addLast(o); }
	public Myset Union(Myset a) {
		Myset temp  = new Myset();
		MyLinkedList temp2 = this.set;
		MyLinkedList templ = a.set;
		X tempo;
		while(!templ.isEmpty()) {
			tempo = (X)templ.head.data;
			if(!IsMember(tempo)) { temp2.addFirst(tempo); }
			templ.removeFirst();
		}
		temp.set = temp2;
		return temp;
	}
	public Myset Intersection(Myset a) {
		Myset temp  = new Myset();
		MyLinkedList temp2 = new MyLinkedList();
		MyLinkedList templ = a.set;
		X tempo;
		while(!templ.isEmpty()) {
			tempo = (X)templ.head.data;
			if(IsMember(tempo)) { temp2.addFirst(tempo); }
			templ.removeFirst();
		}
		temp.set = temp2;
		return temp;
	}
	public void Delete(X o) throws Exception {
		if(IsMember(o)) {
			if(set.head.data==o) {
				set.head = set.head.next;
			}
			else {
				Node<X> temp = set.head;
				while(temp.next.data!=o) { temp = temp.next; }
				temp.next = temp.next.next;
			}
		} else { throw new Exception("Delete: X not found!"); }
	}
}