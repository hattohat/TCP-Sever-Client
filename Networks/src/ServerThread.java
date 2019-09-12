import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Thread for the server to run multiple reversing of the strings at once
 * Author: Emmitt Frankenberry
 *
 */
public class ServerThread extends Thread{

    // Sets up holders for socket information
    Socket serverSocket;
    Socket connectionSocket;
    // Saves our strings
    String clientLetters;
    String reversedLetters;

    /**
     * Stores the socket of connection
     * @param s
     */
    public ServerThread(Socket s){
        connectionSocket=s;
    }

    /**
     * Runs the thread, receives the info from the client, reverses the string, and sends a message
     * back to the client containing the reversed string
     */
    public void run(){

        // Prepares to get the string from the client
        for(int i=0;i<10;i++){
        BufferedReader inFromClient = null;
        try {
            inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Prepares to send information to the client
        DataOutputStream outToClient = null;
        try {
            outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Actually receives the information from the client
        try {
            clientLetters = inFromClient.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Shows what was received from the client
        System.out.println("Received: " + clientLetters);
        // Reverses the string received
        reversedLetters = new StringBuilder(clientLetters).reverse().toString()+'\n';

        // Sends the reversed string back to the client
        try {
            outToClient.writeBytes(reversedLetters);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
}
