import com.beans.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {
    public static void main(String[] args) {
        // 1、先得到 spring 上下文对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        // 2、通过上下文对象提供 getBean() 获取需要使用的 bean 对象
//        User user = (User) context.getBean("userInfo");
//        User user = context.getBean(User.class);
        User user = context.getBean("user", User.class);
        // 3、使用 bean 对象
        user.sayHi("张三");

//        // 1、获取 bean 工厂
//        BeanFactory factory = new XmlBeanFactory(
//                new ClassPathResource("spring-config.xml"));
//        // 2、获取 bean
//        User user = (User) factory.getBean("userInfo");
//        // 3、使用 bean 对象
//        user.sayHi("李四");
    }
}
