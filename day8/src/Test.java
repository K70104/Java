

public class Test {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
        // new B()后打印的的是 22
        // 然后调用getValue 返回得到的是17 最后打印17
    }
    static class A {
        protected int value; // 10
        public A(int v) {  // 5
            setValue(v);
            // 调用的是子类重写的方法 也就是 B 的 setValue
        }
        public void setValue(int value) {
            this.value = value; // 10  22  16  34
        }
        public int getValue() {
            try {
                value++; // 11  17
                return value; // 11 17
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                this.setValue(value); // 还是调用 B 的：传入 22  17
                System. out.println(value); // 打印：22  34
            }
            return value;
        }
    }
    static class B extends A {
        protected B() {
            super(5); // 5
            setValue(getValue() - 3); // 11-3=8
        }
        public void setValue(int value) { // 5  11  8  17
            super.setValue(2 * value); // 10  22  16  34
        }
    }
}
/*A 11 17 34
B 22 74 74
C 6 7 7
D 22 34 17*/




/*
final class F {
}

abstract class K {
}

public class Test {
    F f;
    K k;
    public static void main(String[] args) {
        F f1 = new F();
        F f;
        K k;
    }
}
*/

