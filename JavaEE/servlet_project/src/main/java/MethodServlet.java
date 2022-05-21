import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/method") // 在同一个 webapp 里 多个 Servlet 关联的路径 不能相同!
public class MethodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doPost(req, resp);
        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write("POST 响应");
    }
}
