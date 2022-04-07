package file;

import java.io.File;

public class Demo4 {
    public static void main1(String[] args) {
        // 在 sysetm.code 下创建一个名为 aaa 的文件夹
        File f = new File("./aaa");
        f.mkdir();
        System.out.println(f.isDirectory()); // true
    }

    public static void main(String[] args) {
        // 创建目录的时候，使用 mkdir 只能创建一级目录，要想一次创建多级，需要使用 mkdirs
        File f =  new File("./aaa/bbb/ccc");
        f.mkdirs();
        System.out.println(f.isDirectory());
    }
}
