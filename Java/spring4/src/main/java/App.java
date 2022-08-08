import com.beans.BeanLifeComponent;
import com.beans.BeanScope1;
import com.beans.BeanScope2;
import com.beans.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("spring-config.xml");
//        BeanScope1 beanScope1 = context.getBean(BeanScope1.class);
//        User user1 = beanScope1.getUser3();
//        System.out.println("BeanScope1" + user1);
//
//        BeanScope2 beanScope2 = context.getBean(BeanScope2.class);
//        User user2 = beanScope2.getUser3();
//        System.out.println("BeanScope2" + user2);
        BeanLifeComponent beanLifeComponent = context.getBean("beanLifeComponent", BeanLifeComponent.class);
        beanLifeComponent.use();
        context.destroy(); // 注销上下文对象
    }
}
