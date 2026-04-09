import java.net.InetAddress;

public class GetLocalHost {
    public static void main(String[] args) throws Exception {
        InetAddress local = InetAddress.getLocalHost();

        System.out.println("Host Name: " + local.getHostName());
        System.out.println("IP Address: " + local.getHostAddress());
    }
}