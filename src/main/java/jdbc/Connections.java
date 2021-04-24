package jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
    private static Connections instance;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "polska123$";
    private static DataSource dataSource;

    static Connections getInstance() {
        if (instance == null) {
            synchronized (Connections.class) {
                if (instance == null) {
                    instance = new Connections();
                }
            }
        }
        return instance;
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

}
