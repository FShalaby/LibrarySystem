package sandbox;

import java.util.List;

public class TextbookGroup {
    public String id;
    public List<Textbook> textbooks;

    public TextbookGroup(String id, List<Textbook> textbooks) {
        this.id = id;
        this.textbooks = textbooks;
    }
}
