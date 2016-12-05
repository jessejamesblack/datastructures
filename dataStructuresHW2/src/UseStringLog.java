//----------------------------------------------------------------------------
// UseStringLog.java           by Dale/Joyce/Weems/Jesse             Chapter 2
//
// Simple example of the use of a StringLog.
//----------------------------------------------------------------------------

public class UseStringLog {
    public static void main(String[] args) {
        LinkedStringLog log;
        log = new LinkedStringLog("Example Use");
        log.insert("Elvis");
        log.insert("Captain Kirk");
        log.insert("Shaun");
        log.insert("Elvis");
        log.insert("Dennis");
        System.out.println(log.uniqInsert("Dennis"));
        System.out.println(log.uniqInsert("Albert"));
        //System.out.println(log + "\n");
        System.out.println(log.isEmpty() + "\n");
        System.out.println("The size of the log is " + log.size() + "\n");
        System.out.println("Elvis is in the log: " + log.contains("Elvis") + "\n");
        System.out.println("Santa is in the log: " + log.contains("Santa") + "\n");
        System.out.println("How many times does Iron Man occur in LL? " + log.howMany("Iron Man") + "\n");
        System.out.println("How many times does Elvis occur in LL? " + log.howMany("Elvis") + "\n");
        System.out.println("Iron Man is in the log: " + log.contains("Iron Man") + "\n");
        System.out.println(log.logAsArray() + "\n");
        System.out.println(log.toString() + "\n");
        System.out.println(log.smallest() + "\n");
    }
}
/*
    Attempting insert; True if already in node, false if not. If false will insert:
    true
    Attempting insert; True if already in node, false if not. If false will insert:
    false
    Is the log empty?
    false

    The size of the log is 6

    Elvis is in the log: true

    Santa is in the log: false

    howMany.
    How many times does Iron Man occur in LL? 0

    howMany.
    How many times does Elvis occur in LL? 2

    Iron Man is in the log: false

    Linked list as Array:
    Albert
    Dennis
    Elvis
    Shaun
    Captain Kirk
    Reached last node, aborting

    [Ljava.lang.String;@74a14482

    StringBuilder toString.
    Log: Example Use

    . Albert
    . Dennis
    . Elvis
    . Shaun
    . Captain Kirk
    . Elvis


    Smallest String is:
    Albert
*/