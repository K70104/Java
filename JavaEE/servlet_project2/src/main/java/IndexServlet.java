import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 返回一个主页. (主页就是一个简单的 html 片段)
        // 此处需要得到用户名是啥, 从 HttpSession 中就能拿到.
        // 此处 getSession 的参数必须是 false. 前面在登录过程中, 已经创建过会话了. 此处是要直接获取到之前的会话.
        HttpSession session = req.getSession(false);
        String username = (String) session.getAttribute("username"); // Object

        // 再从会话中取出 count
        Integer count = (Integer) session.getAttribute("count");
        count += 1;
        // 自增之后 写回会话中
        session.setAttribute("count", count);

        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("<h3>欢迎你！ " + username + " [这是第 "  + count + " 次访问]" + "</h3>");
    }
}
