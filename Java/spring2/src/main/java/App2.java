import com.beans.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.Introspector;

public class App2 {
    public static void main(String[] args) {
        String className1 = "UserController";
        String className2 = "APIController";
        System.out.println(Introspector.decapitalize(className1)); // userController
        System.out.println(Introspector.decapitalize(className2)); // APIController
    }
}
