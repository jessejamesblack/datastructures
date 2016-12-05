/**
 * Created by jesse on 3/30/2016.
 */


public class QueueUnderflowException extends Exception {
    public QueueUnderflowException() {
        super();
    }

    public QueueUnderflowException(String message) {
        super(message);
    }
}