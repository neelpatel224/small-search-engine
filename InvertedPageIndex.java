class InvertedPageIndex {
    public MyHashTable ht = new MyHashTable();
    public void addPage(PageEntry p) {
        Node<WordEntry> temp = p.page_index.pi_set.head;
        while(temp!=null) {
            ht.addPositionsForWord(temp.data);
            temp = temp.next;
        }
    }
    public Myset<PageEntry> getPagesWhichContainWord(String str) {
        Myset<PageEntry> ans = new Myset<PageEntry>();
        Node<WordEntry> temp = ht.hash[ht.getHashIndex(str)].head;
        while(temp!=null) {
            if (str.equals(temp.data.word)) break;
            temp = temp.next;
        }
        if(temp!=null) {
            Node<Position> temp2 = temp.data.word_position.head;
            while(temp2!=null) {
                ans.Insert(temp2.data.p);
                temp2 = temp2.next;
            }
            return ans;
        }
        else { return null; }
    }
}