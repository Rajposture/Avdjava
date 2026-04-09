import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);

        System.out.println("Server is waiting for client...");

        Socket socket = server.accept();

        System.out.println("Client Connected!");

        System.out.println("Client IP Address: " + socket.getInetAddress());
        System.out.println("Client Port: " + socket.getPort());
        System.out.println("Server Port: " + socket.getLocalPort());

        socket.close();
        server.close();
    }
}