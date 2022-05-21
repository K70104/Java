import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class User {
    // 当前都设为 public，如果是 private，但是同时提供了 getter setter，效果等同
    public int userId;
    public int classId;
}

@WebServlet("/postJson")
public class PostJsonServlet extends HttpServlet {
    // 1、创建一个 Jackson 的核心对象
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 2、读取 body 中的请求，然后使用 ObjectMapper 来解析成需要的对象
        User user = objectMapper.readValue(req.getInputStream(), User.class);
        // 源代码是.java => 二进制字节码.class => 被加载到内存中就成为了 class 对象
        // getInputStream()：读取请求的 body 内容. 返回一个 InputStream 对象
        resp.getWriter().write("userId: " + user.userId + ", classId: " + user.classId);
    }
}

