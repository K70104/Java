import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sun.jndi.dns.DnsUrl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/java102?characterEncoding=utf8&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "11111";

    private volatile static DataSource dataSource = null; // volatile

    private static DataSource getDataSource() {
        // 多线程安全
        if (dataSource == null) {
            synchronized (DnsUrl.class) {
                if (dataSource == null) { // 懒汉模式
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource) dataSource).setURL(URL);
                    ((MysqlDataSource) dataSource).setUser(USERNAME);
                    ((MysqlDataSource) dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    // 代码和数据库服务器建立连接 import java.sql.Connection;
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    // 释放资源
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
