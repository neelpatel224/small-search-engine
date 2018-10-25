class PageIndex { // for each page p
    //
    public MyLinkedList<WordEntry> pi_set = new MyLinkedList<WordEntry>();
    public void addPositionForWord(String str, Position p) {
        Node<WordEntry> temp = pi_set.head;
        while(temp!=null) {
            if(str.equals(temp.data.word)) break;
            temp = temp.next;
        }
        if(temp!=null) temp.data.word_position.addFirst(p);
        else {
            WordEntry ans = new WordEntry(str);
            ans.addPosition(p);
            pi_set.addFirst(ans);
        }
    }
    public MyLinkedList<WordEntry> getWordEntries() {
        return pi_set;
    }
}