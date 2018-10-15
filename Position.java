class Position { // for each word in set_of_pages
    PageEntry p;
    int wordIndex;
    public Position(PageEntry pe, int wi) { p = pe; wordIndex = wi; }
    public PageEntry getPageEntry() { return p; } 
    public int getWordIndex() { return wordIndex; }
}