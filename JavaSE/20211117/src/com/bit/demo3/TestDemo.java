package com.bit.demo3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Chloe
 * Date: 2021-11-18
 * Time: 23:21
 */

/*interface IShape {
    public  abstract void draw(); // 抽象方法

    default public void func() {
        System.out.println("func:");
    }
    public static void func2() {
        System.out.println("func2:");
    }
}*/

interface IShape {
    public abstract void draw(); // 抽象方法
    // void draw(); // 不加也默认是public abstract
}

class Rect implements IShape {
    @Override
    public void draw() {
        System.out.println("♦");
    }
}


/*interface IA {
    public static final int a = 10;
    int b = 10;
}*/

/*interface IA {
    int A = 10;
    void funcA(); // public abstract
}

interface IB {
    void funcB();
}

class AClass implements IA, IB {
    @Override
    public void funcA() {
        System.out.println("A->funcA");
        System.out.println(A);
    }

    @Override
    public void funcB() {
        System.out.println("B->funcB");
    }
}*/



/*interface IA {
    int A = 10;
    void funcA(); // public abstract
}

interface IB {
    void funcB();
}

class BClass {

}

class AClass extends BClass implements IA, IB {
    @Override
    public void funcA() {
        System.out.println("A->funcA");
        System.out.println(A);
    }

    @Override
    public void funcB() {
        System.out.println("B->funcB");
    }
}*/



interface IA {
    void funcA();
}

interface IB extends IA{
    void funcB();
}

class C implements IB{
    @Override
    public void funcA() {
        System.out.println("IA:funcA");
    }

    @Override
    public void funcB() {
        System.out.println("IB:funcB");
    }
}


public class TestDemo {
    public static void drawMap(IShape iShape) {
        iShape.draw(); // 和动态绑定
    }

    public static void main(String[] args) {
        Rect rect = new Rect(); // 也可向上转型
        drawMap(rect); // ♦
    }

    public static void main1(String[] args) {
        IShape iShape = new Rect();
        iShape.draw(); // ♦
    }
}
