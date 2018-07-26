package com.contacts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection = null;
    private static volatile int activeReferences = 0;
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jss";
    private static final String USER_NAME = "root";
    private static final String PASS = "Obss_147";

    private ConnectionManager() {

    }

    public static synchronized Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASS);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection == null) {
            throw new RuntimeException();
        }
        else {
            activeReferences++;
            return connection;
        }
    }

    public static synchronized void closeConnection() {
        if (activeReferences > 0 && --activeReferences == 0) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
