import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
    Jesse-James Black
    COMP 228
    Homework #7
 */
public class UseBook {
    public static void main(String[] args) throws Exception {
        final int ARGS_ERROR = -9;
        final int PROPERTIES_FILE_ERROR = -11;
        final int BAD_DATA_FILE = -11;
        Book b1 = null;

        try {
            b1 = new Book(40, BookTypes.HARDBACK, "Lord of the Flies", 8.99);
            System.out.println(b1);
        } catch (BookException e) {
            System.err.println(e.getMessage());
        }

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
        List list = new ArrayList(Arrays.asList());
        while ((text = reader.readLine()) != null) {
            String parts[] = text.split(","); // separator is ,
            try {
                Book b = new Book(Integer.parseInt(parts[2]), BookTypes.valueOf(parts[1]),
                        parts[0], Double.parseDouble(parts[3]));
                list.add(b);
                System.out.println(b);
            } catch (BookException e) {
                System.err.println("Cannot open data file " + fileName + e.getMessage());
                //System.exit(BAD_DATA_FILE);
            }
        }

        //instantiate list and add books to it then sort
        Collections.sort(list);
        System.out.println(list);

        //compare
        Book b2 = (Book) list.get(1);
        Book b3 = (Book) list.get(2);
        System.out.println(b2.compareTo(b3));

        //use binary search to locate a book
        int index = Collections.binarySearch(list, list.get(1));
        System.out.println(index);
        Collections.binarySearch(list, b1);
        System.out.println(index);
    }
}
/* OutPut
        Cannot open data file books.txtNumber of pages cannot be less than one.
        Book{numberOfPages=40, type
        =HARDBACK, title='Lord of the Flies', price=8.99}
        Cannot open data file books.txtPrice is negative.
        Book{numberOfPages=120, type=HARDBACK, title='The Lord of the Rings', price=29.99}
        Cannot open data file books.txtThe title is zero in length.
        Book{numberOfPages=156, type=SOFTBACK, title='And Then There Were None', price=19.99}
        Book{numberOfPages=212, type=HARDBACK, title='The Hobbit', price=32.5}
        Book{numberOfPages=253, type=HARDBACK, title='The Da Vinci Code', price=25.0}
        Book{numberOfPa ges=439, type=ELECTRONIC, title='Harry Potter and the Half-Blood Prince', price=19.99}
        Book{numberOfPages=829, type=HARDBACK, title='The Soloman Curse', price=23.95}
        Book{numberOfPages=320, type=HARDBACK, title='American Sniper', price=16.2}
        Book{numberOfPages=391, type=SOFTBACK, title='The Girl on the Train', price=23.0}
        [Book{numberOfPages=120, type=HARDBACK, title='The Lord of the Rings', price=29.99}, Book{numberOfPages=156, type=SOFTBACK, title='And Then There Were None', price=19.99}, Book{numberOfPages=212, type=HARDBACK, title='The Hobbit', price=32.5}, Book{numberOfPages=253, type=HARDBACK, title='The Da Vinci Code', price=25.0}, Book{numberOfPages=320, type=HARDBACK, title='American Sniper', price=16.2}, Book{numberOfPages=391, type=SOFTBACK, title='The Girl on the Train', price=23.0}, Book{numberOfPages=439, type=ELECTRONIC, title='Harry Potter and the Half-Blood Prince', price=19.99}, Book{numberOfPages=829, type=HARDBACK, title='The Soloman Curse', price=23.95}]
        -1
        1
        1
        */