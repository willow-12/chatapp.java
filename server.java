import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println("Client: " + msg);
                out.println(console.readLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
