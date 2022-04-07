package file;

import java.io.File;

public class Demo2 {
    public static void main(String[] args) {
        File f = new File("e:/test.txt");
        // 文件存在
        System.out.println(f.exists()); // true
        // 是否是一个目录
        System.out.println(f.isDirectory()); // false
        // 是否是一个普通文件
        System.out.println(f.isFile()); // true

        File f2 = new File("./test.txt");
        System.out.println(f2.exists()); // false
        System.out.println(f2.isDirectory()); // false
        System.out.println(f2.isFile()); // false
    }
}
