import com.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // 1、先得到上下文对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
//        // 2、得到 bean 对象
//        UserController controller = context.getBean("userController", UserController.class);
//        // 3、使用 bean
//        controller.sayHi();

//        // 2、得到 bean 对象
//        UserService service = context.getBean("userService", UserService.class);
//        // 3、使用 bean
//        service.sayHi();

//        // 2、得到 bean 对象
//        UserRepository repository = context.getBean("userRepository", UserRepository.class);
//        // 3、使用 bean
//        repository.sayHi();

//        // 2、得到 bean 对象
//        UserConfig config = context.getBean("userConfig", UserConfig.class);
//        // 3、使用 bean
//        config.sayHi();

//        // 2、得到 bean 对象
//        UserComponent component = context.getBean("userComponent", UserComponent.class);
//        // 3、使用 bean
//        component.sayHi();

//        APIController apiController = context.getBean("APIController", APIController.class);
//        apiController.sayHi();



//        User user = context.getBean("user1", User.class);
//        User user = context.getBean(User.class);
//        User user = context.getBean("user1", User.class);
//        System.out.println(user);
    }
}
