import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Properties;

/**
 * Created by jesse on 4/21/2016.
 */
public class TreeSet {
    public static void main(String[] args) throws Exception {
        final int ARGS_ERROR = -9;

        //initialize
        java.util.TreeSet<Book> books = new java.util.TreeSet<>();
        java.util.TreeSet<Book> books2 = new java.util.TreeSet<>(new BookPrice());
        PriorityQueue<Book> pq = new PriorityQueue<Book>();
        PriorityQueue<Book> pq2 = new PriorityQueue<Book>(20, new BookPrice());

        //read them all in
        if (args.length != 1) {
            System.err.println("Supply name of properties file");
            System.exit(ARGS_ERROR);
        }
        final String PROPERTIES_FILE_NAME = args[0];
        Properties properties = new Properties();
        String fileName = null;
        try {
            properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
            fileName = properties.getProperty("file_name");
        } catch (IOException e) {
            System.err.println("Exception Occurred" + e.getMessage());
            //System.exit(PROPERTIES_FILE_ERROR);
        }
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String text;
        while ((text = reader.readLine()) != null) {
            String parts[] = text.split(","); // separator is ,
            try {
                Book b = new Book(Integer.parseInt(parts[2]), BookTypes.valueOf(parts[1]),
                        parts[0], Double.parseDouble(parts[3]));
                books.add(b);
                books2.add(b);
                pq.offer(b);
                pq2.offer(b);
            } catch (BookException e) {
                System.err.println("Cannot open data file " + fileName + e.getMessage());
                //System.exit(BAD_DATA_FILE);
            }
        }
        //print the normal TreeSet
        books.forEach(System.out::println);
        //print the TreeSet with price
        books2.forEach(System.out::println);
        //print the priority queue
        try {
            for (int x = 0; x < pq.size(); ++x) {
                System.out.println(pq.poll());
            }
        } catch (Exception e) {
            System.err.println("Reached end of queue.");
        }
        //print the priority queue with price
        try {
            for (int x = 0; x < pq2.size(); ++x) {
                System.out.println(pq2.poll());
            }
        } catch (Exception e) {
            System.err.println("Reached end of queue.");
        }
    }
}
/*OutPut
        Cannot open data file books.txtNumber of pages cannot be less than one.
        Cannot open data file books.txtPrice is negative.
        Cannot open data file books.txtThe title is zero in length.
        Book{numberOfPages=120, type=HARDBACK, title='The Lord of the Rings', price=29.99}
        Book{numberOfPages=156, type=SOFTBACK, title='And Then There Were None', price=19.99}
        Book{numberOfPages=212, type=HARDBACK, title='The Hobbit', price=32.5}
        Book{numberOfPages=253, type=HARDBACK, title='The Da Vinci Code', price=25.0}
        Book{numberOfPages=320, type=HARDBACK, title='American Sniper', price=16.2}
        Book{numberOfPages=391, type=SOFTBACK, title='The Girl on the Train', price=23.0}
        Book{numberOfPages=439, type=ELECTRONIC, title='Harry Potter and the Half-Blood Prince', price=19.99}
        Book{numberOfPages=829, type=HARDBACK, title='The Soloman Curse', price=23.95}
        Book{numberOfPages=320, type=HARDBACK, title='American Sniper', price=16.2}
        Book{numberOfPages=156, type=SOFTBACK, title='And Then There Were None', price=19.99}
        Book{numberOfPages=391, type=SOFTBACK, title='The Girl on the Train', price=23.0}
        Book{numberOfPages=829, type=HARDBACK, title='The Soloman Curse', price=23.95}
        Book{numberOfPages=253, type=HARDBACK, title='The Da Vinci Code', price=25.0}
        Book{numberOfPages=120, type=HARDBACK, title='The Lord of the Rings', price=29.99}
        Book{numberOfPages=212, type=HARDBACK, title='The Hobbit', price=32.5}
        Book{numberOfPages=120, type=HARDBACK, title='The Lord of the Rings', price=29.99}
        Book{numberOfPages=156, type=SOFTBACK, title='And Then There Were None', price=19.99}
        Book{numberOfPages=212, type=HARDBACK, title='The Hobbit', price=32.5}
        Book{numberOfPages=253, type=HARDBACK, title='The Da Vinci Code', price=25.0}
        Book{numberOfPages=320, type=HARDBACK, title='American Sniper', price=16.2}
        Book{numberOfPages=439, type=ELECTRONIC, title='Harry Potter and the Half-Blood Prince', price=19.99}
        Book{numberOfPages=156, type=SOFTBACK, title='And Then There Were None', price=19.99}
        Book{numberOfPages=391, type=SOFTBACK, title='The Girl on the Train', price=23.0}

 */