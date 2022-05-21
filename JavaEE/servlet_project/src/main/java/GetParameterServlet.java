import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/getParameter")
public class GetParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        // 预期浏览器传来的请求：/getParameter?userId=123&classId=789
        String userId = req.getParameter("userId");
        String classId = req.getParameter("classId");
        resp.getWriter().write("userId=" + userId + ", classId=" + classId);
    }
}
