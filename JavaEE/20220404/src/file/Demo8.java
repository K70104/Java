package file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo8 {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("e:/test.txt", true)) {
            /*outputStream.write(97);
            outputStream.write(98);
            outputStream.write(99);*/
            byte[] buffer = new byte[] {97, 98, 99};
            outputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
