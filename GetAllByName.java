
import java.net.InetAddress;

public class GetAllByName {

    public static void main(String[] args) throws Exception {

        InetAddress[] addresses = InetAddress.getAllByName("www.google.com");

        for(InetAddress addr : addresses)
        {
            System.out.println("IP Address: " + addr.getHostAddress());
        }
    }
}