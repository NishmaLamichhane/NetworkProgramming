import java.net.URLDecoder;

public class DecoderTest {
    public static void main(String[] args) {
        try {
            String encoded = "This%2Bstring%2Fhas%3Dencoded%26characters";
            String decoded = URLDecoder.decode(encoded, "UTF-8");

            System.out.println("Encoded: " + encoded);
            System.out.println("Decoded: " + decoded);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
