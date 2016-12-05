/**
 * Created by jesse on 3/30/2016.
 */

public interface QueueInterface {

    Object dequeue() throws QueueUnderflowException;

    void enqueue(Object element);

    boolean isEmpty();
}



