import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Server <port>");
            return;
        }
        int port = Integer.parseInt(args[0]);
        try {
            ServerSocket serverSocket = new ServerSocket(port); // create a new ServerSocket listening on the specified
                                                                // port
            System.out.println("Server started. Listening on port " + port + "...");
            while (true) {
                Socket clientSocket = serverSocket.accept(); // wait for a client to connect
                System.out.println("Client connected from " + clientSocket.getInetAddress().getHostAddress() + ":"
                        + clientSocket.getPort());
                // start a new thread to handle the client connection
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Failed to start server: " + e.getMessage());
            return;
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Received from client: " + line);
                writer.println(line); // echo the input back to the client
            }
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error handling client connection: " + e.getMessage());
        }
    }
}