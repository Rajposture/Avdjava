import java.net.URL;

public class URLDemo {

    public static void main(String[] args) throws Exception {

        URL url = new URL("https://classmark.online/");

        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Host: " + url.getHost());
        System.out.println("Port: " + url.getPort());
        System.out.println("File: " + url.getFile());
        System.out.println("External Form: " + url.toExternalForm());
    }
}