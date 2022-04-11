import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/work?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("11111");

        Connection connection = dataSource.getConnection();

    }
}
