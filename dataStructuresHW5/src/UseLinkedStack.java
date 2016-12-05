import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class UseLinkedStack {
    public static void main(String[] args) throws Exception {
        final int ARGS_ERROR = -9;
        final int PROPERTIES_FILE_ERROR = -11;
        final int BAD_DATA_FILE = -11;
        LinkedStack stack = new LinkedStack();
        //stack.pop();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        /*String top = (String) stack.top();
        System.out.println(top);
        stack.pop();
        top = (String) stack.top();
        System.out.println(top);
        stack.pop();
        top = (String) stack.top();
        System.out.println(top);*/
        try {
            stack.pop();
        } catch (StackUnderflowException e) {
            System.err.println("Exeption: " + e);
        }
        //toString(), popTop(), and size()
        System.out.println("toString(): " + stack.toString());
        System.out.println("popTop(): " + stack.popTop());
        System.out.println("size() of stack: " + stack.size());

        //underflow
        /*
        stack.pop();
        stack.pop();
        stack.pop();
        */
        //underflow
        //stack.top();

        //Showing use of book with linkedStack

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
                for (int x = 0; x < parts.length; x++) {
                    //push the each object onto the stack
                    stack.push(b);
                    //print each one to prove that it is being done
                    System.out.println(stack.top());
                }
            } catch (BookException e) {
                System.err.println("Cannot open data file " + fileName + e.getMessage());
                //System.exit(BAD_DATA_FILE);
            }
        }

        //more use of linkedStack with book
        Book b1 = null;
        Book b2 = null;
        Book b3 = null;
        b1 = new Book(40, BookTypes.HARDBACK, "Lord of the Flies", 8.99);
        b2 = new Book(60, BookTypes.SOFTBACK, "The Mist", 18.99);
        b3 = new Book(50, BookTypes.ELECTRONIC, "The Martian", 48.99);
        stack.push(b1);
        System.out.println("LinkedStack with Book: " + stack.top());
        stack.push(b2);
        System.out.println("LinkedStack with Book: " + stack.top());
        stack.push(b3);
        System.out.println("LinkedStack with Book: " + stack.top());
        stack.pop();
        System.out.println("LinkedStack with Book: " + stack.top());
        System.out.println("logAsArray(): " + log.logAsArray());
    }
}
/*Output
    toString(): Log: LLObjectNode@74a14482

    . C
    . B
    . A

    popTop(): C
    size() of stack: 2
    Book{numberOfPages=120, type=HARDBACK, title='The Lord of the Rings', price=29.99}
    Book{numberOfPages=120, type=HARDBACK, title='The Lord of the Rings', price=29.99}
    Book{numberOfPages=120, type=HARDBACK, title='The Lord of the Rings', price=29.99}
    Book{numberOfPages=120, type=HARDBACK, title='The Lord of the Rings', price=29.99}
    Book{numberOfPages=156, type=SOFTBACK, title='And Then There Were None', price=19.99}
    Book{numberOfPages=156, type=SOFTBACK, title='And Then There Were None', price=19.99}
    Book{numberOfPages=156, type=SOFTBACK, title='And Then There Were None', price=19.99}
    Book{numberOfPages=156, type=SOFTBACK, title='And Then There Were None', price=19.99}
    Book{numberOfPages=212, type=HARDBACK, title='The Hobbit', price=32.5}
    Book{numberOfPages=212, type=HARDBACK, title='The Hobbit', price=32.5}
    Book{numberOfPages=212, type=HARDBACK, title='The Hobbit', price=32.5}
    Book{numberOfPages=212, type=HARDBACK, title='The Hobbit', price=32.5}
    Book{numberOfPages=253, type=HARDBACK, title='The Da Vinci Code', price=25.0}
    Book{numberOfPages=253, type=HARDBACK, title='The Da Vinci Code', price=25.0}
    Book{numberOfPages=253, type=HARDBACK, title='The Da Vinci Code', price=25.0}
    Book{numberOfPages=253, type=HARDBACK, title='The Da Vinci Code', price=25.0}
    Book{numberOfPages=439, type=ELECTRONIC, title='Harry Potter and the Half-Blood Prince', price=19.99}
    Book{numberOfPages=439, type=ELECTRONIC, title='Harry Potter and the Half-Blood Prince', price=19.99}
    Book{numberOfPages=439, type=ELECTRONIC, title='Harry Potter and the Half-Blood Prince', price=19.99}
    Book{numberOfPages=439, type=ELECTRONIC, title='Harry Potter and the Half-Blood Prince', price=19.99}
    Book{numberOfPages=829, type=HARDBACK, title='The Soloman Curse', price=23.95}
    Book{numberOfPages=829, type=HARDBACK, title='The Soloman Curse', price=23.95}
    Book{numberOfPages=829, type=HARDBACK, title='The Soloman Curse', price=23.95}
    Book{numberOfPages=829, type=HARDBACK, title='The Soloman Curse', price=23.95}
    Book{numberOfPages=320, type=HARDBACK, title='American Sniper', price=16.2}
    Book{numberOfPages=320, type=HARDBACK, title='American Sniper', price=16.2}
    Book{numberOfPages=320, type=HARDBACK, title='American Sniper', price=16.2}
    Book{numberOfPages=320, type=HARDBACK, title='American Sniper', price=16.2}
    Book{numberOfPages=391, type=SOFTBACK, title='The Girl on the Train', price=23.0}
    Book{numberOfPages=391, type=SOFTBACK, title='The Girl on the Train', price=23.0}
    Book{numberOfPages=391, type=SOFTBACK, title='The Girl on the Train', price=23.0}
    Book{numberOfPages=391, type=SOFTBACK, title='The Girl on the Train', price=23.0}
    Book{numberOfPages=391, type=SOFTBACK, title='The Girl on the Train', price=23.0}
    LinkedStack with Book: Book{numberOfPages=40, type=HARDBACK, title='Lord of the Flies', price=8.99}
    LinkedStack with Book: Book{numberOfPages=60, type=SOFTBACK, title='The Mist', price=18.99}
    LinkedStack with Book: Book{numberOfPages=50, type=ELECTRONIC, title='The Martian', price=48.99}
    LinkedStack with Book: Book{numberOfPages=60, type=SOFTBACK, title='The Mist', price=18.99}
    Reached last node, aborting
    Book{numberOfPages=391, type=SOFTBACK, title='The Girl on the Train', price=23.0}
    Book{numberOfPages=320, type=HARDBACK, title='American Sniper', price=16.2}
    Book{numberOfPages=829, type=HARDBACK, title='The Soloman Curse', price=23.95}
    Book{numberOfPages=439, type=ELECTRONIC, title='Harry Potter and the Half-Blood Prince', price=19.99}
    Book{numberOfPages=253, type=HARDBACK, title='The Da Vinci Code', price=25.0}
    Book{numberOfPages=212, type=HARDBACK, title='The Hobbit', price=32.5}
    Book{numberOfPages=156, type=SOFTBACK, title='And Then There Were None', price=19.99}
    Book{numberOfPages=120, type=HARDBACK, title='The Lord of the Rings', price=29.99}
    logAsArray(): [Ljava.lang.Object;@677327b6
    Cannot open data file books.txtNumber of pages cannot be less than one.
    Cannot open data file books.txtPrice is negative.
    Cannot open data file books.txtThe title is zero in length.

 */