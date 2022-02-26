


class OuterClass {
    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;

    //实例内部类：你可以把他当做 是外部类的一个普通实例的成员
    class InnerClass { // 实例内部类
        // public static int num = 10; // 1. err
        public int data1 = 999999;
        public int data4 = 4;
        private int data5 = 5;
        public static final int data6 = 6;

        public InnerClass() {
            System.out.println("不带参数的内部类的构造方法！");
        }

        public void test() {
            // 实例内部类中，如果包含了和外部类同名的成员变量，如何在实例内部类当中访问
            System.out.println(OuterClass.this.data1); // 外部类的 this
            System.out.println(this.data1); // 加this还是999999 当前类的引用

            System.out.println(data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
            System.out.println("InnerClass::test()");
        }
    }

    public void func1() {
        //static int a = 10; 属于类的  不属于对象的
        System.out.println("OuterClass::func1()");
    }
}

public class TestDemo extends OuterClass.InnerClass {
    public TestDemo(OuterClass out) {
        out.super();
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        // 2、实例化内部类对象
        // 外部类名.内部类名 变量 = 外部类对象的引用.new 内部类()
        OuterClass.InnerClass innerClass = outerClass.new InnerClass(); // 运行：不带参数的内部类的构造方法！

        innerClass.test(); // 1 999999 2 3 4 5 6 InnerClass::test()
    }

    // 内部类 哈希表
    public void func() {
        class Test { // 内部类
            public int num;
        }
    }

    // 二分
    public int mySqrt(int x) {
        if(x == 1) return 1;
        int left = 1;
        int right = x / 2; //
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(x / mid > mid) { //不用x > mid * mid 防溢出
                left = mid + 1;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right; // -1->-1   0->1
    }

    // 2、根据平方数的性质——连续n个奇数相加的结果一定是平方数
    public int mySqrt2(int x) {
        if(x < 0) return 0;
        int i = 1;
        int ans = 0;
        while(x >= 0) {
            x -= i;
            i += 2;
            ans++;
        }
        return ans - 1;
    }

    public int mySqrt1(int x) {
        double mul = Math.sqrt(x);
        return (int)Math.floor(mul);
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
