public class Book {
    //private attributes
    private int numberOfPages;
    private BookTypes type;
    private String title;
    private double price;

    //non default constructor
    public Book(int numberOfPages, BookTypes type, String title, double price) throws BookException {
        setType(type);
        setNumberOfPages(numberOfPages);
        setPrice(price);
        setTitle(title);
    }

    //getters
    public int getNumberOfPages() {
        return numberOfPages;
    }

    public BookTypes getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() throws BookException {
        return price;
    }

    //setters
    public void setNumberOfPages(int numberOfPages) throws BookException {
        //dont let pages be less than 1
        if (numberOfPages <= 1)
            throw new BookException("Number of pages cannot be less than one. ");
        this.numberOfPages = numberOfPages;
    }

    //settype is handled by booktypes enum
    public void setType(BookTypes type) {
        this.type = type;
    }

    //dont let title be null or <= 0 with custom messages for both
    public void setTitle(String title) throws BookException {
        if (title == null || title.length() <= 0) {
            if (title == null)
                throw new BookException("The title is null. ");
            if (title.length() <= 0)
                throw new BookException("The title is zero in length. ");
        }
        this.title = title;
    }

    // dont let price be less than 0
    public void setPrice(double price) throws BookException {
        if (price < 0)
            throw new BookException("Price is negative. ");
        this.price = price;
    }

    @Override
    public boolean equals(Object Book) {
        if (Book == null)
            return false;
        if (!(Book instanceof Book))
            return false;
        Book book = (Book) Book;

        return this.type.equals(book.type) && this.numberOfPages == book.numberOfPages
                && this.title.equals(book.title) && this.price == book.price;
    }

    @Override
    public int hashCode() {
        int value;
        value = numberOfPages + (int) price + title.hashCode();
        int valueType = 0;
        switch(type) {
            case HARDBACK:
                valueType = 1;
                break;
            case SOFTBACK:
                valueType = 2;
                break;
            case ELECTRONIC:
                valueType = 3;
        }
        value = value + valueType;
        return value;
    }

    //toString
    @Override
    public String toString() {
        return "Book{" +
                "numberOfPages=" + numberOfPages +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

}
