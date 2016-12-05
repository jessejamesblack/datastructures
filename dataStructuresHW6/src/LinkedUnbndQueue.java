import java.util.ArrayList;

/**
 * Created by jesse on 3/30/2016.
 */

public class LinkedUnbndQueue implements QueueInterface {
    protected LLObjectNode front;   // reference to the front of this queue
    protected LLObjectNode rear;    // reference to the rear of this queue
    protected int count;    //instance variable.

    public LinkedUnbndQueue() {
        front = null;
        rear = null;

        //rear = front;
        count = 0;
    }

    public void enqueue(Object element) {
        LLObjectNode newNode = new LLObjectNode(element);
        if (rear == null)
            front = newNode;
        else
            rear.setLink(newNode);
        count++;
        rear = newNode;
    }

    public Object dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Dequeue attempted on empty queue.");
        } else {
            Object element;
            element = front.getInfo();
            front = front.getLink();
            if (front == null)
                rear = null;
            count--;
            return element;
        }

    }

    public boolean isEmpty() {
        if (front == null)
            return true;
        else
            return false;
    }

    public ArrayList toList() {
        ArrayList<Object> list = new ArrayList<Object>();
        LLObjectNode tempFront = front;
        //iterate through each node in list.
        while (tempFront != null) {
            list.add(tempFront.getInfo());
            tempFront = tempFront.getLink();
        }
        return list;
    }

    /*public int howMany() {
        int count = 0;
        LLObjectNode tempFront = front;
        //iterate through each node in list.
        while (tempFront != null) {
            count++;
            list.add(tempFront.getInfo());
            tempFront = tempFront.getLink();
        }
        return count;
    }*/
    public int howMany() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder logString = new StringBuilder("Log: " + front + "\n\n");
        LLObjectNode tempFront = front;

        while (tempFront != null) {
            logString.append(". " + tempFront.getInfo() + "\n");
            tempFront = tempFront.getLink();
        }
        return logString.toString();
    }
}
