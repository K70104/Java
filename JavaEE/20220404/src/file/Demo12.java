package file;

import java.io.*;
import java.util.Scanner;


public class Demo12 {
    public static void main(String[] args) {
        // 1、输入两个路径
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要拷贝的路径：");
        String scr = scanner.next();
        System.out.println("请输入要拷贝的目标路径：");
        String dest = scanner.next();
        File scrFile = new File(scr);
        if (!scrFile.isFile()) {
            System.out.println("输入的源路径不正确！");
            return;
        }
        // 此处不太需要检查目标文件是否存在，OutputStream 写文件的时候，能够自动创建不存在的文件
        // 2、读取源文件，拷贝到目标文件中
        try (InputStream inputStream = new FileInputStream(scr)) {
            try (OutputStream outputStream = new FileOutputStream(dest)) {
                // 把 inputStream 中的数据读出来，写入到 outputStream 中
                byte[] buffer = new byte[1024];
                while (true) {
                    int len = inputStream.read(buffer);
                    if (len == -1) {
                        // 读取完毕
                        return;
                    }
                    // 写入的时候，不能把整个 buffer 都进去，可能 buffer 只有一部分是有效数据，只写入读出来的
                    outputStream.write(buffer, 0, len);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/* 请输入要拷贝的路径：
e:/test.txt
请输入要拷贝的目标路径：
e:/test2.txt

请输入要拷贝的路径：
e:/picture.png
请输入要拷贝的目标路径：
e:/picture2.png */