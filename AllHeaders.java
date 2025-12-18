//Print all the headers from a HTTP request...  Do this in practicle file
import java.io.*;
import java.net.*;
import java.util.*;
public class AllHeaders {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter URLs separated by space:");
    String input = scanner.nextLine();
    scanner.close();
 // Split input into individual URLs
        String[] urls = input.trim().split("\\s+");

        for (String urlString : urls) {
            try {
URL u = new URL(urlString);
URLConnection uc = u.openConnection();
for (int j = 1; ; j++) {
String header = uc.getHeaderField(j);
if (header == null) break;
System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
}
} catch (MalformedURLException ex) {
System.err.println(urlString + " is not a URL I understand.");
} catch (IOException ex) {
System.err.println(ex);
}
System.out.println();
}
}
}