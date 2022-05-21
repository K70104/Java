import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 返回一个 302 重定向，让浏览器自动跳转到 sogou 主页
        // resp.setStatus(302);
        // resp.setHeader("Location", "https://www.sogou.com");

        // Servlet 提供了一个更简便的实现重定向的写法：
        resp.sendRedirect("https://www.sogou.com");
    }
}
