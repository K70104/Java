

public class TestDemo2 {
    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b); // false
    }

    public static void main1(String[] args) {
        Integer a = 123; //装箱  装包【隐式的】
        int b = a; //拆箱  拆包【隐式的】
        System.out.println(a+" " + b); // 123 123

        System.out.println("=============");

        Integer a2 = Integer.valueOf(123); //显示地装包
        Integer a3 = new Integer(123); // 显示地装包

        int b2 = a2.intValue(); // 显示地拆包
        double d = a2.doubleValue(); // 显示地拆包
        int i = 10; // 显示地初始化
    }
}

/*public class TestDemo {
    public static void main(String[] args) {
        String str = "123";
        int ret = Integer.valueOf(str);
        System.out.println(ret+1); // 124
    }

*//*    public static void main(String[] args) {
        String[] strings = new String[10];
        Object o1 = new String[10];
        Object[] o2 = new String[10];
    }*//*
}*/
