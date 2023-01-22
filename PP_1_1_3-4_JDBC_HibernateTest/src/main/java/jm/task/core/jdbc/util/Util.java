package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public Util() {
    }

    // реализуйте настройку соеденения с БД

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "Romawka123!";

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String DIALECT = "org.hibernate.dialect.MySQL5Dialect";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


}
