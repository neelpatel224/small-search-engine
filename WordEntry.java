class WordEntry { // for each word in set_of_pages
    public String word;
    public MyLinkedList<Position> word_position = new MyLinkedList<Position>();
    public WordEntry(String str) { word = str; }
    public void addPosition(Position position) {
        word_position.addFirst(position);
    }
    public void addPositions(MyLinkedList<Position> positions) { //correct it
        //word_position = word_position.Union(positions);
    }
    public MyLinkedList<Position> getAllPositionsForThisWord() {
        return word_position;
    }
    public float getTermFrequency(String word) {
        return 0;
    }
}