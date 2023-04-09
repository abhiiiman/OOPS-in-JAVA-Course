import java.io.*;
import java.net.*;
 
public class ChatClient {
    // String name;
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java ChatClient <host name> <port number>");
            System.exit(1);
        }
 
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
 
        Socket socket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
        // Read the welcome message from the server
        String serverMessage = in.readLine();
        System.out.println(serverMessage.toUpperCase());
 
        // Start a thread to handle incoming messages from the server
        new ServerThread(in).start();
 
        // Read messages from the console and send them to the server
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        while ((userInput = console.readLine()) != null) {
            out.println(userInput);
        }
 
        out.close();
        in.close();
        socket.close();
    }
 
    private static class ServerThread extends Thread {
        private BufferedReader in;
 
        public ServerThread(BufferedReader in) {
            this.in = in;
        }
 
        public void run() {
            String serverMessage;
            try {
                while ((serverMessage = in.readLine()) != null) {
 
                    System.out.println(serverMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}