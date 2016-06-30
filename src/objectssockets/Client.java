package objectssockets;

import Main.Controller;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    private ObjectOutputStream output; // output stream to client
    private ObjectInputStream input; // input stream from client
    private Socket client; // connection to client
    private String HOST = "localhost";
    private int PORT = 12345;
    private boolean disconnect = false;
    private Controller controller;
    private ReceiveMessageThread thread;

    public Client(String host, Controller controller) {
        this.controller = controller;
        this.HOST = host;
    }

    // connect to server and process messages from server
    public void runClient() {
        try { // connect to server, get streams, process connection
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            thread = new ReceiveMessageThread(client, output, input, HOST, controller);
            thread.start();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // connect to server
    private void connectToServer() throws IOException {
        System.out.println("Attempting connection\n");
        // create Socket to make connection to server
        client = new Socket(HOST, PORT); //Or new Socket(InetAddress.getByName(HOST), PORT);
        // display connection information
        System.out.println("Connected to: " + client.getInetAddress().getHostName());
    }

    // get streams to send and receive objects
    private void getStreams() throws IOException {
        // set up output stream for object
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush(); // flush output buffer to send header information   
        // set up input stream for object
        input = new ObjectInputStream(client.getInputStream());
    }

    // process connection with server
    public void sendMessage(String message) throws IOException, ClassNotFoundException {
        output.writeObject(message);
    }

    public void closeConnection() {
        System.out.println("\nClosing connection");
        try {
            thread.closeConnection();
            output.close(); // close output stream
            input.close(); // close input stream
            client.close(); // close socket
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
