package file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// 案例1：查找删除文件
public class Demo11 {
    public static void main(String[] args) {
        // 1、先输入要扫描的目录，以及要删除的内容
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径：");
        String rootDirPath = scanner.next();
        System.out.println("请输入要删除的文件名：");
        String toDeleteName = scanner.next();
        File rootDir = new File(rootDirPath);
        if (!rootDir.isDirectory()) {
            System.out.println("输入的扫描路径有误！");
            return;
        }
        // 2、遍历目录，把 指定目录 中的所有文件和子目录都遍历一遍，从而找到要删除的文件
        //    通过这个方法来实现 递归和遍历并删除 的操作
        scanDir(rootDir, toDeleteName);
    }

    private static void scanDir(File rootDir, String toDeleteName) {
        // 1、列出 rootDir 中有哪些内容
        File[] files = rootDir.listFiles();
        if (files == null) {
            // rootDir 是一个空目录
            return;
        }
        // 2、遍历当前列出的这些内容，如果是普通文件，就检测文件名时候是要删除的文件，
        //    如果是目录，就递归地调用进行遍历
        for (File f : files) {
            if (f.isFile()) {
                // 不要求名字完全一样，只要文件名中包含了关键字即可删除
                deleteFile(f);
            } else if (f.isDirectory()) {
                // 目录就递归
                scanDir(f, toDeleteName);
            }
        }
    }

    private static void deleteFile(File f) {
        try {
            System.out.println(f.getCanonicalPath() + " 确认要删除吗(Y/N)");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if (choice.equals("Y") ||  choice.equals("y")) {
                f.delete();
                System.out.println("文件删除成功！");
            } else {
                System.out.println("文件放弃删除！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
