import java.nio.ByteBuffer;

public class BufferFillingandDraining {
    public static void main(String[] args) {

        // 1. Create and allocate buffer
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println("Capacity: " + buffer.capacity());

        // 2. Fill buffer (write mode)
        buffer.put((byte) 10);
        buffer.put((byte) 20);
        buffer.put((byte) 30);
        System.out.println("Position after put: " + buffer.position());

        // 3. flip(): switch from write mode to read mode
        buffer.flip();
        System.out.println("Limit after flip: " + buffer.limit());

        // 4. Drain buffer (read mode)
        while (buffer.hasRemaining()) {
            System.out.println("Read: " + buffer.get());
        }

        // 5. rewind(): re-read same data
        buffer.rewind();
        System.out.println("Position after rewind: " + buffer.position());

        // 6. mark() and reset()
        buffer.get();      // read first byte
        buffer.mark();     // mark position
        buffer.get();      // read second byte
        buffer.reset();    // go back to marked position
        System.out.println("After reset: " + buffer.get());

        // 7. remaining()
        System.out.println("Remaining bytes: " + buffer.remaining());

        // 8. clear(): prepare buffer for new data
        buffer.clear();
        System.out.println("Position after clear: " + buffer.position());
        System.out.println("Limit after clear: " + buffer.limit());

        // 9. Direct buffer (used in high-speed I/O)
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(10);

        // 10. Wrap array into buffer
        byte[] data = {1, 2, 3, 4};
        ByteBuffer wrappedBuffer = ByteBuffer.wrap(data);
    }
}
