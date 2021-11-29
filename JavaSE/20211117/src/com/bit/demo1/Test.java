package com.bit.demo1;

class Shape {
    public void draw() {
        System.out.println("Shape::draw()");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("♦");
    }
}

class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("△");
    }
}

class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("●");
    }
}

public class Test {
    public static void drawMap(Shape shape) { // 向上转型
        shape.draw(); // 动态绑定
    }

    //
    public static void main(String[] args) {
        Rect rect = new Rect();
        Flower flower = new Flower();
        Triangle triangle = new Triangle();

        // 创建了一个 Shape 对象的数组
        Shape[] shapes = {triangle, rect, triangle, rect, flower};

        for (Shape x : shapes) {
            x.draw();
        }
    }

    // if-else 循环
    public static void main1(String[] args) {
        Rect rect = new Rect();
        Flower flower = new Flower();
        Triangle triangle = new Triangle();

        String[] shapes = {"triangle", "rect", "triangle", "rect", "flower"};

        for (String x : shapes) {
            if(x.equals("triangle")) {
                triangle.draw();
            } else if(x.equals("rect")) {
                rect.draw();
            } else {
                flower.draw();
            }
        }
    }

    public static void main3(String[] args) {
        Shape shape1 = new Rect();
        drawMap(shape1); // ♦
        //drawMap(new Rect());

        Shape shape2 = new Flower();
        drawMap(shape2); // ❀

        Shape shape3 = new Triangle();
        drawMap(shape3); // △
    }
}
