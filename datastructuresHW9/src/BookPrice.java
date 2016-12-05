import java.util.Comparator;

/**
 * Created by jesse on 4/21/2016.
 */
public class BookPrice implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        //System.out.println("In compare");
        try {
            if (b1.getPrice() < b2.getPrice()) {
                return -1;
            } else if (b1.getPrice() > b2.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        } catch (BookException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
