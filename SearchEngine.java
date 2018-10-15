class SearchEngine {
    public InvertedPageIndex ipi = new InvertedPageIndex();
    public void performAction(String actionMessage) {
        String[] action = actionMessage.split("\\s+");
        if(action[0].equals("addPage")) {
            try {
                PageEntry p = new PageEntry(action[1]);
                ipi.addPage(p);
            } catch(Exception e) { System.out.println(e.getMessage()); }
        }
        else if(action[0].equals("queryFindPagesWhichContainWord")) {
            String ans = "";
            Myset<PageEntry> tempset = ipi.getPagesWhichContainWord(action[1]);
            Node<PageEntry> temp = tempset.set.head;
            while(temp!=null) {
                ans = ans + temp.data.name + ", ";
                temp = temp.next;
            }
            System.out.println(ans.substring(0,ans.length()-2));
        }
        else if(action[0].equals("queryFindPositionsOfWordInAPage")) {
            String ans = "";
            Myset<PageEntry> tempset = ipi.getPagesWhichContainWord(action[1]);
            Node<PageEntry> temp = tempset.set.head;
            while(temp!=null) {
                if(action[2].equals(temp.data.name)) break;
                temp = temp.next;
            }
            if(temp!=null) {
                Node<WordEntry> temp2 = temp.data.page_index.pi_set.head;
                while(temp2!=null) {
                    if(action[1].equals(temp2.data.word)) break;
                    temp2 = temp2.next;
                }
                Node<Position> temp3 = temp2.data.word_position.head;
                while(temp3!=null) {
                    if(action[2].equals(temp3.data.p)) ans = ans + temp3.data.wordIndex + ", ";
                    temp3 = temp3.next;
                }
                System.out.println(ans.substring(0,ans.length()-2));
            }
            else {
                System.out.println("Webpage " + action[2] + " does not contain word " + action[1]);
            }
        }
    }
}