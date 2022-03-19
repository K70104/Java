import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        // 1、创建好数据源
        DataSource dataSource = new MysqlDataSource(); // 向下转型
        // 设置数据库所在的地址
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/work?characterEncoding=utf8&useSSL=false");
        // 设置数据库的用户名
        ((MysqlDataSource) dataSource).setUser("root"); // 向上转型
        // 设置登录数据库的密码
        ((MysqlDataSource) dataSource).setPassword("11111");

        // 2、让代码和数据库服务器建立连接 - 相当于快递到达了菜鸟驿站
        Connection connection = dataSource.getConnection();

        // 2.5、让用户通过控制台 输入待插入的数据
        System.out.println("请输入学号：");
        int id = scanner.nextInt();
        System.out.println("请输入姓名：");
        String name = scanner.next();

        // 3、操作数据库
        // 以插入数据为例：构造一个 SQL 语句
        // 在 JDBC 中构造 SQL，不需带上分号，它只是在命令行中用来区分不同语句的

        // String sql = "insert into student values (1, '张三')";
        // String sql = "insert into student values (" + id + ", '张三')";
        //String sql = "insert into student values (?, ?)";
        String sql = "insert into student values (?, ?)";
        // String sql = "insert into student values(?, ?), (?, ?),  (?, ?)";

        // 只有 String 类型的 sql还不行，需要把这个 String 包装成一个 “语句对象”
        PreparedStatement statement = connection.prepareStatement(sql);
        // PreparedStatement 准备的语句
        // 通过 connection 里的 prepareStatement 方法构造语句对象

        // 进行替换操作
        statement.setInt(1, id);
        statement.setString(2, name);
        System.out.println("statement: " + statement);

        // 4、执行 SQL - 相当于扫码取件
        // SQL 里如果是 insert，update，delete，都是用executeUpdate（执行更新） 方法
        // SQL 里如果是 select，就使用 execute
        // Query（执行查询） 方法
        int ret = statement.executeUpdate(); // 执行更新
        System.out.println(ret);
        // 返回的数字同于：5 rows in set (0.00 sec)

        // 5、此时 SQL 已经执行完毕，需要释放资源
        statement.close();
        connection.close();
    }
}
