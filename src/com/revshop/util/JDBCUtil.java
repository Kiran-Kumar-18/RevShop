package com.revshop.util;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    private static String db_url;
    private static String db_username;
    private static String db_password;

    static {
        try (InputStream is = JDBCUtil.class
                .getClassLoader()
                .getResourceAsStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            db_url = properties.getProperty("DB.URL");
            db_username = properties.getProperty("DB.USERNAME");
            db_password = properties.getProperty("DB.PASSWORD");
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    private JDBCUtil() {}

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(db_url, db_username, db_password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        return con;
    }
}