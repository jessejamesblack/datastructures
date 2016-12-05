import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
    Jesse-James Black
    COMP 228
    Homework #4
 */
public class UseBook {
    public static void main(String[] args) throws Exception {
        final int ARGS_ERROR = -9;
        final int PROPERTIES_FILE_ERROR = -11;
        final int BAD_DATA_FILE = -11;
        Book b1 = null;
        Book b2 = null;
        Book b3 = null;
        Book b4 = null;

        //Says yes these books are equal and hashcode same
        try {
            b1 = new Book(40, BookTypes.HARDBACK, "Lord of the Flies", 8.99);
            System.out.println(b1);
            b2 = new Book(40, BookTypes.HARDBACK, "Lord of the Flies", 8.99);
            System.out.println(b2);
        } catch (BookException e) {
            System.err.println(e.getMessage());
        }
        //Says no these books are not equal and hashcode is different
        try {
            b3 = new Book(10, BookTypes.ELECTRONIC, "Night Shift", 7.99);
            System.out.println(b1);
            b4 = new Book(50, BookTypes.HARDBACK, "Lord of the Flies", 8.99);
            System.out.println(b2);
        } catch (BookException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(b1.equals(b2));
        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        System.out.println(b3.equals(b4));
        System.out.println(b3.hashCode());
        System.out.println(b4.hashCode());

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
        LinkedBookLog log = new LinkedBookLog();
        while ((text = reader.readLine()) != null) {
            String parts[] = text.split(","); // separator is ,
            try {
                Book b = new Book(Integer.parseInt(parts[2]), BookTypes.valueOf(parts[1]),
                        parts[0], Double.parseDouble(parts[3]));
                log.insert(b);
                System.out.println(b);
            } catch (BookException e) {
                System.err.println("Cannot open data file " + fileName + e.getMessage());
                //System.exit(BAD_DATA_FILE);
            }
        }
    }
}

/* OutPut
        Book{numberOfPages=40, type=HARDBACK, title='Lord of the Flies', price=8.99}
        Book{numberOfPages=40, type=HARDBACK, title='Lord of the Flies', price=8.99}
        Book{numberOfPages=40, type=HARDBACK, title='Lord of the Flies', price=8.99}
        Book{numberOfPages=40, type=HARDBACK, title='Lord of the Flies', price=8.99}
        true
        2108958741
        2108958741
        false
        -1635702194
        2108958751
        Cannot open data file books.txtNumber of pages cannot be less than one.
        Cannot open data file books.txtPrice is negative.
        Cannot open data file books.txtThe title is zero in length.
        Book{numberOfPages=120, type=HARDBACK, title='The Lord of the Rings', price=29.99}
        Book{numberOfPages=156, type=SOFTBACK, title='And Then There Were None', price=19.99}
        Book{numberOfPages=212, type=HARDBACK, title='The Hobbit', price=32.5}
        Book{numberOfPages=253, type=HARDBACK, title='The Da Vinci Code', price=25.0}
        Book{numberOfPages=439, type=ELECTRONIC, title='Harry Potter and the Half-Blood Prince', price=19.99}
        Book{numberOfPages=829, type=HARDBACK, title='The Soloman Curse', price=23.95}
        Book{numberOfPages=320, type=HARDBACK, title='American Sniper', price=16.2}
        Book{numberOfPages=391, type=SOFTBACK, title='The Girl on the Train', price=23.0}
        */