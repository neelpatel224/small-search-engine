class MyHashTable {
    MyLinkedList<WordEntry> [] hash = new MyLinkedList[26];
    public MyHashTable() {
        for (int i=0; i<26; i++) {
            hash[i] = new MyLinkedList<WordEntry>();
        }
    }
    public int getHashIndex(String str) { //works for A-Z, a-z, 0-9
        str = str.toLowerCase();
        int ans = str.charAt(0)-97;
        if(ans>=0 && ans<26) return ans;
        else return str.charAt(0)-48;
    }
    public void addPositionsForWord(WordEntry w) {
        MyLinkedList<WordEntry> myhash = hash[getHashIndex(w.word)];
        Node<WordEntry> temp = myhash.head;
        while(temp!=null) {
            if(w.word.equals(temp.data.word)) break;
            temp = temp.next;
        }
        if (temp==null) { 
            myhash.addFirst(w);
        }
        else {
            Node<Position> temp2 = w.word_position.head;
            while(temp2!=null) {
                temp.data.word_position.addFirst(temp2.data);
                temp2 = temp2.next;
            }
        }
    }
}