package file;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// 按照字符来读写
public class Demo9 {
    public static void main(String[] args) {
        try (Reader reader = new FileReader("e:/test.txt")) {
            while (true) {
                char[] buffer = new char[1024];
                int len = reader.read(buffer);
                if (len == -1) {
                    break;
                }
                /*for (int i = 0; i < len; i++) {
                    System.out.println(buffer[i]);
                }*/
                // 如果这里传入的数组是 byte 数组，还可以手动指定以下 utf8 字符集，避免乱码
                // String s = new String(buffer, 9, len, "utf-8");
                String s = new String(buffer, 0, len);
                System.out.println(s); // a bc
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
