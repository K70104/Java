package file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo10 {
    public static void main(String[] args) {
        try (Writer write = new FileWriter("e:/test.txt")) {
            write.write("xyz");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
