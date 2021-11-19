/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Chloe
 * Date: 2021-11-19
 * Time: 12:52
 */

class A {

}
class B extends A {

}
class C extends B {

}

public class TestDemo {
    public static void main(String[] args) {
        A a0 = new A();
        A a1 = new B();
        A a2 = new C();
    }
}
