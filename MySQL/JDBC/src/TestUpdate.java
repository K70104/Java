import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestUpdate {
    public static void main(String[] args) throws SQLException {
        // 1、创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/work?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("11111");

        // 2、和数据库建立连接
        Connection connection = dataSource.getConnection();

        // 3、输入信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要修改的学生id：");
        int id =  scanner.nextInt();
        System.out.println("请输入要修改的学生姓名：");
        String name = scanner.next();

        // 4、拼装 sql
        String sql = "update student set name = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2, id);
        System.out.println("statement: " + statement);

        // 5、执行 sql
        int ret = statement.executeUpdate();
        System.out.println(ret);

        // 6、回收资源
        statement.close();
        connection.close();
    }
}
