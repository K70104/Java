import com.beans.UserController;
import com.beans.UserController2;
import com.beans.UserController3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // 1、得到上下文对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        UserController3 userController3 = context.getBean(UserController3.class);
        userController3.sayHi();



//        UserController2 userController2 = context.getBean(UserController2.class);
//        userController2.sayHi();



        // 2、通过上下文对象的 getBean 方法获取 bean 对象
        UserController userController = context.getBean(UserController.class);
        // 3、使用 bean
        userController.sayHi();
    }
}
