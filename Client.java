import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        // Sunucuya bağlanmak için kullanılan port ve IP adresi
        String serverAddress = "localhost";  // veya sunucunun IP adresi
        int port = 8080;

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to server");

            // Sunucuya mesaj göndermek için yazıcı ve yanıt almak için okuma akışları oluşturuyoruz
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Sunucuya mesaj gönderiyoruz
            out.println("Hello from client!");
                                                                    //fork ve pull request denemesi
            // Sunucudan gelen yanıtı okuyoruz      
            String response = in.readLine();
            System.out.println("Server says: " + response);

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
