package com.bit.demo1;

//受查异常
class MyException extends Exception{
    public MyException(String message) {
        super(message);
    }
}
//非受查异常
class MyException2 extends RuntimeException{
    public MyException2(String message) {
        super(message);
    }
}

public class Test {
    public static void func3(int x) throws MyException{
        try {
            if(x == 0) {
                throw new MyException2("heihei");
            }
        }catch (MyException2 e) {
            e.printStackTrace();
        }
    }

    public static void func4(int x) {
        // JVM 处理
        if(x == 0) {
            throw new MyException2("heihei");
        }
    }

    public static void func1(int x) {
        try {
            if(x == 0) {
                throw new MyException("heihei");
            }
        }catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void func2(int x) throws MyException{
        if(x == 0) {
            throw new MyException("hahah");
        }
    }
}
