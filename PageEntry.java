import java.util.*;
import java.io.*;
class PageEntry {
    public PageIndex page_index;
    public String name;
    public PageEntry(String pageName) throws Exception {
        page_index = new PageIndex();
        name = pageName;
        try {
            FileInputStream fstream = new FileInputStream("./webpages/" + pageName);
            Scanner s = new Scanner(fstream);
            String words_string = "";
            String[] punctuation_marks = {"{", "}", "[", "]", "<", ">", "=", "(", ")", ".", ",", ";", "'", "\"", "?", "#", "!", "-", ":"};
            String[] connector_words = {"a", "an", "the", "they", "these", "this", "for", "is", "are", "was", "of", "or", "and", "does", "will", "whose"};
            while(s.hasNextLine()) {
                String line = s.nextLine();
                line = line.toLowerCase();
                for (int i=0; i<punctuation_marks.length; i++) {
                    line = line.replace(punctuation_marks[i]," ");
                }
                for (int i=0; i<connector_words.length; i++) {
                    line = line.replace(" "+connector_words[i]+" ", " ");
                }
                line = line.replace("structures", "structure");
                line = line.replace("stacks", "stack");
                line = line.replace("applications", "application");
                words_string = words_string + " " + line;
            }
            String[] words = words_string.substring(1).split("\\s+");
            for (int i=0; i<words.length; i++) {
                Position p = new Position(this, i+1);
                page_index.addPositionForWord(words[i], p);
            }
        } catch(Exception e) { throw new Exception("Webpage " + pageName + " not found!"); }
    }
    public PageIndex getPageIndex() {
        return page_index;
    }
}