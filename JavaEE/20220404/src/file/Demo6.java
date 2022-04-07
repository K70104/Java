package file;

import java.io.File;

public class Demo6 {
    public static void main(String[] args) {
        File f = new File("./aaa");
        File f2 = new File("./zzz");
        // 将文件 aaa 改成 zzz 的文件名
        f.renameTo(f2);

        System.out.println(f.canRead()); // 判断用户是否对文件有可读权限 false
        System.out.println(f.canWrite()); // 判断用户是否对文件有可写权限 false
    }
}
