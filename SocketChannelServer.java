//Server Side Socket Channel Example
import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class SocketChannelServer {
   public static void main(String[] args)throws IOException {
    SocketChannel Server=SocketChannel.open();
    SocketAddress address=new InetSocketAddress("localhost",9000);
    Server.connect(address);
    Path path=Paths.get("C:/Test/temp.txt");
    FileChannel fileChannel=FileChannel.open(path);
    ByteBuffer buffer=ByteBuffer.allocate(1024);
    while (fileChannel.read(buffer)>0) {
        buffer.flip();
        Server.write(buffer);
        buffer.clear();
    }
    fileChannel.close();
    System.out.println("File sent successfully.");
    Server.close();
}
}
