import jdk.internal.org.objectweb.asm.util.ASMifier;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

abstract class Animal {
    abstract void say();
}

class Cat extends Animal {
    @Override
    public void say() {
        System.out.println("Cat : say()");
    }
}


interface A {
    public void test();
}

public class TestDemo implements Comparator<Integer> {

    public static void main(String[] args) {

    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String n = scanner.next();
            while (n.length() > 1) {
                int sum = 0;
                for (int i = 0; i < n.length(); i++) {
                    sum += n.charAt(i) - '0';
                }
                n = String.valueOf(sum);
            }
            System.out.println(n);
        }
    }

    public static void main1(String[] args){
        TestDemo testDemo = new TestDemo();
        int[] array = {1,2,4,6,21,52,55,3};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (testDemo.compare(array[j], array[j + 1]) > 0) {
                    swap(array[j], array[j + 1]);
                }
            }
        }
        System.out.println(123);
        System.out.println(Arrays.toString(array));
    }

    private static void swap(int i, int i1) {
        int tmp = i;
        i = i1;
        i1 = tmp;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}
