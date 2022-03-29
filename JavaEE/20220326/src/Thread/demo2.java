package Thread;

import java.util.Scanner;

public class demo2 {
    private static volatile int isQuit = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (isQuit == 0) {

            }
            /*while (isQuit == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
            System.out.println("循环结束！ t 线程退出！");
        });
        t1.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个 isQuit 的值：");
        isQuit = scanner.nextInt();
        System.out.println("main 线程执行完毕！");
    }
}
