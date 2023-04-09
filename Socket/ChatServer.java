import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
 
public class ChatServer {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java ChatServer <port number>");
            System.exit(1);
        }
 
        int portNumber = Integer.parseInt(args[0]); //9090
        ServerSocket serverSocket = new ServerSocket(portNumber);
 
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new ClientThread(clientSocket).start();
        }
    }
 
    private static class ClientThread extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
 
        public ClientThread(Socket socket) {
            this.clientSocket = socket;
        }
 
        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
 
                out.println("Welcome to the chat room!");
 
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    // if(inputLine.charAt(0) >= '0' && inputLine.charAt(0) <= '9' ){
                    //     System.out.println("expression");
 
                    // }
 
                    System.out.println("Received message: " + inputLine.toUpperCase());
 
                    // Broadcast the message to all clients
                    for (ClientThread client : ChatServer.clients) {
                        client.out.println(inputLine);
                    }
                }
 
                out.close();
                in.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    private static List<ClientThread> clients = new ArrayList<>();
}