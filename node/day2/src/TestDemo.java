import javax.swing.table.AbstractTableModel;
import java.util.*;


class Base {
    public Base() {

    }
    public String Base(String s) {
        System.out.println("B");
        return s;
    }
}


abstract class Child {
    public String name = "Person!";
    int age = 0;
    //abstract void fun() {}; // Abstract methods cannot have a body
}


abstract class MyClass {
    public int constInt = 5;
    // add code here
    public abstract void anotherMethod();
    public void method() {
    }
}

/*
A. public abstract void method (int a);
        B. consInt = constInt + 5;
        C. public int method();
        D. public abstract void anotherMethod() {}
*/


public class TestDemo extends Child{
    public static void main(String[] args) {
        String s1 = "abcd ";
        String s2 = s1.toLowerCase(); // 与 "abcd" 一样 返回原来的对象
        System.out.println(s1 == s2);
        System.out.println(s1.toLowerCase() == "abcd");

        String s3 = "Admin" ;
        String s4 = s1.toLowerCase(); // 大写转小写 不一样 产生了一个新的对象
        System.out.println(s2 = "admin");
    }

    public static void main6(String[] args) {
        System.out.println(100 % 3); // 1
        System.out.println(100 % 3.0); // 1.0
        System.out.println(100 % 3.3); // 1.0000000000000053
    }

    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] array = new int[3 * n];
            for(int i = 0; i < 3 * n; i++) {
                array[i] = scanner.nextInt();
            }
            Arrays.sort(array);
            if(n == 3) {
                System.out.println(array[1]);
            } else {
                int teams = n;
                int right = 3 * n - 2;
                long ans = 0; // 溢出
                while(teams > 0) {
                    ans += array[right];
                    right -= 2;
                    teams--;
                }
                System.out.println(ans);
            }
        }
    }

    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int max = 0;
        int count = 0;
        int end = 0;
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                count++;
                if(count > max) {
                    max = count;
                    end = i;
                }
            } else {
                count = 0;
            }
            System.out.println(str.substring(max - end - 1, max + 1));
        }
    }

    public static void main4(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                if(sb1.length() > sb2.length()) { // 短的数字集合清空
                    sb2.delete(0, sb2.length());
                } else {
                    sb1.delete(0, sb1.length());
                }
            } else {
                if(sb1.length() == 0){
                    while(i < str.length() && Character.isDigit(str.charAt(i))) {
                        sb1.append(str.charAt(i));
                        i++;
                    }
                    i--;
                } else {
                    while(i < str.length() && Character.isDigit(str.charAt(i))) {
                        sb2.append((str.charAt(i)));
                        i++;
                    }
                    i--;
                }
            }
        }
        System.out.println(sb1.length() > sb2.length() ? sb1.toString() : sb2.toString());
    }

    public String str;
    public static void main3(String[] args) {
        Child child = new TestDemo();
        System.out.println(child.name);
    }

    /*public TestDemo(String s) {
        System.out.print("D");
    }*/

    public static void main2(String[] args) throws Exception {
        int i = 12;
        if(i > 10) {
            throw new Exception("1");
        }
    }

    /*public static void main1(String[] args) {
        new TestDemo("C");
    }*/
}
