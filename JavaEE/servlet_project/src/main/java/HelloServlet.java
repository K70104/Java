import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
// 如果代码中找不到 HttpServlet 这个类 说明依赖没有被正确引入
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 这个代码一定要干掉！ 不能调用父类的 doGet！
        // super.doGet(req, resp);

        // 这是让服务器在自己的控制台里打印
        System.out.println("hello world!");
        // 在页面上也能打印，把 hello world! 字符串放到 http 响应的 body 中，浏览器就会把 body 的内容显示到页面上
        // resp 是响应对象
        // getWriter 其实是反回了一个 Writer 对象(字符流对象)
        // 此处 Writer 对象就不是往文件里写了，而是往 HTTP 响应的 body 中写入数据
        // write 是真正的干活，写数据的方法
        resp.getWriter().write("hello word!" + System.currentTimeMillis());
    }
}
