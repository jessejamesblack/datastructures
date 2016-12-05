public class LinkedStack implements StackInterface {
    protected LLObjectNode top;   // reference to the top of this stack

    public LinkedStack() {
        top = null;
    }

    public void push(Object element) {
        // Places element at the top of this stack.
        LLObjectNode newNode = new LLObjectNode(element);
        newNode.setLink(top);
        top = newNode;
    }

    public void pop() {
        // Throws StackUnderflowException if this stack is empty,
        // otherwise removes top element from this stack.
        if (!isEmpty()) {
            top = top.getLink();
        } else {
            throw new StackUnderflowException("Pop attempted on an empty stack.");
        }
    }

    public Object top() {
        // Throws StackUnderflowException if this stack is empty,
        // otherwise returns top element from this stack.
        if (!isEmpty())
            return top.getInfo();
        else
            throw new StackUnderflowException("Top attempted on an empty stack.");
    }

    public boolean isEmpty() {
        // Returns true if this stack is empty, otherwise returns false.
        if (top == null)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        if (top == null) {
            String emptyStack = "Empty Stack";
            return emptyStack;
        } else {
            StringBuilder logString = new StringBuilder("Log: " + top + "\n\n");
            LLObjectNode node = top;

            while (node != null) {
                logString.append(". " + node.getInfo() + "\n");
                node = node.getLink();
            }
            return logString.toString();
        }
    }

    //correct?! Correct!
    public Object popTop() throws StackUnderflowException {
        //remove and return the top element of the stack
        Object temp = top.getInfo();
        if (!isEmpty()) {
            top = top.getLink();
        } else {
            throw new StackUnderflowException("Pop attempted on an empty stack.");
        }
        return temp;
    }

    public int size() {
        //returns the size of the stack
        int size = 0;
        while (top != null) {
            size++;
            top = top.getLink();
            //System.out.println(size);
            if (top == null)
                return size;
        }
        return size;
    }

}