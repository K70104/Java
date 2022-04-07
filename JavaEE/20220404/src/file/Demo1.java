package file;

import java.io.File;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        File f = new File("e:/test.txt");
        // 获取到文件的父目录
        System.out.println(f.getParent()); // e:\
        // 获取到文件名
        System.out.println(f.getName()); // test.txt
        // 获取到文件路径 -- 构造 File 的时候指定的路径
        System.out.println(f.getPath()); // e:\test.txt
        // 获取到绝对路径
        System.out.println(f.getAbsolutePath()); // e:\test.txt
        // 获取到绝对路径
        System.out.println(f.getCanonicalPath()); // E:\test.txt


        File f2 = new File("./test.txt");
        System.out.println(f2.getParent()); // .
        System.out.println(f2.getName()); // test.txt
        System.out.println(f2.getPath()); // .\test.txt

        System.out.println(f2.getAbsolutePath());
        // E:\Gitee\java\JavaEE\system_code\.\test.txt
        //                     基准路径    在基准路径的基础上，又把相对路径给拼接上来了
        // . 仍然是表示当前目录也就是 system_code 这一级目录，完全可以把 . 给去掉

        System.out.println(f2.getCanonicalPath());
        // E:\Gitee\java\JavaEE\system_code\test.txt
        // 得到的是化简过的绝对路径
    }

    public static void main1(String[] args) {
        // 绝对路径
        File file1 = new File("e:/test.txt");
        // 相对路径
        File file2 = new File("./test.txt");
    }
}
