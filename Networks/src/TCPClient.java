import java.io.*;
import java.net.*;

/**
 * Client on 4446 port of then local host that sends a string to the server and gets info back
 * Author Emmitt Frankenberry
 *
 */
class TCPClient {
    public static void main(String argv[]) throws Exception {
        //Holds our strings
        //String tenLetters;
        String tenLetters[] = new String[10];
        tenLetters[0]="HelloWorld";
        tenLetters[1]="ItsABadMan";
        tenLetters[2]="sWorldItsA";
        tenLetters[3]="BadMansWor";
        tenLetters[4]="ldItsABadM";
        tenLetters[5]="ansWorldOk";
        tenLetters[6]="IGotBoredO";
        tenLetters[7]="fThatFastB";
        tenLetters[8]="utINeedMor";
        tenLetters[9]="eWordsBore";
        String reversedLetters;

        // Gathers user input
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        // Connects to socket 4446 on the used machine
        Socket clientSocket = new Socket("localhost", 4446);

        // Used to gather and receive info for the server
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Gathers user input
        for(int i=0; i<10; i++){
        //tenLetters = inFromUser.readLine();
        // Sends String to the server for it to change
        outToServer.writeBytes(tenLetters[i] + '\n');
        // Gets what the server spits back
        reversedLetters = inFromServer.readLine();
        // Prints out what the server told us
        System.out.println("Returned: " + reversedLetters);
        }
        // closes our connection to the socket
        clientSocket.close();
    }
}
