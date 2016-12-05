/**
 * Created by jesse on 3/30/2016.
 */

public class UseQueue {
    public static void main(String args[]) throws QueueUnderflowException {
        LinkedUnbndQueue queue = new LinkedUnbndQueue();

        String first = "first", second = "second", third = "third", last = "last";

        queue.enqueue(first);
        queue.enqueue(second);
        queue.enqueue(third);

        java.util.ArrayList list = queue.toList();
        for (java.util.Iterator it = list.iterator(); it.hasNext(); ) {
            Object o = it.next();
            System.out.println(o);
        }
        System.out.println(queue.howMany());
        System.out.println(queue.toString());

        //Set secondElement to the second element in the queue, leaving the queue without its original front two elements.
        LinkedUnbndQueue myQ = new LinkedUnbndQueue();
        Object secEle;
        //add a bunch of stuff
        try {
            Book b1 = new Book(40, BookTypes.HARDBACK, "Lord of the Flies", 8.99);
            Book b2 = new Book(60, BookTypes.SOFTBACK, "The Mist", 18.99);
            Book b3 = new Book(50, BookTypes.ELECTRONIC, "The Martian", 48.99);
            Book b4 = new Book(50, BookTypes.ELECTRONIC, "The Martian", 48.99);
            //add dequeue's for first second and third ones you figure it out
            queue.enqueue(b1);
            queue.enqueue(b2);
            queue.enqueue(b3);
            queue.enqueue(b4);
        } catch (BookException e) {
            System.out.println("Something went wrong");
        }
        secEle = myQ.dequeue();
        secEle = myQ.dequeue();


        //Set last equal to the rear element in the queue, leaving the queue unchanged.
        Object rear;
        while(!queue.isEmpty())
            rear = myQ.dequeue();

        try {
            Book b1 = new Book(40, BookTypes.HARDBACK, "Lord of the Flies", 8.99);
            Book b2 = new Book(60, BookTypes.SOFTBACK, "The Mist", 18.99);
            Book b3 = new Book(50, BookTypes.ELECTRONIC, "The Martian", 48.99);
            Book b4 = new Book(50, BookTypes.ELECTRONIC, "The Martian", 48.99);
            //add dequeue's for first second and third ones you figure it out
            queue.enqueue(b1);
            queue.enqueue(b2);
            queue.enqueue(b3);
            queue.enqueue(b4);
        } catch (BookException e) {
            System.out.println("Something went wrong");
        }

        list = queue.toList();
        for (java.util.Iterator it = list.iterator(); it.hasNext(); ) {
            Object o = it.next();
            System.out.println(o);
        }
        System.out.println("howMany(): " + queue.howMany());
        System.out.println("toString(): " + queue.toString());
    }
}
/* Output
    third
    secondElement
    2
    Log: LLObjectNode@74a14482

    . third
    . secondElement

    third
    secondElement
    Book{numberOfPages=40, type=HARDBACK, title='Lord of the Flies', price=8.99}
    Book{numberOfPages=60, type=SOFTBACK, title='The Mist', price=18.99}
    Book{numberOfPages=50, type=ELECTRONIC, title='The Martian', price=48.99}
    Book{numberOfPages=50, type=ELECTRONIC, title='The Martian', price=48.99}
    howMany(): 6
    toString(): Log: LLObjectNode@74a14482

    . third
    . secondElement
    . Book{numberOfPages=40, type=HARDBACK, title='Lord of the Flies', price=8.99}
    . Book{numberOfPages=60, type=SOFTBACK, title='The Mist', price=18.99}
    . Book{numberOfPages=50, type=ELECTRONIC, title='The Martian', price=48.99}
    . Book{numberOfPages=50, type=ELECTRONIC, title='The Martian', price=48.99}

*/