class WordEntry { // for each word in set_of_pages
    //  WordEntry :: word, (LL)word_position
    public String word;
    public MyLinkedList<Position> word_position = new MyLinkedList<Position>();
    public WordEntry(String str) { word = str; }
    public void addPosition(Position position) {
        word_position.addFirst(position);
    }
    public void addPositions(MyLinkedList<Position> positions) {
        Node<Position> temp = positions.head;
        for(int i=0; i<positions.size; i++) {
            word_position.addFirst(temp.data);
            temp = temp.next;
        }
    }
    public MyLinkedList<Position> getAllPositionsForThisWord() { return word_position; }
    public float getTermFrequency(String word) { return 0; }
}