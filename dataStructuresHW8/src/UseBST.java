import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by jesse on 4/13/2016.
 */

public class UseBST {
    public static void main(String args[]) throws Exception {
        final int ARGS_ERROR = -9;
        final int PROPERTIES_FILE_ERROR = -11;
        final int BAD_DATA_FILE = -11;
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree bstB = new BinarySearchTree();
        //could also do bst.add(20); this is not a comparable it is a primitive
        //javaC will however auto wrap it to one.
        bst.add(new Integer(20));
        bst.add(new Integer(18));
        bst.add(new Integer(80));
        bst.add(new Integer(8));
        bst.add(new Integer(0));
        bst.add(new Integer(10));
        bst.add(new Integer(12));
        bst.add(new Integer(1));
        bst.add(new Integer(2));
        bst.add(new Integer(22));
        bst.printInOrder();
        System.out.println("The smallest value is: " + bst.min());
        System.out.println("The largest value is: " + bst.max());

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
                //p1, p2, p3, p4 are the parts string from HW4
                int p1 = Integer.parseInt(parts[2]);
                BookTypes p2 = BookTypes.valueOf(parts[1]);
                String p3 = parts[0];
                Double p4 = Double.parseDouble(parts[3]);
                bstB.add(new Book(p1, p2, p3, p4));
            } catch (BookException e) {
                System.err.println("Cannot open data file " + fileName + e.getMessage());
                //System.exit(BAD_DATA_FILE);
            }
        }
        bstB.printInOrder();
    }
}

/*      //use giant parse thing from previous code. Look at HW4.
    BST b = new BST();
    while(readLine())
        //parse
        b.add(new Book(p1, p2, p3, p4);
 */
/* Output
    Cannot open data file books.txtNumber of pages cannot be less than one.
    0
    Cannot open data file books.txtPrice is negative.
    Cannot open data file books.txtThe title is zero in length.
    1
    2
    8
    10
    12
    18
    20
    22
    80
    The smallest value is: 0
    The largest value is: 80
    Book{numberOfPages=391, type=SOFTBACK, title='The Girl on the Train', price=23.0}
    Book{numberOfPages=320, type=HARDBACK, title='American Sniper', price=16.2}
    Book{numberOfPages=829, type=HARDBACK, title='The Soloman Curse', price=23.95}
    Book{numberOfPages=439, type=ELECTRONIC, title='Harry Potter and the Half-Blood Prince', price=19.99}
    Book{numberOfPages=253, type=HARDBACK, title='The Da Vinci Code', price=25.0}
    Book{numberOfPages=212, type=HARDBACK, title='The Hobbit', price=32.5}
    Book{numberOfPages=156, type=SOFTBACK, title='And Then There Were None', price=19.99}
    Book{numberOfPages=120, type=HARDBACK, title='The Lord of the Rings', price=29.99}

 */