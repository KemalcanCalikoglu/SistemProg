import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        // Sunucuyu belirtilen port üzerinden başlatıyoruz
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");

            while (true) {
                // Yeni istemci bağlantısını bekliyoruz
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    // İstemciye yazıcı ve okuma akışları oluşturuyoruz
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    // İstemciden gelen mesajı okuyoruz
                    String message = in.readLine();
                    System.out.println("Received from client: " + message);

                    // İstemciye yanıt gönderiyoruz
                    out.println("Hello from server!");

                } catch (IOException ex) {
                    System.out.println("Error handling client: " + ex.getMessage());
                }
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
        }
    }
}
