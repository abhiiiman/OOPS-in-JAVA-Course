import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Client <host> <port>");
            return;
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        try {
            Socket socket = new Socket(host, port); // create a new socket to connect to the server
            System.out.println("Connected to server at " + host + ":" + port);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                out.println(line); // send the user's input to the server
                String response = reader.readLine(); // receive the server's response
                System.out.println("Server says: " + response);
            }
            socket.close();
        } catch (IOException e) {
            System.out.println("Failed to connect to server: " + e.getMessage());
            return;
        }
    }
}