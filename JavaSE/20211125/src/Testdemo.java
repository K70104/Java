import sun.security.util.Password;

import javax.management.NotificationEmitter;

class NameException extends RuntimeException {
    public NameException(String message) {
        super(message);
    }
}

class PasswordException extends RuntimeException {
    public PasswordException(String message) {
        super(message);
    }
}

public class Testdemo {
    public static void main(String[] args) {
        int i = 0;
        while(i < 10) {
            try {
                if(i < 10) {
                    throw new Exception();
                }
            }catch (Exception e) {
                e.printStackTrace();
                System.out.println("尝试链接网络第 "+i+"次………………");
                i++;
            }
        }
        System.out.println("链接恢复，程序继续执行！");
    }

    private static final String name = "bit";
    private static final String password = "123";

    public static void login(String name, String passwoerd) {
        if(!Testdemo.name.equals(name)) {
            throw new NameException("用户名错误！");
        }
        if(!Testdemo.password.equals(password)) {
            throw new PasswordException("密码错误！");
        }
    }

    public static void main1(String[] args) {
        try {
            login("bit", "1234");
        }catch (NameException e) {
            e.printStackTrace();
            System.out.println("用户名");
        }catch (PasswordException e) {
            e.printStackTrace();
            System.out.println("密码");
        }finally {
            System.out.println("xxx");
        }
    }
}
