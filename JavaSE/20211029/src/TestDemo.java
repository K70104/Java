

class Person {
    /**
     * 类的成员
     * 1.字段-属性-成员变量 --- 普通成员变量
     *                        静态成员变量-->类名.静态的成员属性/方法
     */

    //  普通的成员变量 -都是属于对象的
    public String name; // 实例变量 存放在对象内
    public int age;

    // 静态成员变量 -类变量 -> 方法区
    public static int count;

    public void eat() {
        System.out.println(name+"正在吃饭！");
    }
    public void sleep() {
        System.out.println(name+"正在睡觉！");
    }

    // 类方法/静态方法
    public static void staticFunc() {
        System.out.println("static::func()");
    }

    // 一个对象存储到哪里，和被final修饰无关
    public final int size1 = 10; // 对象中
    public static final int size2 = 20; // 方法区


    // toString 方法会在 println 的时候被自动调用
    // 序列化：对象转成字符串
    /*    public String toString() {
        return "姓名："+name+" 年龄"+age;
    }*/

    // 右击generate toString
    // 重写Object的toString方法
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    private String n;
    // 封装 -只能在当前类使用 -安全
    /*
    public String getN() {
        return n;
    }
    public void setN(String myN) {
        n = myN;
    }*/
    // 右击generate Getter Setter
    public String getN() {
        return n;
    }
    public void setN(String n) {
        this.n = n; //this引用 代表**当前对象的引用**
    }

    // 构造方法
    public Person() {
        System.out.println("Person()::不带参数的构造方法");
    }
    public Person(String name) {
        this.name = name;
        System.out.println("Person(String)::带一个String 类型参数的构造方法");
    }
    // 重载
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person(String)::带2个String 类型参数的构造方法");
    }


    public static int test = 10;
    {
        this.age = 50; // 实例代码块可以实例数据成员 静态代码块不能
        System.out.println("实例代码块");
    }
    static {
        test = 99;
        System.out.println("静态代码块");
    }
}

public class TestDemo {

    public static void main(String[] args) {
        // 匿名对象
        /*
        没有引用的对象称为匿名对象.
        匿名对象只能在创建对象时使用.
        如果一个对象只是用一次, 后面不需要用了, 可以考虑使用匿名对象
         */
        // 一次性
        new Person().eat(); // new对象 调用eat
        new Person().sleep();
        System.out.println(new Person());
        System.out.println("==============");

        // 只用一次对象
        Person person1 = new Person();
        person1.eat();
        person1.sleep();
        System.out.println(person1);
    }

    public static void main14(String[] args) {
        // this关键字

        // this代表当前对象-err
        // 调用完构造方法才会实例化生成对象，this只代表为对象分配内存空间，第二步还未完成，

        /* 1. this.data --> 调用当前对象的属性
        2. this.func() --> 调用当前对象的方法 (静态方法里不能用this)
        3. this() --> 调用当前对象的其他构造方法
        只能存放在构造方法中
         */
        // print.java


         // 代码块
        /*
        本地代码块
        实例代码块
        静态代码块
        同步代码块
         */

        // 本地代码块
        {

        }

        // 代码块是如何被调用的
        Person person1 = new Person();
        /**打印：
         * 静态代码块
         * 实例代码块
         * Person()::不带参数的构造方法
         */

        System.out.println("====================");
        Person person2 = new Person();
        /**
         * 第二次实例化对象：
         * 静态代码块
         * 实例代码块
         * Person()::不带参数的构造方法
         * ====================
         * 实例代码块
         * Person()::不带参数的构造方法
         */
        // 静态代码块不管生成多少个对象，其只会执行一次，且是最先执行的。
        // 静态代码块不用实例化 就可以被执行 （类加载的时候）

        // <-
        // test打印10还是99
        System.out.println(Person.test);
        // 99
        // 如果都是静态的，和定义的顺序有关
        // 字段在前 99
        // 静态代码块在前 10
        // 如果test没有初始化默认值0：
        // 字段在前 99
        // 静态代码块在前 99
    }

    public static void main13(String[] args) {
        /*
        构造方法是一种特殊方法, 使用关键字new实例化新对象时会被自动调用, 用于完成初始化操作

        构造方法
        方法名称与类名称相同，且构造方法比较特殊，没有返回值
        构造方法是干什么的->一个对象的产生/实例化new 需要：
        1. 为对象分配内存空间
        2. 调用合适的构造方法 --（构造方法不止一个）
        */

        Person person = new Person(); // Person()::不带参数的构造方法

        System.out.println("=====================");
        /*
        1. 如果类中没有提供任何的构造函数，那么编译器会默认生成一个不带有参数的构造函数
        一个类，至少会有一个改造方法
        2. 若类中定义了其他构造方法，则编译器默认生成的无参构造将不再生成
        3. 构造方法支持重载（方法名称相同，参数列表不同，返回值不做要求）. 规则和普通方法的重载一致
         */

        // 在实例化对象时，调用了构造方法
        // 同时会给name传值
        Person person1 = new Person("bit"); // Person(String)::带一个String 类型参数的构造方法

        System.out.println("======================");

        Person person2 = new Person("bit", 19); // Person(String)::带2个String 类型参数的构造方法
    }

    public static void main12(String[] args) {
        //  封装
        // 在我们写代码的时候经常会涉及两种角色: 类的实现者和类的调用者.
        //封装的本质就是让类的调用者不必太多的了解类的实现者是如何实现类的, 只要知道如何使用类就行了.
        //这样就降低了类使用者的学习和使用成本, 从而降低了复杂程度

        // 被 public 修饰的成员变量或者成员方法, 可以直接被类的调用者使用.
        //被 private 修饰的成员变量或者成员方法, 不能被类的调用者使用

        // 如果n被private修饰，就只能在当前类中使用
        // 需要获取或者修改这个 private 属性，就需要使用getter和setter方法
        Person person = new Person();
        // 赋值
        person.setN("bit");
        // 获取
        System.out.println(person.getN()); // bit

        /*
        注意事项
        getName 即为 getter 方法, 表示获取这个成员的值
        setName 即为 setter 方法, 表示设置这个成员的值
        当set方法的形参名字和类中的成员属性的名字一样的时候，如果不使用this, 相当于自赋值. this 表示当前实例的引用

         */
    }

    public static void main11(String[] args) {
        Person person = new Person();
        System.out.println(person); // Person@1b6d3586
        // 打印此引用的值 toString
    }


    public static void main10(String[] args) {
        // Main
    }

    // 成员变量
    Person person = new Person();

    public static void main9(String[] args) {
        // 4. 引用一定在栈上吗？不一定
        TestDemo testDemo = new TestDemo();
        Person person = new Person();
    }

    public static void main8(String[] args) {
        // Person person = null; // 1. 此引用不指向任何对象

        //Person person = new Person();
        //Person person1 = person; // 2. person1这个引用指向person这个引用所指向的对象

        // 3. 一个引用不能同时指向多个对象
        Person person = new Person();
        person = new Person();
        person = new Person();
        person = new Person();
        person = new Person(); // 最后一次
    }

    public static void main7(String[] args) {
        /*
        main函数为什么是静态的
        main是不是静态的都可以，取决于JVM如何实现的
         */
    }

    public static void func1() {

    }
    public void func2() {

    }

    public static void main6(String[] args) {
        func1(); // ok

        // func2(); // err 普通成员方法需要对象
        TestDemo testDemo = new TestDemo();
        testDemo.func2(); // ok
    }

    public static void main5(String[] args) {
        // TestPerson.java
    }

    public static void main4(String[] args) {
        // 访问静态方法：直接用类名
        Person.staticFunc();

        // 需要引用指向对象
        Person p = new Person();
        p.eat();
    }

    public static void main3(String[] args) {
        /*Person person1 = new Person();
        person1.count++;*/

        // 通过类名访问静态成员变量
        // 类名.静态的成员属性/方法
        // 不需要new两个对象 节省了2个对象的空间
        Person.count++;
        System.out.println(Person.count); // 1

        System.out.println("===================");

        /*Person person2 = new Person();
        person2.count++;*/
        Person.count++;
        System.out.println(Person.count); // 2
        // 方法区
    }

    public static void main2(String[] args) {
        Person person1 = new Person();
        person1.age++;
        System.out.println(person1.age); // 1

        System.out.println("===================");

        Person person2 = new Person();
        person2.age++;
        System.out.println(person2.age); // 1
    }

    public static void main1(String[] args) {
        Person person = new Person();
        person.count = 1999;
        System.out.println(person.count); // 1999
    }
}
