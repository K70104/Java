import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCSelect {
    public static void main(String[] args) throws SQLException {
        // 1、创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/work?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("11111");

        // 2、建立连接
        Connection connection = dataSource.getConnection();

        // 3、拼装 sql 语句
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        // 4、执行 sql，对于查询操作，需要使用 executeQuery
        //    查询操作返回的不是int 而是一个“临时表”
        //    使用 ResultSet 表示这个表
        ResultSet resultSet = statement.executeQuery();

        // 5、遍历结果集合（返回的临时表），先获取到这一行，再获取到这一行的每一列
        //    next 方法表示获取到行的记录，同时把光标向后移动一行
        //    如果遍历到表的结束位置，此处的 next 直接返回 false
        // +------+--------+
        // | id   | name   |
        // +------+--------+
        // |   1  | 张三   |
        // |   2  | 李四   |
        // +------+--------+
        while (resultSet.next()) {
            // 针对当前这一行，获取其中的列
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id: " + id + ", name: " + name);
        }

        // 6、回收释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
