package com.rubypaper.jdbc.util;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;

@Data
public class JDBCConnectionManager {
    private String driverClass;
    private String url;
    private String username;
    private String password;

    public JDBCConnectionManager() {
        System.out.println("===> JDBCConnectionManager 생성");
    }

    public Connection getConnection() {
        try {
            Class.forName(driverClass);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
