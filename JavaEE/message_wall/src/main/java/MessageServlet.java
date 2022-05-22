import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.rowset.CachedRowSetImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Message {
    public String from;
    public String to;
    public String message;
}

// 和前面约定的 前后端交互接口 相匹配
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

//    private List<Message> messages = new ArrayList<>();
//    改成数据库，不需要整个变量

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理提交信息请求
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
//        // 最简单的保存放法就是保存到内存中
//        messages.add(message);
        // 通过 ContentType 告知页面，返回的数据是 json 格式
        // 有了这样的声明，此时 jquery ajax 就会自动帮我们把字符串转成 js 对象
        // 如果没有，jquery ajax 只会当成字符串来处理
        save(message);
        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write("{ \"ok\": true }");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取到消息列表 将消息列表的内容整个的都返回给客户端即可
        // 此处需要使用 ObjectMapper 把 Java 对象，转成 JSON 格式字符串
        List<Message> messages = load();
        String jsonString = objectMapper.writeValueAsString(messages);
        System.out.println("jsonString: " + jsonString);
        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write(jsonString);
    }

    private void save(Message message) {
        // 把一条数据保存到数据库中
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1、和数据库建立连接
            connection = DBUtil.getConnection();
            // 2、构造 SQL
            String sql = "insert into message values(?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, message.from);
            statement.setString(2, message.to);
            statement.setString(3, message.message);
            // 3、指向 SQL
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    private List<Message> load() {
        // 从数据库中获取所有数据
        List<Message> messages = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from message";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Message message = new Message();
                message.from = resultSet.getString("from");
                message.to = resultSet.getString("to");
                message.message = resultSet.getString("message");
                messages.add(message);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return messages;
    }
}
