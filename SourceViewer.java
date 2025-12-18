import java.io.*;
import java.net.*;

public class SourceViewer {

    public static void main(String[] args) {

        String urlInput = "https://www.google.com";

        try {
            URL url = new URL(urlInput);
            URLConnection connection = url.openConnection();

            try (InputStream raw = connection.getInputStream()) {
                InputStream buffer = new BufferedInputStream(raw);
                Reader reader = new InputStreamReader(buffer);

                int c;
                while ((c = reader.read()) != -1) {
                    System.out.print((char) c);
                }
            }

        } catch (MalformedURLException ex) {
            System.err.println(urlInput + " is not a valid URL");
        } catch (IOException ex) {
            System.err.println("IO Error: " + ex.getMessage());
        }
    }
}
