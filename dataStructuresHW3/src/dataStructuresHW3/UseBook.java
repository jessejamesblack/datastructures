/*
    Jesse-James Black
    COMP 228
    Homework #4
 */
public class UseBook {
    public static void main(String[] args) throws Exception {
        Book b1 = null;
        Book b2 = null;

        //throws title is null BookException
        try {
            b1 = new Book(40, BookTypes.HARDBACK, "Lord of the Flies", 8.99);
            System.out.println(b1);
            b2 = new Book(90, BookTypes.SOFTBACK, null, 15.40);
            System.out.println(b2);
        } catch (BookException e) {
            System.err.println(e.getMessage());
        }
        //throws BookException because numberOfPages is 0
        try {
            b1.setNumberOfPages(0);
        } catch (BookException e) {
            System.err.println(e.getMessage());
        }
        //Doesn't throw exception because of BookTypes enum
        /*try{
            b1.setType(BookTypes.ELECTRONIC);
        }catch (BookException e){
            System.err.println(e.getMessage());
        }*/
        //throws price is less than 0 BookException
        try {
            b1.setPrice(-1);
        } catch (BookException e) {
            System.err.println(e.getMessage());
        }
        //throws title is <= 0 exception
        try {
            b1.setTitle("");
        } catch (BookException e) {
            System.err.println(e.getMessage());
        }
        //throws title is null exception
        try {
            b1.setTitle(null);
        } catch (BookException e) {
            System.err.println(e.getMessage());
        }try {
            b1 = new Book(40, BookTypes.HARDBACK, "Lord of the Flies", 8.99);
            System.out.println(b1.hashCode());
            b2 = new Book(90, BookTypes.SOFTBACK, "Star Wars", 15.40);
            System.out.println(b2.hashCode());
        } catch (BookException e) {
            System.err.println(e.getMessage());
        }
    }
}
/* OutPut
        Book{numberOfPages=40, type=HARDBACK, title='Lord of the Flies', price=8.99}
        The title is null.
        Number of pages cannot be less than one.
        Price is negative.
        The title is zero in length.
        The title is null.
        */