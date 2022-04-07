package file;

import java.io.File;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        // 文件的创建和剔除 在 system.code 下创建 test.txt
        File f = new File("./test.txt");
        System.out.println(f.exists());
        System.out.println("创建文件");
        f.createNewFile();
        System.out.println("创建文件结束");

        // 删除文件
        // deleteOnExit() -- JVM 运行完后进行
        f.delete();
    }
}
