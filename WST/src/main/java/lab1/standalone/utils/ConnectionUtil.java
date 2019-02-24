package lab1.standalone.utils;

import lab1.common.dao.FilmDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtil {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "12345";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER,
                    JDBC_PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
