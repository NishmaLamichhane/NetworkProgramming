//Client Side Socket Channel Example
import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.util.*;

public class SocketChannelClient {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket=null;
        SocketChannel Client=null;
        serverSocket=ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress(9000));
        Client=serverSocket.accept();
        System.out.println("Client Connected: "+Client.getRemoteAddress()); 
        Path path=Paths.get("C:/Test/temp1.txt");
        FileChannel fileChannel=FileChannel.open(path,EnumSet.of(StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING,StandardOpenOption.WRITE));
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while (Client.read(buffer)>0) {
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }
        fileChannel.close();
        System.out.println("File received successfully.");
        Client.close();
    }
}
