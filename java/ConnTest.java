import java.io.IOException;
import java.net.Socket;

public class ConnTest {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            System.out.println("Connection successful!");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}