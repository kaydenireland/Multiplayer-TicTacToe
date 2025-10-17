package network;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Server {

    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private DataInputStream input = null;

    public Server(int port) {

        // Start Server and Wait for Connection
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started. Waiting for a client ...");
            socket = serverSocket.accept();
            System.out.println("Client accepted.");

            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String msg = "";

            // Keep Reading Until Message is "exit"
            while (!msg.equals("exit")) {
                try {
                    msg = input.readUTF();
                    System.out.println("Client says: " + msg);
                } catch (IOException e) {
                    System.out.println("Error Reading Message from Client: " + e.getMessage());
                }
            }

            // Close the Connection
            System.out.println("Closing connection...");

            socket.close();
            input.close();

        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        Server server = new Server(5000);
    }

}