import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {

    public static void main(String[] args) {

        int port = 1234;   // You can change the port number
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket connection = null;

                try {
                    connection = server.accept();   // Accept client connection
                    System.out.println("Client connected: " + connection.getInetAddress());

                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    Date now = new Date();

                    out.write(now.toString() + "\r\n");
                    out.flush();

                } catch (IOException ex) {
                    // Handle request error
                    System.out.println("Error handling client request: " + ex.getMessage());
                } finally {
                    try {
                        if (connection != null) connection.close();
                    } catch (IOException ex) {
                        System.out.println("Error closing connection: " + ex.getMessage());
                    }
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
            } catch (IOException ex) {
                System.out.println("Error closing server: " + ex.getMessage());
            }
        }
    }
}
