import java.io.*;
import java.net.*;

/**
 * Server on the 4446 port to reverse a string sent by a client
 * Author: Emmitt Frankenberry
 */
class TCPServer {
    public static void main(String argv[]) throws Exception {
        /*String clientLetters;
        String reversedLetters;*/

        //Sets up the socket to 4446 for the server
        ServerSocket welcomeSocket = new ServerSocket(4446);

        while (true) {
            //Accepts a client
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("Connected");
            //starts a thread for each client
            ServerThread st = new ServerThread(connectionSocket);
            // runs the thread
            st.start();
        }
    }
}
