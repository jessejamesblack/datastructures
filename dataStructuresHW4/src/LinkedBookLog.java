public class LinkedBookLog implements BookLogInterface {
    protected LLBookNode log; // reference to first node of linked
    // list that holds the StringLog strings
    protected String name;      // name of this StringLog

    public LinkedBookLog()
    // Instantiates and returns a reference to an empty StringLog object
    // with name "name".
    {
        log = null;
        this.name = name;
    }

    public void insert(Object element)
    // Precondition:   This StringLog is not full.
    //
    // Places element into this StringLog.
    {
        LLBookNode newNode = new LLBookNode(element);
        newNode.setLink(log);
        log = newNode;
    }

    public boolean isFull()
    // Returns true if this StringLog is full, false otherwise.
    {
        return false;
    }

    public int size()
    // Returns the number of Strings in this StringLog.
    {
        int count = 0;
        LLBookNode node;
        node = log;
        while (node != null) {
            count++;
            node = node.getLink();
        }
        return count;
        //O(N)
    }

    @Override
    public boolean contains(Object element) {
        return false;
    }

    public boolean contains(String element)
    // Returns true if element is in this StringLog,
    // otherwise returns false.
    // Ignores case difference when doing string comparison.
    {
        //int count = 0;
        LLBookNode node;
        node = log;
        boolean found = false;
        boolean moreToSearch;
        moreToSearch = (node != null);

        while (moreToSearch && !found) {
            if (element.toString() == node.getInfo())  // if they match
            {
                found = true;
                //count++;
                //System.out.println(count);
            } else {
                node = node.getLink();
                moreToSearch = (node != null);
            }
        }

        return found;
    }

    public void clear()
    // Makes this StringLog empty.
    {
        log = null;
    }

    public String getName()
    // Returns the name of this StringLog.
    {
        //O(1)
        return name.toString();
    }

    @Override
    public String toString() {
        System.out.println("StringBuilder toString. ");
        StringBuilder logString = new StringBuilder("Log: " + name + "\n\n");
        LLBookNode node = log;

        while (node != null) {
            logString.append(". " + node.getInfo() + "\n");
            node = node.getLink();
        }
        return logString.toString();
    }

   /* public String[] logAsArray() {
        System.out.println("Linked list as Array: ");
        int count = 0;
        LLBookNode node = log;
        String retArray[] = new String[size()];

        //iterate through each node in list.
        while (node != null) {
            retArray[count] = node.getInfo();
            node = node.getLink();
            if (node == null)
                retArray[count] = "Reached last node, aborting " + "\n";
            count++;
        }
        for (int x = 0; x < retArray.length; x++) {
            System.out.println(retArray[x]);
        }
        return retArray;
    }*/

    public boolean isEmpty() {
        System.out.println("Is the log empty?");
        return (log == null);
    }

    public int howMany(Object element) {
        System.out.println("howMany.");
        int count = 0;
        LLBookNode node = log;

        while (node != null) {
            if (element.toString() == node.getInfo()) {
                count++;
                node = node.getLink();
            } else
                node = node.getLink();
        }
        return count;
    }

    public boolean uniqInsert(String element) {
        System.out.println("Attempting insert; True if already in node, false if not. If false will insert: ");
        LLBookNode node = log;
        boolean result = false;
        while (node != null) {
            if (element.toString() == node.getInfo()) {
                result = true;
                return result;
            } else {
                node = node.getLink();
                if (node == null) {
                    LLBookNode newNode = new LLBookNode(element);
                    newNode.setLink(log);
                    log = newNode;
                    result = false;
                    return result;
                }
            }
        }
        return result;
    }

   /* public String smallest() {
        System.out.println("Smallest String is: ");
        LLBookNode node;
        LLBookNode node2;
        LLBookNode node3 = log;
        node = log;
        node2 = log;
        String name = "";

        while (node != null && node2 != null) {
            if ((node.getInfo().compareTo(node2.getInfo())) < 0) {
                node3 = node;
                node2 = node2.getLink();
                name = node3.getInfo();
            } else if (node != null && node2 != null) {
                node3 = node2;
                node = node.getLink();
                name = node3.getInfo();
            }
        }
        return name;
    }*/
}