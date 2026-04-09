import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class TCPServer22 {

    private static final int PORT = 6000;
    private static Set<ClientHandler> clients = ConcurrentHashMap.newKeySet();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server Started on Port 6000...");

            ExecutorService pool = Executors.newCachedThreadPool();

            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket);
                clients.add(handler);
                pool.execute(handler);
                broadcastClientList();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void broadcastClientList() {
        StringBuilder sb = new StringBuilder("Connected Clients: ");
        for (ClientHandler c : clients) {
            sb.append(c.getClientName()).append(" ");
        }
        for (ClientHandler c : clients) {
            c.sendMessage(sb.toString());
        }
    }

    static class ClientHandler implements Runnable {

        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private String clientName;

        ClientHandler(Socket socket) throws Exception {
            this.socket = socket;
            this.clientName = "Client-" + socket.getPort();
            this.in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(
                    socket.getOutputStream(), true);

            System.out.println(clientName + " Connected");
        }

        String getClientName() {
            return clientName;
        }

        void sendMessage(String msg) {
            out.println(msg);
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(clientName + ": " + message);
                    out.println("Server Reply: " + message);
                }
            } catch (Exception e) {
                System.out.println(clientName + " Disconnected");
            } finally {
                try {
                    socket.close();
                } catch (Exception ignored) {}
                clients.remove(this);
                broadcastClientList();
            }
        }
    }
}

