package file;

import java.io.File;
import java.util.Arrays;

public class Demo5 {
    public static void main(String[] args) {
        File f = new File("./aaa");
        // 返回 File 对象代表的目录下的所有文件名
        System.out.println(f.list()); // [Ljava.lang.String;@1b6d3586
        System.out.println(Arrays.toString(f.list())); // [bbb]

        File f2 = new File("./");
        System.out.println(Arrays.toString(f2.list())); // [.idea, 2022.iml, aaa, out, src]
        // 返回 File 对象代表的目录下的所有文件，以 File 对象表示
        System.out.println(Arrays.toString(f2.listFiles())); // [.\.idea, .\2022.iml, .\aaa, .\out, .\src]
    }
}
