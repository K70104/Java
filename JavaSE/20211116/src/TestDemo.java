import com.bit.demo1.Test;

public class TestDemo {
    public static void main(String[] args) {
        Test test = new Test();
        // System.out.println(test.val);
    }
}


/*import static java.lang.System.*;
import static java.lang.Math.*;

public class TestDemo {
    public static void main(String[] args) {
        out.println("hehe");

        out.println(max(10, 20)); // out.println(Math.max(10, 20));
    }
}*/


/*import java.util.Date;

// import java.util; 导入一个具体的类 不能导入一个具体的包

import java.util.*; // 通配符
// util下有很多类 Java处理的时候 需要哪个才会拿哪个
// C语言 通过include关键字导入 会把这个文件的内容全部拿过来

*//**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Chloe
 * Date: 2021-11-16
 * Time: 21:23
 *//*


public class TestDemo {
    public static void main(String[] args) {
        Date data = new Date();
        System.out.println(data.getTime()); // 得到一个毫秒级别的时间戳

        java.util.Date date1 = new java.util.Date(); // util和sql中都存在一个Date这样的类 避免冲突
    }
}*/
