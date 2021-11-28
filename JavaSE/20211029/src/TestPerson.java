

class Person1 {
    public String name;
    public int age;

    public static int count;

    public void eat() {
        // static int size = 0; // err

        /**
         * ① 普通的方法内部，不能定义静态的变量
         * 1. static 定义的变量，是类变量，属于类
         * 2. eat方法的调用，需要对应的引用来调用，但是如果可以定义static的变量，类名Person就可以调用
         */

        System.out.println(name+"正在吃饭！");
    }

    // 类方法/静态方法
    public static void staticFunc1() {
        // ② 静态的成员变量，是不可以在方法中定义的
        // static int size = 0; // err
        count = 1; // 可以赋值静态成员变量
    }

    public void sleep() {
        // ③ 普通方法内部，可以调用静态的方法
        // 普通方法依赖于对象，静态方法不依赖对象
        staticFunc();
        System.out.println(name+"正在睡觉！");
    }

    // 类方法/静态方法
    public static void staticFunc() {
        // ④ 静态方法内部，不能调用普通方法
        // 通过类名就可以调用静态方法，而普通方法需要对象
        // sleep(); // err
        System.out.println("static::func()");
    }
}

public class TestPerson {

    public static void main1(String[] args) {
        // ③
        Person1 p = new Person1();
        p.sleep();
    }
}
