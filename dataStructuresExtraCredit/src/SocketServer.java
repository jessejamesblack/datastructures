/**
 * Created by jesse on 3/30/2016.
 */

//run this one first

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


public class SocketServer {
    public static void main(String[] args) {
        final int ARGS_ERROR = -9;
        final int PROPERTIES_FILE_ERROR = -11;
        final int BAD_DATA_FILE = -11;

        ServerSocket server;
        Socket client = null;
        ObjectOutputStream oos = null;

        try {
            server = new ServerSocket(5024);
            System.out.println("Waiting for connections.");
            client = server.accept();
            System.err.println("Accepted a connection from: " + client.getInetAddress());

            oos = new ObjectOutputStream(client.getOutputStream());

            List<Book> list = new LinkedList<Book>();
            //open read book.txt
            if (args.length != 1) {
                System.err.println("Supply name of properties file");
                System.exit(ARGS_ERROR);
            }
            final String PROPERTIES_FILE_NAME = args[0];

            Properties properties = new Properties();
            String fileName = null;
            try {
                properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
                fileName = properties.getProperty("file_name");
            } catch (IOException e) {
                System.err.println("Exception Occurred" + e.getMessage());
                //System.exit(PROPERTIES_FILE_ERROR);
            }
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String text;
            while ((text = reader.readLine()) != null) {
                String parts[] = text.split(","); // separator is ,
                try {
                    Book b = new Book(Integer.parseInt(parts[2]), BookTypes.valueOf(parts[1]),
                            parts[0], Double.parseDouble(parts[3]));
                    list.add(b);
                    //System.out.println(b);
                } catch (BookException e) {
                    System.err.println("Cannot open data file " + fileName + e.getMessage());
                    //System.exit(BAD_DATA_FILE);
                }
            }
            oos.writeObject(list);
            oos.close();
            client.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

    }
}
