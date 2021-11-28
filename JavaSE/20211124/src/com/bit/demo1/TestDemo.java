package com.bit.demo1;

class NameException extends RuntimeException{
    public NameException(String message) {
        super(message);
    }
}
class PasswordException extends RuntimeException{
    public PasswordException(String message) {
        super(message);
    }
}
public class TestDemo {

    //使用while循环建立类似“恢复模型”的异常处理行为，它将不断重复，直到异常不再抛出
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            try {
                if( i < 10) {
                    throw new Exception();
                }
            }catch (Exception e) {
                e.printStackTrace();
                System.out.println("尝试连接网络第"+i+"次.........");
                i++;
            }
        }
        System.out.println("终于有网了,程序继续执行！！！！！");
    }


    public static void main2(String[] args) {
        try {
            throw new Exception("我抛出异常了！");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("我finally确实被执行了");
        }
    }

    private static final String name = "bit";
    private static final String password = "123";

    public static void login(String name,String password) throws  NameException,PasswordException{
        if(!TestDemo.name.equals(name)) {
            throw new NameException("用户名错误");
        }
        if(!TestDemo.password.equals(password)) {
            throw new PasswordException("密码错误！");
        }
    }
    public static void main1(String[] args) {
        try {
            login("bit","1234");
        }catch (NameException e) {
            System.out.println("用户名错误了！");
        }catch (PasswordException e) {
            e.printStackTrace();
            System.out.println("密码错误了！");
        }finally {
            System.out.println("finally执行了！");
        }
    }
}