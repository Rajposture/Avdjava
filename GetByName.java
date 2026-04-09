
import java.net.InetAddress;

public class GetByName {
    public static void main(String[] args) throws Exception {

        InetAddress address = InetAddress.getByName("www.whatsapp.com");

        System.out.println("Host Name: " + address.getHostName());
        System.out.println("IP Address: " + address.getHostAddress());
    }
}