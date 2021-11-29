import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Person implements Cloneable {
    public int id;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class TestDemo {
    public static void main(String[] args) {
        System.out.println(readFile());
    }
    public static String readFile() {
        // 尝试打开文件, 并读其中的一行.
        File file = new File("e:/test.txt");
        // 使用文件对象构造 Scanner 对象.
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sc.nextLine();
    }

    public static void func1(int x) throws ArithmeticException {
        if(x == 0) {
            //System.out.println(10/x);
            throw new ArithmeticException("/ by 0");
        }
    }

    public static void func(int x) throws RuntimeException{ // 声明
        if(x == 0) {
            throw new RuntimeException("x==" +x); //
        }
    }

    public static void func2(int n) {
        /*try{
            System.out.println(10/n);
        }catch (ArithmeticException e) {
            e.printStackTrace();
        }*/
        System.out.println(10/n);
    }

    public static void main6(String[] args) {
        try {
            func(0);
        }catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    public static void main5(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(10 / n);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("输入有误！");
        } finally { //一般用作 资源的关闭
            System.out.println("finally执行了！");
        }
    }

    public static void func4() {
        func4();
    }

    public static void main4(String[] args) {
        func4();
    }

    public static void main3(String[] args) {
        int[] array = {1,2,3};
        try{
            array = null; // 修改代码, 让代码抛出的是空指针异常
            System.out.println(array[5]);
        }catch (ArrayIndexOutOfBoundsException | NullPointerException e){
            e.printStackTrace();
            System.out.println("捕捉到一个数组越界异常！");
        }
        System.out.println("xxx");
    }

    public static void main2(String[] args) {
        int[] array = {1,2,3};
        try{
            array = null; // 修改代码, 让代码抛出的是空指针异常
            System.out.println(array[5]);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("捕捉到一个数组越界异常！");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("捕捉到一个空指针异常！");
        }
        System.out.println("xxx");
    }

    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person1 = (Person) person.clone();
    }
}
