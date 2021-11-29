

class NameException1 extends RuntimeException{
    public NameException1(String message) {
        super(message);
    }
}

public class Test {
    public static void main(String[] args) {

    }

    public static void main1(String[] args) {
        try {
            throw new Exception("我抛出异常了！");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("我finally确实被执行了");
        }
    }

}
