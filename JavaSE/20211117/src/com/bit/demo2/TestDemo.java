package com.bit.demo2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Chloe
 * Date: 2021-11-18
 * Time: 22:42
 */
abstract class Shape {
    public int val;
    public void func() {
        System.out.println("测试普通方法：");
    }
    public  abstract void draw();
}

abstract class A extends Shape {
    public abstract void funcA();
}

class B extends A {
    @Override
    public void funcA() {
        super.func();
    }

    @Override
    public void draw() {

    }
}


class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("♦");
    }
}

public class TestDemo {
    public static void drawMap(Shape shape) {
        shape.draw(); // 和动态绑定
    }

    public static void main(String[] args) {
        Shape shape = new Rect(); // 可以向上转型
        drawMap(shape);
    }
}
