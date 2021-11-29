

class Test{
    public int a;
    public static int count;
}

public class Main{

    public static void main(String[] args) {
        Test t1 = new Test();
        t1.a++; // 1
        Test.count++; // 1
        System.out.println(t1.a); // 1
        System.out.println(Test.count); // 1

        System.out.println("============");

        Test t2 = new Test();
        t2.a++; // 1
        Test.count++; // 2
        System.out.println(t2.a); // 1
        System.out.println(Test.count); // 2
    }

}