import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] array = new int[3 * n];
            for (int i = 0; i < 3 * n; i++) {
                array[i] = scanner.nextInt();
            }
            Arrays.sort(array);
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += array[array.length - 2 * (i + 1)];
            }
            System.out.println(sum);
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] array = new int[3 * n];
            for (int i = 0; i < 3 * n; i++) {
                array[i] = scanner.nextInt();
            }
            Arrays.sort(array);
            if (n == 3) {
                System.out.println(array[1]);
            } else {
                int teams = n;
                int right = 3 * n - 2;
                long ans = 0; // 溢出
                while (teams > 0) {
                    ans += array[right];
                    right -= 2;
                    teams--;
                }
                System.out.println(ans);
            }
        }
    }
}


/*
// insert
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBC{
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        DataSource dataSource = new MysqlDataSource(); // 向下转型
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/work?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root"); // 向上转型
        ((MysqlDataSource) dataSource).setPassword("11111");
        Connection connection = dataSource.getConnection();
        System.out.println("请输入学号：");
        int id = scanner.nextInt();
        System.out.println("请输入姓名：");
        String name = scanner.next();
        String sql = "insert into student values (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);
        System.out.println("statement: " + statement);
        int ret = statement.executeUpdate();
        System.out.println(ret);
        statement.close();
        connection.close();
    }
}

// delete
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCDelete {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/work?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("11111");
        Connection connection = dataSource.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个要删除的 id: ");
        int id = scanner.nextInt();
        String sql = "delete from student where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        int ret = statement.executeUpdate();
        System.out.println(ret);
        statement.close();
        connection.close();
    }
}

// update
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCUpdate {
    public static void main(String[] args) throws SQLException {
        // 1、创建数据        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/work?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("11111");
        Connection connection = dataSource.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要修改的学生id：");
        int id =  scanner.nextInt();
        System.out.println("请输入要修改的学生姓名：");
        String name = scanner.next();
        String sql = "update student set name = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2, id);
        System.out.println("statement: " + statement);
        int ret = statement.executeUpdate();
        System.out.println(ret);
        statement.close();
        connection.close();
    }
}

// select
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCSelect {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/work?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("11111");
        Connection connection = dataSource.getConnection();
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id: " + id + ", name: " + name);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
*/
