import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Admin on 13.03.2016.
 */
public class CreateTest {
    public static void main(String[] args) {
        try {
            createTableGoods();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test","postgres", "3336754");
        return connection;
    }
    private static void createTableGoods() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("create table if not exists GOODS " +
                    "(id serial NOT NULL PRIMARY KEY, " +
                    "name VARCHAR(50), description varchar(200), imageUrl VARCHAR(150), " +
                    "price DECIMAL(5) , categoryId bigint)");
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

}
