/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectssockets;

import Main.Controller;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alelizmu
 */
public class ReceiveMessageThread extends Thread {

    private final ObjectOutputStream output;
    private final ObjectInputStream input;
//    private ServerSocket server; // server socket
    private final Socket connection; // connection to client
    private boolean disconnect = false;
    private final String PORT;
    private Controller controller;

    public ReceiveMessageThread(Socket connection, ObjectOutputStream output, ObjectInputStream input, String PORT, Controller controller) {
        this.connection = connection;
        this.controller = controller;
        this.PORT = PORT;
        this.input = input;
        this.output = output;
    }

//    // get streams to send and receive data
//    private void getStreams() throws IOException {
//        output = new ObjectOutputStream(connection.getOutputStream());
//        output.flush(); 
//        input = new ObjectInputStream(connection.getInputStream());
//    }
    // process connection with client
    private void processConnection() throws IOException, InterruptedException, ClassNotFoundException {
        while (!disconnect) {
            String text = (String) input.readObject();
            receiveMessage(text);
        }
    }

    // close streams and socket
    public void closeConnection() {
        System.out.println("\nTerminating connection");
        try {
            disconnect = true;
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket  
//            server.close(); // clse server socket
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
//            getStreams();
            processConnection();
        } catch (IOException | InterruptedException | ClassNotFoundException ex) {
            Logger.getLogger(ReceiveMessageThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(); // close connection
        }
    }
    
    private void receiveMessage(String text) {
        controller.writeInTextField(text);
    }
}