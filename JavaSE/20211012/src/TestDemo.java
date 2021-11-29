import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * psvm - main
 * sout - println
 */

public class TestDemo {
    public static void main(String[] args) {
        // 6、位运算符
        // 按位与&   -- 对应为都是1，结果是1
        // 按位或|   -- 有1就是1
        // 按位异或^ --  相同为0，相异为1
        // 按位取反~ -- 0变1,1变0

        // 7、移位运算符
        // << >> >>> 都是按二进制位移
        // 左移 右边补0 相当于原数字*2的N次方
        // 右移 左边补符号位 相当于原数字/2的N次方
        //   0000 1011>>1     0000 0101

        // 无符号右移 - 不管符号位是什么，左边统一补0

        // 8、条件运算符
        int a = 10;
        int b = 20;
        int max = a > b ? a : b; // 表达式1为布尔表达式
    }

    public static void main8(String[] args) {
        // 5、逻辑运算符
        // 逻辑与 &&
        // 表达式1 && 表达式2 --> 此2表达式都是布尔表达式
        // 短路：如果表达式1为假，就不执行表达式2

        // 逻辑或 ||
        // 表达式1 || 表达式2 --> 此2表达式都是布尔表达式
        // 短路：如果表达式1为真，就不执行表达式2

        // 逻辑非 !
        int a = 10;
        int b = 20;
        System.out.println(!!(a<b)); // true

        System.out.println(10<20 && 10/0 == 0); // 短路
        System.out.println(10<20 || 10/0 == 0); // 短路
    }

    public static void main7(String[] args) {
        // 二、运算符
        // 1、算术运算符
        // %
        int a = 10;
        int b = 0;
        // System.out.println(a/b); // 抛出异常 程序结束 by zero-算术异常
        System.out.println("xxxxxxxxxxx"); // 不打印

        System.out.println(10 % 3); // 1
        System.out.println(-10 % 3); // -1
        System.out.println(10 % -3); // 1
        System.out.println(-10 % -3); // -1

        // 2、增量赋值运算符 += -= ……
        short s = 10;
        // s = (short)(s+9);
        s += 9; // +=自动强制类型转换
        System.out.println(s);

        // 3、自增自减 ++ --
        // 区分前置（先++后使用），后置（先使用后++）

        // 4、关系运算符 == != < > <= >=
        // --> 关系运算符表达式结果是波尔值
        // if(布尔表达式)
        int i1 = 10;
        int i2 = 20;
        System.out.println(i1 == i2); // false
        System.out.println(i1 != i2); // true
    }

    public static void main6(String[] args) {
        // 14、int 和 String 之间的相互转换
        int num = 10;
        String ret = String.valueOf(num); // int->String
        System.out.println(ret); // 10

        // String->int
        String str = "123";
        int ret2 = Integer.valueOf(str);
        System.out.println(ret+1); //
    }

    public static void main5(String[] args) {
        // 13、整形提升：小范围提升为大范围，效率高

        // byte放int
        // byte a = 128; // err  -128  127

        byte a = 1;
        byte b = 2;
        byte c = (byte)(a + b); // 小于4 提升
        System.out.println(c);

        int num1 = 10;
        long num2 = 10;
        int sum = (int)(num1+num2);
    }

    public static void main4(String[] args) {
        // 12、类型转换
        int a = 10;
        long b = a; // ok
        System.out.println(b);

        long d = 12;
        // int c = d; // err 报错（强类型语言）
        int c = (int)d; // 强制类型转换（有风险）

        // boolean不能
        boolean n = true;
        // int t = (int)n; // err

        // int->byte
        byte num1 = 1;
        byte num2 = 2;
        byte sum = (byte)(num1 + num2); // 强制类型转换

        byte num3 = 1+2; // 1和2都是常量，在程序编译时，已经被编译为3了  --byte num3 = 3;

    }

    public static void main3(String[] args) {
        // 常量：
        // 1.字面值常量
        // 2.final修饰的变量 ->常量
        // 程序编译时，就已经确定值
        // 只能初始化一次

        // 11、变量：
        // 程序运行的时候们可以改变的量

        final int a = 10;
        // a = 20; // err

    }

    public static void main2(String[] args) {
        // 10、字符串类型-（引用类型）
        String str = "hello";
        System.out.println(str);

        // 注意问题：
        System.out.println("hello"+"world"); // helloworld
        System.out.println("hello"+10+20); // hello1020
        // 其他数据类型和字符串使用加号拼接，结果就是一个字符串

        System.out.println(10+20+"hello"); // 30hello
        System.out.println("hello+(10+20)"); // hello+(10+20)

        System.out.println(10+""+20+"hello"); // 1020hello

        System.out.println("a = "+10+", b = " +20); // a = 10, b = 20

        /*
        *                         整数   byte short int long
        *                         浮点数 float double
        *          基本数据类型    字符   char
        *                         布尔   boolean
        * 数据类型
        *          引用类型        String  数组 类 接口 枚举……
        * */

        // 转义字符
        System.out.println("\"bit\""); // "bit"
        // 水平制表符\t - Tab键
    }

    public static void main1(String[] args) {
        // 9、布尔类型
        // 在Java中，boolean只有两种取值，true真，false假
        // 在JVM的规范中，没有规定布尔类型的大小，
        // 布尔类型变量不能+-，因为不是数值
        boolean flag = false;
        System.out.println(flag);
    }
}
