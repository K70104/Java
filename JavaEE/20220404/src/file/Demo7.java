package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo7 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("e:/test.txt")) {
            while (true) {
                byte[] buffer = new byte[1024];
                int len = inputStream.read(buffer);
                if (len == -1) {
                    return;
                }
                for (int i = 0; i < len; i++) {
                    System.out.print(buffer[i] + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 97 98 99 100 101 102
    }

    public static void main2(String[] args) {
        try (InputStream inputStream = new FileInputStream("e:/test.txt")) {
            while (true) {
                int  b = inputStream.read();
                if (b == -1) {
                    System.out.println(b);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main1(String[] args) {
        // 构造方法中需要指定打开文件的路径
        // 此处的路径可以是绝对的，也可以是相对路径，还可以是 File 队形
        InputStream inputStream = null;
        try {
            // 1、创建对象，同时也是在打开文件
            inputStream = new FileInputStream("e:/test.txt");
            // 2、尝试一个一个字节地读，把整个文件都读完
            while (true) {
                int b = inputStream.read();
                if (b == -1) {
                    // 读到了文件的末尾
                    break;
                }
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3、读完之后记得关闭文件，释放资源
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
