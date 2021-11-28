package com.bit.demo4;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Chloe
 * Date: 2021-11-19
 * Time: 11:27
 */

class Animal {
    protected String name;
    public Animal(String name) {
        this.name = name;
    }
}

// 不是所有动物都会飞 所以不能写到Animal类里
// 也不能写到另一个类中 因为一个类不能继承多个类 多以用接口
interface IFlying {
    void fly();
}

interface IRunning {
    void run();
}

interface ISwimming {
    void swim();
}

class Bird extends Animal implements IFlying{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.name+" 正在飞！");
    }
}

class Frog extends Animal implements IRunning,ISwimming {
    public Frog(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name+" 正在跑！");
    }

    @Override
    public void swim() {
        System.out.println(this.name+" 正在游泳！");

    }
}

class Duck extends Animal implements IFlying,IRunning,ISwimming {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.name+" 正在飞！");
    }

    @Override
    public void run() {
        System.out.println(this.name+" 正在跑！");
    }

    @Override
    public void swim() {
        System.out.println(this.name+" 正在游泳！");
    }
}

class Roobot implements IRunning {
    @Override
    public void run() {
        System.out.println("机器人在跑！");
    }
}

public class Test {
    public static void runFunc(IRunning iRunning) {
        iRunning.run();
    }

    public static void swimmingFunc(ISwimming iSwimming) {
        iSwimming.swim();
    }

    public static void flyingFunc(IFlying iFlying) {
        iFlying.fly();
    }

    public static void main(String[] args) {
        runFunc(new Duck("小鸭")); // 小鸭 正在跑！
        runFunc(new Frog("青蛙"));  // 青蛙 正在跑！

        swimmingFunc(new Duck("小鸭")); // 小鸭 正在游泳！
        swimmingFunc(new Frog("青蛙")); // 青蛙 正在游泳！

        flyingFunc(new Duck("小鸭")); // 小鸭 正在飞！
        flyingFunc(new Bird("小鸟")); // 小鸟 正在飞！

        runFunc(new Roobot()); // 机器人在跑！
    }
}
