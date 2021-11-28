package com.bit.demo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Chloe
 * Date: 2021-11-16
 * Time: 22:19
 */

class Animal {
    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("eat()");
    }
}

class Dog extends Animal{
    public Dog(String name, int age) {
        // super -> 显示调用构造方法
        super(name, age); // 调用父类带有2个参数的构造方法
    }
}

class Bird extends Animal{
    public String wing;

    public Bird(String name, int age, String wing) {
        super(name, age);
        this.wing = wing;
    }

    public void fly() {
        System.out.println("fly()");
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Dog dog = new Dog("hehe", 19);
        System.out.println(dog.name);
        dog.eat();

        Bird bird = new Bird("haha", 20, "wingwing");
        System.out.println(bird.name);
    }
}



/*package com.bit.demo1; // package 指定当前的类在哪个包下

public class TestDemo {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.val);
    }
}*/
