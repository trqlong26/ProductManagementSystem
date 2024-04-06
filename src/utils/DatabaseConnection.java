package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnection
 */
public class DatabaseConnection {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Product";
    private static final String USER = "root";
    private static final String PASS = "181200";

    private static Connection conn;

    public static Connection connection() {
        try {
            // load driver
            Class.forName(JDBC_DRIVER);
            // get connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connection to database successfully !");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return conn;
    }
}
