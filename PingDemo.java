import java.net.InetAddress;

public class PingDemo {

    public static void main(String[] args) throws Exception {

        InetAddress address = InetAddress.getByName("www.chatgpt.com");

        if(address.isReachable(5000))
        {
            System.out.println("Host is reachable (Ping successful)");
        }
        else
        {
            System.out.println("Host is NOT reachable");
        }
    }
}