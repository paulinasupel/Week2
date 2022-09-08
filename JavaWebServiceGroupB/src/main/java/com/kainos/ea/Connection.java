package com.kainos.ea;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.util.Properties;

public class Connection {
    private static java.sql.Connection conn;

    private static java.sql.Connection getConnection() {
        String user;
        String password;
        String host;

        if (conn != null) {
            return conn;
        }

        try {
            // Bad practice alert!
            FileInputStream propsStream =
                    new FileInputStream("employeesdb.properties");

            Properties props = new Properties();
            props.load(propsStream);

            user            = props.getProperty("user");
            password        = props.getProperty("password");
            host            = props.getProperty("host");

            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain "
                                + "user, password, and host properties.");
            conn = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/employees?useSSL=false", user, password);
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
