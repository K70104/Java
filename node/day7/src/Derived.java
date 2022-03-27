class A {
    public void test4() {
        System.out.println("test4()");
    }
}

class Base{
    public void test1() {
        System.out.println("test1()");
    }
    public static void test2() {
        System.out.println("test2()");
    }
}
public class Derived extends Base{
    public static void test3() {

    }

    public void method() {
        super.test1();
        Base.test2();
        test3();
        // test4();
    }

    public static void main(String[] args){
        Derived derived = new Derived();
        derived.method();
    }
}

