

public class TestDemo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0, 12);
        myArrayList.add(1, 23);
        myArrayList.add(2, 57);

        myArrayList.display();

        System.out.println(myArrayList.size());

        System.out.println(myArrayList.contains(12));

        System.out.println(myArrayList.search(12));

        System.out.println(myArrayList.getPos(0));

        myArrayList.setPos(0, 99);
        myArrayList.display(); // 99 23 57

        myArrayList.remove(99);
        myArrayList.display(); // 23 57

        System.out.println("=================");
        myArrayList.clear();
        myArrayList.display();
    }
}

/*class Test1 {
    public String toString() {
        System.out.print("aaa");
        return "bbb";
    }
}

public class TestDemo {

    private float f=1.0f;
    int m=12;
    static int n=1;

    public static void main(String[] args) {
        // System.out.println(new Test1());

        TestDemo t=new TestDemo();

    }
}*/

/*public class TestDemo{

    static int cnt = 6;
    static{
        cnt += 9;
    }
    public static void main(String[] args) {
        System.out.println("cnt =" + cnt);
    }
    static{
        cnt /=3;
    };

*//*    private int count;

    public static void main(String[] args) {

        TestDemo test=new TestDemo(88);

        System.out.println(test.count);

    }

    TestDemo(int a) {

        count=a;

    }*//*

}*/

/*public class TestDemo {

    private static int x = 100;// 2

    public static void main(String args[]) {// 3

        TestDemo hsl = new TestDemo();// 4

        hsl.x++;// 5

        TestDemo hs2 = new TestDemo();// 6

        hs2.x++;// 7

        hsl = new TestDemo();// 8

        hsl.x++;// 9

        TestDemo.x--;// 10

        System.out.println(" x=" + x);// 11
    }

}*/
