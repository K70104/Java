

/**
 * 编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘
 * 除四种运算.
 * 设计一个包含多个构造函数的类，并分别用这些构造函数来进行实例化对象。
 */
class Calculator {
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add() {
        return num1 + num2;
    }
    public int sub() {
        return num1 - num2;
    }
    public int mul() {
        return num1 * num2;
    }
    public double dev() {
        return num1*1.0 / num2;
    }
}


/*
    实现交换两个变量的值。要求：需要交换实参的值
 */
class MyValue {
    public int val;
}

public class TestDemo {

    public static void swap(MyValue myV1, MyValue myV2) {
        int tmp = myV1.val;
        myV1.val = myV2.val;
        myV2.val = tmp;
    }

    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.val = 10;

        MyValue myValue2 = new MyValue();
        myValue2.val = 20;

        swap(myValue1, myValue2);
        System.out.println(myValue1.val+" "+ myValue2.val); // 20 10
    }

    public static void main1(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setNum1(1);
        calculator.setNum2(2);
        System.out.println(calculator.add());
    }
}