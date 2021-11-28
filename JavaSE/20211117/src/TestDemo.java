// import com.bit.demo1.*;

/*public class TestDemo {

    public static void main(String[] args) {
        com.bit.demo1.TestDemo testDemo2 = new com.bit.demo1.TestDemo();
        System.out.println(testDemo2.val);

        TestDemo testdemo = new TestDemo();
        // System.out.println(testdemo.val);
    }
}*/

/*class Animal {
    public String name;
    public int age;

    public void eat() {
        System.out.println(name+" ani::eat()");
    }
}

class Dog extends Animal{

}

class Bird extends Animal{
    public String wing;

    public void fly() {
        System.out.println(name+" fly() "+age);
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.name); // null
        dog.eat(); // null ani::eat()

        Bird bird = new Bird();
        System.out.println(bird.name); // null
        bird.eat(); // null ani::eat()
        bird.fly(); // null fly() 0
    }
}*/



class Animal {
    public int age;
    private int count;
    public Animal(String name, int age) {
        //this.name = name;
        this.age = age;
    }
    public void eat() {
        System.out.println(name+" ani::eat()");
    }
    public String name ="animal+name";

}
class Dog extends Animal{
    public Dog(String name, int age) {
        super(name, age); // 调用父类带有2个参数的构造方法
    }
    @Override
    public void eat() {
        System.out.println(name+" 狼吞虎咽的eat()");
    }
}
class Bird extends Animal{
    public String wing;
    public Bird(String name, int age, String wing) {
        super(name, age);
        this.wing = wing;
    }
    public void fly() {
        System.out.println(super.name+" fly() "+super.age);
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Animal animal = new Bird("hehe", 10,"RR");
        System.out.println(animal.name);

        Dog dog = new Dog("hehe", 19);
        ;
        System.out.println(dog.name);
        // null 狼吞虎咽的eat()
        // hehe
        dog.eat(); // hehe 狼吞虎咽的eat()

        Bird bird = new Bird("haha", 20, "wingwing");
        System.out.println(bird.name);
        // null ani::eat()
        // haha
        bird.eat(); // haha ani::eat()
        bird.fly(); // haha fly() 20
    }
}


/*public class TestDemo {

    public static void main(String[] args) {
        com.bit.demo1.TestDemo testDemo2 = new com.bit.demo1.TestDemo();
        System.out.println(testDemo2.test);

        TestDemo testdemo = new TestDemo();
        System.out.println(testdemo.test);


        Dog animal = new Dog("hehe", 10);
        // null 狼吞虎咽的eat()
    }
}*/


/*public class TestDemo {
    public static void main(String[] args) {
        Animal animal = new Dog("hehe", 10);
        Bird bird = (Bird)animal;
        bird.fly();

        Animal animal2 = new Dog("hehe", 10);
        if(animal2 instanceof Bird) { // 判断animal2引用的是不是Bird的对象
            Bird bird2 = (Bird)animal2;
            bird2.fly();
        }
    }
}*/


/*class Animal {
    public String name;
    public int age;
    private int count;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void eat() {
        System.out.println(name+" eat()");
    }
}

class Dog extends Animal{
    public Dog(String name, int age) {
        super(name, age); // 调用父类带有2个参数的构造方法
    }

    @Override
    public void eat() {
        System.out.println(name+" 狼吞虎咽的eat()");
    }

    public void func(int a) {
        System.out.println("int");
    }
    public void func(int a, int b) {
        System.out.println("int, int");
    }
    public void func(int a, int b, int c) {
        System.out.println("int, int, int");
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Dog dog = new Dog("haha", 19);
        dog.func(10);
    }
}*/

/*class Animal {
    public String name;
    public int age;
    private int count;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void eat() {
        System.out.println(name+" eat()");
    }
}

class Dog extends Animal{
    public Dog(String name, int age) {
        super(name, age); // 调用父类带有2个参数的构造方法
    }

    @Override
    public void eat() {
        System.out.println(name+" 狼吞虎咽的eat()");
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Animal animal = new Dog("haha", 19); // 调用dog类带有两个参数的构造方法
        animal.eat(); // haha eat()
        // dog里加上eat自己的方法后运行打印：
        // haha 狼吞虎咽的eat()
    }
}*/


/*
public class TestDemo {

    public static void func(Animal ani) {

    }

    public static Animal func2() {
        Dog dog = new Dog("haha", 19);
        return dog;
    }

    public static void main(String[] args) {
        Animal animal = new Dog("haha", 19); // 父类引用 引用 子类对象

        Dog dog = new Dog("haha", 19);
        func(dog);
    }
}*/
