import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * @param <T> 此时代表当前类是一个泛型类，T:当做是一个占位符
 */
class MyArray<T> {
    //public T[] objects = new T[10]; // ERROR 1、不能实例化泛型类型的数组
    public T[] objects = (T[])new Object[10]; //也不可以

    public void set(int pos, T val) {
        objects[pos] = val;
    }

    public T get(int pos) {
        return objects[pos];
    }


    public Object[] getArray() {
        return objects;
    }
}

// 写一个泛型类，求出数组当中的最大值
/*class Alg<T extends Comparable<T>> { // 传入的E必须是实现了这个接口的 特殊的上界
    public T findMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            // 这里为什么会报错？？？？
            // 引用类型要用compareTo
            // if(max < array[i]) {
            if(max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}*/

class Alg<T extends Comparable<T>> {
    public <T extends Comparable<T>> T findMax(T[] array) { // 指定返回值类型
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}

class Alg2 {
    public static<T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}

class Alg3  {
    public static <T> void print1(ArrayList<T> list) {
        for (T x: list) {
            System.out.println(x);
        }
    }

    public static void print2(ArrayList<?> list) {
        for (Object x:list) {
            System.out.println(x);
        }
    }
}

class Person {

}
class Student extends Person {

}

public class TestDemo {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a == b);
        System.out.println(c == d);
    }

    public static void main10(String[] args) {
        ArrayList<? super Person> arrayList1 = new ArrayList<Person>();
        //ArrayList<? super Person> arrayList2 = new ArrayList<Student>(); // err

        arrayList1.add(new Person());
        arrayList1.add(new Student());//添加的元素 是person或者person的子类

        //Person person = arrayList2.get(0); //why????
        //Student student = arrayList1.get(0); //why????
        Object o = arrayList1.get(0); //只能那object获取
    }

    public static void main9(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        List<? extends Number> list = arrayList1;

        // list.add(1,1); // 报错，此时list的引用的子类对象有很多，再添加的时候，
        // 任何子类型都可以，为了安全，java不让这样进行添加操作。

        Number a = list.get(0); // 可以通过
        // Integer i = list.get(0); // 编译错误，只能确定是Number子类
    }

    public static void main8(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        Alg3.print2(list1); // 1 2
        Alg3.print2(list1); // 1 2
    }

    public static void main7(String[] args) {
        Alg<Integer> alg1 = new Alg<Integer>();
        System.out.println(alg1); // Alg@1b6d3586
        Alg<Integer> alg2 = new Alg<Integer>(); // Alg@4554617c
        System.out.println(alg2);
    }

    public static void main6(String[] args) {
        Integer[] array = {1,12,3,4};
        System.out.println(Alg2.findMax(array)); // 12
    }

    public static void main5(String[] args) {
        Alg<Integer> alg1 = new Alg<Integer>();
        Integer[] array = {1,12,3,4}; // 12
        System.out.println(alg1.findMax(array));

        Alg<String> alg2 = new Alg<>();
        String[] array2 = {"abc","hello","cdef"}; // hello
        System.out.println(alg2.findMax(array2));
    }

    public static void main4(String[] args) {
        MyArray<String> myArray = new MyArray<String>();
        MyArray<Integer> myArrayI = new MyArray<>();
        MyArray<Number> myArrayN = new MyArray<>();
        myArrayN.set(0,10);
        myArrayN.set(0,12.5);

        Object[] re2t = myArray.getArray();//编译器认为 此时 并不是很安全
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        // Integer[] ret = arrayList.toArray(); // err
        Object[] ret2 = arrayList.toArray();
    }

    public static void main3(String[] args) {
        MyArray<String> myArray = new MyArray<>();
        myArray.set(0, "bit");
        // myArray.set(1, 10); // err 1. 译的时候，自动进行类型的检查
        String str = myArray.get(0); // 2. 不需要进行类型的强制转换。自动帮我们进行类型的转换
        MyArray<Integer> myArray2 = new MyArray<Integer>();
        // MyArray<int> myArray3 = new MyArray<int>(); // 3. 简单类型 基本类型 不能作为泛型类型的参数
    }

    public static void main2(String[] args) {
        MyArray myArray = new MyArray();
        myArray.set(0, "bit");
        myArray.set(1, 10);;

        // String str = myArray.get(0); // 编译报错
        String str = (String) myArray.get(0);
    }

    public static void main1(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // 每放一个元素 都得保证当前的堆 是大堆 或者是小堆
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        priorityQueue.offer(3);

        System.out.println(priorityQueue.poll()); // 1 ->默认是小堆
        System.out.println(priorityQueue.peek()); // 2
    }
}
