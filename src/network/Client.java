package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;

public class Client {

    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    public Client(String ip, int port) {
        System.out.println("Looking for server...");
        try {
            this.socket = new Socket(ip, port);
            this.input = new DataInputStream(System.in);
            this.output = new DataOutputStream(this.socket.getOutputStream());
        } catch (Exception e) {
            System.out.println("Error Connecting to Server: " + e.getMessage());
            return;
        }

        String msg = "";

        // Keep Reading Until Message is "exit"
        while (!msg.equals("exit")) {
            try {
                msg = this.input.readLine();
                this.output.writeUTF(msg);
            } catch (IOException e) {
                System.out.println("Error Sending Message to Server: " + e.getMessage());
            }
        }

        // Close the Connection
        try {
            this.input.close();
            this.output.close();
            this.socket.close();
        } catch (IOException e) {
            System.out.println("Error Closing Connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Client("127.0.0.1", 5000);
    }
}
