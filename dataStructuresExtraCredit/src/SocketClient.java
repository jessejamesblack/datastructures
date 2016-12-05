/**
 * Created by jesse on 3/30/2016.
 */

//then run this one

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;


public class SocketClient {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Socket socket = null;
        List<Book> list = new LinkedList<Book>();

        try {
            // open a socket connection
            socket = new Socket("127.0.0.1", 5024);
            // open I/O streams for objects
            ois = new ObjectInputStream(socket.getInputStream());
            // read an object from the server
            list = (LinkedList) ois.readObject();
            //print it
            System.out.println(list);
            //close
            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}