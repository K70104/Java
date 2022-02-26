


class OuterClass2 {
    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;
    //静态内部类:
    static class InnerClass {
        public int data4 = 4;
        private int data5 = 5;
        public static int data6 = 6; // ok

        //public static OuterClass2 out2 = new OuterClass2();

        public OuterClass2 out;
        public InnerClass(OuterClass2 out) {
            this.out = out;
        }

        public InnerClass() {
        }

        public void test() {
            // System.out.println(data1); // err 需要外部类的引用

            // 1、
            /*OuterClass2 outerClass2 = new OuterClass2();
            System.out.println(outerClass2.data1);*/

            System.out.println(out.data1); // 2、

            //System.out.println(new OuterClass2().data1); // 3、

            //System.out.println(out.data2); // 私有成员需要get set方法

            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
            System.out.println("InnerClass::test()");
        }
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        OuterClass2.InnerClass innerClass = new OuterClass2.InnerClass();
    }
}
