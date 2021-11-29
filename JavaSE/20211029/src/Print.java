

class PT {

    public String name;
    public int age;

    public PT() {
        // this调用构造函数
        // 必须放在第一行
        this("zhangsan"); // ->调用带有一个参数的构造方法
        System.out.println("Person()::不带参数的构造方法");
    }
    public PT(String name) {
        this.name = name; // 给name赋值
        System.out.println("Person(String)::带一个String 类型参数的构造方法");
    }
}

public class Print {

    public static void main(String[] args) {
        PT test = new PT(); // ->调用不带参数的构造方法
        // Person(String)::带一个String 类型参数的构造方法
        // Person()::不带参数的构造方法
        System.out.println(test);
        // Person{name='zhangsan', age=0}
    }
}
